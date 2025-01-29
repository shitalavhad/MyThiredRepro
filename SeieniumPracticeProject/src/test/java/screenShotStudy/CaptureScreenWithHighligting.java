package screenShotStudy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebElement;

public class CaptureScreenWithHighligting {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.facebook.com/");
		
	//	WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');");
		//js.executeScript("document.setAttribute('style', 'background: yellow; border: 2px solid red;');");
		//js.executeScript("document.activeElement.setAttribute(' style' , 'background: yellow; border:  2px solid red');");
		js.executeScript("document.body.style.backgroundColor = 'yellow';");
	/*	TakesScreenshot tc=(TakesScreenshot)driver;
		File srcFile=emailField.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"\\screenshot\\"+"element.png";
		
		File targetFile=new File(path);
		FileHandler.copy(srcFile, targetFile);*/
		js.executeScript("document.body.style.backgroundColor = '';");
		
		//sdriver.quit();

	}

}
