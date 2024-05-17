package PracticeQustions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshPage {

	public static void main(String[] args) {
		//lunch the browser
			WebDriverManager.chromedriver().setup();
				
	     WebDriver driver=new ChromeDriver();
				
		driver.get("https://www.facebook.com/");
		
		//refresh the page
		//way1]using navigate()method
		//driver.navigate().refresh();
		
		//way2]using Actions class
		//Actions act=new Actions(driver);
	  //	act.sendKeys(Keys.F5);
		
		//way3]using javascriptExecutor
	//	JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.location.reload();" );
		
	//way4]usind getCurrentUrl()method
		//driver.get(driver.getCurrentUrl());
		

		      

	}

}
