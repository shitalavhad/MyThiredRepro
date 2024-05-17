package dropDownProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SortingDrp {

	public static void main(String[] args) {
		
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
       //open the application
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		//locate the element 
		WebElement courseNameDrp=driver.findElement(By.xpath("//select[@id='course']"));
		
		//create the instance of the Select class
		Select sc=new Select (courseNameDrp);
		List<WebElement> options=sc.getOptions();
		
		//create two empty arrayList
		List actualList=new ArrayList();
		
		List tempList=new ArrayList();
		
		
		
		//retrive the webElemnt
		for(WebElement op:options)
		{
		System.out.println("Actual list before the sort :"+actualList);
		
		//sorting templist
		Collections.sort(tempList);
		System.out.println("Actual list after the sort :"+tempList);
		}
		//validations
		if(actualList.equals(tempList))
		{
			System.out.println("drop down is sorted");
		}
		else
		{
			System.out.println("drop down is not sorted");
		}
		
		
}
}
