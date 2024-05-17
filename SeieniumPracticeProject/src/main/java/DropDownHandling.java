import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		 DropDownHandling dp=new  DropDownHandling();
		 dp.dropDownHandling();

	}
	public void  dropDownHandling()
	{
		   WebDriverManager.chromedriver().setup();
			
	       driver=new ChromeDriver();
	       
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	       driver.get("https://www.facebook.com/");
	       
	       WebElement createNewAccountButton=driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]"));
	       
	       createNewAccountButton.click();
	       
	      WebElement monthDrp= driver.findElement(By.xpath("//select[@id='month']"));
	      
	      Select sc=new Select(monthDrp);
	      
	      //print all elemnt
	      List<WebElement> options = sc.getOptions();
	      for(WebElement o:options)
	      {
	    	String e = o.getText();
	    	System.out.println(e);
	      }
	      
	}

}
