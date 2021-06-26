package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayTest3bb extends TestBase3bb {
    private static Logger logger = Logger.getLogger(EbayTest3bb.class);

    @Test
    public void validateUserCanSearchForItemsInEbay() {

        logger.info("browser opened and ebay.com launched");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't matched");
        logger.info("ebay homepage url has validate");
//so this time we are not putting dod click after findElement.we are going to store it WebElement coz inside finde we have WebE
        WebElement ebayLogo = driver.findElement(By.id("gh-l-h1"));//
        Assert.assertTrue(ebayLogo.isDisplayed());//isDisplayed return true/false
        logger.info("ebay logo has been displayed");


        waitFor(5);
        TypeOnXpath("//input[@id='gh-ac']", "java books");
        logger.info("type java books in the search bar");


        clickOnId("gh-btn");
        logger.info("search button has been clicked");
        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String log = result.getText();
        Assert.assertTrue(log.contains("java books"), "log didn;t contains java books");
        logger.info(log + "has been displayed");

    }

    @Test(priority =1 )
    public void validateUserBeingAbleToChooseOptionFromSearchDropDown() {
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Music");
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToChooseOptionFromMouseHover() {

        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        driver.findElement(By.linkText("Classics")).click();

    }

    @Test (enabled = false)
    public void validateUserShouldBeAbleToScrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    @Test ()
    public void validateUserShouldBeAbleToScrollDownToElement() {

        WebElement element = driver.findElement(By.linkText("Registration"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//@Test
//public void validateUserCanABleToCheckWindowPopUp(){
        //setupBrowser();
//}

}