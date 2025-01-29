package excelSheetDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class EnterDataonLoginPage {

	public static void main(String[] args) throws IOException {
		   System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			  FileInputStream file=new FileInputStream("D:\\AutomationData\\testData.xlsx");
				
				XSSFWorkbook workbook=new XSSFWorkbook(file);
				
				XSSFSheet sheet=workbook.getSheet("Sheet2");
			
			WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
	       //String un=sheet.getRow(1).getCell(0).getStringCellValue();
			String un=readDataFromeExcelSheet(1, 0);
	       userName.sendKeys(un);
			
			WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
			
			//String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
			String pwd=readDataFromeExcelSheet(1, 1);
			password.sendKeys(pwd);
			
			WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton.click();

	}
	public static String readDataFromeExcelSheet(int rowNumber,int cellNumber ) throws IOException
	{
         FileInputStream file=new FileInputStream("D:\\AutomationData\\testData.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
	  String value	=sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	  return value;
		
		
		 
	}

}
