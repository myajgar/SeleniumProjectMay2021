package ebay;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase3aa {
    public static WebDriver driver;
    private static  Logger logger=Logger.getLogger(TestBase3aa.class);

     @BeforeMethod
    public static void setupBrowser(String browserName,String url ) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webDriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
        } else{
            System.setProperty("webDriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();

        }//implicitlyWait is depend on element how much taking time to see all element in the page.
        driver.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      @AfterMethod
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
    public void clickOnIdAndSendKey(String id, String key) {
        driver.findElement(By.id(id)).sendKeys(key);
    }
    public void clickOnIdAndClick(String id) {
        driver.findElement(By.id(id)).click();
    }
    public void clickOnXpath(String xpath){driver.findElement(By.xpath(xpath)).click();}
    public void TypeOnXpath(String xpath, String data) { driver.findElement(By.xpath(xpath)).sendKeys(data);

    }
}
