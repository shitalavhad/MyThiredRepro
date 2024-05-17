package webTableHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTbleHandling {


	   public static void main(String[] args) throws InterruptedException {
      // WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement userNameField=driver.findElement(By.xpath("//input[@name='username']"));
		userNameField.sendKeys("Admin");
		
		WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys("admin123");
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		

	}

}
