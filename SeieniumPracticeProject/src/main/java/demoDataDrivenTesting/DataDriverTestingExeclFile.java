package demoDataDrivenTesting;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriverTestingExeclFile {
	static  JavascriptExecutor js;

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		 String filePath="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		//ExcelUtilityFile .getRowCount(filePath, Sheet5);
	  int	rows =ExcelUtilityFile.getRowCount(filePath, "Sheet6");
		for(int i=1;i<=rows;i++)
		{
			String depositAmmount =ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 0);
			String length=ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 1);
			String intrestRate=ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 2);
			String compounding=ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 3);
			String cd_Worth=ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 4);
			String expectedValue=ExcelUtilityFile.getCellData(filePath, "Sheet6", i, 5);
			
			WebElement initialDepositeAmount=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			initialDepositeAmount.clear();
			initialDepositeAmount.sendKeys(depositAmmount);
			

			WebElement lengthOfCDmonth=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			lengthOfCDmonth.clear();
			lengthOfCDmonth.sendKeys(length);
	        
			 

			WebElement iRate=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			iRate.clear();
			iRate.sendKeys(intrestRate);
			 
			 
			 
			 WebElement compoundingClickButton=driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
				compoundingClickButton.click();
				
			   List<WebElement> compoundingList = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']"));
			  // String expectedoption="Compounded Monthly";
			   for(WebElement list:compoundingList)
			   {
				   String actualValue=list.getText();
				   if(actualValue.equals( expectedValue))
				   {
					   
					   list.click();
					   //js=(JavascriptExecutor)driver;
					 //  js.executeScript("arguments[0].click();", list);
					   break;
				   }
			   }
			   Thread.sleep(1000);
			   
			  
			   WebElement runButton=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
				// runButton.click();
				   js=(JavascriptExecutor)driver;
				   js.executeScript("arguments[0].click();", runButton);
			  
			  //validation
			 String actualValue= driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			 if(expectedValue==actualValue)
			 {
				 System.out.println("Test passed");
				 
				 ExcelUtilityFile.setCellData(filePath, "Sheet6", i, 7,"Passed");
				 ExcelUtilityFile.fillGrenColor(filePath, "Sheet6", i, 7);
			 }
			 else
			 {
                  System.out.println("Test Failed");
				 
				 ExcelUtilityFile.setCellData(filePath, "Sheet6", i, 7,"Fail");
				 ExcelUtilityFile.fillRedColor(filePath, "Sheet6", i, 7);
			 }
				
		}
		driver.quit();
		
	
	
	
	
	
	}

}
