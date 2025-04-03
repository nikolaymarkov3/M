package util;

import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SelenideConfig {

    private static SelenideConfig instance;

    private SelenideConfig() {
    }

    public void setCommonConfiguration() {
        Configuration.pageLoadTimeout = 30000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = 30000;
        Configuration.screenshots = false;
        getWebDriver().manage().window().maximize();
    }

    public static SelenideConfig getInstanceConfig() {
        if (instance == null) {
            instance = new SelenideConfig();
        }
        return instance;
    }

    private void initializationSelenideCIRun() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--no-sandbox", "--disable-gpu", "--headless", "--window-size=1920,1080");
        Configuration.headless = true;
    }

    private boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    public void initSelenideConfig() {
        if (isServerRun()) {
            initializationSelenideCIRun();
        }
    }
}