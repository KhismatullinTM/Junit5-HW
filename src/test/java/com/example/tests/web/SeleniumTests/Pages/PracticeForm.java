package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeForm extends BasePage {

    public PracticeForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id = 'firstName']") private WebElement firstName;
    @FindBy(xpath = "//input[@id = 'lastName']") private WebElement lastName;
    @FindBy(xpath = "//input[@id = 'userEmail']") private WebElement userEmail;
    @FindBy(xpath = "//input[@id = 'userNumber']") private WebElement userNumber;
    @FindBy(xpath = "//textarea[@id ='currentAddress']") private WebElement currentAddress;
    @FindBy(xpath = "//label[@for='gender-radio-1' and normalize-space()='Male']") private WebElement genderMaleLabel;
    @FindBy(xpath = "//input [@for = 'gender-radio-2' and normalize-space()='Female']") private WebElement genderFemaleLabel;
    @FindBy(xpath = "//input [@for = 'gender-radio-3' and normalize-space()='Other']") private WebElement genderOtherLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1' and normalize-space()='Sports']") private WebElement hobbySportsLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2' and normalize-space()='Reading']") private WebElement hobbyReadingLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3' and normalize-space()='Music']") private WebElement hobbyMusicLabel;
    @FindBy(xpath = "//button[@id = 'submit']") private WebElement submitBtn;

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
        wait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void setName(String first, String last) {
        fillField(firstName, first);
        fillField(lastName, last);
    }

    public void setEmail(String email) {
        fillField(userEmail, email);
    }

    public void selectMale() {
        genderMaleLabel.click();
    }

    public void setPhone(String phone) {
        fillField(userNumber, phone);
    }

    public void setAddress(String address) {
        fillField(currentAddress, address);
    }

    public void setHobbie() {
        hobbySportsLabel.click();
    }

    public void submit() {
        submitBtn.click();
    }
}