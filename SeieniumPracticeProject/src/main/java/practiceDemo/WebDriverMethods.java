package practiceDemo;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver ;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethods {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//lunchBrowser("https://www.facebook.com/");
		WebDriverMethods wb=new WebDriverMethods();
		//wb.maximizeWindow();
		//wb.resizeWindow(500, 600);
		//wb.changePositon(100, 200);
		//wb.getTitle();
		wb.getCurrentUrl();
		

	}
	//lunch the browser
	public static void lunchBrowser( String url)
	{
		WebDriverManager.chromedriver().setup();
		
	    driver=new ChromeDriver();
		
		driver.get(url);
		
	}
	//maximize the window
	public  void maximizeWindow()
	{
       this.lunchBrowser("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
	}
	//change size
	public void resizeWindow(int height,int width)
	{
		this.maximizeWindow();
		 Dimension d=new Dimension(height,width);
		driver.manage().window().setSize(d);
	}
	//change positions
	public void changePositon(int x,int y)
	{
		this.maximizeWindow();
		
		Point p=new Point(x,y);
		driver.manage().window().setPosition(p);
		
		
	}
	
	public String  getTitle()
	{
		this.maximizeWindow();
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	public String getCurrentUrl()
	{
		this.getTitle();
		//this.maximizeWindow();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
	

}
