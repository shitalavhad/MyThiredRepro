package sampleScreenShotDemo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighLigthElementAndScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].value='shital';", emailField);
		
		js.executeScript("arguments[0].style.border='2px solid red'",emailField );
		
	
		TakesScreenshot tc=(TakesScreenshot)driver;
		
		File srcFile=tc.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(System.getProperty("user.dir")+"//screenshot//issuearea.png");
		
		FileHandler.copy(srcFile, destFile);
		
		driver.quit();
		
		
		

	}

}
