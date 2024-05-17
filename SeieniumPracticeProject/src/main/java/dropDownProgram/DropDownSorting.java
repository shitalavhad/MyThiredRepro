package dropDownProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class DropDownSorting {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new  ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver .manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		//WebElement productdrp=driver.findElement(By.xpath("//select[@id='first']"));
		WebElement animalDrp=driver.findElement(By.xpath("//select[@id='animals']"));
		Select sc=new Select(animalDrp);
		List<WebElement >option=sc.getOptions();
		
		//two list
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		
		for(WebElement e:option)
		{
			//System.out.println(e.getText());
			originalList.add(e.getText());
			tempList.add(e.getText());
	}
		System.out.println("original List :"+originalList);
		
		Collections.sort(tempList);
		
		//validation
		if(originalList.equals(tempList))
		{
			System.out.println("drp sorted");
		}
		else
			{
			System.out.println("drp not sorted");
			}
			}
	}


