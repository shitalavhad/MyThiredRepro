package assertionStudy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.Assert.*;

public class HardAssert {
	@Test
	public void verifiactionOfFBEmaildFiled()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailIdField=driver.findElement(By.xpath("//input[@id='email']"));
		
		emailIdField.sendKeys("HYR Tutorial",Keys.ENTER);
		
		//verify error message
		emailIdField=driver.findElement(By.xpath("//input[@id='email']"));
	   WebElement	errorText=driver.findElement(By.xpath("//div[@class='_9ay7']"));
	   String actualErrorMessage=errorText.getText();
	   String expectedErrorMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	    Assert. assertEquals(actualErrorMessage,expectedErrorMessage,"Error message is not matching");
		
	    //verify title
	    String actualTitle=driver.getTitle();
	    String expectedTitle="Log in to Facebook";
	    assertEquals(actualTitle,expectedTitle,"Title is not matching");
	    
	    //verify text
	WebElement  emailField=driver.findElement(By.xpath("//input[@id='email']"));
	  String actualText= emailIdField.getAttribute("value");
	  String expectedtext="Email address or phone number";
	  assertEquals(actualText,expectedtext,"Text is not matching");
	  
	  //verify url
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzAyNTQyODc2LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
	  assertNotEquals(actualUrl,expectedUrl,"URl is matching");
	  
	  //verify border
 	// WebElement  emailField=driver.findElement(By.xpath("//input[@id='email']"));
	  String actualBorder=emailField.getCssValue("boarder");
	  String expectedBorder="1px solid rgb(  240,  40, 73)";
	  assertEquals(actualBorder,expectedBorder,"border is not matching");
	  
	}

	
		
	}


