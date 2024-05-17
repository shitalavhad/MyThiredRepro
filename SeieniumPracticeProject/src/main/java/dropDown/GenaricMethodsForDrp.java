package dropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;

public class GenaricMethodsForDrp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String url="https://chercher.tech/practice/practice-dropdowns-selenium-webdriver";
		
		driver.get(url);
		
		WebElement productDrp=driver.findElement(By.xpath("//select[@id='first']"));
		dropDownHandling(productDrp, "Google");
		
		WebElement animalDrp=driver.findElement(By.xpath("//select[@id='animals']"));
		dropDownHandling(animalDrp, "Avatar");
		

	}
	public static void dropDownHandling(WebElement ele,String value)
	{
		Select sc=new Select(ele);
		List<WebElement>options=sc.getOptions();
		for(WebElement op:options)
		{
			if(op.getText().equals(value))
			{
				System.out.println("selected options is:"+op.getText());
				op.click();
				break;
			}
			
				
			
		}
	}

}
