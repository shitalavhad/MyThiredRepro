package demoDataDrivenTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class verifyDropDown {
	@Test
	public void fetchAllOptionFromeDropDown()
	{
       System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
			
    	WebDriver driver=new ChromeDriver();
					
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@class,'_42ft _4jy0 _6lti')]"));
		createNewAccountButton.click();
		
		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc=new Select(monthDrp);
		List<WebElement> options=sc.getOptions();
		for(WebElement e:options)
		{
			String allAvaliableOptions=e.getText();
			System.out.println("All present opions : "+allAvaliableOptions);
		}
	}

}
