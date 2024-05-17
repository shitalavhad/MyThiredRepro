package readDataFromPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesFileReading {
	static WebDriver driver;
	 static String path;

	public static void main(String[] args) throws IOException {
		
		 path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\main\\resources\\config.properties";
	
		String browserName="chrome";
		if(browserName.equals(readDataFromePropertiesFile("browser")))
		{
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}
	       //driver.get( properties.getProperty("url"));
		  driver.get(readDataFromePropertiesFile("url1"));
	}
	//Genaric function for readPropertiesFile
	public static String  readDataFromePropertiesFile(String key) throws IOException
	{
		//create the object of the properties class
		Properties properties=new Properties();
		
		//create the object of FileInputStream
		FileInputStream fileInputStream=new FileInputStream(path);
		
		properties.load(fileInputStream);
		
	  String value	=properties.getProperty(key);
	  return value;
		
		
	}

}
