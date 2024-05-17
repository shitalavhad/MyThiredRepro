package readDataFromExeclSheet;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityClass.XLUtility;

import org.openqa.selenium.WebElement;


public class WebTableToExecl {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://qavbox.github.io/demo/webtable/");
		String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\WebTable.xlsx";
		XLUtility xlutility=new XLUtility(path);
		
		//write header execl 
		xlutility.setCellData("sheet1", 0, 0, "ManualTesting");
		xlutility.setCellData("sheet1", 0, 1, "AutomationTesting");
		xlutility.setCellData("sheet1", 0, 2, "IssueTracker");
		
		//how many row
		WebElement table=driver.findElement(By.xpath("//table[@id='table01']//tbody"));
		
		//int rows=table.findElements(By.xpath("tr")).size();
		int rows=driver.findElements(By.xpath("//table[@id='table01']//tbody/tr")).size();
		System.out.println(rows);
		
		for(int r=1;r<=rows;r++)
		{
			String ManualTesting=table.findElement(By.xpath("tr[ "+r+" ]/td[1]")).getText();
			String AutomationTesting=table.findElement(By.xpath("tr [ "+r+" ]/td[2]")).getText();
			String IssueTracker =table.findElement(By.xpath("tr[ "+r+" ]/td[3]")).getText();
			//String  =table.findElement(By.xpath("tr[ "+r+" ]/td[1]")).getText();
			System.out.println(ManualTesting+AutomationTesting+ IssueTracker);
			
			xlutility.setCellData("Sheet1", r, 0,ManualTesting );
			xlutility.setCellData("Sheet1", r, 1,AutomationTesting );
			xlutility.setCellData("Sheet1", r, 2,IssueTracker);
		}
		System.out.println("web scrapping is done sucessfully ----");
		
	}

}
