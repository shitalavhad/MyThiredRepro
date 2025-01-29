package aWebDriverMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class WebDriverMethod {

	public static void main(String[] args) {
		//lunch the browser
		System.setProperty("webdriver.chrome.driver","G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//hoe to open application
		driver.get("https://www.facebook.com/");
		
	/*	//how to resize browser
		Dimension d=new Dimension(200,300);
		driver.manage().window().setSize(d);*/
		
	/*	//hoe to change th eposition for browser
		Point p=new Point(500,600);
		driver.manage().window().setPosition(p);
		*/
		//how to get the title of the page
		String title=driver.getTitle();
		System.out.println("Title of the page :"+title);
		
		//how to get the url of the currnt page
		String url=driver.getCurrentUrl();
		System.out.println("Url  of the page :"+url);
		
		//how to get the html code for whole page
		String htmlCode=driver.getPageSource();
		System.out.println("Source code for whole page :"+htmlCode);
		
		//how to get the size of the page
		Dimension d=driver.manage().window().getSize();
		System.out.println(d.width);
		System.out.println(d.height);
		
	/*	//navigational command
		driver.navigate().to("https://www.vctcpune.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();*/
		
     driver.quit();
	}

}
