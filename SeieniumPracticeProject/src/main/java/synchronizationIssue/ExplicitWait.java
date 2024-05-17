package synchronizationIssue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebDriverWait ewit=new WebDriverWait(driver, Duration .ofSeconds(10));
		WebElement ele=ewit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email1']")));
		ele.sendKeys("abd");

	}

}
