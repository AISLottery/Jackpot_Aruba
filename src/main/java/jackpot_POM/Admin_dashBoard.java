package jackpot_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import jackpot_Utility.Utility;

public class Admin_dashBoard extends Base
{
	@FindBy(id = "gameType")private WebElement pickSelectdropDown;
	@FindBy(xpath = "//*[@class='info-box-number']")private WebElement totalNumberOfRegisteredPlayerDashBoard;
	@FindBy(xpath = "//*[@class='info-box-number totalPlayer']")private WebElement totalNumberOfOnlinePLayersDashBoard;
	@FindBy(xpath = "//*[@class='info-box-number totalLotteries']")private WebElement totalNumberOfAllLotteriesDashBoard;
	@FindBy(xpath = "(//*[@class='info-box-number totalOngoingLotteries'])[1]")private WebElement totalNumberOfOngoingLotteriesDashBoard;
	@FindBy(xpath = "(//*[@class='info-box-number totalOngoingLotteries'])[2]")private WebElement totalNumberOfSoldTicketsDashBoard;
	@FindBy(xpath = "(//*[@class='info-box-number totalOngoingLotteries'])[3]")private WebElement totalProfitDashBoard;
	@FindBy(xpath = "(//*[@class='info-box-number totalOngoingLotteries'])[4]")private WebElement totalLossDashBoard;
	@FindBy(xpath = "//*[@href='/myPlayer']")private WebElement playerManagement;
	@FindBy(xpath = "//*[@href='/tickets']")private WebElement ticketManagement;
	@FindBy(xpath = "//*[@href='/lotteryManagement']")private WebElement lotteryManagement;
	@FindBy(xpath = "//*[@href='/lottery']")private WebElement gameHistory;
	@FindBy(xpath = "//*[@href='/getResultManagement']")private WebElement resultManagement;
	@FindBy(xpath = "(//*[@class='nav-link '])[6]")private WebElement transactionManagement;
	@FindBy(xpath = "//*[@href='/wallet']")private WebElement walletManagement;
	@FindBy(xpath = "//*[@href='/addNewPlayer']")private WebElement addNewPlayer;
	@FindBy(xpath = "//*[@type='search']")private WebElement searchByUserName;
	@FindBy(xpath = "//*[@name='myTable_length']")private WebElement showEntriesPlayerManagement;
	@FindBy(id = "myTable_info")private WebElement totalNumerOfPlayersfromList;
	@FindBy(xpath = "//*[@class='col-sm-12 col-md-5']/div")private WebElement totalNumberOfSoldTicketsFromList;
	@FindBy(id = "full_name")private WebElement playerName;
	@FindBy(id = "email")private WebElement userEmailAddress;
	@FindBy(id = "mobile")private WebElement userMobileNumber;
	@FindBy(id = "password")private WebElement userpassword;
	@FindBy(id = "confirmPassword")private WebElement userconfirmPassword;
	@FindBy(xpath = "//*[@type='submit']")private WebElement submitUserCreation;
	@FindBy(xpath = "//*[@id='myTable']/tbody/tr[1]/td[2]")private WebElement verifyNewUserFromList;
	@FindBy(xpath = "//*[@class='pagination']/li[5]")private WebElement ticketfourthPage;
	@FindBy(xpath = "//*[@class='pagination']/li[1]")private WebElement ticketList_Previousbutton;
	@FindBy(id = "countryCode")private WebElement countryCode;
	
	public String fname;
	
	public Admin_dashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void click_PlayerManagement()
	{
		playerManagement.click();
	}
	
	public void click_addNewPlayer()
	{
		addNewPlayer.click();
	}
	
	public String enter_PlayerName()
	{
		fname=Utility.firstName();
		playerName.sendKeys(fname);
		return fname;
	}
	
	public void enter_EmailAddress()
	{
	userEmailAddress.sendKeys(Utility.emailAddress());
	}
	
	public void enter_MobileNumber()
	{
		userMobileNumber.sendKeys(Utility.indianMobileNumber());
	}
	
	public void enter_Password() throws InterruptedException, IOException
	{
		userpassword.sendKeys(Utility.propertyFileData("Password"));
	}
	
	public void enter_confirmPassword() throws InterruptedException, IOException
	{
		userconfirmPassword.sendKeys(Utility.propertyFileData("Password"));
	}
	public void click_submitUserCreation()
	{
		submitUserCreation.click();
	}
	
	public String verify_NewlyAddedUser()
	{
		String actualName=verifyNewUserFromList.getText();
		return actualName;
	}
	
	public void click_TicketManagement()
	{
		ticketManagement.click();
	}
	
	public void click_ticketListPage()
	{
		ticketfourthPage.click();
	}
	public void click_ticketListPreviousButton()
	{
		ticketList_Previousbutton.click();
	}
	
	public void enter_CountryCode()
	{
		Select s=new Select(countryCode);
		s.selectByValue("+91");
	}

}
