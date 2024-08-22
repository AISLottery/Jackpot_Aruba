package jackpot_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jackpot_Utility.Utility;

public class Admin_LoginPage 
{
	@FindBy(id = "email")private WebElement AdminEmail;
	@FindBy(id = "password")private WebElement AdminPassword;
	@FindBy(id = "remember_me")private WebElement remenbermeCheckBox;
	@FindBy(xpath = "//*[@href='/forgot-password']")private WebElement forgetPassword;
	@FindBy(xpath = "//*[@class='btn btn-primary btn-block' and (contains(text(),'Sign In'))]")private WebElement signINButton;
	@FindBy(id = "eye_icon")private WebElement viewpasswordtoggle;

	
	public Admin_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enter_AdminEmail() throws InterruptedException, IOException
	{
		AdminEmail.sendKeys(Utility.propertyFileData("AdminEmail"));
	}
	public void enter_AdminPassword() throws InterruptedException, IOException
	{
		AdminPassword.sendKeys(Utility.propertyFileData("AdminPassword"));
	}
	
	public void click_SignInButton()
	{
		signINButton.click();
	}
	public void check_remeberme()
	{
		remenbermeCheckBox.click();
	}
	public void click_ForgetPassword()
	{
		forgetPassword.click();
	}
	public void click_viewPasswordToggle()
	{
		viewpasswordtoggle.click();
	}
	
	
	
	
}
