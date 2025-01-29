package DemoWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebDriverMetod {

	public static void main(String[] args) {
	//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//open the application
		driver.get("https://www.facebook.com/");
		
		//maximze the browser
		driver.manage().window().maximize();
		
		//get the title of page
		String pageTitle=driver.getTitle();
		System.out.println("page Title is: "+pageTitle);
		
		//get the url of the page
		String url=driver.getCurrentUrl();
		System.out.println("Current url of the page :"+url);
		
		//retrive the html code 
		String pageSource=driver.getPageSource();
		System.out.println("Page source code is :"+pageSource);
		
		//resize the browser
		Dimension d=new Dimension(200,300);
		driver.manage().window().setSize(d);
		
		//change the position of the browser
		Point p=new Point(500,600);
		driver.manage().window().setPosition(p);
		
		//close the browser
		driver.close();
		
		//quit the browser
		driver.quit();
		
		//apply the pageload
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//minimize the window
		driver.manage().window().minimize();
		
		//navigation command
		driver.navigate().to(url);
		
		//click on back button
		driver.navigate().back();
		
		//clcik on forward button
		driver.navigate().forward();
		
		//clcik on refresh button
		driver.navigate().refresh();

	}

}
