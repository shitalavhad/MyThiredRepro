package calenderHandling;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectPriouesAndNextDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.path2usa.com/travel-companion/");
	/*	Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data in this month");
		String day=sc.nextLine();*/
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
			
		WebElement dataField=driver.findElement(By.xpath("//input[contains(@id,'form-field-travel_comp_date')]"));
		WebElement sortOption=driver.findElement(By.xpath("//p[@class='p2u_sortby']"));
		js.executeScript("arguments[0].scrollIntoView();",dataField) ;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", dataField);
		Thread.sleep(1000);
	//	js.executeScript("arguments[0].click();", dataField);
		
		dataField.click();
		String day="25";
		int count=0;
		
		//todaysData
	//	WebElement todaysData=driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
	//	todaysData.click();
		
		List<WebElement> activedate=driver.findElements(By.xpath("//div[@class='dayContainer']//span"));
		
		for(WebElement activeDay:activedate)
		{
			if(activeDay.getText().equals(day))
			{
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", activeDay);
				count++;
				activeDay.click();
				break;
			}
		}
		if(count<1)
		{
			System.out.println("given day is not active day Hence we cant be selected");
		}
		
		

	}

}
