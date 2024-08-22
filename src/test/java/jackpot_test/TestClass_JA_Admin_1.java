package jackpot_test;
import base.BaseAdmin;

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
public class TestClass_JA_Admin_1 extends BaseAdmin
{
	public static Logger logger;
	Admin_LoginPage adminLoginPage;
	
	@BeforeClass
	public void startLogger()
	{
		logger=Logger.getLogger("Jackpot_Aruba");
		PropertyConfigurator.configure("C:\\Users\\vinton\\eclipse-workspace\\Jackpot_Aruba\\src\\test\\resources\\log4j.properties");
		
	}
	
	@BeforeMethod
	public void startProcess() throws InterruptedException, IOException
	{
		launchJackpotAdmin();
		adminLoginPage=new Admin_LoginPage(driver);

	}
	@Test
	public void adminSignIN() throws InterruptedException, IOException
	{
		adminLoginPage.enter_AdminEmail();
		Utility.wait(1400);
		adminLoginPage.enter_AdminPassword();
		Utility.wait(1400);
		adminLoginPage.click_viewPasswordToggle();
		Utility.wait(1000);
		adminLoginPage.click_SignInButton();
		Utility.wait(5000);
		try
		{
		Utility.handle_Alert(driver);
		}
		catch (Exception e) {
			System.out.println("Check your saved password popUP not appeared");
		}
		logger.info("Admin Logged in Successfully");
	}
	
	@Test
	public void DashBoard_Items_Verification()
	{
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException 

	{
		
		Utility.wait(3000);
		closeJackpotAdmin();
		 
		
	}
	
}
