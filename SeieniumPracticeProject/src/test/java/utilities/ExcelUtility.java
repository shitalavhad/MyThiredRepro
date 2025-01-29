package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fileInputStream;
	public  static FileOutputStream fileOutputStream;
	
	public static XSSFWorkbook workbook;
	public  static XSSFSheet sheet;
	public  static XSSFRow row;
	public  static XSSFCell cell;
	
	public static XSSFCellStyle  style;
	
	public static String path;
	
	public ExcelUtility()
	{
		this.path=path;
	}
	 public static int getRowCount(String sheetName) throws IOException
	 {
		
			fileInputStream=new FileInputStream(path);
			workbook=new XSSFWorkbook(fileInputStream);
			sheet=workbook.getSheet(sheetName);
			int rowcount = sheet.getLastRowNum();
			workbook.close();
			fileInputStream.close();
			return rowcount;
	 }
	 
	 public static int getCellCount(int rowNum,String sheetName) throws IOException
	 {
	
			fileInputStream=new FileInputStream(path);
			workbook=new XSSFWorkbook(fileInputStream);
			sheet=workbook.getSheet(sheetName);
		  int  cellCount = sheet.getRow(rowNum).getLastCellNum();  
		  workbook.close();
		  fileInputStream.close();
		  return cellCount;
	 }
	 public static String getCellData(String sheetName,int rownum,int cellnum) throws IOException
	 {
		 fileInputStream=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fileInputStream);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(cellnum);
		 
		 String data;
		 try
		 {
			//data =cell.toString();--->firestapproach
			 DataFormatter formatter=new DataFormatter();
			data= formatter.formatCellValue(cell);//return the value of a cell as a string 
		 }
		 catch(Exception e)
		 {
			 data="  ";
		 }
		 workbook.close();
		 fileInputStream.close();
		 return data;
	 }
	 
	 public static void setCellData(String sheetName,int rownum,int cellnum ,String data) throws IOException
	 {
		 fileInputStream=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fileInputStream);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rownum);
		 
		cell= row.createCell(cellnum);
		cell.setCellValue(data);
		//cell= row.getCell(cellnum);
		 fileOutputStream=new FileOutputStream(path);
		 workbook.write(fileOutputStream);
		 workbook.close();
		 fileInputStream.close();
		 fileOutputStream.close(); 
	 }
	 
	 public static  void fillGreenColor(String sheetName,int rownum,int cellnum) throws IOException
	 {
	    fileInputStream=new FileInputStream(path)  ;
	    workbook= new XSSFWorkbook(fileInputStream);
	    sheet=workbook.getSheet(sheetName);
	    row=sheet.getRow(rownum);
	   cell= row.getCell(cellnum);
	   
	  style= workbook.createCellStyle();
	  style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	  
	  cell.setCellStyle(style);
	  fileOutputStream=new FileOutputStream(path);
	  workbook.write(fileOutputStream);
	  workbook.close();
	  fileInputStream.close();
	  fileOutputStream.close();
	 }
	 
	 public static  void fillRedColor(String sheetName,int rownum,int cellnum) throws IOException
	 {
	    fileInputStream=new FileInputStream(path)  ;
	    workbook= new XSSFWorkbook(fileInputStream);
	    sheet=workbook.getSheet(sheetName);
	    row=sheet.getRow(rownum);
	   cell= row.getCell(cellnum);
	   
	  style= workbook.createCellStyle();
	  style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	  
	  cell.setCellStyle(style);
	  fileOutputStream=new FileOutputStream(path);
	  workbook.write(fileOutputStream);
	  workbook.close();
	  fileInputStream.close();
	  fileOutputStream.close();
	 }
}
