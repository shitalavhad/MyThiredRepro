package screeanShot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		TakesScreenshot tc=(TakesScreenshot)driver;
		
		File src = tc.getScreenshotAs(OutputType.FILE);
		
		File dest =new File ("‪‪C:\\Users\\SAI\\Desktop\\ScreenShot\\myFile.png");
		FileHandler.copy(src, dest);

	}

}
