package _1MeeshoTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Browser;
import MeeshoUtility.Utilities;
import Pages.HeaderPage;
import Pages.TargetProductPage;

public class Test2 extends Browser {
       private HeaderPage headerPage;
       private TargetProductPage targetProductPage;
	   private WebDriver driver;
	   private String TestID;
		static ExtentHtmlReporter reporter;
			
			@BeforeTest
			@Parameters("browser")
			public void launchBrowser(String browsername) throws Exception {
				
				reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
				ExtentReports extend = new ExtentReports();
				extend.attachReporter(reporter);	
			if(browsername.equals("chrome"))
			{
			  driver = launchChrome();
			}
			
			if(browsername.equals("firefox"))
			{
				driver = launchFireFox();	
			}
			
			if(browsername.equals("microsoftEdge"))
			{
				driver = launchEdge();
			}
			
							
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		@BeforeClass
		public void creatingPOMObject()
		{
			headerPage = new HeaderPage(driver);
			targetProductPage = new TargetProductPage(driver);
		}
		
		@BeforeMethod
		public void launchBrowser() throws InterruptedException
		{
			driver.get("https://www.meesho.com/");
			
			Thread.sleep(1000);
		}
		
		@Test
		public void selectTargetProduct() throws InterruptedException, IOException
		{
			TestID = "MS001";
			headerPage.clickOnSearchFeild();
			headerPage.sendDataIntoSearchFeild("Kurtas");
			targetProductPage.clickOnTargetedSize();
			targetProductPage.clickOnAddToCartButton();
					
		}
		
		@AfterMethod
		public void testTestment(ITestResult result) throws IOException
		{

			if(ITestResult.FAILURE == result.getStatus())
			{
			  Utilities.captureScreenshot(driver, "test-output//FailedTestScreenshot", TestID);
		     }
		
		}
		
		@AfterClass
		public void clearingObject()
		{
			headerPage = null;
			targetProductPage = null;

		}
		
		
		@AfterTest
		public void closeBrowser()
		{
			driver.close();
			driver = null;
			System.gc();
		}

		



}
