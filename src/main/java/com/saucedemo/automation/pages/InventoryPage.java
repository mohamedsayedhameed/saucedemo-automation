package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.saucedemo.automation.drivers.DriverManager;

public class InventoryPage extends BasePage {

    private By title = By.className("title");  //By.cssSelector("[data-test='inventory-title']") for future

    public boolean isInventoryPageDisplayed(){
        
     /* return DriverManager.getDriver().findElement(title).isDisplayed(); */ 

      /* return getWait().until(
        driver -> driver.findElement(title).isDisplayed()
    );   */

        getWait().until(ExpectedConditions.visibilityOfElementLocated(title));
        return true;
    
    }


}
