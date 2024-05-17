package webTableHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//print entier table
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		
	//	List<WebElement> tableh = driver.findElements(By.xpath("//table[@id='table1']//tr/*"));
		
		/*for(WebElement dh:tableh)
		{
			System.out.println(dh.getText());
		}*/
		
	//	for(int i=0;i<tableh.size();i++)
		//{
			
	//	}
		//how many cols
	  List< WebElement> colsElement = driver.findElements(By.xpath("//table[@id='table1']//tr//th"));
	  int cols = colsElement .size();
	  System.out.println("Totel no of cols :"+cols);
	  
	  //how many row
	  List<WebElement> rowElement=driver.findElements(By.xpath("//table[@id='table1']//tr"));
	 int rows = rowElement.size();
	  System.out.println("Totle no of row :"+rows);
	  
	  //feach the data
/*	  for(int i=0;i<rows;i++)
	  {
		  for(int j=0;j<cols;j++)
		  {
			WebElement data = driver.findElement(By.xpath("//table[@id='table1']//tr["+(i-1)+"]//td["+j+"]"));
			String allData = data.getText();
			System.out.print(allData   );
		  }
		  System.out.println(    "     "  );
	  }*/
	  Thread.sleep(2000);
	  
	  for(int r=1;r<=rows;r++)
	  {
		  if(r==1)
		  {
			  for(int c=0;c<=cols;c++)
			  {
				 WebElement tableHeading = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//th["+c+"]"));
				 String headling=tableHeading.getText();
				 System.out.print(headling+"   ");
				  
			  }
			  System.out.println();
		  }
		  else
		  {
			  for(int c=1;c<cols;c++)
			  {
				  WebElement tableData=driver.findElement(By.xpath("//table[@id='table1']//tr["+(r-1)+"]//td["+c+"])"));
				  String data=tableData.getText();
				  System.out.print(data + "   ");
			  }
			  System.out.println( );
		  }
	  }
	}

}
