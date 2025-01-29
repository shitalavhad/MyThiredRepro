package screenShotStudy;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreen1 {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.facebook.com/");
	try {
	TakesScreenshot tc=(TakesScreenshot)driver;
    File srcFile = tc.getScreenshotAs(OutputType.FILE);
	String path="D:\\Screenshot "+"myScreenShot .png ";
	File targetFile=new File(path);
	FileHandler.copy(srcFile, targetFile);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	driver.quit();


	}

}
