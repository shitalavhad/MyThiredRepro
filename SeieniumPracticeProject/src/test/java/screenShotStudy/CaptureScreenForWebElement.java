package screenShotStudy;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenForWebElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	driver.get("https://www.facebook.com/");
	
	WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
	
    File srcFile = emailField.getScreenshotAs(OutputType.FILE);
    
    String targetPath="D:\\Screenshot\\webElementScreenShot.png";
    
    File targetFile=new File(targetPath);
    
    srcFile.renameTo(targetFile);

    driver.quit();
	}

}
