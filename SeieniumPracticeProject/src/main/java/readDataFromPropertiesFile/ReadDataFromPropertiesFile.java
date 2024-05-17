package readDataFromPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		  WebDriver driver = null ;
		
		//create the object of properties class
		Properties properties=new Properties();
		
		//create the instance of the FileInputStream Class
		
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\main\\resources\\config.properties");
		
		//load the all variable using load() methods
		properties.load(fileInputStream);
		
		//acess the value
		System.out.println("my browser name is: "+properties.getProperty("browser"));
		
		String browserName=properties.getProperty("browser");
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
		else if(browserName.equals("gecko"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			 driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("browser is null");
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		
		driver.findElement(By.xpath("//input[@id='email']")
				).sendKeys(properties.getProperty("userName"));
		
		
		
	}

}
