package handlingWindows;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class HandlingWindow {
	@Test(enabled=false)
	public void handlingSpecificWindow()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://omayo.blogspot.com/");
		
		WebElement clickMeButton=driver.findElement(By.xpath("//a[text()='Open a popup window']"));
		clickMeButton.click();
		
		String parentWindowID=driver.getWindowHandle();
	   //fetch the addrese od main page window and child window
		Set<String> addr=driver.getWindowHandles();
		System.out.println("Addresses of window:"+addr);
		
		//create list and set data store inside the arrayLIst
		List<String> window=new ArrayList<String>(addr);
		/*System.out.println("Parent Window id :"+window.get(0));
		
		driver.switchTo().window( window.get(1));
		String childWindowTitle=driver.getTitle();
		System.out.println("Child Window Id: "+childWindowTitle);*/
		for(String e:window)
		{
			if(!e.equals(parentWindowID))
			{
				driver.switchTo().window(e);
				String childWindowTitle=driver.getTitle();
				System.out.println("Child Window Title:"+childWindowTitle);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindowID);
		String parentWindowTitle=driver.getTitle();
		System.out.println("ParentWindow Title:"+parentWindowTitle);
		driver.quit();
	}
	@Test
	public void handlingMultipleWindow() throws InterruptedException
	{
System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://omayo.blogspot.com/");
		
		WebElement clickMeButton=driver.findElement(By.xpath("//a[text()='Open a popup window']"));
		clickMeButton.click();
		
		WebElement clickOnLink=driver.findElement(By.xpath("//a[@id='selenium143']"));
		clickOnLink.click();
		
		String parentWindowID=driver.getWindowHandle();
		
		Set<String> windowIDs=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowIDs);
		for(String e:handles)
		{
			driver.switchTo().window(e);
			if(driver.getTitle().equals("New Window"))
			{
				String childWindow1Title=driver.getTitle();
				System.out.println("ChildWindow1 Title  :"+childWindow1Title);
				driver.close();
			}
			else if(driver.getTitle().contains("Selenium143 "))
			{
				Thread.sleep(1000);
				String childWindow2Title=driver.getTitle();
				System.out.println("ChildWindow2 Title  :"+childWindow2Title);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowID);
		String parentWindowTitle=driver.getTitle();
		System.out.println("Parent Window Title :"+parentWindowTitle);
		driver.quit();
	}

}
