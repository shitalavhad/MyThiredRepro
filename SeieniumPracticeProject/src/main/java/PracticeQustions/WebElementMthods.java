package PracticeQustions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMthods {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//how to enter the text inside the text field
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		//emailField.sendKeys("avhadshital8@gmail.com");
		//enterText(emailField, "//input[@id='email']");
		
		//enter text without using sendKeys() method
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById='email'.value='avhadshital8@gmail.com';");
		//js.executeScript("arguments[0].value='avhadshital8@gmail.com';", emailField);
		
		//how to click buttons links
		WebElement forgottenPasswordLink=driver.findElement(By.xpath("//div[@class='_6ltj']//a"));
		//forgottenPasswordLink.click();
		//clickOnButton(driver, forgottenPasswordLink, "//div[@class='_6ltj']//a");
		
		//clcik without using inbuild method
	//	JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", forgottenPasswordLink);
		
		//how to get the attribute of the page
		//WebElement attribute=driver.findElement(By.xpath("//input[@id='email']"));
	//	System.out.println("element attribute value :"+attribute.getAttribute("id"));
		
		//how to get the beckground color of webeelement
		String co = emailField.getCssValue("background");
		//Color color=Color.fromString(co);
		//System.out.println("WebElement background color is : "+color.asHex());
		
		//how to get the text of the webelement
		WebElement elememntText=driver.findElement(By.xpath("//h2[@class='_8eso']"));
		//System.out.println("Element text is :"+elememntText.getText());
		getText(elememntText, "//h2[@class='_8eso']");
		
	}
	//how to enter text inside the text field
	public static void enterText(WebElement ele,String locator)
	{
		ele=driver.findElement(By.xpath(locator));
		ele.sendKeys("avhadshital8@gmail.com");
	
	}
	
	//how to click on links
	public static void clickOnButton(WebDriver driver,WebElement ele,String locator)
	{
		ele=driver.findElement(By.xpath(locator));
		ele.click();
	}
	
	//how to get the text of the webelemet
	public static void getText(WebElement ele,String locator)
	{
		ele=driver.findElement(By.xpath(locator));
		System.out.println(ele.getText());
		
	}

}
