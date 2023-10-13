package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search2ndResultsPage {
	
	@FindBy (xpath = "(//div[@class='sc-dkrFOg ProductList__GridCol-sc-8lnc8o-0 cokuZA eCJiSA'])")
	private WebElement targetProduct;
	
	private WebDriver driver;
	
	public Search2ndResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void clickOnproduct() throws InterruptedException
	{   Actions actions = new Actions(driver);
		actions.moveToElement(targetProduct).click().perform();
		Thread.sleep(500);
	}

}
