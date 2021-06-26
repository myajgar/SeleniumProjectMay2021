package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverLaunch3bb { //used logger class u don;t need to use println .
    private static WebDriver driver;//class lavel variable so that we can use anywhere.
    private static  Logger logger=Logger.getLogger(DriverLaunch3bb.class);//create object for logger class.
    public static void setupBrowser(String browsername, String url) {
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webDriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
        } else {
            System.setProperty("webDriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();

        }//thread.sleep freze the whole execution so that at work we need to use line 30.when page is loading its
         //takes longer than expected so add line 30 befor get(url).when u launch url to find element its will wait
        //10 sec max.pageload time#
        driver.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(url);//any elements b4 throuh exception its wait called implicitlyWait.
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
    public void clickOnId(String id) {
        driver.findElement(By.id(id)).sendKeys("java books");
    }
    public void clickOnXpath(String xpath){driver.findElement(By.xpath(xpath)).click();}
    public void TypeOnXpath(String xpath, String data) { driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    @Test
    public void validateUserCanSearchForItemsInEbay() {
        setupBrowser("chrome", "https://www.ebay.com/");
        logger.info("browser opened and ebay.com launched");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";//make both String are same we use if-else.
        //if(actualUrl.equalsIgnoreCase(expectedUrl)){
        // system.out.println("url matched");
        //}else{
        //system.out.println("url didn't matched")}//insted 4line we can say by 1 line 71.compare 2string #Assertequals
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't matched");
        logger.info("ebay homepage url has validate");

    WebElement ebayLogo= driver.findElement(By.id("gh-l-h1"));
     //boolean result=ebayLogo.isDisplayed();//isDisplay method represent true/false
    //Assert.assertEquals(result,true,"result didnt matched");
    Assert.assertTrue(ebayLogo.isDisplayed());//insted 2line we can do with one line.asserttrue return the value true/false
    logger.info("ebay logo has been displayed");


        waitFor(5);
       TypeOnXpath("//input[@id='gh-ac']", "java books");
       logger.info("type java books in the search bar");



        clickOnId("gh-btn");
        logger.info("search button has been clicked");
        WebElement result=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String log=result.getText();
        Assert.assertTrue(log.contains("java books"),"log didn;t contains java books");
        logger.info(log+ "has been displayed");
        //System.out.println(result.getText());
       // boolean rs=log.contains("java books");//string has method called contains return true/false.
        closeBrowser();
    }

    @Test
    public void validateUerCanClickOnRegisterButton() {
        setupBrowser("chrome", "https://www.ebay.com/");
        logger.info("browser opend and ebay homepage displayed");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't matched");
        logger.info("ebay homepage url has validate");
        clickOnLinkText("register");
        WebElement createaccount = driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT"));
        Assert.assertTrue(createaccount.isDisplayed());
        logger.info("create account has been displayed");

       //navigateBack();
        driver.findElement(By.id("firstname")).sendKeys("AJGAR");
        logger.info("first name has been filled");

        closeBrowser();

    }

    @Test
    public void validatusercanSearchitemsInamazonXpath() {
        setupBrowser("firefox", "https://www.amazon.com");
        TypeOnXpath("//input[@id='twotabsearchtextbox']", "java books");
        closeBrowser();

    }
}