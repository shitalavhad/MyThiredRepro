package readDataFromExeclSheet;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookDataReadExcelFile {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys(readDataFromeExeclSheet(1, 1));
		
	

	}
	public static String  readDataFromeExeclSheet(int row,int cell) throws EncryptedDocumentException, IOException
	{
		 String path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		 
		FileInputStream fileInputStream=new FileInputStream(path);
		String value=WorkbookFactory.create(fileInputStream).getSheet("Sheet3").getRow(row).getCell(cell).getStringCellValue();
		return value;
		
		
	}

}
