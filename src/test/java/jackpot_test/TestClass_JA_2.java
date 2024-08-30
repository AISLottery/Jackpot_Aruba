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
	
	@Test()
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
	
	@Test()
	public void verify_UserWinningTicket() throws InterruptedException, IOException
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
		homepage.click_MyOrdertButton();
		Utility.scrolling(0, 500);
		Utility.wait(2500);
		String [] allTicketsLotteryNumbers=homepage.tablerows(driver);
		
		
	}
	
	@Test()
	public void User_Manage_Winnings_bankTransfer() throws InterruptedException, IOException
	{
		homepage.loginClick();
		Reporter.log("User clicked login button",true);
		Utility.wait(1500);
		loginpage.enterUserName(Utility.propertyFileData("Email"));
		Reporter.log("User Entered UserEmail",true);
		Utility.wait(550);
		loginpage.enterPassword(Utility.propertyFileData("Password"));
		Reporter.log("User Entered UserPassword",true);
		Utility.wait(1000);
		loginpage.clickOnSubmit();
		Reporter.log("User Clicked on Submit",true);
		Utility.wait(9000);
		homepage.click_MyAccount();
		Reporter.log("User Clicked on MyAccount",true);
		Utility.wait(1000);
		homepage.click_Profile();
		Reporter.log("User Clicked on Profile",true);
		Utility.wait(3000);
		myProfile.click_Manage_winnnings(driver);
		Reporter.log("User Clicked on Manage Winnnings",true);
		Utility.wait(2000);
		myProfile.click_Bank_transfer();
		Reporter.log("User Clicked on Bank transfer",true);
		Utility.wait(2000);
		myProfile.enterAmount();
		Reporter.log("User Entered Amount",true);
		Utility.wait(1200);
		myProfile.enterBankName();
		Reporter.log("User Entered Bank Name",true);
		Utility.wait(1200);
		myProfile.enterAccountHolderName();
		Reporter.log("User Entered Account Holder Name",true);
		Utility.wait(1200);
		myProfile.enterAccountNumber();
		Reporter.log("User Entered Account Number",true);
		Utility.wait(1200);
		myProfile.enterRoutingNumber();
		Reporter.log("User Entered Routing Number",true);
		Utility.wait(2000);
		myProfile.clickBankDetailSubmit(driver);
		Reporter.log("User Clicked on Submit",true);
		Utility.wait(1000);
		String toasterMessage=myProfile.toasterStatus();
		System.out.println(toasterMessage);
		Reporter.log(toasterMessage);
		logger.info(toasterMessage+"   withdraw from the account");
		//logger.info(toasterMessage);

	}
	
	@Test()
	public void UserProfle_UpdatePassword() throws InterruptedException, IOException
	{
		homepage.loginClick();
		Reporter.log("User clikec",true);
		Utility.wait(1500);
		loginpage.enterUserName(Utility.propertyFileData("Email"));
		Reporter.log("User Entered UserEmail",true);
		Utility.wait(550);
		loginpage.enterPassword(Utility.propertyFileData("Password"));
		Reporter.log("User Entered UserPassword",true);
		Utility.wait(1000);
		loginpage.clickOnSubmit();
		Reporter.log("User Clicked on Submit",true);
		Utility.wait(9000);
		homepage.click_MyAccount();
		Reporter.log("User Clicked on MyAccount",true);
		Utility.wait(1000);
		homepage.click_Profile();
		Reporter.log("User Clicked on Profile",true);
		Utility.wait(3000);
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException 

	{
		
		Utility.wait(3000);
		closeJackpot();
		 
		
	}
	
}
