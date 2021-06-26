package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverLaunch3 {   //here we are showing create a method and call them in main method.
      private static WebDriver driver ;
      public static void setupBrowser(){
          System.setProperty("webDriver.chrome.driver" , "src/main/resources/chromedriver.exe");
         driver = new ChromeDriver();//since we take variable webdriver driver we dont need to say webdriver anym
         driver.get("http://www.ebay.com");
    }
    public static void closeBrowser() throws InterruptedException {
      //  Thread.sleep(5000);
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        setupBrowser() ;
        driver.findElement(By.id("gh-ac")).sendKeys("java books");
        //driver.findElement(By.id("firstname")).sendKeys("ajgar");
        closeBrowser();
    }


}
//if we want to write one more testcase in this main method we need to create another method in the class.
//can we have too many method in the class? no we can.than how can we have two different test case in same class

//with testNG u don't need to create main method to write 10 test case.see details DriverLaunch3TestNG.