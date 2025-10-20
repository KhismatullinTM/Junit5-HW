package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeForm extends BasePage {

    public PracticeForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName") private WebElement firstName;

    @FindBy(id = "lastName") private WebElement lastName;

    @FindBy(id = "userEmail") private WebElement userEmail;

    @FindBy(id = "userNumber") private WebElement userNumber;

    @FindBy(id = "currentAddress") private WebElement currentAddress;

    @FindBy(id = "submit") private WebElement submitBtn;

    @FindBy(xpath = "//label[normalize-space()='Male']/preceding-sibling::input")
    private WebElement genderMale;

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
        if (!genderMale.isSelected()) {
            genderMale.findElement(By.xpath("following-sibling::label[1]")).click();
        }
    }

    public void setPhone(String phone) {
        fillField(userNumber, phone);
    }

    public void setAddress(String address) {
        fillField(currentAddress, address);
    }

    public void submit() {
        submitBtn.click();
    }
}