package brokenLinkPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;



public class BrokenLinksAndImg {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		//find the how many link are avaliable o webpage
	List<	WebElement >links=driver.findElements(By.tagName("a"));
	System.out.println("Total available links on webpage : "+links.size());
	
	//find the imager
	links.addAll(driver.findElements(By.tagName("img")));
	System.out.println("Total no of links and img :"+links.size());
	
	List<WebElement>activeLinks=new ArrayList<WebElement>();
	
	//iterive the all links which having parameter only href
	for(int i=0;i<links.size();i++)
	{
		if(links.get(i).getAttribute("href")!=null &&(!links.get(i).getAttribute("href").contains("javascript")) ) {
			activeLinks.add(links.get(i));
		}
			
		}
	 System.out.println("size of active links :"+activeLinks.size());
	 
	 for(int j=0;j<activeLinks.size();j++)
	 {
	
	
		HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String response=connection.getResponseMessage();
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href")+"--------------------->"+response);
		
		
	 }
		}
	}
	
	
		
	

	


