package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	static  FileInputStream fileInputStream;
	static FileOutputStream fileOutputStream;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static String path=null;
	public XLUtility(String path)
	{
		this.path=path;
	}
//row count
	public  int getRowCount(String sheetName) throws IOException
	{
	 	fileInputStream=new FileInputStream(path);
		
		//workbook
		workbook=new XSSFWorkbook(fileInputStream);
		
		//sheet
		sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
	//count cols
	public  int getCellCount(String sheetName,int rownum) throws IOException
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
	//get cell dat
	public   String getCellData(String sheetName,int rownum,int colsnum) throws IOException
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
