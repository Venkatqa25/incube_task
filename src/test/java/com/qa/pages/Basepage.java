package com.qa.pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
    public static WebDriver driver;
    //TestUtils utils = new TestUtils();
    public Basepage(){

        PageFactory.initElements(driver, this);
        
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        //utils.log().info(msg);
        e.click();
    }
    
    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        //utils.log().info(msg);
        e.sendKeys(txt);
    }

}
