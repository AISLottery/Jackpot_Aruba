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
public class TestClass_JA_Admin_1 extends Base
{
	public static Logger logger;
	Admin_LoginPage adminLoginPage;
	Admin_dashBoard adminDashBoard;
	
	@BeforeClass
	public void startLogger()
	{
		logger=Logger.getLogger("Jackpot_Aruba");
		//PropertyConfigurator.configure("C:\\Users\\vinton\\eclipse-workspace\\Jackpot_Aruba\\src\\test\\resources\\log4j.properties");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
	}
	
	@BeforeMethod
	public void startProcess() throws InterruptedException, IOException
	{
		launchJackpotAdmin();
		adminLoginPage=new Admin_LoginPage(driver);
		adminDashBoard=new Admin_dashBoard(driver);
		
		
		adminLoginPage.enter_AdminEmail();
		Reporter.log("Admin Email ID is Entered",true);
		Utility.wait(1400);
		adminLoginPage.enter_AdminPassword();
		Reporter.log("Admin Password is Entered",true);
		Utility.wait(1400);
		adminLoginPage.click_viewPasswordToggle();
		Reporter.log("Clicked on View Password Toggle",true);
		Utility.wait(1000);
		adminLoginPage.click_SignInButton();
		Reporter.log("Clicked on Sign IN Button",true);
		Utility.wait(5000);
		try
		{
		Utility.handle_Alert(driver);
		}
		catch (Exception e) {
			System.out.println("Check your saved password popUP not appeared");
		}

	}
	@Test()
	public void Admin_SignIN() throws InterruptedException, IOException
	{
		
		logger.info("Admin Logged in Successfully");
	}
	
	@Test
	public void AddPlayer_PlayerManagement_andVerify() throws InterruptedException, IOException
	{
		
		 adminDashBoard.click_PlayerManagement();
		 Reporter.log("Clicked on Player Management",true);
		 Utility.wait(1500);
		 adminDashBoard.click_addNewPlayer();
		 Reporter.log("Clicked on Add New Player",true);
		 Utility.wait(1000);
		 adminDashBoard.enter_PlayerName();
		 Reporter.log("Entered Player Name",true);
		 Utility.wait(1000);
		 adminDashBoard.enter_EmailAddress();
		 Reporter.log("Entered User Email ID",true);
		 Utility.wait(1000);
		 adminDashBoard.enter_CountryCode();
		 Utility.wait(1500);
		 adminDashBoard.enter_MobileNumber();
		 Reporter.log("Entered User Mobile Number",true);
		 Utility.wait(1000);
		 adminDashBoard.enter_Password();
		 Reporter.log("Enter User Password",true);
		 Utility.wait(1000);
		 adminDashBoard.enter_confirmPassword();
		 Reporter.log("Entered Confirmed Password",true);
		 Utility.wait(1500);
		 adminDashBoard.click_submitUserCreation();
		 Reporter.log("Clicked on Submit Button",true);
		 logger.info("User Created Successfully");
		 Reporter.log("User Created Successfully",true);
		 
		 Utility.wait(8000);
		 String actualName=adminDashBoard.verify_NewlyAddedUser();
		 String expectedName=adminDashBoard.fname;
		 
	     System.out.println("This is the name returned from the list:-- "+actualName);
		 System.out.println("This is the name which entered:-- "+expectedName);
		 
		 Assert.assertEquals(actualName,expectedName,"Couldn't matched the Name for Newly created user");
		 logger.info("New User Added successfully"+actualName);
		
//			logger.info("This Test case got Failed");
//			System.out.println("This message from the catch bloack");
		
		
		 
		 
		 
	}
	
	@Test()
	public void Ticket_Management_Verify_Tickets()
	{
		
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException 

	{
		
		Utility.wait(3000);
		closeJackpot();
		Reporter.log("Browser Closed",true);
		 
		
	}
	
}
