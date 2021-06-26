package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverLaunch3TestNG {
    public static WebDriver driver;

    public static void setupBrowser(String browsername,String url) {
        System.setProperty("webDriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.ebay.com");
    }

    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test //to run it we can add @Test  for testcase.from testNG we have dependency thta what its come from.
    public static void validateUserCanClickOnRegisterButton() throws InterruptedException {//testcase
        setupBrowser("chrome","http://www.ebay.com");
        driver.findElement(By.linkText("register")).click();
        driver.findElement(By.id("firstname")).sendKeys("ajgar");
        closeBrowser();
    }
    @Test
    public static void validateUserCanClickOnSignInButton() throws InterruptedException {//testcase
        setupBrowser("chrome","http://www.ebay.com");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("firstname")).sendKeys("ajgar");
        closeBrowser();
    }
    @Test
    public void validateUserCanAbleToHandleMultipleWindow(){
        setupBrowser("chrome","http://www.google.com");
    }
} //we have two testcase from same url ebay if we want to add another url for amazon what we can do.
//see next class for details.//DriverLaunch3uParams