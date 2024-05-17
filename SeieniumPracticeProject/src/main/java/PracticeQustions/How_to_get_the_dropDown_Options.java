package PracticeQustions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class How_to_get_the_dropDown_Options {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		//locte the element
		WebElement ele=driver.findElement(By.xpath("//select[@id='first']"));
		
		//create the instance of Select class and pass the webElement as a arguments
		Select sc=new Select(ele);
		
	  List<WebElement>options=sc.getOptions();
	/*	for(WebElement op:options)
		{
			System.out.println("All options inside the dropDown :"+op.getText());
		}*/
		
		//how cheak the expected options present inside the drp or not
	/*	String expectedOption="Apple";
		for(WebElement op:actualoptions)
		{
			if(op.equals(expectedOption))
			{
				System.out.println(op.getText());
				op.click();
			}
		}*/
	  //validate dropdown sorted or not
	  List  originalList=new ArrayList();
	  List tempList=new ArrayList();
	  for(WebElement e:options)
	  {
		  originalList.add(e.getText());
		  tempList.add(e.getText());
	  }
	  Collections.sort(tempList);
	  if(originalList.equals(tempList))
	  {
		  System.out.println("drop down is sorted");
	  }
	  else
	  {
		  System.out.println("drop down is not sorted");
	  }
		
		
		
	}
   

}
