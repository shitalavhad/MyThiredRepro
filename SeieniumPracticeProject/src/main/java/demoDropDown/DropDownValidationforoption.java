package demoDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import java.util.*;
import org.openqa.selenium.support.ui.*;

public class DropDownValidationforoption {
	@Test
	public void valiadateDropDown()
	{
		
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		 try {
	            // Navigate to the webpage
	          //  driver.get("URL_of_the_page");
			 driver.get("https://testautomationpractice.blogspot.com/");

	            // Locate the dropdown element
	            WebElement dropdownElement = driver.findElement(By.id("colors"));

	            // Use the Select class to get all options
	            Select dropdown = new Select(dropdownElement);
	            List<WebElement> allOptions = dropdown.getOptions();
	            System.out.println("Total options in the DOM: " + allOptions.size());
	            
	            // Use JavaScript to count only visible options
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            Long visibleOptionsCount = (Long) jsExecutor.executeScript(
	                "return Array.from(arguments[0].options).filter(option => !option.hidden && option.offsetParent !== null).length;",
	                dropdownElement);
	            System.out.println("Visible options in UI: " + visibleOptionsCount);
	            // Validate the difference
	            if (allOptions.size() != visibleOptionsCount) {
	                System.out.println("Mismatch in dropdown options: Hidden options are present.");
	            } else {
	                System.out.println("All options are visible in the dropdown.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();

	}

	}
}
