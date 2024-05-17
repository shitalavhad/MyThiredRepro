package dropDownProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerityActualExpectedOp {

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
			   String expectedOptions="Google";
			   for(WebElement e:options)
			   {
				   if(e.getText().equals(expectedOptions))
				   {
					   e.click();
				   }
			   }

	}

}
