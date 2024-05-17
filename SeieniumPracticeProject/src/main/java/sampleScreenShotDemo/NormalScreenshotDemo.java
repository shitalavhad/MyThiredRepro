package sampleScreenShotDemo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import  org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalScreenshotDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File srcFile=tc.getScreenshotAs(OutputType.FILE);
		String destpath=System.getProperty("user.dir")+"//screenshot//normalImage.png";
		File destFile=new File(destpath);
		FileHandler.copy(srcFile, destFile);

	}

}
