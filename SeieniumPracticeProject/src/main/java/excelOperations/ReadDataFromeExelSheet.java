package excelOperations;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromeExelSheet {
   public  static 	WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
	  driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		//emailField.sendKeys(getDataFromExeclSheet("Sheet1", 0, 0));
		//sendValue("//input[@id='email']", "shitalavhad");
		//WebElement email = null;
		//sendValue(email, "//input[@id='email']", "shitalavhad");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='shitalavhad';", emailField);
	

	}
	public static void  sendValue(String xpath,String value)
	{
		WebElement emailFiled=driver.findElement(By.xpath(xpath));
		emailFiled.sendKeys(value);
	}
	public static void sendValue(WebElement ele,String xpath,String value)
	{
		WebElement email=driver.findElement(By.xpath(xpath));
		email.sendKeys(value);
	}


public  static String getDataFromExeclSheet(String sheetName,int rownum,int columnum) throws IOException
{
	String  path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
	FileInputStream fil=new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(fil);
	XSSFSheet sheet=workbook.getSheet(sheetName);
	XSSFRow row=sheet.getRow(rownum);
	XSSFCell cols = row.getCell(columnum);
	
	DataFormatter formatter=new DataFormatter();
	String data;
	try {
	data=formatter.formatCellValue(cols);
	}
	 catch(Exception e)
	{
		data="   ";
	}
	workbook.close();
	return data;
}
}