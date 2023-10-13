package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath = "//span[text()='Men']")
	private WebElement menTab;
	
	@FindBy (xpath = "//p[text()='Track Pants']")
	private WebElement trackpantsTab;
	
	@FindBy (xpath = "(//input[@type='text'])[1]")
	private WebElement searchFeild;
	
	private WebDriver driver;
	private Actions actions;
	
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}

	public void clickOnTrackPantsTab() throws InterruptedException
	{
		  actions.moveToElement(menTab).perform();
	      Thread.sleep(1000);
	      
	      actions.moveToElement(trackpantsTab).perform();
	      Thread.sleep(1000);
	      actions.click().perform();
	      Thread.sleep(2000);
	}
	
	public void clickOnSearchFeild() throws InterruptedException
	{
		actions.moveToElement(searchFeild).click().build().perform();
		Thread.sleep(500);
		
	}
	
	public void sendDataIntoSearchFeild(String search2nd ) throws InterruptedException
	{
		actions.moveToElement(searchFeild).sendKeys(search2nd).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1500);
	}

}
