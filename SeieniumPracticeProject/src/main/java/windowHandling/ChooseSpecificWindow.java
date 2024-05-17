package windowHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChooseSpecificWindow {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//open the another window
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.automationtesting.in/Windows.html");
		String parentWindowId=driver.getWindowHandle();
		System.out.println("Parent Window Address:  "+parentWindowId);
		//child window address
		Set<String> handles=driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(handles);
		if(switchToSpecificWindow(hList, "Frames & windows"))
		{
			System.out.println(driver.getTitle()+"    : :"+driver.getCurrentUrl());
		}
		

	}
	public static boolean  switchToSpecificWindow(List<String> hList,String windowTitle)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Found right Window");
				return true;
			}
		}
		return false;
	}

}
