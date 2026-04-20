package com.saucedemo.automation.listeners;

import com.saucedemo.automation.utils.ExtentManager;
import com.saucedemo.automation.utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentTest;

public class TestListeners implements ITestListener {

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest =
        ExtentManager.getInstance().createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String screenshotPath = ScreenshotUtil.takeScreenshot(result.getName());

       System.out.println("Screenshot saved at: " + screenshotPath);
        test.get().fail(result.getThrowable());
        test.get().fail("Test Failed").addScreenCaptureFromPath(screenshotPath);
        System.out.println("Screenshot saved at: " + screenshotPath);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.get().pass("Test Passed");
    }

    

    @Override
    public void onFinish(org.testng.ITestContext context){
        ExtentManager.getInstance().flush();
    }



}
