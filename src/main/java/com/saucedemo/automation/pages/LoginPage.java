package com.saucedemo.automation.pages;

//import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saucedemo.automation.drivers.DriverManager;

public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public void enterUsername(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return DriverManager.getDriver().findElement(errorMessage).getText();
    }
}
