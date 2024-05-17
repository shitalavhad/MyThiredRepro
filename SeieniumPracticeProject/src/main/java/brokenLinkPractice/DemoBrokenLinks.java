package brokenLinkPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//get the all links and img
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		links.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Totle number of links:"+links.size());
		
		//create empty list
		List<WebElement > tempList=new ArrayList<WebElement>();
		
		//excludu all links those not haning href attribute
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null && (!links.get(i).getAttribute("href").contains("javascript")))
			{
			 tempList.add(links.get(i));
			}
		}
		System.out.println("totle no of active links :"+tempList.size());
		
		//establish the connection withURL
		for(int j=0;j<tempList.size();j++) {
	HttpURLConnection	connection=(HttpURLConnection) new URL(tempList.get(j).getAttribute("href")).openConnection();
	String respons=connection.getResponseMessage();
	connection.setConnectTimeout(3000);
	connection.disconnect();
	System.out.println(tempList.get(j).getAttribute("href")+"====================>"+respons);
		
		}
	}

}
