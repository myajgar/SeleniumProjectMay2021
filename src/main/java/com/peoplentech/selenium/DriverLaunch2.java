package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch2 {
    public static void main(String[] args) throws InterruptedException {
       //website ebay tried by id and linktext.
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         driver.get("https://www.ebay.com/");

         driver.findElement(By.id("gh-ac")).sendKeys("i-phone");
         driver.findElement(By.id("gh-btn")).click();
         Thread.sleep(5000);

         driver.findElement(By.linkText("Sell")).click();

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi' ]")).sendKeys("java books");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.xpath("//img[@alt='Google']")).click();
        driver.findElement(By.xpath("//a[@class='MV3Tnb']")).click();

        Thread.sleep(5000);//what exception sleep method throws ##interruptedException..good interview ?
        driver.quit();
        //driver.get("http://www.ebay.com");

        //driver.findElement(By.id("gh-ac")).sendKeys("java books");
       // driver.findElement(By.id("gh-btn")).click();
       // driver.findElement(By.linkText("register")).click();
        //driver.findElement(By.id("firstname")).sendKeys("ajgar");


    }
}
