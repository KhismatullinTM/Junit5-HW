package com.example.tests.web.cucumbertests;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.List;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;


public class StepDef {

    @Before
    public void перед_сценарием() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 12000;
        if (WebDriverRunner.hasWebDriverStarted()) {
            clearBrowserCookies();
            clearBrowserLocalStorage();
        }
    }

    @After
    public void после_сценария() {
        closeWebDriver();
    }

    //Общие шаги

    @Дано("открыт сайт DemoQA.com")
    public void открыт_сайт() {
        open("https://demoqa.com/");
        удалить_баннер();
    }

    @Когда("пользователь нажимает по карточке {string}")
    public void клик_по_карточке(String пример_названия) {
        $(byText(пример_названия)).scrollTo().click();
    }

    @Когда("пользователь выбирает пункт меню {string}")
    public void выбрать_пункт_меню(String пункт) {
        $x("//li[.//span[normalize-space()='" + пункт + "']]")
                .shouldBe(visible).scrollTo().click();
    }

    @Тогда("в меню отображаются пункты:")
    public void проверить_пункты(io.cucumber.datatable.DataTable таблица) {
        List<String> ожидаемые = таблица.asList();
        $$x("//div[contains(@class,'element-group')][.//div[contains(@class,'header-text') and normalize-space()='Alerts, Frame & Windows']]//li/span[@class='text']")
                .shouldHave(texts(ожидаемые));
    }

    @Тогда("отображается текст {string}")
    public void отображается_текст(String textValue) {
        $("#framesWrapper").shouldHave(text(textValue));
    }

    // ТК_1

    @Когда("пользователь переключается на родительский фрейм")
    public void переключиться_на_родительский_фрейм() {
        switchTo().frame($("#frame1").shouldBe(visible));
    }
    @Тогда("во фрейме отображается текст {string}")
    public void во_фрейме_отображается_текст(String текст) {
        $(byText(текст)).shouldBe(visible);
    }

    @Когда("пользователь переключается на дочерний фрейм")
    public void переключиться_на_дочерний_фрейм() {
        switchTo().frame($("iframe").shouldBe(visible));
    }

    @Когда("пользователь возвращается к родительскому фрейму")
    public void switchToParentFromChild() {
        switchTo().parentFrame();
    }

    @Когда("пользователь возвращается на основную страницу")
    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    // ТК_2

    @Тогда("на форме отображается кнопка с текстом {string}")
    public void проверить_текст_кнопки(String текст) {
        $("#startStopButton").shouldHave(text(текст));
    }

    @Когда("пользователь нажимает кнопку {string}")

    public void нажать_кнопку(String текст) {
        $("#startStopButton").shouldBe(visible).click();
    }

    @Тогда("кнопка изменяет текст на {string}")
    public void кнопка_изменяет_текст(String текст) {
        $("#startStopButton").shouldHave(text(текст));
    }

    @Когда("^прогресс достигает (\\d+) процентов$")
    public void ждать_прогресс(int число) {
        SelenideElement bar = $(".progress-bar").shouldBe(visible);
        int progress = 0;
        while (progress < число) {
            progress = Integer.parseInt(bar.getAttribute("aria-valuenow"));
            System.out.println("Текущий прогресс: " + progress + "%");
            sleep(200);
        }
    }
    @Тогда ("кнопка снова отображает {string}")
    public void отобразить_текст (String текст){
        $("#startStopButton").shouldHave(text(текст));
    };

    // ТК_3

    @Тогда ("на странице отображается пункт {string}")
    public void отобразить_атрибут(String лейбл) {
        $x("//div[@id='selectMenuContainer']//*[normalize-space()='" + лейбл + "']")
                .shouldBe(visible);
        $("#oldSelectMenu").shouldBe(visible);
    };

    @Когда("пользователь нажимает на выпадающий список Old Style Select Menu")
    public void clickOldStyleDropdown() {
        $("#oldSelectMenu").shouldBe(visible).scrollTo().click();
    }

    @И("выбирает значение {string}")
    public void выбрать_значение_в_old_select(String oldValue) {
        $("#oldSelectMenu").shouldBe(visible).selectOption(oldValue);
    }
    @Тогда("значение в пункте Old Style Select Menu становится {string}")
    public void проверить_значение_в_old_select(String expected) {
        $("#oldSelectMenu").getSelectedOption().shouldHave(text(expected));
    }

    @Когда("пользователь нажимает на выпадающий список Multiselect drop down")
    public void openMultiselect() {
        $("#react-select-4-input").shouldBe(visible);
    }

    @И("выбирает значение {string} и значение {string}")
    public void chooseTwoInMultiselect(String first, String second) {
        SelenideElement input = $("#react-select-4-input").shouldBe(visible);
        input.setValue(first).pressEnter();
        input.setValue(second).pressEnter();
    }

    @Тогда("в пункте Multiselect drop down отображаются {string} и {string}")
    public void checkMultiselect(String first, String second) {
        $("#selectMenuContainer").shouldHave(text(first), text(second));
    }

    private void удалить_баннер() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            executeJavaScript("document.getElementById('fixedban')?.remove();");
            executeJavaScript("document.querySelector('#close-fixedban')?.click();");
        }
    }
}



