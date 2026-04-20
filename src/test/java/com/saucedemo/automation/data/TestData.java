package com.saucedemo.automation.data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData(){
        return new Object[][] {
           {"standard_user", "secret_sauce"},
           
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData(){
        return new Object[][] {
           {"invalid_user", "wrong_pass"}
        };
    }

    @DataProvider(name = "blockedLoginData")
    public static Object[][] blockedLoginData(){
        return new Object[][] {
           {"locked_out_user", "secret_sauce"},
        };
    }

}


