package jackpot_test;

import base.Base;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
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
	
	@BeforeClass
	public void startLogger()
	{
		logger=Logger.getLogger("Jackpot_Aruba");
		PropertyConfigurator.configure("C:\\Users\\vinton\\eclipse-workspace\\Jackpot_Aruba\\src\\test\\resources\\log4j.properties");
		
	}
	
	@BeforeMethod
	public void startProcess() throws InterruptedException
	{
		launchJackpot();
		homepage=new Home_Page(driver);
		
		
	}
	
	@Test
	public void result() throws InterruptedException
	{
		Utility.scrolling(0,600);
		Utility.wait(1400);
		homepage.selectPick3();
		logger.info("Test case Passed");
		Reporter.log("Test Case passed");
		
	}
	

}
