package handlingWindows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.Test;

public class HandlingWindowUsingGenaricFunction {
	 static WebDriver driver;
	 @Test
	 public void handlingWindows()
	 {
		   System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://www.thetesttribe.com/blog/multiple-windows-selenium/");
			
			String parentWindowID=driver.getWindowHandle();
			
		WebElement linkLind	=driver.findElement(By.xpath("(//span[contains(@class,'elementor')])[6]"));
		linkLind.click();
		
		WebElement facebookLink=driver.findElement(By.xpath("(//span[contains(@class,'elementor')])[7]"));
		facebookLink.click();
		
		//WebElement twitterLink=driver.findElement(By.xpath("(//span[contains(@class,'elementor')])[8]"));
		//twitterLink.click();
		
		WebElement messageLink	=driver.findElement(By.xpath("(//span[contains(@class,'elementor')])[9]"));
		messageLink.click();
		
		WebElement whatsupLink	=driver.findElement(By.xpath("(//span[contains(@class,'elementor')])[10]"));
		whatsupLink.click();
		
		Set<String > windowsID=driver.getWindowHandles();
		List<String>hList=new ArrayList<String>(windowsID);
		
		
		
			
			
			
			
	 }



public static boolean switchToSpecificWindow(List<String> hList,String windowTitle)
{
	for(String e:hList)
	{
		String title=driver.switchTo().window(e).getTitle();
		if(title.contains(windowTitle))
		{
			System.out.println("Found coorect Window.........");
		  return true;
	}
		
}
	return false;
	
}
public static  void closeChildWindow(List<String> hList,String parentWindowID)
{
	for(String e:hList)
	{
		if(e.equals(parentWindowID))
		{
			driver.switchTo().window(e).close();
		}
	}
}

public static void switchToParentWindow(String parentWindowID)
{
	System.out.println(driver.getTitle()+ "  "+driver.getCurrentUrl());
}

}

