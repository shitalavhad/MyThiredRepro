package WindowHandling;

import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindow {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
	driver=new ChromeDriver();
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	String parentWindowAdd=driver.getWindowHandle();
	
	driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[1]")).click();
	driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[2]")).click();
	driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[3]")).click();
	driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[4]")).click();
	
	Set<String> handles=driver.getWindowHandles();
	List<String> hList=new ArrayList<String>(handles);
	if(switchToSpecificWindow("OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ | Facebook", hList))
	{
		System.out.println(driver.getCurrentUrl() +" : "+driver.getTitle());
	}
	switchParentWindow(parentWindowAdd);
	System.out.println(driver.getCurrentUrl() +" : "+driver.getTitle());
	closeallWindow(hList, parentWindowAdd);
	
	

	}
	public static void closeallWindow(List<String> hList,String parentWindowAdd)
	{
		for(String e:hList)
		{
			if(!e.equals( parentWindowAdd))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void  switchParentWindow(String parentWindowAdd )
	{
		driver.switchTo().window(parentWindowAdd);
	}
	public static boolean switchToSpecificWindow(String windowTitle,List<String> hList)
	{	
		for(String e:hList) {
			String title=driver.switchTo().window(e).getTitle();
		if(title.contains(windowTitle))
		{
			System.out.println("Found Right window.................");
			return true;	
		}
		
	}
	return false;

}
}

