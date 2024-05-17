package brokenLinkPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksFinding {

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		//driver.get("https://www.amazon.com/");
		
		//find the how many link are avaliable o webpage
	List<	WebElement >links=driver.findElements(By.tagName("a"));
	System.out.println("Total available links on webpage : "+links.size());
	
	//iterve the all links
	for(WebElement linkUrl:links)
	{
		String linksurl=linkUrl.getAttribute("href");
		
		//create the instane or url class
		URL url=new URL(linksurl);
	  URLConnection urlconnection = url.openConnection();
	  HttpURLConnection httpurlconnection=(HttpURLConnection) urlconnection;
	  httpurlconnection.setConnectTimeout(5000);
	  httpurlconnection.connect();
	  if(httpurlconnection.getResponseCode()==200)
	  {
		  System.out.println(linksurl +" ------    "+httpurlconnection.getResponseMessage());
	  }
	  else
	  {
		  System.err.println(linksurl+"------"+httpurlconnection.getResponseMessage());
	  }
			
		}	
			
		
	

	}

}
