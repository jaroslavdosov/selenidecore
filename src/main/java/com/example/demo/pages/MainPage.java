package com.example.demo.pages;


import com.codeborne.selenide.SelenideElement;
import com.example.demo.annotations.ElementTitle;
import com.example.demo.annotations.ElementType;
import com.example.demo.webelements.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class MainPage extends Page{

    @ElementType(type = "webElements")
    @ElementTitle(title = "Хидер")
    public Header header() { return page(Header.class);}

    @ElementType(type = "button")
    @ElementTitle(title = "Кнопка Поиск")
    private  SelenideElement searchButton() { return $(By.xpath("//input[@class=\"searchbutton\"]"));}

    @Step("Нажать на кнопку Поиск")
    public  MainPage clickSearchButton() {
        searchButton().click();
        return page(MainPage.class);
    }



}