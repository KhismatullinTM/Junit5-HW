package com.example.tests.web.SeleniumTests.TestScripts;

import com.example.tests.web.SeleniumTests.Pages.PracticeForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTest {
    private WebDriver driver;
    private PracticeForm form;

    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(new FirefoxOptions());
        driver.manage().window().maximize();
        form = new PracticeForm(driver);
    }

    @AfterEach
    void tearDown() { if (driver != null) driver.quit(); }

    @Test
    void submit() {
        form.open();
        form.setName("Timur", "Khismatullin");
        form.setEmail("timuuur01@yandex.ru");
        form.selectMale();
        form.setPhone("79944453653");
        form.setAddress("Sterlitamak");
        form.submit();

        // Быстрая проверка появления модалки
        assertTrue(driver.getPageSource().contains("Thanks for submitting the form"),
                "Ожидаем модалку результата после Submit");
    }
}

