package demoDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class CaptureDuplicateElementFromeDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://testautomationpractice.blogspot.com/");
			
			WebElement colourDropDown=driver.findElement(By.xpath("//select[@id='colors']"));
			Select sc=new Select( colourDropDown);
			List<WebElement> options=sc.getOptions();
			boolean flag=false;
			
			Set<String> uniqueOption=new HashSet<String>();
			
			for(WebElement op:options)
			{
				String text=op.getText();
				//System.out.println(uniqueOption.add(text));
				if(!uniqueOption.add(text))
				{
					System.out.println("Duplicate elment :"+text);
					flag=true;
					
				}
			}
        if(!flag)
        {
        	System.out.println("Not Duplicate found in the list box");
        }
	}

}
