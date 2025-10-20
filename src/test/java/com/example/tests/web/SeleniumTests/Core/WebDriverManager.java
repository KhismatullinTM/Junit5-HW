package com.example.tests.web.SeleniumTests.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class WebDriverManager {

    private WebDriverManager () {}

    public static WebDriver createFirefox() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        return driver;
    }
}
