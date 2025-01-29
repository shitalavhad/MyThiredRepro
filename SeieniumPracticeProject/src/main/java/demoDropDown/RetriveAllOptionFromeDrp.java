package demoDropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import org.openqa.selenium.By;
import java.util.*;



public class RetriveAllOptionFromeDrp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement colourDropDown=driver.findElement(By.xpath("//select[@id='colors']"));
		Select sc=new Select( colourDropDown);
		List<WebElement> options=sc.getOptions();
		for(WebElement op:options)
		{
			//String text=op.getText();
			System.out.println(op.getText());
		}
		
		
	}

}
