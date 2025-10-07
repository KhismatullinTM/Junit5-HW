package com.example.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.example.extensions.anno.SetUpBrowser;
import org.junit.jupiter.api.extension.*;

import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SetUpBrowserExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadTimeout = 20000;
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        String url = resolveUrl(context).orElse("https://demoqa.com/");
        Selenide.open(url);
        $("body").shouldBe(visible);
        System.out.printf(">>> [BeforeEach] Открыта страница: %s (Extension)%n");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт (Extension).");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println(">>> [AfterAll] Все тесты завершены (Extension).");
    }

    private Optional<String> resolveUrl(ExtensionContext ctx) {

        if (ctx.getTestMethod().isPresent()) {
            SetUpBrowser onMethod = ctx.getRequiredTestMethod().getAnnotation(SetUpBrowser.class);
            if (onMethod != null && !onMethod.url().isBlank()) {
                return Optional.of(onMethod.url());
            }
        }

        if (ctx.getTestClass().isPresent()) {
            SetUpBrowser onClass = ctx.getRequiredTestClass().getAnnotation(SetUpBrowser.class);
            if (onClass != null && !onClass.url().isBlank()) {
                return Optional.of(onClass.url());
            }
        }

        return Optional.empty();
    }
}

