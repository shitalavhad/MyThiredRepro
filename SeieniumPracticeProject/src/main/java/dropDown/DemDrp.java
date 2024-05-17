package dropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;




import io.github.bonigarcia.wdm.WebDriverManager;

public class DemDrp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		WebElement courseName=driver.findElement(By.xpath("//select[@id='course']"));
		
		//get all avaliable options
		Select sc=new Select(courseName);
		List<WebElement> allOptions = sc.getOptions();
		
		//how many options present
		System.out.println(allOptions.size());
		for(WebElement option:allOptions)
		{
			System.out.println(option.getAttribute("textContent"));
		}
	}

}
