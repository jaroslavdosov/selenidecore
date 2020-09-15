package com.example.demo.webelements;


import com.example.demo.pages.QaPage;
import com.example.demo.pages.TestingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Header {

    @Step("������ �� ����� ����������� ��������")
    public QaPage clickQa() {
        $(By.xpath("//li/a[text()='����������� ��������']")).click();
        return page(QaPage.class);

    }

    @Step("������ �� ����� ������������")
    public TestingPage clickTestig() {
        $(By.xpath("//li/a[text()='������������']")).click();
        return page(TestingPage.class);

    }
}
