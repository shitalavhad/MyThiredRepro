package windowHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificLinkSelection {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
     driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
	
	driver.findElement(By.xpath("((//a[contains(@class,'button ')])[1])")).click();
	
	Thread.sleep(500);
	
	driver.findElement(By.xpath("(//a[text()='Click Here'])[1]")).click();
	
	String parentWindowId=driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	List<String> hList=new ArrayList<String>(handles);
	if(switchToSpecificWindow(hList, "Frames And Windows - GlobalSQA"))
	{
		System.out.println(driver.getCurrentUrl()+"  ::  "+driver.getTitle());
	}
	closeChildWindow(parentWindowId, hList);
	switchToParentWindow(parentWindowId);
	
	

	}
	public static void closeChildWindow(String parentWindowId,List<String>hList)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowId))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentWindow(String parentWindowId)
	{
		System.out.println(driver.getCurrentUrl()+"::"+driver.getTitle());
	}
	public static boolean switchToSpecificWindow(List<String>hList,String windowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Found right window.......");
				return true;
			}
		}
		return false;
	}

}
