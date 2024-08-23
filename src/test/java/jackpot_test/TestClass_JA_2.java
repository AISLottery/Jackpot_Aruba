package jackpot_test;
import base.Base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import jackpot_Utility.*;
import jackpot_POM.*;

@Listeners(listners.Listner_Jackpot.class)
public class TestClass_JA_2 extends Base
{
	public static Logger logger;
	Home_Page homepage;
	Login_Page loginpage;
	Register_UserPage registerUser;
	MyProfile_Page myProfile;
	Payment_Page paymentPage;
	
	
	@BeforeClass
	public void startLogger()
	{
		logger=Logger.getLogger("Jackpot_Aruba");
		PropertyConfigurator.configure("C:\\Users\\vinton\\eclipse-workspace\\Jackpot_Aruba\\src\\test\\resources\\log4j.properties");
		
	}
	
	@BeforeMethod
	public void startProcess() throws InterruptedException, IOException
	{
		launchJackpot();
		homepage=new Home_Page(driver);
		loginpage=new Login_Page(driver);
		registerUser=new Register_UserPage(driver);
		myProfile=new MyProfile_Page(driver);
		paymentPage=new Payment_Page(driver);
	}
	
	@Test
	public void Add_Credit() throws InterruptedException, IOException
	{
		homepage.loginClick();
		Utility.wait(1500);
		loginpage.enterUserName(Utility.propertyFileData("Email"));
		Utility.wait(550);
		loginpage.enterPassword(Utility.propertyFileData("Password"));
		Utility.wait(1000);
		loginpage.clickOnSubmit();
		Utility.wait(9000);
		homepage.click_MyAccount();
		Utility.wait(1000);
		homepage.click_Profile();
		Utility.wait(3000);
		myProfile.creditAdd(driver);
		Utility.wait(3000);
		Utility.scrolling(0,200);
		myProfile.creditAmountBox(driver);
		Utility.wait(1500);
		myProfile.clickPayNowButton();
		Utility.wait(9000);
		paymentPage.enterCardNumber();
		Utility.scrolling(0,200);
		Utility.wait(1200);
		paymentPage.enterExpiryMonth();
		Utility.wait(1400);
		paymentPage.enterexpiryYear();
		Utility.wait(1500);
		paymentPage.enterCVV();
		Utility.scrolling(0,400);
		Utility.wait(2500);
		paymentPage.enterCardHolderName();
		Utility.wait(1667);
		paymentPage.clickPayButton();
		Utility.wait(12500);
		String actualPaySuccess=paymentPage.paySuccessVarification();
		String expectedPaySuccess="Success";
		Assert.assertEquals(actualPaySuccess,expectedPaySuccess,"Deposit Success Message not Matched/Did not Appeared");
		logger.info("Add Credit/Payment Successfully Done");
		Utility.wait(2000);
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException 

	{
		
		Utility.wait(3000);
		closeJackpot();
		 
		
	}
	
}
