package brokenLinkPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class BrokenLinkAndImgFinding {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		//open the application
		WebDriver driver=new ChromeDriver();
		
	  //maximize the application
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//find the all links and image
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		//add the image 
		links.addAll(driver.findElements(By.tagName("img")));
		
		//cheak how many links are avaliable
		System.out.println("Total no of links are avaliable on webpage :"+links.size());
		
		//create the empty list
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		//exclude the all links this link do not have href attribute
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null &&(! links.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("Total no of active Links :"+activeLinks.size());
		for(int j=0;j<activeLinks.size();j++)
		{
		HttpURLConnection connection = (HttpURLConnection)	 new URL(activeLinks.get(j).getAttribute("href"))
				.openConnection();
		connection.connect();
		String respons = connection.getResponseMessage();
		connection.setReadTimeout(5000);
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href")+"===============>"+respons);
		}
		
		

	}

}
