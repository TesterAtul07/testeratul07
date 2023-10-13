package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackPantsPage {
	
	@FindBy (xpath = "//span[text()='Track Suit and Pants']")
	private WebElement trackSuitAndPantsCheckBox;
	
	@FindBy (xpath = "//p[text()='Men']")
	private WebElement menOption;
	
	@FindBy (xpath = "//span[text()='Fabric']")
	private WebElement fabricDropDown;
	
	@FindBy (xpath = "//span[text()='Denim']")
	private WebElement targetFabricOption;

	@FindBy (xpath = "//span[text()='Color']")
	private WebElement colourDropDownOption;
	
	@FindBy (xpath = "//p[text()='Black']")
	private WebElement blackColourOption;
	
	@FindBy (xpath = "//p[text()='Blue']")
	private WebElement blueColourOption;
	
	@FindBy (xpath = "(//p[text()='White'])[1]")
	private WebElement whiteColourOption;
	
	@FindBy (xpath = "//span[text()='Size']")
	private WebElement sizeDropDownOption;
	
	@FindBy (xpath = "//span[text()='28']")
	private WebElement targetSizeOption;
	
	@FindBy (xpath = "(//div[@class='sc-dkrFOg ProductList__GridCol-sc-8lnc8o-0 cokuZA eCJiSA'])[3]")
	private WebElement targetProduct;
	
	private WebDriver driver;
	private Actions actions;
	
	public TrackPantsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickTrackSuitsAndPantsCheckBox() throws InterruptedException
	{
		 boolean result = trackSuitAndPantsCheckBox.isSelected();
	      
	      if(result==true)
	      {
	    	  System.out.println("Selected");
	      }
	      else
	      {
	    	  trackSuitAndPantsCheckBox.click();
	    	  Thread.sleep(1000);
	      }
	}
	
	public void clickOnMenOption() throws InterruptedException
	{
		actions.moveToElement(menOption).click().build().perform();
	      Thread.sleep(1000);
	}
	
	public void clickOnFabricDropDown() throws InterruptedException
	{
	   actions.moveToElement(fabricDropDown).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnTargetFabricOption() throws InterruptedException
	{
		actions.moveToElement(targetFabricOption).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnColourDropDownOption() throws InterruptedException
	{
		actions.moveToElement(colourDropDownOption).click().build().perform();
		Thread.sleep(1500);
	}
	
	public void clickOnTargetedColour() throws InterruptedException
	{
		actions.moveToElement(blackColourOption).click().build().perform();
	    Thread.sleep(1000);
	    
	    actions.moveToElement(blueColourOption).click().build().perform();
		Thread.sleep(1000);
		
		actions.moveToElement(whiteColourOption).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnSizeDropDown() throws InterruptedException
	{
		actions.moveToElement(sizeDropDownOption).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnTargetSizeOption() throws InterruptedException
	{
		actions.moveToElement(targetSizeOption).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnTargetProduct()
	{
		actions.moveToElement(targetProduct).click().build().perform();

	}
}
