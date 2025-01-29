package demoDropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDorpDown1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
		createNewAccountButton.click();
		
		WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
		//retrivetheAllOptionFromeDrp(monthDrp);
		
	/*	//retrive the all element
	 * 
		Select sc=new Select(monthDrp);
		List<WebElement> allOptions=sc.getOptions();
		
		for(WebElement op:allOptions)
		{
			String availableOptions=op.getText();
			System.out.println(availableOptions);
		}*/
	/*	//sorting dropdown
		Select sc=new Select(monthDrp);
		List<WebElement> allOptions=sc.getOptions();
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		for(WebElement e:allOptions)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println("OrinnalList : "+originalList);
		System.out.println("=============================");
		System.out.println("TempList beforesorting :"+tempList);
		
		Collections.sort(tempList);
		System.out.println("TempList afterSorting :"+tempList);
		if(originalList.equals(tempList))
		{
			System.out.println("Give dropDown  is sorted");
		}
		else
		{
			System.out.println("Given drop doen is not sorted");
		}*/
		//cheak the value present or not inside drp
	//	String expectedOption="Jan";
		Scanner sc1=new Scanner(System.in);
		String expectedOption=sc1.next();
		System.out.println("Enter the option");
		
		Select sc=new Select(monthDrp);
		List<WebElement> allOptions=sc.getOptions();
		for(WebElement option:allOptions)
		{
			String actualOption=option.getText();
			if(actualOption.equals(expectedOption))
			{
				String op=option.getText();
				System.out.println(op);
				option.click();
				break;
			}
		}
		
		
		
	}
	public static void retrivetheAllOptionFromeDrp(WebElement ele)
	{
		Select sc=new Select(ele);
		List<WebElement> allOptions=sc.getOptions();
		for(WebElement op:allOptions)
		{
			String allAvaliableOptions=op.getText();
			System.out.println("allAvalaibleOPtions is: "+allAvaliableOptions);
		}
	}

}
