package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebTable extends BasePage {


    @FindBy(xpath = "//button[@id='addNewRecordButton']")   private WebElement addButton;
    @FindBy(xpath = "//input[@id = 'firstName']")           private WebElement firstName;
    @FindBy(xpath = "//input[@id = 'lastName']")            private WebElement lastName;
    @FindBy(xpath = "//input[@id = 'userEmail']")           private WebElement userEmail;
    @FindBy(xpath = "//input[@id = 'age']")                 private WebElement age;
    @FindBy(xpath = "//iinput[@id = 'salary']")             private WebElement salary;
    @FindBy(xpath = "//input[@id = 'department-wrapper']")  private WebElement departmentWrapper;
    @FindBy(xpath = "//button[@id = 'submit']")             private WebElement submitBtn;

    protected WebTable(WebDriver driver) {
        super(driver);
    }


    public void open() {
        driver.get("https://demoqa.com/webtables");
        wait.until(ExpectedConditions.visibilityOf(addButton));
    }

    public void clickAdd() {
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void setFirstName(String value) {
        fillField(firstName, value);
    }

    public void setLastName(String value) {
        fillField(lastName, value);
    }

    public void setUserEmail(String value) {
        fillField(userEmail, value);
    }

    public void setAge(int value) {
        fillField(age, String.valueOf(value));
    }

    public void setSalary(int value) {
        fillField(salary, String.valueOf(value));
    }

    public void setDepartment(String value) {
        fillField(departmentWrapper, value);
    }

    public void submit() {
        submitBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(submitBtn));
    }
}