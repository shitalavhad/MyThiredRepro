package bWebElementMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class DemoWebElement {
	 static WebDriver driver;

	public static void main(String[] args) {
		//lunch the browser
		System.setProperty("webdriver.chrome.driver","G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	/*	//how to enter text inside the field
		WebElement userNameField=driver.findElement(By.xpath("//input[@name='username']"));
		userNameField.sendKeys("Admin");
		*/
		//enterText("//input[@name='username']", "Admin");
		
	/*	//how to enter text inside text field without using sendKeys function
		WebElement userNameField=driver.findElement(By.xpath("//input[@name='username']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Admin';", userNameField);*/
		
		WebElement userNameField=driver.findElement(By.xpath("//input[@name='username']"));
		userNameField.sendKeys("Admin");
		
		WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys("admin123");
		
	//	WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		//loginButton.click();
		
		WebElement compantName=driver.findElement(By.xpath("(//div[contains(@class,'orangehrm-login')])[5]"));
		System.out.println("Company name:"+compantName.getText());
		
		WebElement companLogo=driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']"));
		if(companLogo.isDisplayed()==true)
		{
			System.out.println("Logo present on webpage");
		}
		else
		{
			System.out.println("Not present on webpage");
		}
		
		
	
		

	}
	//genaric function for enter the text inside the textField
	public static WebElement enterText(String locater,String value)
	{
		WebElement ele=driver.findElement(By.xpath(locater));
		ele.sendKeys(value);	
		return ele;
	}

}
