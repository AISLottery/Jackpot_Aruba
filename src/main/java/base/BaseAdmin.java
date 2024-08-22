package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import jackpot_Utility.Utility;



public class BaseAdmin 
{
	static protected WebDriver driver;
	//open browser
	
	public void launchJackpotAdmin() throws InterruptedException, IOException
	{
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching Browser",true);
		driver.get(Utility.propertyFileData("AdminURL"));
		Thread.sleep(2000);
	}
	
	//now closing the browser
	
	public void closeJackpotAdmin() throws InterruptedException
	{
		Reporter.log("Closing the browser",true);
		Thread.sleep(1000);
		driver.quit();
	}

}