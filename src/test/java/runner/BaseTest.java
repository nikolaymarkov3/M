package runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.PropertyLoader.getPropertyLoader;
import static util.SelenideConfig.getInstanceConfig;


public class BaseTest {
    private static final String CONFIG_PATH_UI = "ui.properties";
    private static final String BASE_URL = getPropertyLoader().get(CONFIG_PATH_UI,  "baseUrl");
    private static final String DEFAULT_BROWSER = getPropertyLoader().get(CONFIG_PATH_UI, "defaultBrowser");

    @BeforeClass
    @Parameters("browser")
    public void initWebDriver(@Optional String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = DEFAULT_BROWSER;
        }

        switch(browser) {
            case "chrome" -> {
                WebDriverRunner.setWebDriver(new ChromeDriver());
                Configuration.baseUrl = BASE_URL;
                getInstanceConfig().setCommonConfiguration();
                open("/");

                SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                        .savePageSource(false));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                WebDriverRunner.setWebDriver(new FirefoxDriver());
                Configuration.baseUrl = BASE_URL;
                getInstanceConfig().setCommonConfiguration();
                open("/");

                SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                        .savePageSource(false));
            }
            case "edge" -> {
                WebDriverRunner.setWebDriver(new EdgeDriver());
                Configuration.baseUrl = BASE_URL;
                getInstanceConfig().setCommonConfiguration();
                open("/");

                SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                        .savePageSource(false));
            }
        }
    }

    @AfterClass
    public void tearDown(){
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
