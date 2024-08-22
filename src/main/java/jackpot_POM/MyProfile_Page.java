package jackpot_POM;

import java.io.IOException;

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


}
