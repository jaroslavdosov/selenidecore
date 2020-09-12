package com.example.demo.tests;

import annotations.TestId;
import com.example.demo.TestBase;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {

    @TestId(id="test=1-1")
    @Test
    public void openPage() {
        System.out.println("test1");
    }
}