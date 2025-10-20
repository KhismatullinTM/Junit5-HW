package com.example.tests.web.SeleniumTests.Core;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openDemoqaPage() {
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".card.mt-4.top-card")));
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void openTab(String tabName) {
        By menuItem = By.xpath("//span[normalize-space()='" + tabName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(menuItem)).click();
    }

    public void fillField(WebElement input, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.clear();
        input.sendKeys(text);
    }
}