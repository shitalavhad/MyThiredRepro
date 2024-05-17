package scrollingOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import  org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingOperations {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		/*js.executeScript("window.scrollBy(0,500);");//scrolldown
		Thread.sleep(200);
		js.executeScript("window.scrollBy(0,-200);" );//scrollup
		Thread.sleep(200);
		js.executeScript("window.scrollBy(100,0);");
		Thread.sleep(200);
		js.executeScript("window.scrollBy(-200,0);");*/
		
		//scrolling opertaions for specific element
		WebElement forgottenLink=driver.findElement(By.xpath("//div[@class='_6ltj']"));
           js.executeScript("arguments[0].scrollIntoView(true);",forgottenLink);
	       forgottenLink.click();
		
		
	}

}
