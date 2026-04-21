package com.saucedemo.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.saucedemo.automation.data.TestData;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "validLoginData", dataProviderClass = TestData.class)
    public void validLoginTest(String username, String password){

        log.info("========== START validLoginTest ==========");
        log.info("Attempting login with username: {}", username);

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        log.info("Performing login action");
        loginPage.login(username, password);

        log.info("Verifying inventory page is displayed");
        boolean isDisplayed = inventoryPage.isInventoryPageDisplayed();

        if(isDisplayed){
            log.info("Login successful for user: {}", username);
            log.info("Login successful for user: {}", username);
        }else{
            log.error("Login failed for user: {}", username);
        }

        Assert.assertTrue(isDisplayed, "Login Failed");

        log.info("========== END validLoginTest ==========");
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void invalidLoginTest(String username, String password){

        log.info("========== START invalidLoginTest ==========");
        log.info("Attempting invalid login with username: {}", username);

        LoginPage loginPage = new LoginPage();

        log.info("Performing login action");
        loginPage.login(username, password);

        log.info("Validating error message for invalid login");
        String errorMessage = loginPage.getErrorMessage();

        log.info("Actual error message: {}", errorMessage);

        if(errorMessage.contains("Username and password do not match")){
            log.info("Correct error message displayed");
        }else{
            log.error("Incorrect error message displayed");
        }

        Assert.assertTrue(errorMessage.contains("Username and password do not match"));

        log.info("========== END invalidLoginTest ==========");
    }

    @Test(dataProvider = "blockedLoginData", dataProviderClass = TestData.class)
    public void blockedLoginTest(String username, String password){

        log.info("========== START blockedLoginTest ==========");
        log.info("Attempting login for blocked user: {}", username);

        LoginPage loginPage = new LoginPage();

        log.info("Performing login action");
        loginPage.login(username, password);

        log.info("Validating blocked user message");
        String errorMessage = loginPage.getErrorMessage();

        log.info("Actual error message: {}", errorMessage);

        if(errorMessage.contains("locked")){
            log.info("Blocked user validation successful");
        }else{
            log.error("Blocked user validation failed");
        }

        Assert.assertTrue(errorMessage.contains("locked"));

        log.info("========== END blockedLoginTest ==========");
    }
}
















///////////
/// ////////
/// the old one without logging
/// /////////


/*package com.saucedemo.automation.tests;

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
        "Website did not open correctly"); */ /* 
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
 


}*/
