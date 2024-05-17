package autoCompletedDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompletedDropDown {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://www.amazon.in/");
	
	WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	
	searchBox.sendKeys("l");
	//String expectedOption="lunch box";
	Scanner sc=new Scanner(System.in);
     String expectedOption=sc.nextLine();
	WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(10));
	ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s-heavy']")));
	
	List<WebElement> options=driver.findElements(By.xpath("//span[@class='s-heavy']/parent::div"));
	//WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(10));

	for(WebElement option:options)
	{
		String actualOptions=option.getText();
		System.out.println(actualOptions);
	if(actualOptions.equals(expectedOption))
		{
			option.click();
			break;
		}
	
}
	WebElement text	=driver.findElement(By.xpath("(//span[contains(@class,'text-bold')])[1]"));
	System.out.println("Text is:"+text.getText());
	
	}

}
