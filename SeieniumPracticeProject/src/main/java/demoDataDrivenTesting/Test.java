package demoDataDrivenTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		
		WebElement initialDepositeAmount=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		initialDepositeAmount.clear();
		initialDepositeAmount.sendKeys("500");
		
		WebElement lengthOfCDmonth=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		lengthOfCDmonth.clear();
		lengthOfCDmonth.sendKeys("2");
        
		
		WebElement intrestRate=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		intrestRate.clear();
		intrestRate.sendKeys("24");
		
		WebElement compoundingClickButton=driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
		compoundingClickButton.click();
		
	   List<WebElement> compoundingList = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']"));
	   String expectedoption="Compounded Monthly";
	   for(WebElement list:compoundingList)
	   {
		   String actualoption=list.getText();
		   if(actualoption.equals(expectedoption))
		   {
			   list.click();
			   break;
		   }
	   }
	   
	   WebElement runButton=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
	//   runButton.click();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", runButton);
	}

}
