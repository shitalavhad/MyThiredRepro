package dropDown;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubE
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.makemytrip.com/");
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html#google_vignette");	
		
		WebElement courseName=driver.findElement(By.xpath("//select[@id='course']"));
		Select sc=new Select(courseName);
		String expectedOptions="Java";
		//how many element present inside tyhe drp
		List<WebElement> options = sc.getOptions();
		System.out.println("Totle no of ele,emt avaliable inside the drp:"+options.size());
		System.out.println("===========================================");
		//how to fectch all options inside the drp
		for(WebElement ele:options)
		{
			//System.out.println("All avliable options :"+ele.getText());
			String actualOptions=ele.getText();
			if(actualOptions.equals(expectedOptions))
			{
				ele.click();
				break;
			}
		}
		int count=0;
		if(count!=0)
		{
			System.out.println(expectedOptions  +"options is match");
		}
		else
		{
			System.out.println(expectedOptions   +"not match");
		}
		
		
		
		
	
		
	}

}
