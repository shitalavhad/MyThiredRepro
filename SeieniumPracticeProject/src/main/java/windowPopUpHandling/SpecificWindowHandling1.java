package windowPopUpHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.github.dockerjava.api.model.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.By;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificWindowHandling1 {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
	
		driver.get("https://www.facebook.com/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.google.com/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.vctcpune.com/");
		
		//parentWindowAddress
		String parentWindowAddress=driver.getWindowHandle();
		System.out.println("Parent window address:"+parentWindowAddress);
		
		//child window addreass
		Set<String> childWindowAddress=driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(childWindowAddress);
		if(switchToChildWindow(hList, "Google"))
		{
			System.out.println(driver.getTitle()+"  : :  " +driver.getCurrentUrl());
		}
		closeChildWindow(hList, parentWindowAddress);
		switchToParentWindow(parentWindowAddress);
		

	}
	public static void closeChildWindow(List<String> hList,String parentWindowAddress)
	{
		for(String e:hList)
		{
			if(!e.contains(parentWindowAddress))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentWindow(String parentWindowAddress)
	{
		driver.switchTo().window(parentWindowAddress);
		System.out.println(driver.getTitle()+" :  :"+driver.getCurrentUrl());
	}
	public static boolean  switchToChildWindow(List<String>hList,String windowTitle)
	{
		for(String e:hList)
		{
		      String title=driver.switchTo().window(e).getTitle();
		      if(title.contains(windowTitle))
		      {
		    	  System.out.println("Found correct window........");
		    	  return true;
		      }
		}
		return false;
	}

}
