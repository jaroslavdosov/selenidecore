package com.example.demo.listeners;

import com.example.demo.annotations.TestId;
import com.example.demo.utils.AttachmentsUtils;
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
        saveResult(iTestResult, "success");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveResult(iTestResult, "failure");
        AttachmentsUtils attach = new AttachmentsUtils();
        attach.makeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        saveResult(iTestResult, "skipped");
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

    // сохраненение результата в тест рейл или куда-нибудь ещё
    //  to do - пенести в отдельный класс
    public void saveResult(ITestResult iTestResult, String result) {
        System.out.println(iTestResult.getMethod());
        System.out.println(iTestResult.getTestClass());

        for (Method testMethod : iTestResult.getTestClass().getRealClass().getMethods()) {
            if (testMethod.getName().equals(iTestResult.getName()) && testMethod.isAnnotationPresent(TestId.class)) {

                TestId useAsTestName = testMethod.getAnnotation(TestId.class);
                System.out.println("Case ID---> " +  useAsTestName.id() + "is " + result);
            }
        }
        System.out.println("ti super! test ");
    }
}