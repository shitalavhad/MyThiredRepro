package tableHandling;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;


public class StaticTableHandling {

	public static void main(String[] args) {
	  
System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("https://omayo.blogspot.com/");

//how many rows 
List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']//tr"));
System.out.println("Number of rows :"+rows.size());
System.out.println("=============================================");

//how many cols
List<WebElement> cols=driver.findElements(By.xpath("//table[@id='table1']//th"));
System.out.println("Number of cols :"+cols.size());
System.out.println("=============================================");

//retrive only heading
List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//th"));
for(WebElement header:headers)
{
	System.out.println(header.getText());
}
System.out.println("=============================================");

//retrive the data
List<WebElement> datas=driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
for(WebElement data:datas)
{
	System.out.println(data.getText());
}
System.out.println("=============================================");

//retrive header and data
List<WebElement> had=driver.findElements(By.xpath("//table[@id='table1']//tr |  //table[@id='table1']//th"));
for(WebElement hd:had)
{
	System.out.println(hd.getText());
}






		

	}

}
