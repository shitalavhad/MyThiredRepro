package windowHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;



public class OpenNewWindowAndHandle {
	static WebDriver driver;

	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    
     driver=new ChromeDriver();
    
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
    driver.get("https://www.facebook.com/");
    
    driver.switchTo().newWindow(WindowType.TAB);
    
    driver.get("https://www.google.com/");
    
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.redbus.in/");
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://web.whatsapp.com/");
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://vctcpune.com/");
    String parentWindowId=driver.getWindowHandle();
    Set<String> handles=driver.getWindowHandles();
    List<String>hList=new ArrayList<String>(handles);
  if(  switchToSpecificWindow(hList, "📊 India's No.1 IT Training Center 📈"))
  {
	  System.out.println(driver.getCurrentUrl()+"  :  :"+driver.getTitle());
  }
  closeChlidWindow(hList, parentWindowId);
  switchToParentWindow(parentWindowId);
    
    

	}
	public static void closeChlidWindow(List<String>hList,String parentWindowId)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowId))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentWindow(String parentWindoeId)
	{
		System.out.println(driver.getCurrentUrl()+": :"+driver.getTitle());
	}
	
	public static boolean switchToSpecificWindow(List<String>hList,String windowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Found correct Window.....");
				return true;
			}
		}
		return false;
	}

}
