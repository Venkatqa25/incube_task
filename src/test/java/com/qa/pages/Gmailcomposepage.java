package com.qa.pages;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Gmailcomposepage extends Basepage {
	SoftAssert s_assert = null;
	//public static WebDriver driver;
	

	@FindBy(xpath="//DIV[@id='headingSubtext']") public WebElement logintext;
	//WebElement logintext = driver.findElement((By.xpath("//DIV[@id='headingSubtext']")));
	@FindBy(id="identifierId") public WebElement identifyemail;
	@FindBy(className = "VfPpkd-RLmnJb") public WebElement identifynextbutton;
	@FindBy(xpath = "//input[@type=\"password\"]") public WebElement identifypassword;
	@FindBy(xpath = "//DIV[@class='T-I T-I-KE L3'][text()='Compose']") public WebElement composebutton;
	@FindBy(name = "to") public WebElement toaddressfield;
	@FindBy(name = "subjectbox") public WebElement identifysubject;
	@FindBy(xpath = "//DIV[@aria-label='Message Body']") public WebElement identifymsgbody;
	@FindBy(xpath = "//DIV[@data-tooltip='Send \u202A(Ctrl-Enter)\u202C']") public WebElement identifycomposebtn;
	@FindBy(xpath = "//a[@aria-label='Sent']") public WebElement identifysentbox;
	@FindBy(className = "bqe") public WebElement identifysentsubject;
	@FindBy(xpath = "//img[@class='gb_Da gbii']") public WebElement identifyaccountimg;
	@FindBy(xpath = "//a[@id='gb_71']") public WebElement identifysingout;

	/*
	 * public Gmailcomposepage(){
	 * 
	 * }
	 */
	/*
	 * public Gmailcomposepage baseSetup() { new Basepage();
	 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 * driver.get("https://gmail.com"); return this; }
	 */
	public Gmailcomposepage quit_driver() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		return this;
	}
	public Gmailcomposepage clickOn_SignOutThe_GMail() throws InterruptedException {
		Thread.sleep(3000);
				click(identifysingout,"Click on the Singout to get out of the Gmail");
		return this;
	}

	public Gmailcomposepage clickOn_UserAccount_ToSignout() throws InterruptedException {

		Thread.sleep(5000);
		click(identifyaccountimg,"Click on the User account to Singout the Gmail");
		return this;
	}

	public Gmailcomposepage verify_Mail_WhichSent_UserB(String subjectinsent) throws InterruptedException {
		s_assert = new SoftAssert();
		String capturesubtext = identifysentsubject.getText();
		Thread.sleep(2000);
		System.out.println("Get subject of the mail from sent" +capturesubtext);
		try{
			s_assert.assertEquals(capturesubtext,subjectinsent);
			System.out.println("Actual Message " +capturesubtext+ "Match with" +subjectinsent);
		}
		catch (Exception e){

			s_assert.fail("Actual Message " +capturesubtext+ "Mismatch with" +subjectinsent);
			System.out.println("Actual Message " +capturesubtext+ "Mismatch with" +subjectinsent);
		}
		return this;
	}


	public Gmailcomposepage navigate_To_SentSection() throws InterruptedException {

		click(identifysentbox,"Click on sent box to verify mail which sent to UserB");
		System.out.println("Click on sent box to verify mail which sent to UserB");
		Thread.sleep(3000);
		return this;
	}

	public Gmailcomposepage clickon_SendButton() throws InterruptedException {
		Thread.sleep(5000);
		click(identifycomposebtn,"Click on send button to send mail");
		System.out.println("Click on Send button to send mail");
		Thread.sleep(5000);
		return this;
	}

	public Gmailcomposepage fillThe_ContentOfTheMail(String content) throws InterruptedException {
		sendKeys(identifymsgbody,content,"Enter the content of the mail");
		System.out.println("Enter the content of the mail");
		return this;
	}

	public Gmailcomposepage fill_Subject_SubjectField(String mailsubject) throws InterruptedException {
		
		sendKeys(identifysubject,mailsubject,"Fill the mail subject");
		System.out.println("Fill the mail subject " +mailsubject);
		Thread.sleep(4000);
		return this;
	}

	public Gmailcomposepage fill_EmailIdIn_ToAddressBar(String userbmaiild) throws InterruptedException {

		sendKeys(toaddressfield,userbmaiild,"Enter the email-id in to address field");
		System.out.println("Enter the email id in addressfield" +userbmaiild);
		Thread.sleep(2000);
		return this;
	}

	public Gmailcomposepage clickonthe_ComposeButton() throws InterruptedException {

		click(composebutton,"Click on Compose button");
		System.out.println("Click on compose button");
		Thread.sleep(3000);
		return this;
	}

	public Gmailcomposepage navigate_to_InboxPage() throws InterruptedException {
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
		return this;
	}

	public Gmailcomposepage fillthe_Password(String password) throws InterruptedException {

		clear(identifypassword);
		sendKeys(identifypassword,password,"Enter the Password"+password);
		System.out.println("Enter the password " +password);
		Thread.sleep(3000);
		return this;
	}
	public Gmailcomposepage clickon_nextbutton() throws InterruptedException {

		click(identifynextbutton,"Click on Next button from Email Id/Password page");
		System.out.println("Click on next button from Email ID/Password");
		Thread.sleep(5000);
		return this;
	}
	public Gmailcomposepage fillthe_Emailid(String emailid) throws InterruptedException {

		clear(identifyemail);
		sendKeys(identifyemail,emailid,"Signin with "+emailid);
		System.out.println("Enter email id" +emailid);
		Thread.sleep(4000);
		return this;
	}
	public Gmailcomposepage confirmthe_Signinpage(){
		s_assert = new SoftAssert();
		if(logintext.isDisplayed()){
			String loginstr = logintext.getText();
			System.out.println("Current Url is login page" +loginstr);
			s_assert.assertTrue(true,"Current Url is login page" +loginstr);

		}
		else{
			s_assert.fail("Current Url is not login page");
			System.out.println("Current Url is not login page" );
		}
		return this;
	}


}
