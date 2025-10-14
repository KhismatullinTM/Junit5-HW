package com.example.tests.web.SeleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class SeleniumTest {

    @Test
    void openDemoQA() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        FirefoxOptions options = new FirefoxOptions();

        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");

        WebElement elementOne = driver.findElement(By.xpath("//h5[text()='Elements']"));
        if (elementOne.isDisplayed()) {
            System.out.println("Карточка Elements найдена");
            elementOne.click();
        } else {
            System.out.println("Карточка Elements не найдена");
        }

        WebElement textBox = driver.findElement(By.xpath("//span[text()='Text Box']"));
        if (textBox.isDisplayed()) {
            System.out.println("Вкладка Text Box найдена");
            textBox.click();
        } else {
            System.out.println("Вкладка Text Box не найдена");
        }

        driver.findElement(By.id("userName")).sendKeys("Timur Khismatullin");
        driver.findElement(By.id("userEmail")).sendKeys("timuuur01@yandex.ru");
        driver.findElement(By.id("currentAddress")).sendKeys("Sterlitamak");
        driver.findElement(By.id("permanentAddress")).sendKeys("Russia");

        driver.findElement(By.id("submit")).click();

        assert driver.findElement(By.id("output")).isDisplayed();

        driver.quit();
    }
}



