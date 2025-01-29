package studyDropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheakDropDownSortedOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("https://www.facebook.com/");

	WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_')]"));
	createNewAccountButton.click();

	WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
	Select sc1=new Select(monthDrp);
	List<WebElement> options=sc1.getOptions();
	
	//create two list
	List originalList=new ArrayList();
	List tempList=new ArrayList();
	
	for(WebElement e:options)
	{
	  originalList.add(e.getText());
	  tempList.add(e.getText());

	}
	System.out.println("OriginalList Befor Sorting  :"+originalList);
	Collections.sort( tempList);
	System.out.println("TempList After Sorting  :"+tempList);
	
	if(originalList.equals(tempList))
	{
		System.out.println("Drop Down sorted");
	}
	else
	{
		System.out.println("Drop Down not sorted");
	}
	
	}

}
