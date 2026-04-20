package com.saucedemo.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.saucedemo.automation.data.TestData;
//import com.saucedemo.automation.drivers.DriverManager;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class LoginTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "validLoginData", dataProviderClass = TestData.class)
    public void validLoginTest(String username, String password){

        log.info("test start");

        LoginPage loginPage = new LoginPage();  // inside the test for the parrallel execuation
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login(username, password);  
        //loginPage.login("standard_user", "secret_sauce");  //static way befor data driven

        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(),"Login Failed");
        
        /* Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("inventory"),   // no need for wait because selenium is wait for the loading of the page not for Element
        "Website did not open correctly"); */
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void invalidLoginTest(String username, String password){

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        //loginPage.login("standard_user", "secretsauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match")); // pass test
        //Assert.assertTrue(false); // to make fail test

    }

    @Test(dataProvider = "blockedLoginData", dataProviderClass = TestData.class)
    public void blockedLoginTest(String username, String password){

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        //loginPage.login("standard_user", "secretsauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked")); // pass test
        //Assert.assertTrue(false); // to make fail test

    }
 


}
