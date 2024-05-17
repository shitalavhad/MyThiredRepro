package windowHandling;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificWindowHandlingDemo {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		
		driver.findElement(By.xpath("(//button[@id='button1'])[3]")).click();
		
		String parentWindowId=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(handles);
		if(switchToSpecificWindow(hList, "Vinoth Q.A Academy – Learn With Clarity"))
		{
			System.out.println(driver.getTitle()+"  :" +driver.getCurrentUrl());
		}
		closeChildWndow(hList, parentWindowId);
		switchParentWindow(parentWindowId);
		System.out.println(driver.getTitle()+"  "+driver.getCurrentUrl());
		
	}
	public static void closeChildWndow(List<String> hList ,String parentWindowId)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowId))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchParentWindow(String parentWindowId)
	{
		System.out.println(driver.getTitle()+ "  "+driver.getCurrentUrl());
	}
  public static  boolean switchToSpecificWindow(List<String >hList,String windowTitle)
  {
	  for(String e:hList)
	  {
		String title=driver.switchTo().window(e).getTitle();
		if(title.contains(windowTitle))
		{
			System.out.println("Found Write Window  ....");
		}
		return true;
	  }
	  return false;
  }

}
