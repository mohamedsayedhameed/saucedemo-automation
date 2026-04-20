package com.saucedemo.automation.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static{
        try(FileInputStream fis = new FileInputStream("src/main/resources/config.properties")){  //try with resouces , prevent from memory leak
            /*ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");*/ // this line is for CI, Docker
            properties.load(fis);
        }catch(IOException e){
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

}
