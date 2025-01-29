package dataDrivenTestingP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001Verify_LoginDDT {
	@Test(dataProvider="loginData",dataProviderClass=DataProvider1.class)
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    driver.get("https://tutorialsninja.com/demo/");
	    
	    WebElement myAccountLink=driver.findElement(By.xpath("//span[text()='My Account']"));
	    myAccountLink.click();
	    
	    WebElement loginLink=driver.findElement(By.xpath("//a[text()='Login']"));
	    loginLink.click();
	    
	    WebElement emailAddress=driver.findElement(By.xpath("//input[@id='input-email']"));
	    emailAddress.sendKeys(email);
	    
	    WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
	    password.sendKeys(pwd);
	    
	    WebElement loginButton=driver.findElement(By.xpath("//input[@value='Login']"));
	    loginButton.click();
	    
	    WebElement headMessage=driver.findElement(By.xpath("//h2[text()='My Account']"));
	   Boolean targetPage= headMessage.isDisplayed();
	   
	   WebElement logoutLink=driver.findElement(By.xpath("//a[text()='Logout'][@class='list-group-item']"));
	   
	   if(exp.equalsIgnoreCase("Valid"))
	   {
		   if(targetPage==true)
		   {
			   logoutLink.click();
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   Assert.assertTrue(false);
		   }
	   }
	   if(targetPage==true)
 		{
 			logoutLink.click();
       	 Assert.assertTrue(true);
 		}
 		else
 		{
 			Assert.assertTrue(false);
 		}
	}

}