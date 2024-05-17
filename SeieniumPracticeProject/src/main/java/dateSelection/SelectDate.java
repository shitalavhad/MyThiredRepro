package dateSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class SelectDate {

	public static void main(String[] args) {
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		//disable notification
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		WebDriver driver=new ChromeDriver(option);
		
		//maximize the widow
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open the applictaion
		driver.get("https://www.redbus.in/");
		
		//locate the element
		driver.findElement(By.xpath("//div[@id='onwardCal']//span")).click();
		
		driver.findElement(By.xpath("//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']//span[text()='13']"))
		.click();
		
		

	}

}
