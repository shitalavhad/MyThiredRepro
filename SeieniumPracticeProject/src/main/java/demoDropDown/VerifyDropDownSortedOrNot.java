package demoDropDown;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownSortedOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement colourDropDown=driver.findElement(By.xpath("//select[@id='colors']"));
		Select sc=new Select( colourDropDown);
		List<WebElement> options=sc.getOptions();
		
		List originalList=new ArrayList();
		List tempList=new ArrayList();
		for(WebElement e:options)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		
		System.out.println("Before Sorting templist");
		System.out.println(originalList);
		System.out.println(tempList);
		
		Collections.sort(tempList);
		System.out.println("After Sorting templist");
		System.out.println(tempList);
		
		//validation
		if(originalList.equals(tempList))
		{
			System.out.println("DropDown is sorted");
		}
		else
		{
			System.out.println("DropDown not sorted");
		}

	}

}
