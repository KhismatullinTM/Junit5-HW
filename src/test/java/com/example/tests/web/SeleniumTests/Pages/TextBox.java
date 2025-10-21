package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBox extends BasePage {
    protected TextBox(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id = 'firstName']")           private WebElement firstName;
    @FindBy(xpath = "//input[@id = 'userEmail']")           private WebElement userEmail;
    @FindBy(xpath = "//textarea[@id ='currentAddress']")    private WebElement currentAddress;
    @FindBy(xpath = "//textarea[@id ='permanentAddress']")  private WebElement permanentAddress;
    @FindBy(xpath = "//button[@id = 'submit']")             private WebElement submitBtn;

    public void setFirstName(String value) {
        fillField(firstName, value);
    }

    public void setUserEmail(String value) {
        fillField(userEmail, value);
    }

    public void setAddress(String address) {
        fillField(currentAddress, address);
    }

    public void setPermanentAddress(String value) {
        fillField(permanentAddress, value);
    }

    public void submit() {
        submitBtn.click();
    }
}
