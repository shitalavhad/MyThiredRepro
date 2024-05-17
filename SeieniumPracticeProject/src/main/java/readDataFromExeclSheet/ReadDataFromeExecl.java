package readDataFromExeclSheet;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromeExecl {
	static  FileInputStream fileInputStream;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static String path;

	public static void main(String[] args) throws IOException {
	 path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
	System.out.println("Totle no of rows :"+getRowCount("Sheet1"));
	System.out.println("Totle no of cols :"+getCellCount("Sheet1", 0));
	System.out.println(getCellData("Sheet1", 0, 0));
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(getCellData("Sheet1", 0, 0));
	
	
	
	}
	//read row 
	public static int getRowCount(String sheetName) throws IOException
	{
		fileInputStream=new FileInputStream(path);
		
		//workbook
		workbook=new XSSFWorkbook(fileInputStream);
		
		//sheet
		sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
	
	//get cols 
	public static int getCellCount(String sheetName,int rownum) throws IOException
	{
            fileInputStream=new FileInputStream(path);
		
		//workbook
		workbook=new XSSFWorkbook(fileInputStream);
		
		//sheet
		 sheet=workbook.getSheet(sheetName);
		int  row=sheet.getLastRowNum();
		short  cell=sheet.getRow(rownum).getLastCellNum();
		return cell;
		
	}
	public static  String getCellData(String sheetName,int rownum,int colsnum) throws IOException
	{
		  fileInputStream=new FileInputStream(path);
			
			//workbook
			workbook=new XSSFWorkbook(fileInputStream);
			
			//sheet
			 sheet=workbook.getSheet(sheetName);
			 row=sheet.getRow(rownum);
			 cell=row.getCell(colsnum);
			 
			 DataFormatter formatter=new DataFormatter();
			 String data;
			 try
			 {
				 data=formatter.formatCellValue(cell);
			 }
			 catch(Exception e)
			 {
				 data=" ";
			 }
			 workbook.close();
			 fileInputStream.close();
			 return data;
		
	}
	

}
