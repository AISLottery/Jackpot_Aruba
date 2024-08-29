package jackpot_POM;

import java.io.IOException;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jackpot_Utility.Utility;

public class MyProfile_Page 
{
@FindBy(xpath = "//*[@class='btn-primary-outline p-2 primary-bg white-color fs-lg text-center fw-500 rounded-pill w-100 border-0' and (contains(text(),'ADD CREDIT'))]")private WebElement addCreditButton ;	
@FindBy(xpath = "//*[@class='btn-primary-outline p-2 primary-bg white-color fs-lg text-center fw-500 rounded-pill w-100 border-0' and (contains(text(),'TRANSFER/WITHDRAW'))]")private WebElement transferAndWithdrawButton;
@FindBy(xpath = "//*[@class='btn-primary-outline p-2 primary-bg white-color fs-lg text-center fw-500 rounded-pill w-100 border-0' and (contains(text(),'MY ORDERS'))]")private WebElement myOrderButton;
@FindBy(xpath = "//*[@class='non-active btn-primary-outline p-2 primary-bg white-color fs-lg text-center fw-500 rounded-pill w-100 border-0' and (contains(text(),'REDEEM'))]")private WebElement redeemButton;
@FindBy(xpath = "//*[@class='form-control w-auto' and @placeholder='max 10,500']")private WebElement creditAmontBox;
@FindBy(xpath = "//*[@class=' btn-mw btn-primary-outline p-3 primary-bg white-color fs-lg text-center fw-500 rounded-pill border-0' and (contains(text(),'PAY NOW'))]")private WebElement paynowButton;
@FindBy(xpath = "//*[@class='fs-3xl fw-600 mb-0' and (contains(text(),'Manage Winnings'))]")private WebElement manageWinnings;
@FindBy(xpath = "//*[@class='fs-lg fw-500']")private WebElement enterWithdrwAmount;
@FindBy(xpath = "//*[@class='btn-w btn-primary-outline primary-color p-3 mw-sm-100 mx-0 mb-0 fs-lg text-center fw-700 rounded-pill w-100' and (contains(text(),'BANK TRANSFER'))]")private WebElement banktransferButton;
@FindBy(id = "amount")private WebElement banktransferAmount;
@FindBy(id = "bankName")private WebElement bankName;
@FindBy(id = "accountHolderName")private WebElement accountHolderName;
@FindBy(id = "bankAccountNumber")private WebElement bankAccountNumber;
@FindBy(id = "routingNumber")private WebElement routingNumber;
@FindBy(xpath = "//*[@class='btn-primary-outline p-3 primary-bg white-color fs-2xl text-center fw-700 rounded-pill my-3 w-100' and (contains(text(),'Submit'))]")private WebElement bankDetailsSubmit;
@FindBy(xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-right']/div/div/div[2]")private WebElement bankTransferToastermessage;
@FindBy(xpath = "//*[@class='fs-3xl fw-600 mb-0' and (contains(text(),'Account & Security'))]")private WebElement accountAndSecurity;
@FindBy(id = "currentPassword")private WebElement currentPassword;
@FindBy(id = "newPassword")private WebElement newPassword;
@FindBy(id = "confirmNewPassword")private WebElement confirmPassword;
@FindBy(xpath = "//*[@type='submit' and (contains(text(),'CHANGE PASSWORD'))]")private WebElement changePasswordButton;
@FindBy(xpath = "//*[@class='btn-w mt-3 mt-md-4']/button[(contains(text(),'DELETE ACCOUNT'))]")private WebElement deleteAccountButton;


public MyProfile_Page(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public void creditAdd(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.moveToElement(addCreditButton).click().build().perform();
}

public void creditAmountBox(WebDriver driver) throws InterruptedException, IOException
{
Actions act1=new Actions(driver);
act1.moveToElement(creditAmontBox).build().perform();
creditAmontBox.sendKeys(Utility.propertyFileData("CreditAmount"));
}

public void clickPayNowButton()
{
	paynowButton.click();
}

public void click_Manage_winnnings(WebDriver driver) throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,450)");
	Utility.wait(2000);
	manageWinnings.click();
	Utility.wait(2000);
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)");
}

public void click_Bank_transfer() throws InterruptedException
{
	Thread.sleep(2000);
	Utility.scrolling(0,300);
	banktransferButton.click();
}

public void enterAmount() throws InterruptedException, IOException
{
	banktransferAmount.sendKeys(Utility.propertyFileData("BankTrnsferAmount"));
}

public void enterBankName() throws InterruptedException, IOException
{
	bankName.sendKeys(Utility.propertyFileData("BankName"));
}

public void enterAccountHolderName() throws InterruptedException, IOException
{
	accountHolderName.sendKeys(Utility.propertyFileData("BankAccountHolderName"));
}

public void enterAccountNumber() throws InterruptedException, IOException
{
	bankAccountNumber.sendKeys(Utility.propertyFileData("BankAccountNumber"));
}

public void enterRoutingNumber() throws InterruptedException, IOException
{
	routingNumber.sendKeys(Utility.propertyFileData("RoutingNumber"));
}

public void clickBankDetailSubmit(WebDriver driver)
{
	Utility.scrolling(0,150);
	bankDetailsSubmit.click();
}

public String toasterStatus()
{
	String toastMessage=bankTransferToastermessage.getText();
	return toastMessage;
}

}
