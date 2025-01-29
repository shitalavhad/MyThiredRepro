package dataDrivenTestingP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public  FileInputStream fileInputStream;
	public FileOutputStream fileOutputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public  XSSFRow row;
	public XSSFCell cell;
	public String path=null;
	public ExcelUtilities(String path)
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
	public int getCellCount(String sheetName,int rownum) throws IOException
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
	//set cell data
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
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
		
		if(workbook.getSheetIndex(sheetName)==-1)//if sheet not exist then create new sheet
			workbook.createSheet(sheetName);
		  sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)//if row not exist create new row
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		fileOutputStream=new FileOutputStream(path);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
		System.out.println("sucess====");
			
	}
}
