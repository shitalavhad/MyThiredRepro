package windowHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;



import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingSpecificWindow {
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
		
		//Address of parentWindow
		String parentWindowAddress=driver.getWindowHandle();
		
		//Address of child window
		Set<String> handle=driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(handle);
	if(	switchToSpecificWindow(hList, "Frames And Windows - GlobalSQA"))
	{
		System.out.println(driver.getTitle()+"  :: "+driver.getCurrentUrl());
	}
	switchToParentWindow(parentWindowAddress);
	closeSpecificWindow(hList, parentWindowAddress);

	}
	public static void closeSpecificWindow(List<String> hList,String parentWindowAddress)
	{
		for(String e:hList)
		{
			if(!e.equals(parentWindowAddress))
			{
				driver.switchTo().window(e).close();
			}
		
		}
	}
	public static void switchToParentWindow(String parentWindowAddress)
	{
		//driver.switchTo().window(parentWindowAddress);
		System.out.println(driver.getTitle()+"    "+driver.getCurrentUrl());
	}
	public static boolean switchToSpecificWindow(List<String> hList,String widowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(widowTitle))
			{
				System.out.println("Found Correct window......");
				return true;
			}
	}
		return false;
	
	}
	

}
