package com.saucedemo.automation.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;   //for the headless

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser){

        WebDriver driverInstance;

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            //driverInstance = new ChromeDriver();  // for the UI chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driverInstance = new ChromeDriver(options);   //for the headless
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driverInstance = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driverInstance = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser not supported: "+ browser);
        }
        driver.set(driverInstance);
        driver.get().manage().window().maximize();


    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){

        if(driver.get() != null){
            driver.get().quit();
            driver.remove();     //prevent memory leak, delete driver from the thread
        }
    }

}
