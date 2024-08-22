package jackpot_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jackpot_Utility.Utility;

public class Payment_Page 
{
	@FindBy(id = "CARD_NUMBER")private WebElement cardNumber;
	@FindBy(id = "EXPIRY_MONTH")private WebElement expiryMonth;
	@FindBy(id = "EXPIRY_YEAR")private WebElement expiryYear;
	@FindBy(id = "CVV")private WebElement cvvNumber;
	@FindBy(id = "CARD_HOLDER_NAME")private WebElement nameOnCard;
	@FindBy(xpath = "(//*[@class='col span-6 span-sm-12'])[3]/div/button")private WebElement payButton;
	@FindBy(xpath = "//*[@class='login-form__title fs-10xl fw-700 mb-1 text-success' and (contains(text(),'Success'))]")private WebElement paySuccessPOPBox;
	
	public Payment_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterCardNumber() throws InterruptedException, IOException
	{
		cardNumber.sendKeys(Utility.propertyFileData("CardNumber"));
	}
	
	public void enterExpiryMonth() throws InterruptedException, IOException
	{
		expiryMonth.sendKeys(Utility.propertyFileData("ExpiryMonth"));
	}
	
	public void enterexpiryYear() throws InterruptedException, IOException
	{
		expiryYear.sendKeys(Utility.propertyFileData("ExpiryYear"));
	}
	
	public void enterCVV() throws InterruptedException, IOException
	{
		cvvNumber.sendKeys(Utility.propertyFileData("CVV"));
	}
	
	public void enterCardHolderName() throws InterruptedException, IOException
	{
		nameOnCard.sendKeys(Utility.propertyFileData("CardHolderName"));
	}
	
	public void clickPayButton()
	{
		payButton.click();
	}
	
	public String paySuccessVarification()
	{
		String successMessage=paySuccessPOPBox.getText();
		return successMessage;
	}

}
