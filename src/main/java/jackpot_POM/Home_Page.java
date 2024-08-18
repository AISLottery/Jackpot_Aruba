package jackpot_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page
{
	@FindBy(id = "v-pills-pick3-tab")private WebElement pick3selector;
	@FindBy(id = "v-pills-pick4-tab")private WebElement pick4selector;
	@FindBy(id = "v-pills-pick5-tab")private WebElement pick5selector;
	@FindBy(xpath = "(//*[@href='/live-stream'])[5]")private WebElement liveDrawselector;
	@FindBy(xpath = "(//*[@class='ticket-number'])[1]/ul/li")private WebElement ticket1;
	@FindBy(xpath = "(//*[@class='btn btn-primary-outline fs-3xl btn-xl fw-700 purple-color' and contains(text(),'Clear All')])[1]")private WebElement clearAllTicket1;
	@FindBy(xpath = "(//*[@class='fs-6xl fw-700 purple-color' and contains(text(),'100')])[1]")private WebElement ticket1Price;
	@FindBy(xpath = "(//*[@class='purple-color' and @role='button'])[1]")private WebElement ticket1RandomNumber;
	
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectPick3()
	{
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
	
	

}
