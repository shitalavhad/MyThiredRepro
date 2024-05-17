package javascriptExecutorStudy;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('hellow')");
		//highlitng element
		//WebElement emailField=driver.findElement(By.xpath("//input[@name='email']"));
		//js.executeScript("arguments[0].style.background='yellow';", emailField);
		//flashElement(driver, emailField);
		//enterText(driver, emailField);
	//	WebElement passwordField=driver.findElement(By.xpath("//input[@type='password']"));
		//js.executeScript("arguments[1].value='shital';", emailField,passwordField);
		String text = js.executeScript(" return document.documentElement .innerText").toString();
		System.out.println(text);
		
		
		
		
		
		
		

	}
	public static void flashElement(WebDriver driver,WebElement ele) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background='yellow';", ele);
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.background=' ' ;", ele);
		
	}
	public static void enterText(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='shital';", element);
	}

}
