package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverLaunch3ba { //validate the url.every action we need to validate.as a human we know ebay home
    private static WebDriver driver;//page to see logo or url but computer doesnt kno.

    public static void setupBrowser(String browsername, String url) {
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
        } else {
            System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(url);
        }
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() {
        waitFor(5);
        driver.quit();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }
    public void clickOnLinkText(String LinkText) {
        driver.findElement(By.linkText(LinkText)).click();
    }
    public void clickOnId(String id) { driver.findElement(By.id(id)).click();}
    public void TypeOnXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    @Test
    public void validatusercanclickonSignInbutton() {
        setupBrowser("chrome", "https://www.ebay.com");
        System.out.println("browser opened and ebay homepage launched");//perform validation after every action(1)
        String actualUrl = driver.getCurrentUrl();//
        String expectedUrl = "https://www.ebay.com/";//its always good to keep the logs so u will know what happning2
       /* if (actualUrl.equalsIgnoreCase(expectedUrl)) {//now make sure how do  2 String are same.
            System.out.println("url matched");//insted 55-58 the 4line we can say by one line 60.
        }else {
            System.out.println("url didnt matched");//when expected result are met the actual result tc passed.
        }*/ //parctice with the url slash with or without so u will know the different.
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't matched");
        System.out.println("ebay homepage url has validate");
        clickOnLinkText("Sign in");
        driver.findElement(By.id("userid")).sendKeys("dbname");
        closeBrowser();
    }

    @Test
    public void validatusercanclickonregisterbutton() {
        setupBrowser("chrome", "https://www.ebay.com/");
        clickOnLinkText("register");
        navigateBack();
        driver.findElement(By.id("firstname")).sendKeys("AJGAR");
        closeBrowser();

    }

    @Test
    public void validatusercanSearchitemsInamazonXpath() {
        setupBrowser("firefox", "https://www.amazon.com");
        System.out.println("amaazon homepage lanuched");
        String actualurl="";
        String expectedurl="https://www.amazon.com";
        TypeOnXpath("//input[@id='twotabsearchtextbox']", "java books");
        closeBrowser();

    }

    @Test
    public void validateLoginFunctionally() {

    }
}