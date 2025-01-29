package interviewQustions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class QA3BrokenLinkFinder {
	@Test
	public void verifyBrokenLink()
	{
	   System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		
		List <WebElement>activeLink=new ArrayList<WebElement>();
		
		for(int i=0;i<links.size();i++)
		{
			if((links.get(i).getAttribute("href")!=null) && (!links.get(i).getAttribute("href").contains("javascript"))){
				activeLink.add(links.get(i));
				
			}
		}
		System.out.println("Active link on page :"+activeLink.size());
		
		for(int j=0;j<activeLink.size();j++)
		{
			try {
		HttpURLConnection httpconnection	=(HttpURLConnection) new URL(activeLink.get(j).getAttribute("href")).openConnection();
		httpconnection.connect();
		String response=httpconnection.getResponseMessage();
		httpconnection.disconnect();
		System.out.println(activeLink.get(j).getAttribute("href")+"---------------------------->"+response);
		List allLink=new ArrayList();
	//	allLink.add(response);
	//	System.out.println("==============================================================================");
		//System.out.println(allLink);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//System.out.println(allLink);
		
	}

}
