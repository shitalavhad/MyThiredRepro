package cDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.WebElement;
import java.util.*;

public class HandlingDropDown {

	public static void main(String[] args) {
		//lunch the browser
		System.setProperty("webdriver.chrome.driver","G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement selectFrddrp=
				       driver.findElement(By.xpath("(//div[contains(@class,'ui fluid selection')])[1]"));
		                selectFrddrp.click();
	List<WebElement> options=driver.findElements(By.xpath("//div[@class='menu transition visible']//div"))	  ;
	System.out.println("Totle no of element present in drp :"+options.size());
	
	for(WebElement op:options)
	{
		String e=op.getText();
		System.out.println(e);
		if(e.equals("Jenny Hess"))
		{
			op.click();break;
		}
	}
		
		

	}

}
