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
public class TestClass_JA_1 extends Base
{
	public static Logger logger;
	Home_Page homepage;
	Login_Page loginpage;
	Register_UserPage registerUser;
	
	
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

	}
	
	@Test()
	public void SignInTest_and_Purchase_ticket() throws InterruptedException, IOException
	{
		homepage.loginClick();
		Utility.wait(1500);
		loginpage.enterUserName(Utility.propertyFileData("Email"));
		Utility.wait(550);
		loginpage.enterPassword(Utility.propertyFileData("Password"));
		Utility.wait(1000);
		loginpage.clickOnSubmit();
		Utility.wait(5000);
		String actualResult="";
		String expectedResult="";
		try
		{
		 actualResult=homepage.toastmessage();
		 expectedResult="You are successfully login!";
		}
		
		catch (Exception e) 
		{
			logger.info("Login Success Toaster Message not Appered ");
		}
		
		Assert.assertEquals(actualResult, expectedResult,"Values are not Matched!!!! TC Failed");
		logger.info("SuccessFully Logged IN");
		homepage.selectPick3(driver);
		Utility.wait(1500);
		homepage.randomNumberfromTkt1();
		Reporter.log("Random Number Clicked",true);
		Utility.wait(1500);
		homepage.addingCart(driver);
		Utility.wait(2000);
		String actualResult2=homepage.toastmessage2();
		String expectedResult2="Lottery added to cart successfully";
		Assert.assertEquals(actualResult2,expectedResult2,"Ticket not added to Cart");
		Reporter.log("Ticket Added to Cart",true);
		logger.info("Ticket Added to Cart Successfully");
		Utility.wait(4000);
		homepage.click_CartButton();
		Utility.wait(1500);
		homepage.click_buyNowButton();
		Utility.wait(1500);
		String actualTicketConfirmMessage=homepage.ticketConfirmMessage();
		String expectedTicketConfirmMessage="Your lottery ticket confirmed successfully";
		try
		{
		Assert.assertEquals(actualTicketConfirmMessage,expectedTicketConfirmMessage,"Ticket Purchase Failed");
		}
		catch (Exception e) 
		{
			logger.info("Ticket purchase POP Message not Appered/Message not matched");
		}
		
		logger.info("Ticket Purchase Successfully");
	}
	
	@Test()
	public void Register_New_User_Self() throws InterruptedException 
	{
		homepage.registerUser();
		Utility.wait(1500);
		registerUser.enterFullName();
		Reporter.log("Entered Full Name",true);
		Utility.wait(1000);
		Utility.scrolling(0,200);
		registerUser.enterphoneNuber();
		Reporter.log("Entered CellPhone Number",true);
		Utility.wait(1200);
		Utility.scrolling(0,200);	
		registerUser.enterEmailId();
		Reporter.log("Entered EmailID",true);
		Utility.wait(1200);
		registerUser.enterPassword();
		Reporter.log("Entered Password",true);
		Utility.wait(1200);
		registerUser.clickNextButton(driver);
		Reporter.log("Clicked on Submit Button",true);
		Utility.wait(1500);
		//now user need to choose nationality dropdown 
		registerUser.selectNationalityDropdown(driver);
		Reporter.log("Country Selected Successfully",true);
		//now user need to choose Gender
		registerUser.selectGender(driver);
		Reporter.log("Gender Selected Successfully",true);
		//now user need to choose DOB
		registerUser.clickOnCalender();
		Reporter.log("Calender clicked Successfully",true);
		registerUser.clickOnPreviousYear();
		Reporter.log("Year clicked Successfully",true);
		registerUser.clickOnDate();
		Reporter.log("Date clicked Successfully",true);
		registerUser.country_select(driver);
		Reporter.log("Country Selected Successfully",true);
		registerUser.clicking_NextButton(driver);
		Reporter.log("Clicked next Button Succcessfully",true);
		Utility.wait(1500);
		String actualText=registerUser.verify_OTP();
		String expectedText="Enter the code sent to:";
		Assert.assertEquals(actualText,expectedText,"User not Redirected to OTP Enter OTP Screen");
		Reporter.log("User Redirected to Enter OTP Screen",true);
		logger.info("User Created SuccessFully");
		
	}
	
	


	
	@AfterMethod
	public void afterTest() throws InterruptedException 

	{
		
		Utility.wait(3000);
		closeJackpot();
		 
		
	}
	

}
