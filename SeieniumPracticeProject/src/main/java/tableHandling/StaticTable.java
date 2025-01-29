package tableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class StaticTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1]find the totle no of rows in table
		List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Number of rows :"+rows.size());
		
		//2]find th totle no of cols in table
		List<WebElement> cols=driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Number of coloums :"+cols.size());
		
		//3]read data frome specific row and cols
		String specificData=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Specific data retriving :"+specificData);
		
	/*	//4]read data from all row n coloms
		for(int r=1;r<=rows.size();r++)
		{
			for(int c=1;c<=cols.size();c++)
			{
				if(r==1)
				{
					String xpath="//table[@name='BookTable']//th["+c+"]";
					String tableHeader=driver.findElement(By.xpath(xpath)).getText();
					System.out.print( tableHeader   +  "\t");
				}
				else
				{
					String xpath="//table[@name='BookTable']//tr["+r+"]//td["+c+"]";
					String tabledata=driver.findElement(By.xpath(xpath)).getText();
					System.out.print(tabledata   + "  \t    ");
				}
			}
			System.out.println(       );
		}
*/
		//5]print book name whose authore is Mukes
		for(int r=2;r<=rows.size();r++)
		{
			String autherName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(autherName.equals("Mukesh"))
			{
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+" \t"+autherName);
			}
		}

	}

}
