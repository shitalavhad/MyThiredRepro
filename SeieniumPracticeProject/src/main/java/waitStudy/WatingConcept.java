package waitStudy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;

public class WatingConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		
		//explicit wait
		//WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement ele=ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email1']")));
	//	ele.sendKeys("shital");
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		fwait.until(( new Function<WebDriver,WebElement>()
				{
			public WebElement apply(WebDriver driver)
			{
				WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
				return emailField;
				
			
				}
				
				
	}));
		

	}

}
