package demoDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import java.util.*;
import org.openqa.selenium.support.ui.*;

public class CaptureDuplicateElement {
	@Test
	public void captureDuplicateElement()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement listElement=driver.findElement(By.xpath("//select[@id='colors']"));
		
		Set<String> uniqeText=new HashSet<String>();
		
		Select sc=new Select(listElement);
		List<WebElement>options=sc.getOptions();
		 boolean flag = false;
		for(WebElement option:options)
		{
			String optionText=option.getText();
			if(!uniqeText.add(optionText))
			{
				System.out.println("Found Duplicte option :"+optionText);
				flag=true;
				
			}
		}
		if(!flag)
		{
			System.out.println("Not found duplicte option");
		}
		{
			
		}
	}

}
