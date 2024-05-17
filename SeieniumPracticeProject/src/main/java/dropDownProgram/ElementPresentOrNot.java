package dropDownProgram;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;

public class ElementPresentOrNot {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the options: ");
		String userInput = scanner.nextLine();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement createNewAccountButton=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
		
		createNewAccountButton.click();
		
		WebElement monthdrp=driver.findElement(By.xpath("//select[@id='month']"));
		
		//create the instance of the Select class
		Select sc=new Select(monthdrp);
		
		 //String expectedOption="Bangloar";
		 
		List<WebElement> actualOption= sc.getOptions();
		for(WebElement actual:actualOption)
		{
			if(userInput.equals(actual))
			{
				System.out.println(actual.getText());
				actual.click();
			   break;
			}
		}
		if(userInput.equals(actualOption))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
			
			
		}
	
	

	}

}
