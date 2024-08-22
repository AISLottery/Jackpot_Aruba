package jackpot_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_dashBoard 
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

	public Admin_dashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
