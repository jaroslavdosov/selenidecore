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

@Feature("����� ������� ��������")
public class MainPageTest extends TestBase {

    @TestId(id="test=1-1")
    @Test(description = "�������� ����")
    @Description("�������� �����")
    @Story("������ �����")
    public void openPage() {
        MainPage mainPage = open("", MainPage.class);
        Selenide.sleep(4000);

        mainPage.clickSearchButton();
        Selenide.sleep(4000);

        QaPage qaPage = mainPage.header().clickQa();
        Selenide.sleep(4000);
    }
}