package com.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Gmailloginstepdef {
    WebDriver driver = null;

    @Given("I'm on the Gmail Login Page")
    public void gmail_login_page() {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("chrome.switches","--disable-extensions");
    //System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Assignment\\src\\Browserdrivers\\geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Assignment\\src\\Browserdrivers\\chromedriver.exe");
    //driver = new FirefoxDriver();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();

    //WebDriverWait wait = new WebDriverWait(driver, 20);
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.get("https://gmail.com");
    //driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");

    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("Should be navigated to {string} page")
    public void navigatedTo_SigninPage(String signin) {

        WebElement logintext = driver.findElement((By.xpath("//DIV[@id='headingSubtext']")));

        if(logintext.isDisplayed()){
            String loginstr = logintext.getText();

            System.out.println("Current Url is login page" +loginstr);

        }
        else{

            System.out.println("Current Url is not login page" );
        }

    }

    @When("Enter Email as {string}")
    public void enter_EmailId(String emailid) throws InterruptedException {

        driver.findElement(By.id("identifierId")).sendKeys(emailid);
        System.out.println("Enter email id");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }

    @When("Click Next button")
    public void click_next_btn() throws InterruptedException {

        driver.findElement(By.className("VfPpkd-RLmnJb")).click();
        System.out.println("Click next button from email ID");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }

    @When("Enter Password as {string}")
    public void enter_Password(String password) throws InterruptedException {

        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
        System.out.println("Enter password");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }

    @Then("It should be navigated to Inbox page")
    public void shouldbe_Navigate_to_InboxPage() {

        if(driver.getCurrentUrl().equalsIgnoreCase("https://mail.google.com/mail/u/0/#inbox")){

            System.out.println("Navigated to Gmail inbox");
        }
        else{

            System.out.println("Not Navigated to Gmail inbox");

        }

    }

}
