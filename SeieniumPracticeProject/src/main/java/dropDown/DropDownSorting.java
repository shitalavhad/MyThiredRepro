package dropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSorting {

	public static void main(String[] args) {
		
		//lunch the applications
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		
		//open the application
		String url="https://chercher.tech/practice/practice-dropdowns-selenium-webdriver";
		
		driver.get(url);
		
		//locate the webElemnt
		WebElement productDrp=driver.findElement(By.xpath("//select[@id='first']"));
		Select sc=new Select(productDrp);
	   List<WebElement>	 options=sc.getOptions();
		
	 //create the two empty arrayList
		List originalList=new ArrayList();
		
		List tempList=new ArrayList();
		
		//itreate the drp
		
		for(WebElement e:options)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(originalList);
		System.out.println(tempList);
		
		//sorting the tempList
		Collections.sort(tempList);
		System.out.println("sorting the tempList:"+tempList);
		
		//validation
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
