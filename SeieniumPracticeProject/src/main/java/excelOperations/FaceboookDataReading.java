package excelOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import readDataFromExeclSheet.ReadDataFromExcelSheet;

public class FaceboookDataReading {
	@Test
	public void verificationFb() throws Exception, IOException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordField=driver.findElement(By.xpath("//input[@id='pass']"));
		emailField.sendKeys(readDataFromExeclSheet(0, 0, "Sheet4"));
		passwordField.sendKeys(readDataFromExeclSheet(0, 1,  "Sheet4"));
		
	}
	public static String  readDataFromExeclSheet( int rownum,int colnum,String sheetName ) throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		FileInputStream fileInputStream=new FileInputStream(path);
		//XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		/*Workbook workbook = WorkbookFactory.create(fileInputStream);
		//XSSFSheet sheet = workbook.getSheet(sheetName);
		Sheet sheet = workbook.getSheet(sheetName);
		//XSSFRow row = sheet.getRow(rownum);
		Row row = sheet.getRow(rownum);
		//XSSFCell cell = row.getCell(colnum);
		Cell cell = row.getCell(colnum);*/
		Cell cell = WorkbookFactory.create(fileInputStream).getSheet(sheetName).getRow(rownum).getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data=formatter.formatCellValue(cell);
		}
	catch (Exception e) {
		data="   ";
	}
		//workbook.close();
		fileInputStream.close();
		return data;
			
		
		
		
		
	}

}
