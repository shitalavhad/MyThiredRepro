package webTableHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrientTable {

	public static void main(String[] args) throws InterruptedException {
         WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		
		List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		int rows=rowElement.size();
		System.out.println("Totel number of rows :"+rows);
		
		List<WebElement> colsElement = driver.findElements(By.xpath("//table[@id='table1']//th"));
		int cols = colsElement.size();
		System.out.println("Totel number of rows:"+cols);
	/*	for(int r=1;r<=rows;r++)
		{
			if(r==1)
			{
				for(int c=1;c<=cols;c++) {
					String xpathh="//table[@id='table1']//th["+c+"]";
					WebElement tableHeading = driver.findElement(By.xpath(xpathh));
					String heading=tableHeading.getText();
					System.out.print(heading+"  ");
				}
				System.out.println(   );
			}
			else
			{
				for(int c=1;c<=cols;c++) {
					String xpathd="//table[@id='table1']//tr["+(r-1)+"]//td["+c+"]";
					WebElement tabledata = driver.findElement(By.xpath(xpathd));
					String data=tabledata.getText();
					System.out.print(data+ "  ");
				}
				System.out.println(   );
			}
		}*/
		for(int r=1;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String xpatha="//table[@id='table1']//tr["+r+"]//td["+c+"]";
				WebElement tabledata=driver.findElement(By.xpath(xpatha));
				String data=tabledata.getText();
				System.out.print(data + "  ");
			}
			System.out.println(   );
		}
		
		
		
		}

	}


