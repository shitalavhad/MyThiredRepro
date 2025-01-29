package AlertHadling;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class AlertHandling {
	public static void main(String[]args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://ui.vision/demo/webtest/frames/");
	
	/*driver.get("https://testautomationpractice.blogspot.com/");
	
	WebElement alertButton=driver.findElement(By.xpath("//button[@id='alertBtn']"));
	alertButton.click();
	
	/*WebDriverWait  ewait=new WebDriverWait(driver,Duration.ofSeconds(5));
	Alert alt=ewait.until(ExpectedConditions.alertIsPresent());
	alt.accept();*/
/*	try {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.alert=function{};");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	
	//Handling Frame Code
	WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	//driver.switchTo().frame(frame1);
	WebDriverWait  ewait=new WebDriverWait(driver,Duration.ofSeconds(5));
	ewait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame1));
	
	WebElement text1=driver.findElement(By.xpath("//form[@id='id1']//input"));
	text1.sendKeys("I Love You");
	
	WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	driver.switchTo().frame(frame2);
	//Thread.sleep(1000);
	//WebElement text1=driver.findElement(By.xpath("//input[@name='mytext2']"));
//	text1.sendKeys("I love you");
	
}

}
