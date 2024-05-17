package WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

public class WebDriverMethod {

	public static void main(String[] args) {
		//1]how to lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//how to open the application
		//driver.get("https://www.facebook.com/");
		openApplication(driver);
		
		//how to get the current url of the page
		//String currentUrl=driver.getCurrentUrl();
		//System.out.println("Current page url : "+currentUrl);
		getCurrentUrlOfWebPage(driver);
		
		//how to get title of webpage
		//String title=driver.getTitle();
		//System.out.println("WebPage Title is: "+title);
		getTitleOfWebPage(driver);
		
		//how to get the pagesource 
		//String htmlCode=driver.getPageSource();
		//System.out.println("HTML code for webpage   :"+htmlCode);
		getHTMLCodeforwebpage(driver);
		
		//howtoclosethe browser
		//driver.close();
		//closeTheBrowser(driver);
		
		//howtoresizethe browser
		//Dimension d=new Dimension(500,600);
		//driver.manage().window().setSize(d);
		resizeTheBrowser(driver);
		  
		
		
	}
	
	//genaric method for open the application
	public static void openApplication(WebDriver driver)
	{
		String url="https://www.facebook.com/";
		driver.get(url);
	}
	
	//genaric method for get the current url
	public static  String  getCurrentUrlOfWebPage(WebDriver driver)
	{
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current url of the page :"+currentUrl);
		return currentUrl;
	}
	
	//genaric method for get the title of the webpage
	public static String getTitleOfWebPage(WebDriver driver)
	{
		String title=driver.getTitle();
		System.out.println("page title :"+title);
		return title;
	}
	
	//genaric method for get the html code for whole page
	public static String getHTMLCodeforwebpage(WebDriver driver)
	{
		String htmlCode=driver.getPageSource();
		System.out.println("webpage htmlcode "+htmlCode);
		return htmlCode;
	}
	
	//genaric method for close method
	public static void closeTheBrowser(WebDriver driver)
	{
		driver.close();
	}
	//genaric method for resize the browser
	public static void resizeTheBrowser(WebDriver driver)
	{
		Dimension d=new Dimension(500,600);
		driver.manage().window().setSize(d);
	}
	

}
