package windowPopUpHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class ChildWindowPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		
		driver.get(url);
		
		WebElement button=driver.findElement(By.xpath("//button[@id='openwindow']"));
		button.click();
		
		//Set<String > address=driver.getWindowHandles();
		
		//System.out.println("parent window address and child window address :"+address);
		
		List<String> address=new ArrayList<String>(driver.getWindowHandles());
		
		//switch to childwindow
		driver.switchTo().window(address.get(1));
	 String childWindowTitle	=driver.getCurrentUrl();
	 System.out.println("child window title :"+childWindowTitle);
	 driver.close();
	 //switch to parent window
	 driver.switchTo().window(address.get(0));
	String parentWindowTitle=driver.getTitle();
	 System.out.println("parent Window title :"+parentWindowTitle);
	 driver.close();


	}

}
