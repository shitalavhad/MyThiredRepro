package readDataFromPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;


public class GenaricFunctionForReadDataFromPropertyFile {
	 static WebDriver driver=null;

	public static void main(String[] args) throws IOException {
		System.out.println("My bowser name is: "+readDataFromPropertiesFile("browser"));
		
		String browserName=readDataFromPropertiesFile("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("browser is null");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(readDataFromPropertiesFile("url"));
		
		driver.findElement(By.xpath("//input[@id='email']"))
		.sendKeys(readDataFromPropertiesFile("userName"));
		
		

	}
	public static String  readDataFromPropertiesFile(String key) throws IOException
	{
		//create the instance of the properties class
		Properties properties=new Properties();
		
		//create the instane of the FileInputStream class
		
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\main\\resources\\config.properties");
		
		//load the all variable present inside the properties file
		properties.load(fileInputStream);
		
		//acess the all properties
		 String value=properties.getProperty(key);
		 return value;
		
	}

}
