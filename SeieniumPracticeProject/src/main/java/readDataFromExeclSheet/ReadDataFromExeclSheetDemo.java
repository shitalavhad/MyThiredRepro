package readDataFromExeclSheet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExeclSheetDemo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String execlFilePath="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		FileInputStream fileInputStream=new FileInputStream(execlFilePath);
		
		//get Workbook
	  XSSFWorkbook workbook=new XSSFWorkbook (fileInputStream);
	 XSSFSheet sheet = workbook.getSheet("Sheet1");
	 
	/* //for loop
	 int rows = sheet.getLastRowNum();
	 short  cols = sheet.getRow(0).getLastCellNum();
	 for(int r=0;r<rows;r++)
	 {
		XSSFRow row = sheet.getRow(r);
		for(int c=0;c<cols;c++)
		{
			 XSSFCell cell=row.getCell(c);
			 switch(cell.getCellType())
			 {
			 case STRING:System.out.print(cell.getStringCellValue()); break;
			 case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			 case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
			 }
			 System.out.print("  ");
		}
		System.out.println( );
	 }*/
	 /////////////////Iterater/////////////////////////////////////////////
	 Iterator   iterator = sheet.iterator();
	 while(iterator.hasNext())
	 {
		 XSSFRow row = (XSSFRow) iterator.next();
		Iterator  cellIterator = row.cellIterator();
		while(cellIterator.hasNext())
		{
			XSSFCell cell=(XSSFCell) cellIterator.next();
			switch(cell.getCellType())
			 {
			 case STRING:System.out.print(cell.getStringCellValue()); break;
			 case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			 case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
			 }
			System.out.print( "  l  ");
		}
		System.out.println( );
	 }
		
		
		
	}

}
