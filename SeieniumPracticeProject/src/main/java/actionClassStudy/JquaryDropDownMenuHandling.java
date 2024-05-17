package actionClassStudy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquaryDropDownMenuHandling {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
		 //maximize the appliaction
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		 
		 WebElement rigthClickMe=driver.findElement(By.xpath("//span[text()='right click me']"));
		//1stWay 
		/* Actions act=new Actions(driver);
		 act.contextClick(rigthClickMe).pause(Duration.ofSeconds(2))
		 .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2))
		 .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2))
		 .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2))
		 .sendKeys(Keys.ENTER).perform();
		 
		 Alert alt=driver.switchTo().alert();
		 alt.accept();*/
		 Actions act=new Actions(driver);
		 act.contextClick(rigthClickMe).perform();
		 WebElement editButton=driver.findElement(By.xpath("//ul[contains(@class,'context-menu')]//li[1]"));
		 act.click(editButton).perform();
		 Alert alt=driver.switchTo().alert();
		System.out.println("Alert text:"+ alt.getText());
		 alt.accept();
		 
		 
		 
		 
		 

	}

}
