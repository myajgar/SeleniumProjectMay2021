package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase3bb {
    public static WebDriver driver;
    private static Logger logger = Logger.getLogger(TestBase3bb.class);

   @BeforeMethod
    public static void setupBrowserLunchurl() {
       String browsername="chrome";
       String url="https://www.ebay.com";
       String os ="windows";
        if (os.equalsIgnoreCase("mac")) {
            if (browsername.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();

            } else if(browsername.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
            }
        }else if (os.equalsIgnoreCase("windows")){

                if (browsername.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                } else {
                    System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();


                }



            }
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(url);
        }

        public static void waitFor ( int seconds){
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         @AfterMethod
        public static void closeBrowser () {
            waitFor(5);
            driver.quit();
        }

        public static void navigateBack () {
            driver.navigate().back();
        }
        public void clickOnLinkText (String LinkText){
            driver.findElement(By.linkText(LinkText)).click();
        }
        public void clickOnId (String id){
            driver.findElement(By.id(id)).sendKeys("java books");
        }
        public void clickOnXpath (String xpath){
            driver.findElement(By.xpath(xpath)).click();
        }
        public void TypeOnXpath (String xpath, String data){
            driver.findElement(By.xpath(xpath)).sendKeys(data);
        }

    }
