package dataDrivenTesting;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class verifyLoginDDT {
	@Test (dataProvider="loginData")
	public void verifyLoginFunctionality(String email,String pwd,String exp)
	{
		 System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			Reporter.log("Lunch the browser",true);
			driver.manage().window().maximize();
			Reporter.log("Maximize the window",true);
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://tutorialsninja.com/demo/");
			Reporter.log("Open the application",true);
			
			WebElement myAccountLink=driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
			myAccountLink.click();
			Reporter.log("Click On MyAccountLink",true);
			
			WebElement loginLink=driver.findElement(By.xpath("//a[text()='Login']"));
			loginLink.click();
			Reporter.log("Click on LoginLink",true);
			
			WebElement emailIdField=driver.findElement(By.xpath("//input[@id='input-email']"));
			emailIdField.sendKeys(email);
			Reporter.log("Enter the email",true);
			
			WebElement passwordField=driver.findElement(By.xpath("//input[@id='input-password']"));
			passwordField.sendKeys(pwd);
			Reporter.log("Enter the password",true);
			
			WebElement loginButton=driver.findElement(By.xpath("//input[@value='Login']"));
			loginButton.click();
			Reporter.log("Click on loginButton",true);
			
			WebElement logOutLink=driver.findElement(By.xpath("(//a[text()='Logout'])[2]"));
			WebElement wornningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger ')]"));
			 boolean result = wornningMessage.isDisplayed();
			
		 if(exp.equalsIgnoreCase("Valid"))
		 {
		 		
			String actualTitle=driver.getTitle();
			String expectedTitle="My Account";
			Assert.assertEquals(actualTitle, expectedTitle,"Actual and Expected Title are not matching");	
			logOutLink.click();
		 }
		
		 if(exp.equalsIgnoreCase("Invalid"))
		 {
			 if(result==true)
			 {
				 Assert.assertTrue(true);
			 }
		 }
		 		
			
	}
	@DataProvider(name="loginData")
	public Object[] getLoginData()
	{
		Object[] [] data= {{"avhadshital822@gmail.com","shital123","Valid"},
				                       {"avhadshital822@gmail.com","shital123"}
				                       
		
	                                  };
		return data;

}
}
