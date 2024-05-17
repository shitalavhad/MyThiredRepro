package actionClassStudy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyUpAndKeyDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		//maximize the appliaction
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open the applications
		driver.get("https://omayo.blogspot.com/");
		
		Actions act=new Actions(driver);
		WebElement link1=driver.findElement(By.xpath("//a[text()='compendiumdev']"));
		WebElement link2=driver.findElement(By.xpath("//a[text()='onlytestingblog']"));
		WebElement link3=driver.findElement(By.xpath("//a[text()='testwisely']"));
		WebElement link4=driver.findElement(By.xpath("//a[text()='jqueryui']"));
		WebElement link5=driver.findElement(By.xpath("//a[text()='theautomatedtester']"));
		act.pause(Duration.ofSeconds(2))
		.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL)
		.pause(Duration.ofSeconds(2))
		.keyDown(Keys.CONTROL).click(link2).keyUp(Keys.CONTROL)
		.pause(Duration.ofSeconds(2))
		.keyDown(Keys.CONTROL).click(link3).keyUp(Keys.CONTROL)
		.pause(Duration.ofSeconds(2))
		.keyDown(Keys.CONTROL).click(link4).keyUp(Keys.CONTROL)
		.pause(Duration.ofSeconds(2))
		.keyDown(Keys.CONTROL).click(link5).keyUp(Keys.CONTROL).build().perform();
		
		
		
		
		
		
		
		
		

	}

}
