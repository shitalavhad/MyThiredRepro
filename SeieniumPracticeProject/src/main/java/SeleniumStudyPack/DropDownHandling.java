package SeleniumStudyPack;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/select-menu");
		WebElement dropDown=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		//selectValueFromeDrp(dropDown, "Indigo");
	/*	Select sc=new Select(dropDown);
		List<WebElement> options=sc.getOptions();
	/*	for(WebElement e:options)
		{
			String dropDownValue=e.getText();
			System.out.println(dropDownValue);
		}*/
		/*System.out.println("====================================");
		//sorting or not
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		for(WebElement e:options)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println(tempList);
		System.out.println("=======================================");
		for(Object op:tempList)
		{
			System.out.println(op);
		}
		Collections.sort(tempList);
		
		System.out.println("=========================================");
		//valiadation
		if(originalList.equals(tempList))
		{
			System.out.println("DropDown sorted");
		}
		else
		{
			System.out.println("DropDown not sorted");
		}*/
		selectValueFromeDrp(dropDown);
		
	}
	public static void selectValueFromeDrp(WebElement ele)
	{
		Select sc=new Select(ele);
		List<WebElement> options=sc.getOptions();
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		for(WebElement e:options)
		{
			originalList.add(e.getText());
		   tempList.add(e.getText());
			}
		System.out.println("==========================");
		System.out.println(originalList);
		System.out.println("============================");
		System.out.println("Before Sorting " +tempList);
		System.out.println("============================");
		//sorting
		Collections.sort(tempList);
		System.out.println("After  Sorting  "+tempList);
		
		//validation
		if(originalList.equals(tempList))
		{
			System.out.println("DropDown sorted");
		}
		else
		{
			System.out.println("DropDown not sorted");
		}
		
		}
	

}
