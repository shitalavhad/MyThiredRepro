package dropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class HandlingDropDown {

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
		
		//cfreatwe the instance of the Select class
		
		Select sc=new Select (productDrp);
		//sc.selectByIndex(1);
		
		//sc.selectByValue("Apple");
		
		sc.selectByVisibleText("Yahoo");
		System.out.println("my selected options is: "+sc.getFirstSelectedOption().getText());
		
		
		
		
		


	}

}
