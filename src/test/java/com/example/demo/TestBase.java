package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.PropertyLoader;


import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected static String selenoidUrl;
    protected static String browser;

    @BeforeTest(alwaysRun = true)
    public void initTestSuite() throws IOException {

        selenoidUrl = PropertyLoader.loadProperty("selenoid.url");
        browser =  PropertyLoader.loadProperty("browser.name");

        Configuration.baseUrl = PropertyLoader.loadProperty("site.url");
        if (!"".equals(selenoidUrl)) {
            Configuration.remote = selenoidUrl;
        } else {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    break;
                default:
                    throw new WebDriverException("Define browser!");
            }
        }
        Configuration.browser = browser;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "enableVNC",  true);
        capabilities.setCapability( "enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }

    @BeforeMethod
    public void initWebDriver() {
        open(Configuration.baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
