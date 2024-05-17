package windowHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class SpecificWindowHandling {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		Thread.sleep(500);
	  WebElement clickButton	=driver.findElement(By.xpath("//div[@id='Tabbed']//button"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript(" arguments[0].click() ; ", clickButton);
		
		String parentWindowId=driver.getWindowHandle();
		
	//address of all window
   Set<String>	 handle=driver.getWindowHandles();
	   List<String> hList=new ArrayList<String>(handle);
	  if( switchToSpecificWindow("Selenium", hList))
			  {
		        System.out.println(driver.getCurrentUrl()+ "   :  "+driver.getTitle());
			  }
	   closeAllWindow(hList, parentWindowId);
	  switchToParentWindo(parentWindowId);
	  System.out.println(driver.getCurrentUrl()+"  :"+driver.getTitle());
			  
			  
	

	}
	public static void closeAllWindow(List<String>hList,String parentWindowId)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowId))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentWindo(String parentWindowId)
	{
		driver.switchTo().window(parentWindowId);
	}
	public static boolean switchToSpecificWindow(String windowTitle ,  List<String> hList)
	{
	for(String e:hList)
	{
		String title=driver.switchTo().window(e).getTitle();
		if(title.contains(windowTitle))
		{
			System.out.println("This is correct Window");
			return true;
		}
	}
	return false;
	}

}


