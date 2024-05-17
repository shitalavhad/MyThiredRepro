package calenderHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalenderUsingJavascriptExecutor {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	
   WebElement dataFiled	=driver.findElement(By.xpath("//input[@id='datepicker']"));
   
   /*
   JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("arguments[0].value='05/13/2024';", dataFiled);*/
   dataFiled	.sendKeys("05/13/2024");
   
   WebElement headling=driver.findElement(By.xpath("//h1[contains(text(),' Calendar')]"));
   headling.click();
   

	}

}
