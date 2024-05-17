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
import java.util.ArrayList;
import java.util.List;


public class BrokrnlinksFinding1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//open the browser
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	//open the application
	driver.get("https://www.amazon.com/");

	//find the how much link are valiavle on webpage
	List<WebElement> links=driver.findElements(By.tagName("a"));
	links.addAll(driver.findElements(By.tagName("img")));
	
	//create empty list
	List<WebElement> activeLinks=new ArrayList<WebElement>();
	
	//itreave the all list andexcliude the all link this not having href attribute
	for(int i=0;i<links.size();i++)
	{
		//if(links.get(i).getAttribute("href") !=null &&  (!links.get(i).getAttribute("href").contains("javascript"))
		if(links.get(i).getAttribute("href")!=null &&(!links.get(i).getAttribute("href").contains("javascript")) )
		{
			activeLinks.add(links.get(i));
		}
	}
	System.out.println("Total active link avaliable on the webpage :"+activeLinks.size());
	
		for(int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			connection.setReadTimeout(5000);
			connection.getResponseCode();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"-----------"+connection.getResponseMessage());
		}
	}

}
