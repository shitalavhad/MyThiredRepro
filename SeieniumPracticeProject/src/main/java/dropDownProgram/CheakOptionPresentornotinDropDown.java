package dropDownProgram;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheakOptionPresentornotinDropDown {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the options: ");
		String userInput = scanner.nextLine();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://formstone.it/components/dropdown/");
		
		WebElement dropDown=driver.findElement(By.xpath("//select[@id='demo_label']"));
		dropDown.click();
		
		Select sc=new Select(dropDown);
		List<WebElement> options = sc.getOptions();
		for(WebElement actualOption:options)
		{
		  System.out.println("All avaliable options :"+actualOption.getText());
		  actualOption.click();
		  break;	
		}
		
		
		
		
		}
	}


