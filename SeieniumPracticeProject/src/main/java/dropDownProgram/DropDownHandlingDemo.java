package dropDownProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import java.util.List;




import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandlingDemo {

	public static void main(String[] args) {
		//how to get the options inside the dropdown
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new  ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver .manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		WebElement productdrp=driver.findElement(By.xpath("//select[@id='first']"));
	/*	Select sc=new Select(productdrp);
		List<WebElement> avaliableOptions=sc.getOptions();
		for(WebElement options:avaliableOptions)
		{
			System.out.println("all avliable options :"+options.getText());
		}
	}*/
		avaliableOptions(productdrp);
		selectOptionFromeDrp(productdrp, "Yahoo");
	}
	//genaric function for cheak options
     public static void avaliableOptions(WebElement ele)
     {
    	 Select sc=new Select (ele);
    	 List<WebElement> options=sc.getOptions();
    	 for(WebElement op:options)
    	 {
    		 System.out.println("all options :"+op.getText());
    	 }
     }
     //genaric funstion for handling multiple drp
     public  static void selectOptionFromeDrp(WebElement ele,String value)
     {
    	 Select sc=new Select(ele);
    	List< WebElement> optionsElements=sc.getOptions();
    	for(WebElement op:optionsElements)
    	{
    		if(op.getText().equals(value))
    		{
    		  System.out.println(op.getText());
    		  op.click();
    		  break;
    		}
    	}
     }
}
