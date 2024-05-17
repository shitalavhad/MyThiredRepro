package excelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataFromExeclSheet {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileOutputStream fileOutputStream;
	static FileInputStream fileInputStream;
	static String path;

	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\Test.xlsx";
		
		setCellData("Sheet1", 0, 0, "shital");

	}
	public static void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())
		{
			workbook=new XSSFWorkbook();
			fileOutputStream =new FileOutputStream(path);
			workbook.write(fileOutputStream);		
		}
		fileInputStream =new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInputStream);
		
		if(workbook.getSheetIndex(sheetName)==-1)
			workbook.createSheet(sheetName);
		  sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		fileOutputStream=new FileOutputStream(path);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
			
	}

}
