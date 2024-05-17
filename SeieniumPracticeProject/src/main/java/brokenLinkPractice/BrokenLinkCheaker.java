package brokenLinkPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkCheaker {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		//find the all link avaliable on webpage
		List<WebElement> links=driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("src")));
		System.out.println("Total avaliable links :"+links.size());
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		//excluding all links and image which do not having attribute href and src
		for(int i=0; i< links .size();i++)
		{
			if(links.get(i).getAttribute("href")!=null  && (!links.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("Active Links on webpage: "+activeLinks.size());
		for(int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
		//	String respons=connection.get
			connection.setConnectTimeout(2000);
			connection.disconnect();
			//System.out.println(activeLinks.get(j).getAttribute("href")+"--------------------------->"+response);
			
		}
		
		
		
		
		
	}

}
