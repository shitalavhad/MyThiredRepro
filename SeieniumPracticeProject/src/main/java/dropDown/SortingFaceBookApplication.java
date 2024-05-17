package dropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingFaceBookApplication {

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
		
		//2]create the instance of the select class
		Select sc=new Select(monthDrp);
		
		List<WebElement>options=sc.getOptions();
		
		//create the two list
		List originalList=new ArrayList();
		
		List tempList=new ArrayList();
		
		//get the options
		for(WebElement e:options)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println("original list before sorting :"+originalList);
		
		//sorting 
		Collections.sort(tempList);
		
		if(originalList.equals(tempList))
		{
			System.out.println("DropDown is sorted");
		}
		else
		{
			System.out.println("DropDown IS NOT SORTED");
		}
		

	}

}
