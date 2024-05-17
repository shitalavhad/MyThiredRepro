package readDataFromPropertiesFile;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class FaceBookPropertiesFile {
    static WebDriver driver=null;

	public static void main(String[] args) throws IOException {
		String browserName=readDataFromPropertyFile("browser");
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(readDataFromPropertyFile("url"));
		
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[contains(@class,'_42ft _4jy0 ')])[1]"));
		createNewAccountButton.click();
		
		WebElement firestName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firestName.sendKeys(readDataFromPropertyFile("firstName"));
				
		
		
		
		

	}
	//genaric function for properties file
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//create the instance of the properties file
		Properties properties=new Properties();
		
	 //create the instance of the FileInputStream class
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\main\\resources\\config.properties");
		
	  //load the all variable
		properties.load(fileInputStream);
		
		//make the all value from properties file
		String value=properties.getProperty(key);
		
		return value;
	}

}
