package com.example.demo.tests;

import com.example.demo.annotations.TestId;
import com.codeborne.selenide.Selenide;
import com.example.demo.TestBase;
import com.example.demo.pages.MainPage;
import com.example.demo.pages.QaPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Feature("Тесты главной страницы")
public class MainPageTest extends TestBase {

    @TestId(id="test=1-1")
    @Test(description = "Тестовый тест")
    @Description("Описание теста")
    @Story("Раздел теста")
    public void openPage() {
        MainPage mainPage = open("", MainPage.class);
        Selenide.sleep(4000);

        mainPage.clickSearchButton();
        Selenide.sleep(4000);

        QaPage qaPage = mainPage.header().clickQa();
        Selenide.sleep(4000);
    }
}