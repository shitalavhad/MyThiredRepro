package demoDropDown;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExpectedOptionPresentOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Expected Option here:");
		String expectedOption=sc1.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement colourDropDown=driver.findElement(By.xpath("//select[@id='colors']"));
		Select sc=new Select( colourDropDown);
		List<WebElement> options=sc.getOptions();
		for(WebElement e:options)
		{
			String actualOption=e.getText();
			if(actualOption.equals(expectedOption))
			{
				e.click();
				
				break;
			}
		}
		

	}

}
