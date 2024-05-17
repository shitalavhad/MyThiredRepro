package PracticeQustions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Qus_OpenApplication {
	static WebDriver driver;

	public static void main(String[] args) {
		
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
        driver=new ChromeDriver();
		
		//driver.get("https://www.facebook.com/");
        String url="https://www.facebook.com/";
		openApplication(url);
      //  driver.get("www.facebook.com/");//---->invalidArgumentExceptions
	
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//maximize the browser
		driver.manage().window().maximize();
		
	//how to resize youer browser
	//	Dimension d=new Dimension(500,600);
	//	driver.manage().window().setSize(d);
		
		//how to change the position pf the browser
		//Point p =new Point(200,300);
		//driver.manage().window().setPosition(p);
		//changeThePosition(200, 300);
		//how to get the title of the page
		//String myTitle=driver.getTitle();
	//	System.out.println("page title is :"+myTitle);
	//	getPageTitle();
     	//String currentUrl=	driver.getCurrentUrl();
       // System.out.println("Current url is:"+currentUrl);
		//getCueerntUrl();
		
		//get the page source of wholw page
		//String htmlCode=driver.getPageSource();
		//System.out.println("HTML code for whole page :"+htmlCode);
	}
	public static void openApplication(String url)
	{
		driver.get(url);
	}
	
	//chand the positon
	public static void changeThePosition(int a,int b)
	{
		Point p=new Point(a,b);
		driver.manage().window().setPosition(p);
	}
	
	//get the title of the page
	public static void getPageTitle()
	{
		String mytitle=driver.getTitle();
		System.out.println("Current Page Title is :"+mytitle);
				
	}
	//current url of the page
	public static void getCueerntUrl()
	{
		String url=driver.getCurrentUrl();
		System.out.println("Current page url is :"+url);
	}
	
	
	
}
