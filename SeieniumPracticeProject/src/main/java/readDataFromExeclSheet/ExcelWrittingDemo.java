package readDataFromExeclSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilityClass.XLUtility;

public class ExcelWrittingDemo {

	public static void main(String[] args) throws IOException {
/*//1]	/*	//create the Workboook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//create sheet
		XSSFSheet sheet = workbook.createSheet("Text");
		
		//creatr row
	  XSSFRow row = sheet.createRow(0);
	   XSSFCell cell = row.createCell(0);
		String data="shital";
	  cell.setCellValue(data);
	  
	  //cretae fileoutputStream
	  String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\Test.xlsx";
	  FileOutputStream fo=new FileOutputStream(path);
	  workbook.write(fo);
		fo.close();
		System.out.println("successfully done---  ");*/
//2]	//setCellData("Sheet1", 0, 1, "Avhad");
		String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\WebTable.xlsx";
		XLUtility xlutility=new XLUtility(path);
		xlutility.setCellData("Sheet2", 1, 2, "ShitalAvhad");
		
	}
	//genaric function for write operration
	public static void setCellData(String sheetName, int roenum, int colnum, String data) throws IOException
	{
		//create workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		//create sheet
		XSSFSheet sheet = workbook.createSheet(sheetName);
		//crete row
		XSSFRow row = sheet.createRow(roenum);
		//create cell
		XSSFCell cell = row.createCell(colnum);
		//add data
		cell.setCellValue(data);
		String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\LoginInfo.xlsx";
		FileOutputStream fileOutputStream=new FileOutputStream(path);
		workbook.write(fileOutputStream);
		workbook.close();
		fileOutputStream.close();
		
		System.out.println("sucesss=====");
	}

	

}
