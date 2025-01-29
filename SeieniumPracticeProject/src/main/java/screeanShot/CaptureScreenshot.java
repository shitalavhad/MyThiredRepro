package screeanShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {

	public static void main(String[] args) {
	    WebDriverManager.chromedriver().setup();
	    
	    WebDriver driver=new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.get("https://www.facebook.com/");
	    
	    TakesScreenshot tc=(TakesScreenshot)driver;
	    File sreFile=tc.getScreenshotAs(OutputType.FILE);
	    String path=System.getProperty("user.dir")+"//screenshot//captureScreenshot.png";
	    File taregetFile=new File(path);
	    sreFile.renameTo(taregetFile);
	    
	    driver.quit();

	}

}
