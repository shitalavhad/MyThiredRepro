package DemoWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebElementMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get("https://www.facebook.com/");
	
	  //eneter text inside the txt field
	  WebElement emailField=driver.findElement(By.xpath("//input [@id='email']"));
	  emailField.sendKeys("shital");
	  
	  //clrar the text
	  emailField.clear();
	  
	  //get the text 
	  WebElement text=driver.findElement(By.xpath("//div[@class='_8esl']//following-sibling::h2"));
	  //System.out.println("text is: "+text.getText());
	 String myText= text.getAttribute("textContent");
	 System.out.println("Text is "+myText);
	  
	  //get attribute value
	 
	String attributeValue = emailField.getAttribute("placeholder");
	System.out.println("attributeValue is  :"+attributeValue);
	
	//get the size
	WebElement loginButton=driver.findElement(By.xpath("//button[@name='login']"));
	System.out.println(  "retrive thr size of button  "+loginButton.getSize());
	  
	//get the location of the 
    Point p	=loginButton.getLocation();
   System.out.println(p.x     +p.y);
	  	
	

	}

}
