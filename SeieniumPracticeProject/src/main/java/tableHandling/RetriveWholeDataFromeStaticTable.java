package tableHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetriveWholeDataFromeStaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		for(int r=1;r<=rows.size();r++)
		{
			for(int c=1;c<=cols.size();c++)
			{
				if(r==1)
				{
					String xpath="//table[@id='table1']//th["+c+"]";
					String tableHeading=driver.findElement(By.xpath(xpath)).getText();
					System.out.print(tableHeading +   "  ");
				}
				else
				{
					String xpath="//table[@id='table1']//tr["+(r-1)+"]//td["+c+"]";
					String tabledata=driver.findElement(By.xpath(xpath)).getText();
					System.out.print( tabledata +    "   ");
				}
			}
			System.out.println(        );
		}
	}
	
	
}
