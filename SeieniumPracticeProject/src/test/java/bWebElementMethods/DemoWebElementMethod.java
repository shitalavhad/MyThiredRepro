package bWebElementMethods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.*;

public class DemoWebElementMethod {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		String browser="chrome";
		if(browser.equalsIgnoreCase("chrome"))
		{
			String path="G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver","G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe" );
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("driver not avaliable");
		}
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	@Test(priority=1)
	public void enterTextInsideField()
	{
	  WebElement emailField=driver.findElement(By.xpath("//input[@id='email'  and @name='email']"));
	 // emailField.sendKeys("avhadshital8@gmail.com");
	  //without using sendkeys
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].value='avhadshital@gmail.com';", emailField);  
	  
	  //clear text using javascript
	  js.executeScript("arguments[0].value=' ';", emailField);
	}
	@Test(priority=2)
	public void multipleWayToClikingOpration()
	{
		WebElement loginButton=driver.findElement(By.xpath("//button[@name='login'][text()='Log in']"));
		//1way
		//loginButton.click();
		
		//2way
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();",loginButton );
		
		//3way
		loginButton.sendKeys(Keys.ENTER);
		
	   //4way
		Actions act=new Actions(driver);
		act.click(loginButton);
	}
	@Test(priority=3)
	public void getCSSPropertiesOfWebElement()
	{
		WebElement loginButton=driver.findElement(By.xpath("//button[@name='login'][text()='Log in']"));
		String actualbackGroundColor=loginButton.getCssValue("background-color");
		System.out.println(actualbackGroundColor);
		
		String expectedbackGroundColor="8, 102, 255";
		Assert.assertEquals(actualbackGroundColor, expectedbackGroundColor);	
	}
	@Test(priority=4)
	public void getSizeofWebElemnet()
	{
		WebElement loginButton=driver.findElement(By.xpath("//button[@name='login'][text()='Log in']"));
		//Dimension d=loginButton.getSize();
		//System.out.println(d.height  +"  " +d.width);
		getHeigthAndWidthWebElement(driver, loginButton);
	}
	
	public void getHeigthAndWidthWebElement(WebDriver driver,WebElement element)
	{
		Dimension d=element.getSize();
		System.out.println(d.height +"  "+d.width);
	}
	
	
	}



