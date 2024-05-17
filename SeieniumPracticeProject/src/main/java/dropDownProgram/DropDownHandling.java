package dropDownProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DropDownHandling {
	static  Select sc;
	public static void main(String[] args) {
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
       //open the application
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		//locate the element 
		WebElement courseNameDrp=driver.findElement(By.xpath("//select[@id='course']"));
		
		//createthe instance of the select class
		 sc=new Select(courseNameDrp);
		
		//select value using selectByIndrex() method
		//sc.selectByIndex(2);
		
		//select value using selectByVissibleText()
		//sc.selectByVisibleText("Python");
		
		//select value using selectByValue()
		//sc.selectByValue("java");
		
		
		//print the value inside the console window
		//System.out.println("selected value :"+sc.getFirstSelectedOption().getText());
		
		//Handling multiselection drp
		WebElement ideName=driver.findElement(By.xpath("//Select[@id='ide']"));
		
		//cheak drp is single selection or multiselection
		sc=new Select(ideName);
		
		System.out.println(sc.isMultiple());
		
		//select the multiple option at one time
		sc.selectByIndex(1);
		sc.selectByValue("vs");
		sc.selectByVisibleText("NetBeans");
		
		//print the all selected options on console
		List<WebElement> selectedAllOptions=sc.getAllSelectedOptions();
		for(WebElement options:selectedAllOptions)
		{
			System.out.println("selected all options  :"+options.getText());
		}
		
		
		
		

	}

}
