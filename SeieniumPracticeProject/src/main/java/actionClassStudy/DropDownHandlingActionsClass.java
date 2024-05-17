package actionClassStudy;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlingActionsClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		 driver .manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		 driver.get("https://www.facebook.com/");
		
	    WebElement createNewAccountButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
	    
	    Actions act=new Actions(driver);
	    act.click(createNewAccountButton).perform();
	    
	  WebElement monthdrp = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	/*  String expectedMonth="Aug";
	  Select sc=new Select(monthdrp);
	  java.util.List<WebElement> options = sc.getOptions();
	  for(WebElement op:options)
	  {
		  String actualMonth=op.getText();
		 // System.out.println("All DropDownMenuMonth :"+op.getText());
		  
	      if(actualMonth.equals(expectedMonth))
	      {
	    	  System.out.println(op.getText());
	    	  op.click();
	    	  break;
	    	  
	      }
	  }*/
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  act.click(monthdrp).perform();
	  for(int i=0;i<=12;i++)
	  {
		  act.sendKeys(Keys.ARROW_DOWN).perform();
		 // js.executeScript("document.activeElement.setAttribute('style', 'background: yellow; border: 2px solid red;');");
		  highLightingWebElement(driver);
	  }
	  
	}
	public static void highLightingWebElement(WebDriver driver)
	{
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("document.activeElement.setAttribute('style', 'background: yellow; border: 2px solid red;');");
	}

}
