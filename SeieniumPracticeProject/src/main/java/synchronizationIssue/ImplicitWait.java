package synchronizationIssue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
       driver=new ChromeDriver();
     //  impilicitlyWaitMethod(driver, 10);
		
		driver.get("https://www.facebook.com/");
		WebDriverWait ewait=new WebDriverWait(driver ,Duration.ofSeconds(10));
		WebElement emaliIDField=ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email1']")));
		emaliIDField.sendKeys("123");
		///WebElement emaliIDField=driver.findElement(By.xpath("//input[@id='email1']"));
		
	}
	public static void impilicitlyWaitMethod(WebDriver driver,int timeUnit)
	{
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}
	

}
