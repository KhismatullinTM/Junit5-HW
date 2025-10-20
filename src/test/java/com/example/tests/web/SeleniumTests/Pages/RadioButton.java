package com.example.tests.web.SeleniumTests.Pages;


import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RadioButton extends BasePage {

    protected RadioButton(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='yesRadio']") private WebElement LabelYesRadio;
    @FindBy(xpath = "//input[@id='yesRadio']") private WebElement InputYesRadio;
    @FindBy(xpath = "//label[@for='impressiveRadio']") private WebElement LabelImpressiveRadio;
    @FindBy(xpath = "//input[@id='impressiveRadio']") private WebElement InputImpressiveRadio;
    @FindBy(xpath = "//label[@for='noRadio']") private WebElement LabelNoRadio;
    @FindBy(xpath = "//input[@id='noRadio']") private WebElement InputNoRadio;
    @FindBy(xpath = "//*[@class='mt-3']") private WebElement LabelNoMt3;

    public void open() {
        driver.get("https://demoqa.com/radio-button");
        wait.until(ExpectedConditions.visibilityOf(LabelYesRadio));
    }

    public void clickYesRadioButton() {
        if (!LabelYesRadio.isSelected()) LabelYesRadio.click();
    }

    public void clickImpressiveRadioButton() {
        if (!LabelImpressiveRadio.isSelected()) LabelImpressiveRadio.click();
    }

    public void clickNoRadioButton() {
        if (LabelNoRadio.isEnabled()) LabelNoRadio.click();
    }

    public String checkResultText() {
        wait.until(ExpectedConditions.visibilityOf(LabelNoMt3));
        return LabelNoMt3.getText();
    }
}