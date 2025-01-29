package bDropDownHandling;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDropDownHadling {
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
	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void getOptionFromDropDown()
	{
		WebElement createNewAccountButton=
				driver.findElement(By.xpath("//a[contains(@class,'_42ft ')][text()='Create new account']"));
		createNewAccountButton.click();
		WebElement monthDropDown=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc=new Select(monthDropDown);
		List<WebElement> option=sc.getOptions();
		for(WebElement e:option)
		{
			String options=e.getText();
			System.out.println( options);
			
		}
	}
	@Test(priority=3)
	public void selectOptionFromeDropDown()
	{
		WebElement createNewAccountButton=
				driver.findElement(By.xpath("//a[contains(@class,'_42ft ')][text()='Create new account']"));
		createNewAccountButton.click();
		WebElement monthDropDown=driver.findElement(By.xpath("//select[@id='month']"));
		selectOptionFromeDropDown(monthDropDown, "Apr");
		
	}
	@Test(priority=4)
	public void clikingOnlyExpectedOption()
	{
		WebElement createNewAccountButton=
				driver.findElement(By.xpath("//a[contains(@class,'_42ft ')][text()='Create new account']"));
		createNewAccountButton.click();
		WebElement monthDropDown=driver.findElement(By.xpath("//select[@id='month']"));
		String expectedOption="Feb";
		Select sc=new Select( monthDropDown);
		List<WebElement>option=sc.getOptions();
		for(WebElement e:option)
		{
			String actualOption=e.getText();
			if(actualOption.equals(expectedOption))
			{
				e.click();
				break;
			}
		}
	}
	@Test
	public void compareExpectedAndActualDropDownOption()
	{
		WebElement createNewAccountButton=
				driver.findElement(By.xpath("//a[contains(@class,'_42ft ')][text()='Create new account']"));
		createNewAccountButton.click();
		WebElement monthDropDown=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc=new Select( monthDropDown);
		List<WebElement> expectedList=new ArrayList<WebElement>();
		List<WebElement>actualOption=sc.getOptions();
		for(WebElement e:actualOption)
		{
			 expectedList.add(e);
		}
		System.out.println( expectedList);
	}
	public void selectOptionFromeDropDown(WebElement ele,String value)
	{
		Select sc=new Select(ele);
		List<WebElement> option=sc.getOptions();
		for(WebElement e:option)
		{
			String op=e.getText();
			if(op.equals(value))
			{
				System.out.println(e.getText());
				e.click();
				break;
			}
		}
	}

}
