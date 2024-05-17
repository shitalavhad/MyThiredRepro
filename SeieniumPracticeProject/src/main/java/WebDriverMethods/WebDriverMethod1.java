package WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;


import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverMethod1 {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		//open the application genaric method
		openApplication(driver);
		
		//maximize the applicaion
		maximizeTheApplication(driver);
		
		//change the size of the browser
		changeTheSize(driver);
		
		//change the position of the browser
		chandeThePosition(driver);
		
		//get the title of the page
		getTitleOfPage(driver);
		
		//get the current url of page
		getCurrentUrlOfPage(driver);
		
		//get the page sourc 
		getPageSourceCode(driver);
		
		
		
		

	}
	//open the application
	public static void openApplication(WebDriver driver)
	{
		driver.get("https://www.facebook.com/");
	}
	
	//maximize the application
	public static void maximizeTheApplication(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//change the screenSize of the browser
	public static void changeTheSize(WebDriver driver)
	{
		Dimension d=new Dimension(500,600);
		driver.manage().window().setSize(d);
		
	}
	//change the position of the browser
	public static void chandeThePosition(WebDriver driver)
	{
		Point p=new Point(200,300);
		driver.manage().window().setPosition(p);
	}
	
	//get the title of the page
   public static String getTitleOfPage(WebDriver driver)
   {
	   String title=driver.getTitle();
	   System.out.println("Page Title is :"+title);
	   return title;
   }
   
   //get the url of the page
   public static String getCurrentUrlOfPage(WebDriver driver)
   {
	   String currentUrl=driver.getCurrentUrl();
	   System.out.println("Page url is: "+driver.getCurrentUrl());
	   return currentUrl;
   }
   
   //get the page source of the page
   public static String getPageSourceCode(WebDriver driver)
   {
	   String pageSource =  driver.getPageSource();
	   System.out.println("page source code is: "+pageSource);
	   return pageSource;
   }
	

}
