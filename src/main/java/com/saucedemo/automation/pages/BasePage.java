package com.saucedemo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.automation.drivers.DriverManager;

public class BasePage {

    protected WebDriverWait getWait(){

        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    }

    public void type(By locator, String text){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        DriverManager.getDriver().findElement(locator).sendKeys(text);
    }

    public void click(By locator){
         getWait().until(ExpectedConditions.elementToBeClickable(locator));  //ElementNotInteractableException ensure element is clickable to avoid interaction issues
         DriverManager.getDriver().findElement(locator).click();
    }



}
