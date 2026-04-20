package com.saucedemo.automation.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.saucedemo.automation.drivers.DriverManager;
import com.saucedemo.automation.listeners.TestListeners;
import com.saucedemo.automation.utils.ConfigReader;

@Listeners(TestListeners.class)
public class BaseTest {

    @BeforeMethod
    public void setup(){
            System.out.println("SETUP RUNNING...");
        DriverManager.initDriver(ConfigReader.get("browser"));
        DriverManager.getDriver().get(ConfigReader.get("baseUrl"));

    }

    @AfterMethod
    public void tearDown(){

         try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        } 

        DriverManager.quitDriver();
    }

}
