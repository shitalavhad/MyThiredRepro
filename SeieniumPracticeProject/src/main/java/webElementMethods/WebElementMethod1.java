package webElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class WebElementMethod1 {
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		//Enter the text inside the text field
		//emailField.sendKeys("shitalAvhad");
		//enterText(emailField, driver);
		
		//enter the text using the javascriptExector
	  JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('email').value='ShitalAvhad';");
		//js.executeScript("arguments[0].value='AvhadShital';",emailField);
		
		//clear the text
		//emailField.clear();
		//clearText(emailField, driver);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[contains(@class,'_42ft _4jy0 _6lth ')]"));
		//loginButton.click();
		//clcik button using javascrptExecutor
		//js.executeScript("arguments[0].click();", loginButton);
		
		//how th gwt the the text
		//WebElement text=driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		//System.out.println("page text is : "+text.getText());
		
		//verifyElementDisplayed(driver, emailField);
		//enabled and disable element
		String enable ="document.getElementsByName('email').removeAttribute('disabled');";
		js.executeScript(enable);
		
		

	}
	//genaric function to enter the text inside the text field
	public static void enterText(WebElement ele,WebDriver driver)
	{
		WebElement ele1=driver.findElement(By.xpath("//input[@id='email']"));
		ele1.sendKeys("shitalAvhad");
		
	}
	
	//genaric method to clear the text
	public static void clearText(WebElement ele,WebDriver driver)
	{
		WebElement ele2=driver.findElement(By.xpath("//input[@id='email']"));
		ele2.clear();
	}
	
	//cheak element displayed or not on webpage
	public static void verifyElementDisplayed(WebDriver driver,WebElement ele)
	{
		WebElement ele1=driver.findElement(By.xpath("//input[@id='email']"));
		//WebElement ele1=driver.findElement(By.xpath(xpath));
		boolean result = ele1.isDisplayed();
		if(result==true)
		{
			System.out.println("displayed");
		}
		else
		{
			System.out.println(" not displayed");
		}
	}
	
	
}
