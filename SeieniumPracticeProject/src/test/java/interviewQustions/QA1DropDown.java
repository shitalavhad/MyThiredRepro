package interviewQustions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.*;

public class QA1DropDown {
	@Test(priority=1,enabled=false)
	public void selectOptionDrpUsingGenaricFunction()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	
		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_0_0')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", createNewAccountButton);
		
		WebElement dayDrp=driver.findElement(By.xpath("//select[@id='day']"));
		selectValueFromDrp(dayDrp, "5");
		
		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		selectValueFromDrp(monthDrp, "Feb");
		
		WebElement yearDrp=driver.findElement(By.xpath("//select[@id='year']"));
		selectValueFromDrp(yearDrp, "2022");
	}
	@Test(priority=2,enabled=false)
	public void verifyGetAllOptions()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	
		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_0_0')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", createNewAccountButton);
		
		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc=new Select(monthDrp);
		List<WebElement>options=sc.getOptions();
		for(WebElement op:options)
		{
			String e=op.getText();
			System.out.println(e);
		}
	}
		@Test(enabled=false)
		public void verifycheakOptionPresentOrNot()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter option hrer");
			String option=sc.next();
			System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/");
		
			WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_0_0')]"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", createNewAccountButton);
			
			WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
			String expop=option;
			Select sc1=new Select(monthDrp);
			List<WebElement>options=sc1.getOptions();
			for(WebElement op:options)
			{
				String actualop=op.getText();
				if(actualop.equals(expop))
				{
					op.click();
					System.out.println(op.getText());
					break;
				}
				//System.out.println(e);
			}
		}
		
		@Test
		public void verifyDropDownSortedOrnot()
		{
			System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/");
		
			WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_0_0')]"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", createNewAccountButton);
			
			WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
			Select sc=new Select(monthDrp);
			List<WebElement>op=sc.getOptions();
			
			List orgList=new ArrayList();
			List tempList=new ArrayList();
			for(WebElement e:op)
			{
				orgList.add(e.getText());
				tempList.add(e.getText());
			}
			System.out.println("original list  :"+orgList);
			System.out.println("tempList list  :"+tempList);
			
			//sorting
			Collections.sort(tempList);
			System.out.println("Afetr sorting :"+tempList);
			
			//validations
		if(orgList.equals(tempList))
		{
			System.out.println("Drop Down sorted");
		}
		else
		{
			System.out.println("Drop Down not sorted");
		}
		}
	
	public void selectValueFromDrp(WebElement ele,String value)
	{
		Select sc=new Select(ele);
		List<WebElement > options=sc.getOptions();
		for(WebElement op:options)
		{
			String e=op.getText();
			if(e.equals(value))
			{
				op.click();
				System.out.println(op.getText());
				break;
			}
		}
	}

}
