package actionClassStudy;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountUsingKeyBordKey {

	public static void main(String[] args) {
      //  ChromeOptions op=new ChromeOptions();
       // op.addArguments("--remote-allow-origins=*");
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		 //maximize the appliaction
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		 	Actions act=new Actions(driver);
		 	
		 	for(int i=0;i<=22;i++)
		 	{
		 		act.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).perform();
		 		js.executeScript("document.activeElement.setAttribute(' style' , 'background: yellow; border:  2px solid red');");
		 	}
		 	act.sendKeys("shital").pause(Duration.ofSeconds(1))
		 	.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 	.sendKeys("palve").pause(Duration.ofSeconds(1))
		 	.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 	.sendKeys(genratenewEmail()).pause(Duration.ofSeconds(1))
		 	.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys("1346").pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys("shital").pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys("shital").pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.ARROW_LEFT).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
			.sendKeys(Keys.ENTER)
		
			.build().perform();
			
			
			
			
			
			

	}
	public static String genratenewEmail()
	{
		Date date=new Date();
		String newEmail=date.toString().replace("   ", "_").replace(" :  ", "_").concat("@gmail.com");
		return newEmail;
		
	}

}
