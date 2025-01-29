package studyDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectValuFromeDropDownUsingGenaricFunction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_')]"));
		createNewAccountButton.click();

		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		selectOptionFromDrp(monthDrp, "6");
		Thread.sleep(1000);


		WebElement yearDrp=driver.findElement(By.xpath("//select[@id='year']"));
		selectOptionFromDrp(yearDrp, "2019");
		Thread.sleep(1000);
		
		WebElement dayDrp=driver.findElement(By.xpath("//select[@id='day']"));
		selectOptionFromDrp(dayDrp, "7");
		
		driver.quit();

	}
	public  static void selectOptionFromDrp(WebElement ele,String value)
	{
		Select sc=new Select(ele);
		List<WebElement> options=sc.getOptions();
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
			
		}
	}

}
