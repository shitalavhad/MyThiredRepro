package dataDrivenTesting;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class ExeclSheetIntegrateDataProvider {
	WebDriver driver;
	JavascriptExecutor js;
	@BeforeClass

	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

	}
	@Test(dataProvider="testData")
	public void verifyDepositeCalculator(String depositeAmmount,String length,String rate,String expectedOption,String expectedValue ) throws InterruptedException
	{
		   WebElement initalDepositeAmmount=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		   initalDepositeAmmount.clear();
		   initalDepositeAmmount.sendKeys(depositeAmmount);
		   
		   WebElement lengthOfCDmonth=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			lengthOfCDmonth.clear();
			lengthOfCDmonth.sendKeys(length);
			 
			WebElement iRate=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			iRate.clear();
			iRate.sendKeys( rate);
			
			WebElement compoundingClickButton=driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
			compoundingClickButton.click();
			
			List<WebElement> compoundingList =driver.findElements(By.xpath("//span[@class='mat-option-text']"));
			 for(WebElement list:compoundingList)
			   {
				  String actualOption=list.getText();
			   //System.out.println(actualOption);
			   if(actualOption.equals( expectedOption))
				   {
					   
				  // list.click();
			     js=(JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", list);
				   }
			   }
			 Thread.sleep(1000);
			 
			   WebElement runButton=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
				// runButton.click();
			  js=(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", runButton);
			   
			   //validation
			   String actualValue= driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
				 if(actualValue.equals(expectedValue))
				 {
					 System.out.println("Tc passed");
				 }
				 else
				 {
					 System.out.println("Tc failed");
				 }
			 
			 
			 
	}
	@DataProvider(name="testData")
	public Object testData() throws IOException
	{
		String path="‪C:\\Users\\SAI\\Desktop\\TestData\\data.xlsx";
		XLUtility  xl=new XLUtility (path);
		int rows = xl.getRowCount("Sheet2");
		int cells=xl.getCellCount("Sheet2", 1);
		Object [] [] data=new Object[rows][cells];
		for(int r=0;r<rows;r++)
		{
			for(int c=0;c<cells;c++)
			{
				data[r-1][c]=xl.getCellData("Sheet2", r, c);
			}
		}
		return data;
		
	}
}
