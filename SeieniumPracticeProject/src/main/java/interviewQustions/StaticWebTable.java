package interviewQustions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
	   int rows=driver.findElements(By.xpath("//table[@class='ws-table-all']//tr")).size();
	   System.out.println("Totle no of row --->"+rows);
	   
	   int cols=driver.findElements(By.xpath("//table[@class='ws-table-all']//tr/th")).size();
	   System.out.println("Totle no of cols--->"+cols);
	   
	   //get the whole table data
	  /* for(int r=2;r<=rows;r++)
	   {
		   for(int c=1;c<=cols;c++)
		   {
			   System.out.print( driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td["+c+"]")).getText() +"   ");
			 
		   }
		   System.out.println("     ");
	   }*/
	   //get the only 1cols data
	  /* for(int r=2;r<rows;r++)
	   {
		   for(int c=1;c<=cols;c++)
		   {
			 System.out.print( driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td[1]")).getText());
		   }
		   System.out.println(" ");
	   }*/
	   for(int r=2;r<=rows;r++)
	   {
		   System.out.println( driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+ r +"]//td[1]")).getText());
	   }
	   
		
		

	}

}
