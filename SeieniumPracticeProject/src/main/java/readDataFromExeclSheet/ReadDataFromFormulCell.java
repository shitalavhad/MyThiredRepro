package readDataFromExeclSheet;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulCell {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileInputStream fileInputStream;
	static String path;
	public static void main(String[] args) throws IOException {
		path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		fileInputStream=new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fileInputStream);
		
		sheet=workbook.getSheet("Sheet2");
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{
		row	=sheet.getRow(r);
		for(int c=0;c<cols;c++)
		{
		cell	=row.getCell(c);
		switch(cell.getCellType())
		{
		case STRING:System.out.print(cell.getStringCellValue());break;
		case NUMERIC:System.out.print(cell.getNumericCellValue());break;
		case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
		case FORMULA:System.out.print(cell.getNumericCellValue());break;
		}
		System.out.print("    :: ");
		}
		System.out.println(" ");
		}
		
		
		
		

	}

}
