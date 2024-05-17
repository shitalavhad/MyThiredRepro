
package brokenLinkPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class BrokenLinkHandligDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.facebook.com");
		driver.get("https://www.amazon.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		links.add(driver.findElement(By.tagName("img")));
		System.out.println("Totle avaliable links: "+links.size());
		 List<WebElement> activeLinks=new ArrayList<WebElement>();
		 
		 for(int i=0;i<links.size();i++)
		 {
			if( links.get(i).getAttribute("href")!=null &&(! links.get(i).getAttribute("href").contains("javascript")))
					{
				       activeLinks.add(links.get(i));
					}
		 }
		 System.out.println("Total no of activeLinks :"+activeLinks.size());
		 for(int j=0;j<activeLinks.size();j++)
		 {
			HttpURLConnection httpconnection = (HttpURLConnection )new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			httpconnection.connect();
			httpconnection.setConnectTimeout(5000);
			String response=httpconnection.getResponseMessage();
			System.out.println(activeLinks.get(j).getAttribute("href")+"==============>"+response);
		 }
	}

}
