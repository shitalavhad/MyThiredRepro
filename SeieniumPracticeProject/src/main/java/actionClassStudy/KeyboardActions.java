package actionClassStudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class KeyboardActions {

	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		//maximize the appliaction
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open the applications
		driver.get("https://tutorialsninja.com/demo/");
		
		//create the instance of Actions class
		Actions act=new Actions(driver);
		
		WebElement myAccountDropMenu=driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccountDropMenu.click();
		
		WebElement loginButton=driver.findElement(By.xpath("//a[text()='Login']"));
		 loginButton.click();
		 
		 WebElement emailField=driver.findElement(By.xpath("//input[@id='input-email']"));
		/* emailField.sendKeys("shitalavhad5@gmail.com");
		 act.keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys("123456").keyDown(Keys.TAB).keyUp(Keys.TAB)
		 .keyDown(Keys.TAB).keyUp(Keys.TAB)
		 .keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();*/
		 
		 //anoterway
		 act.sendKeys(emailField, "shitalavhad8@gmail.com")
		 .sendKeys(Keys.TAB)
		 .sendKeys("shital@123")
		 .sendKeys(Keys.TAB)
		 .sendKeys(Keys.TAB)
		 .sendKeys(Keys.ENTER)
		 .build().perform();
		 
		
		 		

	}

}
