package actionClassStudy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//resizable element using actions class
		   WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			//maximize the appliaction
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://jqueryui.com/resizable/");
			
			Actions act=new Actions(driver);
			WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			driver.switchTo().frame(frame);
			WebElement resizable=driver.findElement(By.xpath("(//div[contains(@class,'resizable')])[4]"));
			act.pause(Duration.ofSeconds(3)).perform();
			act.dragAndDropBy(resizable,280, 170).perform();
			
			

	}

}
