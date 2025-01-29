package demoDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile {
	public static FileInputStream fil;
	public static FileOutputStream fol;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String filePath,String sheetName) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fil.close();
		return rowCount;			
	}
	//get cell
	public static int getCellCount(String filePath,String sheetName ,int rownum) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fil.close();
		return cellCount;			
	}
	//read data frome execl
	public static String getCellData(String filePath,String sheetName,int rownum,int cellnum) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		DataFormatter dataFormatter=new DataFormatter();
		try {
		data=dataFormatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="  ";
		}
		workbook.close();
		fil.close();
		return data;
	}
	//write data frome execl
	public  static void setCellData(String filePath,String sheetName,int rownum,int cellnum,String data) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		
		//cell=row.getCell(cellnum);
		fol=new FileOutputStream(filePath);
		workbook.close();
		fil.close();
		
	}
	public static void fillGrenColor(String filePath,String sheetName,int rownum,int cellnum) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fol=new FileOutputStream(filePath);
		workbook.close();
		fil.close();
		
	}
	
	public  static void fillRedColor(String filePath,String sheetName,int rownum,int cellnum) throws IOException
	{
		fil=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fil);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fol=new FileOutputStream(filePath);
		workbook.close();
		fil.close();
		
	}
	
	
	

}
