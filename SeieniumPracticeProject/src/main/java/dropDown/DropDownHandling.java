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

public class DropDownHandling {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
	    WebElement airLineDrp=driver.findElement(By.xpath("//select[@id='form-field-travel_comp_airline']"));
	    Select sc=new Select(airLineDrp);
	    
	/*  List<WebElement> avaliableOption = sc.getOptions();
	   for(WebElement options:avaliableOption )
	   {
		String   option= options.getText();
		System.out.println(option);
	   }*/
	    List originalList=new ArrayList();
	    List tempList=new ArrayList();
	    List<WebElement> avaliableOption = sc.getOptions();
	    for(WebElement options:avaliableOption )
	    {
	    	originalList.add(options.getText());
	    	tempList.add(options.getText());
	    }
	    Collections.sort(tempList);
	    
	    if(originalList.equals(tempList))
	    {
	    	System.out.println("DropDown Sorted");
	    }
	    else
	    {
	    	System.out.println("DropDown not sorted");
	    }
	    
	    

	}

}
