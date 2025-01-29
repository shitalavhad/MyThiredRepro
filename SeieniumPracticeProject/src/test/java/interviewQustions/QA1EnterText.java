package interviewQustions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class QA1EnterText {
	
	@Test(priority=1,enabled=false)
	public void enterTextWithoutUsingSendKeys()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='shital';", emailField);
		
	}
	@Test(priority=2,enabled=false)
	public void clickONbuttonWithoutclick()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	
		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_0_0')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", createNewAccountButton);
		
	}
	@Test(priority=3)
	public void verifyScrollingOpreation()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	
		
		WebElement createPage=driver.findElement(By.xpath("(//a[contains(text(),'Create')])[2]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",createPage);
		js.executeScript("arguments[0].click();", createPage);
	}

}
