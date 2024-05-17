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

public class getOptionsFromeDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		WebElement drp=driver.findElement(By.xpath("//select[@id='first']"));
		Select sc=new Select(drp);
		List<WebElement> allOptions=sc.getOptions();
		
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		
		
		/*for(WebElement op:allOptions)
		{
			//System.out.println(op.getText());
			//System.out.println(op.getAttribute("innerText"));
			System.out.println(op.getAttribute("textContent"));
		}
		
		//how many element present inside the drp
		System.out.println("avaliable options   :  "  +allOptions.size());
		
		//specific element present or no let check
		
		System.out.println(allOptions.contains("shital"));*/
		
		//Cheak specific option present or not
		
		for(WebElement op:allOptions)
		{
			originalList.add(op.getText());
			tempList.add(op.getText());
		}
		
		//sorting
		Collections.sort(tempList);
		
		if(originalList.equals(tempList))
		{
			System.out.println("sorting");
		}
		else
		{
			System.out.println("not sorting");
		}
	
		}
		
	   
		

	}



