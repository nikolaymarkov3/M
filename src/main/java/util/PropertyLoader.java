package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyLoader {
    private static PropertyLoader propertyLoader;
    private static Properties properties;
    private static final String configFilePath = "src/main/resources/";

    private PropertyLoader() {
    }

    public static PropertyLoader getPropertyLoader() {
        if (propertyLoader == null) {
            propertyLoader = new PropertyLoader();
        }
        return propertyLoader;
    }

    public String get(String configFileName, String key) {
        properties = readPropertiesFromFile(configFilePath + configFileName);
        return properties.getProperty(key);
    }

    private Properties readPropertiesFromFile(String configFile) {
        try {
            properties = new Properties();
            properties.load(new InputStreamReader(new FileInputStream(configFile), StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties;
    }
}
