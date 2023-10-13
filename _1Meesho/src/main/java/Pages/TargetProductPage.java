package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TargetProductPage {

	@FindBy (xpath = "//span[text()='XL']")
	private WebElement selectTargetSize;
	
	@FindBy (xpath = "//span[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	private WebDriver driver;
	
	public TargetProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnTargetedSize() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(selectTargetSize).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnAddToCartButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", addToCartButton);
		js.executeScript("window.scrollBy(0,-150)");
		addToCartButton.click();
		Thread.sleep(500);
		
		
	}
	
	
	
}
