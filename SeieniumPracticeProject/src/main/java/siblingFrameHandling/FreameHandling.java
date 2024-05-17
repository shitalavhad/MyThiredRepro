package siblingFrameHandling;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FreameHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-left");
		
		WebElement freameLeftText=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		System.out.println("TopLeftFreamText="+freameLeftText.getText());
		
		driver.switchTo().parentFrame();
		
		//2ndSiblingframe
		driver.switchTo().frame("frame-middle");
		WebElement freameMiddleText=driver.findElement(By.xpath("//div[@id='content']"));
		System.out.println("TopFreamMiddelText="+freameMiddleText.getText());
		
		driver.switchTo().parentFrame();
		
		//3rdSiblingFreame
	    driver.switchTo().frame("frame-right");
	    WebElement freameRightText=driver.findElement(By.xpath("  //body[contains(text(),'RIGHT')] "));
	    System.out.println("TopRightFreamText="+freameRightText.getText());
	    
	    driver.switchTo().defaultContent();
	    
	    //bottoemFream
	    driver.switchTo().frame("frame-bottom");
	    WebElement freameBottomText=driver.findElement(By.xpath(" //body[contains(text(),'BOTTOM')] "));
	    System.out.println("BottomFreamText="+freameBottomText.getText());
		
		
	}

}
