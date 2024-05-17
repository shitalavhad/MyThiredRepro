import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;



public class ActionsClassDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		//instance of ACTIONS class
		Actions act=new Actions(driver);
		
		//enter text using Actions class
		WebElement emailFiled=driver.findElement(By.xpath("//input[@id='email']"));
	   act.sendKeys(emailFiled, "shitalAvhad8@gmail.com").perform();
	   
	   //click on element using actions class
	   WebElement createNewAccountButton=driver.findElement(By.xpath("//div[@class='_6ltg']//a"));
	   act.click(createNewAccountButton).perform();
	   
	   //dragAnd drop
	  // act.dragAndDrop(driver.findElement(By.xpath("//input[@name='reg_email__']")), driver.findElement(By.xpath("//a[text()='Cookies Policy']")))
	// .build()  .perform();
	   WebElement src=driver.findElement(By.xpath("//a[text()='Cookies Policy']"));
	  WebElement dest=driver.findElement(By.xpath("//input[@name='reg_email__']"));
	  //act.moveToElement(src).clickAndHold().moveToElement(dest).release().build().perform();
	   
	   //scrolling operations
	  // act.scrollToElement(src).click().build().perform();
	  
	 WebElement dayDrp=driver.findElement(By.xpath("//select[@id='day']"));
	/*  act.click(dayDrp).perform();
	  //act.sendKeys(Keys.ARROW_UP).perform();
	  for(int i=0;i<=10;i++)
	  {
		  act.sendKeys(Keys.ARROW_UP).perform();
	  }
	  act.sendKeys(Keys.ENTER).perform();8*/
	  
	  //scrolling operation using Actions class
	 // act.scrollToElement(dest).sendKeys("9673002305").build().perform();
	// act.scrollToElement(dayDrp).click().build().perform();
	 /*ActionsClassMethods:
	  * click()
	  * click(element)
	  * doubleClick()
	  * doubleClick(webElement)
	  * contextClick()
	  * contextClick(webElement)
	  * moveToElement()
	  * moveToElement(webElement)
	  * clickAndHold()
	  * clickAndHold(WebElemnt)
	  * 
	  * 
	  */
	  
	}

}
