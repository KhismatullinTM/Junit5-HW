package com.example.tests.web.SeleniumTests.Pages;

import com.example.tests.web.SeleniumTests.Core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebTable extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='searchBox' or @placeholder='Type to search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='rt-table']/descendant::div[@class='rt-tbody']")
    private WebElement tableBody;


    @FindBy(xpath = "(//div[@class='rt-tr-group'])[1]")
    private WebElement firstRow;

    @FindBy(xpath = "(//div[@class='rt-tr-group'])[1]//span[@title='Edit']")
    private WebElement editButton;


    @FindBy(xpath = "(//div[@class='rt-tr-group'])[1]//span[@title='Delete']")
    private WebElement deleteButton;

    protected WebTable(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/webtables");
        wait.until(ExpectedConditions.visibilityOf(addButton));
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void search(String keyword) {
        fillField(searchInput, keyword);
    }

    public boolean isTextInTable(String text) {
        return tableBody.getText().contains(text);
    }

    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }
}