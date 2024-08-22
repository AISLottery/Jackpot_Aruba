package jackpot_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_HomePage
{
	@FindBy(xpath = "//*[@class='Toastify__toast-body']/div[2]")private static WebElement loginSuccessToastMessage;
	
	
	public User_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

}
