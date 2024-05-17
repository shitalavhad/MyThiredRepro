package firstProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_First_Program {
	@	Test
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		WebElement searchBox=driver.findElement(By.name("q"));
		//searchBox.sendKeys("selenium",Keys.ENTER);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='selenium';", searchBox);
		searchBox.sendKeys(Keys.ENTER);
	/*	driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);*/
		String title=driver.getTitle();
	  System.out.println("page title: "+title);
		
	}

}
