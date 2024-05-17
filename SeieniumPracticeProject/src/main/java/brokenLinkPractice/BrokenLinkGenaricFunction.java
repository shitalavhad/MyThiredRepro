package brokenLinkPractice;
import org.openqa.selenium.WebDriver ;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.io.IOException;
import java.net.*;

public class BrokenLinkGenaricFunction {

	public static void main(String[] args) throws IOException {
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//open the application
		driver.get("https://bstackdemo.com/");
		
		//find the webElemnt having a tag
		List<WebElement >links=driver.findElements(By.tagName("a"));
		
		//itreave the all links
		for(WebElement Link:links)
		{
			String url=Link.getAttribute("href");
			verifyLinks(url);
		}
		
	}
	public static void verifyLinks(String url ) throws IOException
	{
		URL url1=new URL(url);
		HttpURLConnection httpurlconnection=(HttpURLConnection) url1.openConnection();
		httpurlconnection.connect();
		httpurlconnection.setConnectTimeout(5000);
		httpurlconnection.connect();
		
	   if(httpurlconnection.getResponseCode()==200)
		{
			System.out.println(url1+"------"+httpurlconnection.getResponseMessage());
		}
	   else
	   {
		   System.err.println(url1+"------"+httpurlconnection.getResponseMessage());
	   }
	}

}
