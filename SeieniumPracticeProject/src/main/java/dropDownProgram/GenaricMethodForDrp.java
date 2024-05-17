package dropDownProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GenaricMethodForDrp {

	public static void main(String[] args) {
		//lunch the browser
				
		WebDriverManager.chromedriver().setup();
				
			
		WebDriver driver=new ChromeDriver();
				
	      //open the application
			driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
				
			//locate the element 1
			WebElement courseNameDrp=driver.findElement(By.xpath("//select[@id='course']"));
			selectValueFromDropDown(courseNameDrp, "Python");
				
				
				//locate the element 2
				WebElement ideName=driver.findElement(By.xpath("//Select[@id='ide']"));
				selectValueFromDropDown(ideName, "IntelliJ IDEA");
	

	}
	public static void selectValueFromDropDown(WebElement ele,String value)
	{
		//create the instance of the select class
		Select sc =new Select(ele);
		List<WebElement> options=sc.getOptions();
		for(WebElement op:options)
		{
			if(op.getText().equals(value))
			{
				System.out.println("selected options :"+op.getText());
				op.click();
				break;
			}
		}
	}

}
