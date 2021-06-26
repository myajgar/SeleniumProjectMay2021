package ebay;

import com.peoplentech.selenium.TestBase3bb;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayTest3aa extends TestBase3bb {
    private static final Logger logger = Logger.getLogger(EbayTest3aa.class);

    @Test
    public void validateUserCanSearchForItemsInEbay() {
       //setupBrowser("chrome", "https://www.ebay.com");
        logger.info("browser opened and ebay.com launched");
        String  actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't matched");
        logger.info("ebay homepage url has validate");
//inside the findElement has WebE.this time Instead of findElement By.click we store it to WebElement.
        WebElement ebayLogo = driver.findElement(By.id("gh-l-h1"));
        //boolean result=ebayLogo.isDisplayed;(isdisplayed return something thats why we store it)
        //Assert.assertEquals(result,expected:true,message:"result is not true";instead 2line we can say 1line.
        Assert.assertTrue(ebayLogo.isDisplayed());//isDisplay method return true/false.
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
   //    closeBrowser();
    }

    @Test //dropdown
    public void validateUserBeingAbleToChooseOptionFromSearchDropDown() {
       // setupBrowser("chrome", "https://www.ebay.com");
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Music");
    //    closeBrowser();
    }

    @Test //MouseHover
    public void validateUserBeingAbleToChooseOptionFromMouseHover() {
     // setupBrowser("chrome", "https://www.ebay.com");
        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        driver.findElement(By.linkText("Classics")).click();
    //    closeBrowser();
    }
    /*
    JavaScriptExecutor is used when Selenium Webdriver fails to click on any element.
     JavaScriptExecutor provides two methods "executescript" & "executeAsyncScript" to handle.
      Executed the JavaScript using Selenium Webdriver.
     */

    @Test //MouseHover
    public void validateUserShouldBeAbleToScrollDown() {
      //  setupBrowser("chrome", "https://www.ebay.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;//enable the driver
        js.executeScript("window.scrollBy(0,1000)");//in the zero position i want put 1000 pixel.
      //  closeBrowser();//1000 is pixel how much u want scrool down.
    }

    @Test //MouseHover
    public void validateUserShouldBeAbleToScrollDownToElement() {
        // setupBrowser("chrome", "https://www.ebay.com");
        WebElement element = driver.findElement(By.linkText("Registration"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
        @Test
        public void validateUserCanABleToCheckWindowPopUp(){




        }


    // closeBrowser();
        //after that we have test Drag an dDrop need it for interview question.class12/2:50:00/05-09-21
        //Actions actions =new Actions(driver);what class u need for DAD? -Actions //DragAndDrop
        //actions.dragAndDrop(source,destination).build().perform();
        //in the Actions class we fit the driver object.
        //we use dragAndDrop method .this method takes "source" ,destination.


}