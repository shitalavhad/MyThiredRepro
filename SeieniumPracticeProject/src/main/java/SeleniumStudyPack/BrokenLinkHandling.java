package SeleniumStudyPack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org .openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;




import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkHandling {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//retrive the all liks on webpage
		List<WebElement> linkSet=driver.findElements(By.tagName("a"));
		//cheak how many link are  there
		System.out.println("Totle no of Links :"+linkSet.size());
		List<WebElement> activeLinkSet=new ArrayList<WebElement>();
		//exclue all links those links do not having href attribute 
		for(int i=0;i<linkSet.size();i++)
		{
			if(linkSet.get(i).getAttribute("href")!=null && (!linkSet.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinkSet.add(linkSet.get(i));
			}
		}
		
		for(int j=0;j<activeLinkSet.size();j++)
		{
			
				HttpURLConnection connection = (HttpURLConnection)	 new URL(activeLinkSet.get(j).getAttribute("href"))
						.openConnection();
				connection.connect();
				String respons = connection.getResponseMessage();
				connection.setReadTimeout(5000);
				connection.disconnect();
				System.out.println(activeLinkSet.get(j).getAttribute("href")+"===============>"+respons);
		
			
	
		
			
		
	
	
		
		
		

	 
		}
		
		

	}
	
}

