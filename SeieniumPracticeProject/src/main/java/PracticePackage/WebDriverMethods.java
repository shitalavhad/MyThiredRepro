package PracticePackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;


public class WebDriverMethods {

	public static void main(String[] args) throws MalformedURLException {
	System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
	
	//WebDriver driver=new ChromeDriver();
	
	ChromeDriver driver=new ChromeDriver();
	
	//open the aplication
	driver.get("https://www.facebook.com/");
	
	//retriver the currnt url
	String cuurntUrl=driver.getCurrentUrl();
	System.out.println(cuurntUrl);
	
	//title of the page
	 String title=driver.getTitle();
	 System.out.println(title);
	 
	 //close the currnt tab
	 //driver.close();
	 
	// String htmlCode=driver.getPageSource();
	// System.out.println(htmlCode);
	 
	 driver.manage().window().maximize();
	 driver.manage().window().minimize();
	 
	 //resize youer browser
	// Dimension d=new Dimension( 300,200);
	// driver.manage().window().setSize(d);
	 
	 //change the position of browser
	 //Point p=new Point(230,300);
	 //driver.manage().window().setPosition(p);
	 
	// Dimension d=driver.manage().window().getSize();
	// System.out.println(d.height);
	// System.out.println(d.width);
	 
	// Point p=driver.manage().window().getPosition();
	// System.out.println(p.x);
	// System.out.println(p.y);
	 
//	 driver.navigate().to("https://www.vctcpune.com/");
	// driver.navigate().back();
	// driver.navigate().forward();
	// driver.navigate().refresh();
	 
	 URL url=new URL("https://www.vctcpune.com/");
	 driver.navigate().to(url);
	 
	 driver.quit();
	 
	}

}
