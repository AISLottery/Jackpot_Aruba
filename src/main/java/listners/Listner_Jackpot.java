package listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;
import jackpot_Utility.Utility;


//import base.Base;
public class Listner_Jackpot extends Base implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			Utility.takeScreenShot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}}
