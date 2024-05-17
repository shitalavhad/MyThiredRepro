package fileUploading;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploadingDemo {
	@Test
	public void validateUploadFile() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://github.com/settings/profile");
		
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("avhadshital8@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("shitalavhad@1");
		
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		
		driver.findElement(By.xpath("//img[contains(@class,'avatar rounded-2 avatar-user')]")).click();
		
    WebElement	uploadField=driver.findElement(By.xpath("//label[@class='dropdown-item text-normal']"));
    
    uploadField.click();
    
    Thread.sleep(1000);
    
    JavascriptExecutor js=(JavascriptExecutor)driver;
    
    js.executeScript("arguments[0].value='F:\\Images\\dolly.jpg';",uploadField);
    //uploadField.sendKeys("‪F:\\Images\\dolly.jpg");
    
    System.out.println("succed");
		
		
	}

}
