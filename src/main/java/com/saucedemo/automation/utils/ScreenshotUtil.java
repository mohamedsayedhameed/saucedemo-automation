package com.saucedemo.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.saucedemo.automation.drivers.DriverManager;

public class ScreenshotUtil  {
        public static String takeScreenshot(String testname){
        
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        //String dirPath = "screenshot";
        String dirPath = "test-output/screenshots"; // for the report
        String filePath = dirPath + "/" + testname + "_" + timestamp + ".png";
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdir();
        }
        File src = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        try{
            FileUtils.copyFile(src, dest);
        }catch(IOException e){
            e.printStackTrace();
        }

        //return filePath;
        return dest.getAbsolutePath();  // for the report
        //return "../test_output/screenshots/" + testname + "_" + timestamp + ".png";
    }
}
