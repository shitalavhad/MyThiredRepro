package windowPopUpHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class SpecificWindowHanling {
	static  WebDriver  driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	   driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		
		driver.findElement(By.xpath("((//a[contains(@class,'button ')])[1])")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("(//a[text()='Click Here'])[1]")).click();
		//prent window adress
		String parentWindowAddress=driver.getWindowHandle();
		//child Window address
	  Set<String> handles = driver.getWindowHandles();
	  List<String> hList=new ArrayList<String>(handles);
		if(	switchToSpecifiWindow(hList, "Frames And Windows - GlobalSQA"))
		{
			System.out.println(driver.getTitle()+"  :: "+driver.getCurrentUrl());
		}
		switchToParentWindow(parentWindowAddress);
		closeTheChidWindow(hList, parentWindowAddress);
			
		
			

	}
	public static void closeTheChidWindow(List<String>hList,String parentWindowAddress)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowAddress))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentWindow( String parentWindowAddress)
	{
		System.out.println(driver.getCurrentUrl()+"   ::  "+driver.getTitle() );
	}
	public static boolean switchToSpecifiWindow(List<String>hList ,String windowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println(" Found Correct Window.......");
				return true;
			}
			
		}
		return false;
		
	}

}
