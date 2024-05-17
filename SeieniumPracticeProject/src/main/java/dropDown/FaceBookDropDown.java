package dropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class FaceBookDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[contains(@class,'_42ft _')])[1]"));
		createNewAccountButton.click();
		
		//how to get the value from the drop down
		
		//1]locate the element
		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		
		//create the instance of the SElect class and pass the webElement as a arrgument
		Select sc=new Select(monthDrp);
		
		//uesd getOptions()method
	  List<WebElement>	avaliableOptions=sc.getOptions();
	  
	  //get the all options
	  for(WebElement option:avaliableOptions)
	  {
		  System.out.println(option.getText());
	  }
		
		
		
		
		
	

	}

}
