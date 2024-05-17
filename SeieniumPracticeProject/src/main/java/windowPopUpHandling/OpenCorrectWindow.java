package windowPopUpHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OpenCorrectWindow {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		
       driver.findElement(By.xpath("((//a[contains(@class,'button ')])[1])")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("(//a[text()='Click Here'])[1]")).click();
		
		String parentWindowAddress=driver.getWindowHandle();
		
		Set<String> handles=driver.getWindowHandles();
		
		List<String> hList=new ArrayList<String>(handles);
		

	}
	public static void closeChildWindow(List<String>hList,String parentWindowAdress)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowAdress))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchParentWindow(String parentWindowAdress)
	{
		System.out.println(driver.getTitle()+"  ::   "+driver.getCurrentUrl());
	}
	public static boolean switchFromSpecificWindow(List<String >hList,String windowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Found correctWindow--------");
				return true;
			}
			
		}
		return false;
	}
	

}
