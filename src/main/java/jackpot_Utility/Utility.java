package jackpot_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.io.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Properties;
import base.Base;


public class Utility extends Base
{
	public static String cName="";
	public static String passwd="";
	public static String readingDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Reading data from excelsheet",false);
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Jackpot_LoginDetails.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static void scrolling(int x,int y) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
	
	public static void wait(int k) throws InterruptedException
	{
		Thread.sleep(k);
	}
	
	public static void takeScreenShot(WebDriver driver,String TCID) throws IOException
	{
		Reporter.log("Taking ScreenShot",true);
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\TestScreenShot\\"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved ScreenShot at"+dest,true);
		FileHandler.copy(src, dest);
		
	}
	
	public static String propertyFileData(String key) throws InterruptedException, IOException
	{
		Properties prop=new Properties();
		Thread.sleep(1000);
		
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\TestData.properties");
		prop.load(myFile);
		Thread.sleep(1000);
		
		String value=prop.getProperty(key);
		return value;
	}
	
	public static String streetName()
	{
		Faker faker=new Faker();
		String street = faker.address().streetAddress();
		return street;
		}
	
	public static String cityName()
	{
		Faker faker=new Faker();
		String city=faker.address().cityName();
		return city;
	}
	public static String stateName()
	{
		Faker faker=new Faker();
		String state=faker.address().state();
		return state;
	}
	
	public static String zipCode()
	{
		Faker faker=new Faker();
		String code=faker.address().zipCode();
		return code;
	}
	
	public static String firstName()
	{
		Faker faker=new Faker();
		String fName=faker.name().firstName();
		return fName;
	}
	
	public static String lastName()
	{
		Faker faker=new Faker();
		String lName = faker.name().lastName();
		return lName;
	}
	
	public static String cellphone()
	{
		Faker faker=new Faker();
		String cellNumber = faker.phoneNumber().cellPhone();
		return cellNumber;
	}
	public static String phone()
	{
		Faker faker=new Faker();
		String Landline=faker.phoneNumber().phoneNumber();
		return Landline;
	}
	
	public static String companyName()
	{
		Faker faker=new Faker();
		cName=faker.company().name();
		return cName;
	}
	
	public static String companyURl()
	{
		Faker faker=new Faker();
		String cURL = faker.company().url();
		String comURL="https://"+cURL;
		return comURL;
	}
	
	public static String jobTitle()
	{
		Faker faker=new Faker();
		String jtitle=faker.job().title();
		return jtitle;
	}
	
	
	public static String aboutCompany()
	{
		Faker faker=new Faker();
		String about=faker.company().buzzword();
		return about;
	}
	
	public static String emailAddress()
	{
		Faker faker=new Faker();
		String email=faker.internet().emailAddress();
		return email;
	}
	
	public static String country()
	{
		Faker faker=new Faker();
		String countryName=faker.address().country();
		return countryName;
	}
	public static String company_Address()
	{
		Faker faker=new Faker();
		String companyAddress = faker.address().fullAddress();
		return companyAddress;
	}
	public static String password()
	{
		Faker faker=new Faker();
		passwd=faker.internet().password(10,12,true,true,true);
		return passwd;
	}
	public static String confirm_Password()
	{
		return passwd;
	}
	
	public static String indianMobileNumber()
	{
		Faker faker=new Faker();
		String startDigit = faker.number().numberBetween(7, 10) + "";	
		String remainingDigits = faker.number().digits(9);
		return startDigit + remainingDigits;
	}
	
	public static void handle_Alert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	
	
	
	
}
