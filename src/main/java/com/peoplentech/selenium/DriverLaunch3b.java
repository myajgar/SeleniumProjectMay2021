package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverLaunch3b { //made custom method so that code looks more cleaner.
    private static WebDriver driver;//we made global var so other method can use it.

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
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        waitFor(5);
        driver.quit();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public void clickOnLinkText(String lnkTxt) {
        driver.findElement(By.linkText(lnkTxt)).click();
    }

    public void clickOnId(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickOnXpath(String xpth) {
        driver.findElement(By.xpath(xpth)).click();
    }

    public void TypeOnXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    @Test
    public void validatusercanclickonSignInbutton() {
        setupBrowser("chrome", "https://www.ebay.com/");
        waitFor(3);
        clickOnLinkText("Sign in");
        navigateBack();
        closeBrowser();
    }

    @Test
    public void validatusercanclickonregisterbutton() {
        setupBrowser("chrome", "https://www.ebay.com/");
        clickOnLinkText("register");
       // driver.findElement(By.id("firstname")).sendKeys("AJGAR");
        closeBrowser();

    }

    @Test
    public void validatusercanSearchitemsInamazonXpath() {
        setupBrowser("firefox", "https://www.amazon.com");
        TypeOnXpath("//input[@id='twotabsearchtextbox']", "java books");
        closeBrowser();
    }
    @Test
    public void validateUserCanAbleTo(){
        setupBrowser("firefox","https://www.amazon.com");
        TypeOnXpath("//input[@id='twotabsearchtextbox']","selenium books");
        closeBrowser();
    }

}