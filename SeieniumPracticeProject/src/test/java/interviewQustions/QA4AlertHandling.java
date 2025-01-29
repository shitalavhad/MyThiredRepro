package interviewQustions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class QA4AlertHandling {
	@Test
	public void alertHandling()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		
		WebElement clickMeButton=driver.findElement(By.xpath("//button[@id='alertBox']"));
		clickMeButton.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.alert=function{};");
		
		WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alt = ewait.until(ExpectedConditions.alertIsPresent());
		alt.accept();
	}

}
