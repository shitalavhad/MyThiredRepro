package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {

	public static void main(String[] args) throws AWTException, InterruptedException {
         System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.foundit.in/upload");
		
		WebElement fileUploadButton=driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer']//div[2]"));
		fileUploadButton.click();
		
		//using sendKeys methods
		WebElement fileButton=driver.findElement(By.xpath("//input[@id='file-upload']"));
		//fileButton.sendKeys("D:\\Resume\\SHITAL PALVE RESUME.pdf");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", fileButton);
		
		String filepath="D:\\Resume\\SHITAL PALVE RESUME.pdf";
		StringSelection fileSelectionPath=new StringSelection(filepath);
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
	}

}
