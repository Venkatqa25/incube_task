package com.qa.stepdef;

import com.qa.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Gmailloginstepdef {
    SoftAssert s_assert = null;
    //WebDriver driver = null;
    public static WebDriver driver;
    @Given("I'm on the Gmail Login Page")
    public void gmail_login_page() {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("chrome.switches","--disable-extensions");
    //System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Assignment\\src\\Browserdrivers\\geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Assignment\\src\\Browserdrivers\\chromedriver.exe");
    //driver = new FirefoxDriver();
    //WebDriverManager.chromedriver.setup();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();

    //WebDriverWait wait = new WebDriverWait(driver, 20);
    driver.manage().deleteAllCookies();

    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.get("https://gmail.com");
    //driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");

    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("Should be navigated to {string} page")
    public void navigatedTo_SigninPage(String signin) {
        s_assert = new SoftAssert();
        WebElement logintext = driver.findElement((By.xpath("//DIV[@id='headingSubtext']")));

        if(logintext.isDisplayed()){
            String loginstr = logintext.getText();
            System.out.println("Current Url is login page" +loginstr);
            s_assert.assertTrue(true,"Current Url is login page" +loginstr);

        }
        else{
            s_assert.fail("Current Url is not login page");
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
        System.out.println("Click next button from Email ID/Password");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Enter Password as {string}")
    public void enter_Password(String password) throws InterruptedException {

        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
        System.out.println("Enter password");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Then("It should be navigated to Inbox page")
    public void shouldbe_Navigate_to_InboxPage() throws InterruptedException {
        s_assert = new SoftAssert();
        if(driver.getCurrentUrl().equalsIgnoreCase("https://mail.google.com/mail/u/0/#inbox")){
            s_assert.assertTrue(true,"Navigated to Gmail inbox");
            System.out.println("Navigated to Gmail inbox");
        }
        else{
            s_assert.fail(" Not Navigated to Gmail inbox");
            System.out.println("Not Navigated to Gmail inbox");

        }
        Thread.sleep(5000);

    }
    @When("Click compose button")
    public void clickComposeButton() throws InterruptedException {
        //driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Need to click compose button");
        WebElement composebtn = driver.findElement(By.xpath("//DIV[@class='T-I T-I-KE L3'][text()='Compose']"));
        composebtn.click();
         System.out.println("Click the compose button");
         Thread.sleep(3000);

    }

    @And("Enter Email id {string} in to address bar")
    public void enterEmailIdInToAddressBar(String userbmaiild) throws InterruptedException {

        WebElement toaddressbar = driver.findElement(By.name("to"));
        toaddressbar.sendKeys(userbmaiild);
        System.out.println("Enter to email id in addressbar" +userbmaiild);
        Thread.sleep(2000);

    }

    @And("Enter the mail Subjet {string} in subject field")
    public void enterTheMailInSubjectField(String mailsubject) throws InterruptedException {
        driver.findElement(By.name("subjectbox")).sendKeys(mailsubject);
        System.out.println("Enter mail subject " +mailsubject);
        Thread.sleep(4000);
    }

    @When("Enter the content {string} of the mail")
    public void enterTheContentOfTheMail(String body1) throws InterruptedException {
        WebElement text1 = driver.findElement(By.xpath("//DIV[@aria-label='Message Body']"));
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(text1));
        text1.sendKeys(body1);

       // driver.findElement((By.xpath("//DIV/self::DIV"))).sendKeys("I did a Google search, but couldn't find out how to escape the period before tex.");
        ////DIV/self::DIV
        //driver.findElement(By.xpath("//DIV[@id=':pn']"));
        //driver.findElement(By.id(":61"));
        //driver.findElement(By.xpath("//DIV[@id=':pn']")).sendKeys(body1);
        System.out.println("Enter body one: "+body1);
        Thread.sleep(2000);
    }

}
