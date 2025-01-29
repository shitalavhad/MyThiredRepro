package RealTImeQustions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetriveAllElementArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		List<WebElement> allFooterOptions=driver.findElements(By.xpath("//div[@id='pageFooter']"));
		//System.out.println(allFooterOptions);
		System.out.println(allFooterOptions.size());
		for(WebElement option:allFooterOptions)
		{
			String op=option.getText();
			System.out.println(op);
		}
		//System.out.println(op);

	}

}
