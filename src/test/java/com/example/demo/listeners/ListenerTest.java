package com.example.demo.listeners;

import annotations.TestId;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod());
        System.out.println(iTestResult.getTestClass());

        for (Method testMethod : iTestResult.getTestClass().getRealClass().getMethods()) {
            if (testMethod.getName().equals(iTestResult.getName()) && testMethod.isAnnotationPresent(TestId.class)) {

                TestId useAsTestName = testMethod.getAnnotation(TestId.class);
                System.out.println("Case ID---> " +  useAsTestName.id() + " Run ID--> ");
                System.out.println("send44444444444444444444");
                System.out.println(useAsTestName);
            }
        }

        System.out.println("ti super!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}