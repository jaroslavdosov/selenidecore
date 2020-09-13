package com.example.demo.tests;

import annotations.TestId;
import com.codeborne.selenide.Selenide;
import com.example.demo.TestBase;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {

    @TestId(id="test=1-1")
    @Test
    public void openPage() {
        Selenide.sleep(8000);
        System.out.println("test1");
    }
}