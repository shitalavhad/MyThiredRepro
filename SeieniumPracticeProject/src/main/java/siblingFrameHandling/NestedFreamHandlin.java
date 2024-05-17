package siblingFrameHandling;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFreamHandlin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/frame");
		
		String pageheaderText=driver.findElement(By.xpath("//h1[contains(text(),' Frame')]")).getText();
		System.out.println("PageHeaderTitle ="+pageheaderText);
		
		WebElement ifream1=driver.findElement(By.xpath("(//iframe[@name='googlefcPresent'])[1]"));
		
		driver.switchTo().frame(ifream1);
		WebElement firstName=driver.findElement(By.xpath("//input[@name='fname']"));
		firstName.sendKeys("shital");
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shital");
		
		
		

	}

}
