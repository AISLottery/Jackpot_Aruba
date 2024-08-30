package jackpot_POM;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import jackpot_Utility.Utility;

public class Register_UserPage 
{
	@FindBy(id = "name")private WebElement fullName;
	@FindBy(xpath = "//*[@class='react-international-phone-input']")private WebElement phoneNumber;
	@FindBy(id = "email")private WebElement emailId;
	@FindBy(id = "password")private WebElement password;
	@FindBy(xpath = "//*[@type='submit']")private WebElement nextButton;
	@FindBy(xpath = "(//*[@class=' css-13cymwt-control']/div/div[2])[1]")private WebElement nationality;
	@FindBy(xpath = "(//*[@class=' css-19bb58m']/input)[2]")private WebElement gender;
	@FindBy(xpath = "//*[@class='react-date-picker__inputGroup']")private WebElement calenderClick;
	@FindBy(xpath = "//*[@class='react-calendar__navigation__arrow react-calendar__navigation__prev2-button' and @type='button']")private WebElement previousYear;
	@FindBy(xpath = "(//*[@class='react-calendar__tile react-calendar__month-view__days__day' and @type='button'])[21]")private WebElement dateSelect;
	@FindBy(xpath = "(//*[@class='react-calendar__tile react-calendar__year-view__months__month' and @type='button'])[7]")private WebElement monthSelect;
	@FindBy(xpath = "(//*[@class=' css-hlgwow']/div)[5]")private WebElement countrySelection;
	@FindBy(xpath = "//*[@type='submit']")private WebElement nextButton2;
	@FindBy(xpath = "//p[@class='mb-1 fs-lg fw-500 dark-text-color text-center']")private WebElement verifyOTPPage;
	public Register_UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterFullName()
	{
		fullName.sendKeys(Utility.firstName());
	}
	
	public void enterphoneNuber()
	{
		phoneNumber.sendKeys(Utility.indianMobileNumber());
	}
	
	public void enterEmailId()
	{
		emailId.sendKeys(Utility.emailAddress());
	}
	
	public void enterPassword()
	{
		password.sendKeys("Test@12345");
	}
	
	public void clickNextButton(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(nextButton).build().perform();
		nextButton.click();
	}
	
	public void selectNationalityDropdown(WebDriver driver)
	{
		nationality.click();
		Actions act1=new Actions(driver);
		act1.moveToElement(nationality).sendKeys("India").keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void selectGender(WebDriver driver)
	{
		gender.click();
		Actions act2=new Actions(driver);
		act2.moveToElement(gender).sendKeys("male").keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void clickOnCalender() throws InterruptedException
	{
		calenderClick.click();
		Utility.wait(1000);
		
		//monthSelect.click();
		
		
	
	}
	public void clickOnPreviousYear() throws InterruptedException
	{
		Utility.wait(1500);
		for(int i=0;i<=18;i++)
		{
		previousYear.click();
		}
	}
	public void clickOnDate() throws InterruptedException
	{
		Utility.wait(1500);
		dateSelect.click();
	}
	
	public void country_select(WebDriver driver)
	{
		
		Actions act3=new Actions(driver);
		act3.moveToElement(countrySelection).click().sendKeys("india").keyDown(Keys.ARROW_DOWN).release().keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void clicking_NextButton(WebDriver driver)
	{
		
		Actions act4=new Actions(driver);
		act4.moveToElement(nextButton2).click().build().perform();
		
	}
	
	public String verify_OTP()
	{
		String otpText=verifyOTPPage.getText();
		return otpText;
	}
	

}
