package jackpot_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	@FindBy(id = "username")private WebElement userName;
	@FindBy(id = "password")private WebElement password;
	@FindBy(xpath = "//*[@type='submit']")private WebElement signinButton;
	
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterUserName(String UName)
	{
		userName.sendKeys(UName);
	}
	
	public void enterPassword(String Passwd)
	{
		password.sendKeys(Passwd);
	}
	
	public void clickOnSubmit()
	{
		signinButton.click();
	}
}
