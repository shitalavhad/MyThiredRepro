package bWebDriverMethods;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDirverMethods {
	WebDriver driver;
	@Test
	public void luchBrowser()//lunch browser
	{
		String path="G:\\ChromeDriver\\chromedriver-win64\\chromedirver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		 driver=new ChromeDriver();
	}
	@Test
	public void openApplication()
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
	}
	@Test(priority=3)
	public void verifyTitleOfWebpage()
	{
		this.openApplication();
		driver.manage().window().maximize();
		
		String expectedTitle="Facebook – log in or sign up";
		String actulaTitle=driver.getTitle();
		System.out.println("Title of the webpage: "+driver.getTitle());
		Assert.assertEquals(actulaTitle, expectedTitle,"Title are not matching");
	}
	@Test(priority=4)
	public void verifyUrlOfwebpage()
	{
		this.openApplication();
		driver.manage().window().maximize();
		String expectedUrl="https://www.facebook.com/";
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Url of webpage :"+ actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

}
