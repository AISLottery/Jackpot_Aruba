package jackpot_POM;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import jackpot_Utility.Utility;


public class Home_Page
{
	@FindBy(xpath = "//*[@id='v-pills-pick3-tab']")private WebElement pick3selector;
	@FindBy(id = "v-pills-pick4-tab")private WebElement pick4selector;
	@FindBy(id = "v-pills-pick5-tab")private WebElement pick5selector;
	@FindBy(xpath = "(//*[@href='/live-stream'])[5]")private WebElement liveDrawselector;
	@FindBy(xpath = "//*[@class='ticket-number']/ul/li[4]")private WebElement ticket1number4;
	@FindBy(xpath = "//*[@class='ticket-number']/ul/li[8]")private WebElement ticket1number8;
	@FindBy(xpath = "//*[@class='ticket-number']/ul/li[1]")private WebElement ticket1number1;
	@FindBy(xpath = "(//*[@class='btn btn-primary-outline fs-3xl btn-xl fw-700 purple-color' and contains(text(),'Clear All')])[1]")private WebElement clearAllTicket1;
	@FindBy(xpath = "(//*[@class='fs-6xl fw-700 purple-color' and contains(text(),'100')])[1]")private WebElement ticket1Price;
	@FindBy(xpath = "(//*[@class='purple-color' and @role='button'])[1]")private WebElement ticket1RandomNumber;
	@FindBy(xpath = "//*[@class='plus-minus-input-box']/following-sibling::button")private WebElement ticketCountplusButton;
	@FindBy(xpath = "//*[@class='plus-minus-input-box']/preceding-sibling::button")private WebElement ticketCountminusButton;
	@FindBy(xpath = "//*[@href='/login']")private WebElement signInButton;
	@FindBy(xpath = "//*[@class='Toastify__toast-body']/div[2]")private static WebElement loginSuccessToastMessage;
	@FindBy(xpath = "//*[@class='Toastify__toast-body']/div[2]")private static WebElement lotteryTicketAddToastMessage;
	@FindBy(xpath = "//*[@class='btn btn-white purple-color fs-3xl btn-xl fw-700' and contains(text(),'ADD TO CART')]")private WebElement addToCartButton;
	@FindBy(xpath = "//*[@href='/register']")private WebElement register;
	@FindBy(xpath = "//*[@class='btn py-0 nav-link dropdown-toggle' and (contains(text(),'My Account'))]")private WebElement myAccountButton;
	@FindBy(xpath = "(//*[@href='/account/profile' and (contains(text(),'Profile'))])[1]")private WebElement profiledropDown;
	@FindBy(xpath = "(//*[@stroke='currentColor'])[3]")private WebElement cartButton;
	@FindBy(xpath = "//*[@class='col-md-12']/button")private WebElement buyNowButton;
	@FindBy(xpath = "//*[@class='Toastify__toast-body']/div[2]")private WebElement ticketPurchaseConfimrdToastMessage;
	
	public Home_Page(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}
	
	public void selectPick3(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(pick3selector).click().build().perform();
		pick3selector.click();
	}
	
	public void selectpick4()
	{
		pick4selector.click();
	}
	public void selectpick5()
	{
		pick5selector.click();
	}
	
	public void selectLiveDraw()
	{
		liveDrawselector.click();
	}
	
	public void ticketOneNumberSelector()
	{
		ticket1number1.click();
		ticket1number4.click();
		ticket1number8.click();
		
	}
	public void clear()
	{
		clearAllTicket1.click();
	}
	
	public void randomNumberfromTkt1()
	{
		ticket1RandomNumber.click();
	}
	
	public void loginClick()
	{
		signInButton.click();
	}
	
	public static String toastmessage()
	{
		String Toastmsg=loginSuccessToastMessage.getText();
		return Toastmsg;
	}
	
	public void addingCart(WebDriver driver)
	{
		Actions act2=new Actions(driver);
		act2.moveToElement(addToCartButton).build().perform();
		addToCartButton.click();
		
	}
	
	public void registerUser()
	{
		
		register.click(); 	
	}
	
	public static String toastmessage2()
	{
		String Toastmsg2=lotteryTicketAddToastMessage.getText();
		return Toastmsg2;
	}
	
	public void click_MyAccount()
	{
		myAccountButton.click();
	}
	
	public void click_Profile()
	{
		profiledropDown.click();
	}
	
	
	public void click_CartButton()
	{
		cartButton.click();
	}
	
	public void click_buyNowButton()
	{
		buyNowButton.click();
	}
	
	public String ticketConfirmMessage()
	{
		String ticketSuccessMessage=ticketPurchaseConfimrdToastMessage.getText();
		return ticketSuccessMessage;
	}

}
