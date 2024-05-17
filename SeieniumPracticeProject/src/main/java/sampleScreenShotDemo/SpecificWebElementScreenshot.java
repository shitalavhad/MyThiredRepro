package sampleScreenShotDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificWebElementScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement text=driver.findElement(By.xpath("//h2[contains(text(),'Facebook helps')]"));
		 File srcFile=text.getScreenshotAs(OutputType.FILE);
		 String destpath=System.getProperty("user.dir")+"//screenshot//speficElement.jpg";
		 File destFile=new File(destpath);
		 FileHandler.copy(srcFile, destFile);
		

	}

}
