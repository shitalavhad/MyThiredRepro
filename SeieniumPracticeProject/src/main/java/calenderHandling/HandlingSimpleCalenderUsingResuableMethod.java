package calenderHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSimpleCalenderUsingResuableMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		WebElement dataField=driver.findElement(By.xpath("//input[@id='datepicker']"));
		dataField.click();
		
		WebElement currentMonthElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[1]"));
		String currentMonth=currentMonthElement.getText();
		
		WebElement currentYearElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[2]"));
		String currentYear=currentYearElement.getText();

	}

}
