package studyDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class GetAlloptionFromeDrp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_')]"));
		createNewAccountButton.click();

		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc=new Select(monthDrp);
		List<WebElement> options=sc.getOptions();
		for(WebElement option:options)
		{
			String op=option.getText();
			System.out.println(op);
			
		}

	}

}
