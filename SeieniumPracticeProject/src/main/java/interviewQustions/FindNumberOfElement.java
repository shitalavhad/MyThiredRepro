package interviewQustions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.*;


public class FindNumberOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.booksbykilo.in/new-books");
		
		int previouesCount=0;
		
		int currentCount=0;
		
		while(true)
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"))	;
			currentCount=books.size();
			if(currentCount==previouesCount)
			{
				break;
			}
			 previouesCount=currentCount;
			 
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		System.out.println(currentCount);
				
		
		
				
	}

}
