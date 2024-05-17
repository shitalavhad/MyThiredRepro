package readDataFromExeclSheet;
import java .io.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.Exceptions;

public class DemoReadDataFromeExecl {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fileInputStream;
	static XSSFRow row;
	static XSSFCell cell;
	static String path;

	public static void main(String[] args) throws IOException {
		path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		System.out.println("Totle no of rows :"+countRowNumber("Sheet1"));
		System.out.println("Totle no of cols :"+countColsNumber("Sheet1"));
		System.out.println(getDataFromeExecl("Sheet1", 0, 2));
		
	}
	public static int countRowNumber(String sheetName) throws IOException
	{
		//get the path
		fileInputStream =new FileInputStream(path);
		
		//create workbook
		workbook=new XSSFWorkbook(fileInputStream);
		
		//get sheet
		sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
	//get cols
	public static int  countColsNumber(String sheetName) throws IOException
	{
		fileInputStream =new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fileInputStream);
		
		sheet= workbook.getSheet(sheetName);
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(rows).getLastCellNum();
		return cols;
	}
	//get data
	public static String  getDataFromeExecl(String sheetName,int rowcount,int cellcount) throws IOException
	{
fileInputStream =new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fileInputStream);
		
		sheet= workbook.getSheet(sheetName);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(rows).getLastCellNum();
		
		//get row and cell
		row=sheet.getRow(rowcount);
		cell=row.getCell(cellcount);
		
		//we nevwr idea about 
		DataFormatter dataFormatter=new DataFormatter();
		String data;
		try
		{
			data=dataFormatter.formatCellValue(cell);
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
