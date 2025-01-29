package studyDropDown;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheakSpecificWebElementPresentOrNot {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter actual option hear");
		String expectedOption = sc.next();

		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_')]"));
		createNewAccountButton.click();

		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		Select sc1=new Select(monthDrp);
	   List<WebElement>	 options=sc1.getOptions();
		for(WebElement option:options)
		{
			 String actualOption=option.getText();
			 if(expectedOption.equals(actualOption))
			 {
				 System.out.println(option.getText());
				 option.click();
			 }
		}
		driver.quit();
	}
	

}
