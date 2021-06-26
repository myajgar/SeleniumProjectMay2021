package com.peoplentech.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch1 {
    public static void main(String[] args) throws InterruptedException {
        //set up the enviroment property //#3
        //to set the path of the driver for the browser u need system.setproperty
      System.setProperty("webDriver.chrome.driver" , "src/main/resources/chromedriver.exe ");
       //interview Q.IllegalStateException-if the chromeDriver.exe file path is set incorrectly.
           //created object for ChromeDeiver.
        WebDriver driver = new ChromeDriver();//  line number#1
        //interview question-explain webD d =new chromedriver
        //we are trying to create an object of chromedriver using interface WebDriver.
        //if we say chromeD d=new chromed that driver only work for chromedriver but if we use WebD D=NEW CromeD
        //down the line we can also say driver =firefoxDriver,same driver object can be reuse for different classes.
        // mening different browser like chrome and firefox.

       // open the browser
        driver.get("http://www.google.com");//browser open.//  #2
          //type for java books.
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java books");// #5
     //input[@class ='gLFyf gsfi']"-
        // //-->always start with double slash.
        //input-->tag name.
        //[@key='value']
        Thread.sleep(2000);// this wait time to see how things are done slowly.
       //click on Search button.
        driver.findElement(By.xpath("//input[@name ='btnK']")).click();// #6

       driver.quit();//quit method closes all the browsers.

     //  if u forgot where to start ,kickoff from here with some patient.u will be fine.



    }
}
