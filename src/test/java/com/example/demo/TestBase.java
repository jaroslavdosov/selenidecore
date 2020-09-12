package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.PropertyLoader;


import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected static String gridHubUrl;

    @BeforeTest(alwaysRun = true)
    public void initTestSuite() throws IOException {

        Configuration.baseUrl = PropertyLoader.loadProperty("site.url");
        String browser = PropertyLoader.loadProperty("browser");
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                Configuration.browser = "firefox";
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                throw new WebDriverException("Define browser!");
        }

        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.proxyEnabled = true;
        Configuration.fastSetValue = true;
        Configuration.fileDownload = FileDownloadMode.PROXY;


        gridHubUrl =  PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
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
