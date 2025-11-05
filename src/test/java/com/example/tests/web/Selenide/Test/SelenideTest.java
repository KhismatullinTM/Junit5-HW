package com.example.tests.web.Selenide.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class SelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;
        clearBrowserCache();
    }

    @Test
    void testOne() {
        open("https://demoqa.com/");
        removeFixedBan();

        $(byText("Alerts, Frame & Windows")).click();

        $$x("//div[contains(@class,'element-group')][.//div[contains(@class,'header-text') and normalize-space()='Alerts, Frame & Windows']]//li/span[@class='text']")
                .shouldHave(texts("Browser Windows","Alerts","Frames","Nested Frames","Modal Dialogs"));

        SelenideElement nestedFrames = $(By.xpath("//span[text()='Nested Frames']")).shouldBe(visible);
        nestedFrames.click();

        SelenideElement parent = $x("//iframe[@id='frame1']");
        switchTo().frame(parent);
        $(byText("Parent frame")).shouldBe(visible);

        switchTo().frame($("iframe")); // CSSg
        $(byText("Child Iframe")).shouldBe(visible);

        switchTo().parentFrame();
        $(byText("Parent frame")).shouldBe(visible);

        switchTo().defaultContent();

    }

    @Test
    void testTwo() {
        open("https://demoqa.com/");
        removeFixedBan();

        $(byText("Widgets")).click();

        SelenideElement ProgressBar = $(By.xpath("//li[.//span[normalize-space()='Progress Bar']]")).shouldBe(visible);
        ProgressBar.click();

        SelenideElement buttonStart = $x("//button[@id='startStopButton']").shouldBe(visible);;
        buttonStart.shouldHave(text("Start"));

        buttonStart.click();
        buttonStart.shouldHave(text("Stop"));

        SelenideElement progressBar = $(".progress-bar").shouldBe(visible);

        int progress = 0;
        while (progress < 30) {
            progress = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));
            System.out.println("Текущий прогресс: " + progress + "%");
            sleep(200);
        }
        buttonStart.click();

        buttonStart.shouldHave(text("Start"));
    }

    @Test
    void testThree() {
        open("https://demoqa.com/");
        removeFixedBan();

        $(byText("Widgets")).scrollTo().click();

        SelenideElement selectMenuItem = $x("//li[.//span[normalize-space()='Select Menu']]");
        selectMenuItem.scrollTo().click();
        selectMenuItem.shouldHave(text("Select Menu"));

        SelenideElement oldSelect = $("#oldSelectMenu").shouldBe(visible);
        oldSelect.selectOption("Blue");
        oldSelect.getSelectedOption().shouldHave(text("Blue"));

        SelenideElement multiInput = $("#react-select-4-input").shouldBe(visible);
        multiInput.setValue("Blue").pressEnter();
        multiInput.setValue("Green").pressEnter();

        $("#selectMenuContainer").shouldHave(text("Blue"), text("Green"));

    }
    //Гопник помог написать метод ниже:)
    private static void removeFixedBan() {
        executeJavaScript("document.getElementById('fixedban')?.remove();");
        executeJavaScript("document.querySelector('#close-fixedban')?.click();");
    }
}

