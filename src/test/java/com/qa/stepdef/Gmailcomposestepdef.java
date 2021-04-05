package com.qa.stepdef;

import com.qa.pages.Basepage;
import com.qa.pages.Gmailcomposepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

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

public class Gmailcomposestepdef extends Basepage {
    SoftAssert s_assert = null;
    //WebDriver driver = null;
    //public static WebDriver driver;

    @Given("I'm on the Gmail Login Page")
    public void gmail_login_page() {
        new Basepage();
        
		//System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Assignment\\src\\Browserdrivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
         WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://gmail.com");
        
    }

    @Then("Should be navigated to {string} page")
    public void navigatedTo_SigninPage(String signin) {

        new Gmailcomposepage().confirmthe_Signinpage();
    }

    @When("Enter a Email as {string}")
    public void enter_EmailId(String emailid) throws InterruptedException {

        new Gmailcomposepage().fillthe_Emailid(emailid);
    }

    @When("Click on Next button")
    public void click_next_btn() throws InterruptedException {

        new Gmailcomposepage().clickon_nextbutton();
    }

    @When("Enter a Password as {string}")
    public void enter_Password(String password) throws InterruptedException {

        new Gmailcomposepage().fillthe_Password(password);
    }

    @Then("It should be navigated to Inbox page")
    public void shouldbe_Navigate_to_InboxPage() throws InterruptedException {

        new Gmailcomposepage().navigate_to_InboxPage();

    }
    @When("Click on compose button")
    public void clickComposeButton() throws InterruptedException {

        new Gmailcomposepage().clickonthe_ComposeButton();
    }

    @And("Enter a Email id {string} in to address bar")
    public void enterEmailIdInToAddressBar(String userbmaiild) throws InterruptedException {

        new Gmailcomposepage().fill_EmailIdIn_ToAddressBar(userbmaiild);

    }

    @And("Enter the mail Subject {string} in subject field")
    public void entersubject_SubjectField(String mailsubject) throws InterruptedException {

        new Gmailcomposepage().fill_Subject_SubjectField(mailsubject);
    }

    @When("Enter the content {string} of the mail")
    public void enterTheContentOfTheMail(String content) throws InterruptedException {

        new Gmailcomposepage().fillThe_ContentOfTheMail(content);

    }

    @When("Click on Send button")
    public void clickonSendButton() throws InterruptedException {

     new Gmailcomposepage().clickon_SendButton();
    }

    @And("Go to Sent section")
    public void goToSentSection() throws InterruptedException {

        new Gmailcomposepage().navigate_To_SentSection();
    }

    @Then("Verify mail subject {string} which sent to UserB displayed in sent mail")
    public void verifyMailWhichSentDisplayedInMailBox(String subjectinsent) throws InterruptedException {

        new Gmailcomposepage().verify_Mail_WhichSent_UserB(subjectinsent);

    }

    @When("Click on User Account to Signout")
    public void clickOnUserAccountToLogout() throws InterruptedException {

        new Gmailcomposepage().clickOn_UserAccount_ToSignout();
    }

    @And("Click on Sign out the GMail")
    public void clickOnSignOutTheGMail() throws InterruptedException {

        new Gmailcomposepage().clickOn_SignOutThe_GMail();
        new Gmailcomposepage().quit_driver();
    }
}
