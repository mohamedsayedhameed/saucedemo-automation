package com.saucedemo.automation.utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;
    
    public static ExtentReports getInstance(){

        if(extent==null){
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

}
