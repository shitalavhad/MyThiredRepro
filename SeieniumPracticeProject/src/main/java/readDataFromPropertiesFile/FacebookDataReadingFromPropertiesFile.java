package readDataFromPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookDataReadingFromPropertiesFile {
  static WebDriver driver;
	public static void main(String[] args) throws IOException {   
	   String browserName=readDataFromePropertiesFile("browser");
	   if(browserName.equals("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();  
	   }
	   else if(browserName.equals("edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();  
	   }
	   else if(browserName.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();  
	   }
	   else
	   {
		   System.out.println("browser is null");
	   }
	   
	   //wait
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	   //maximize
	   driver.manage().window().maximize();
	   
	   //open application
	   driver.get(readDataFromePropertiesFile("url"));
	   
	   WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
	   emailField.sendKeys(readDataFromePropertiesFile("userName"));
	   
	   
	}
	public static String readDataFromePropertiesFile(String Key) throws IOException
	{
		Properties properties=new Properties();
		 
		String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\main\\resources\\config.properties";
		FileInputStream fileInputStream=new FileInputStream(path);
		
		properties.load(fileInputStream);
		
	    String value	=properties.getProperty(Key);
	    
	    return value;
	}

}
