package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Buttons extends BasePage {

    protected Buttons(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='doubleClickBtn']")       private WebElement doubleClickButton;
    @FindBy(xpath = "//button[@id='rightClickBtn']")        private WebElement rightClickButton;
    @FindBy(xpath = "//button[@id='PBW9f']")                private WebElement clickMeButton;
    @FindBy(xpath = "//p[@id='doubleClickMessage']")        private WebElement doubleClickMessage;
    @FindBy(xpath = "//p[@id='rightClickMessage']")         private WebElement rightClickMessage;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']")       private WebElement dynamicClickMessage;

    private final Actions actions = new Actions(driver);

    public void performDoubleClick() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
        actions.doubleClick(doubleClickButton).perform();
    }

    public boolean isDoubleClickMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(doubleClickMessage)).isDisplayed();
    }

    public void performRightClick() {
        wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        actions.contextClick(rightClickButton).perform();
    }

    public boolean isRightClickMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(rightClickMessage)).isDisplayed();
    }

    public void performDynamicClick() {
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));
        clickMeButton.click();
    }

    public boolean isDynamicClickMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dynamicClickMessage)).isDisplayed();
    }
}
