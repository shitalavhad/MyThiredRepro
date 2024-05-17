package interviewQustions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AlternativeWayOfGetText {

	public static void main(String[] args) {
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.facebook.com/");
	  
	  WebElement text=driver.findElement(By.xpath("//div[@class='_8esl']//h2"));
	  
	  //System.out.println("Text is ---->"+text.getAttribute("innerText"));
	  System.out.println("Text is---->"+text.getAttribute("textcontent"));
	  
	}
	

}
