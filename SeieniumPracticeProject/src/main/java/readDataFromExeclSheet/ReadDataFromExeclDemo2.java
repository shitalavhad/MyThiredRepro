package readDataFromExeclSheet;
import java.io.*;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExeclDemo2 {

	public static void main(String[] args) throws IOException {
		
		//provide the execl file path
		String execlFilePath="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		FileInputStream fileInputStream=new FileInputStream(execlFilePath);
		
		//create the work book
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		
		//get the sheet
		//XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//get the row and colum
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(rows).getLastCellNum();
		
		//using for loop
		for(int r=0;r<=rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell = row.getCell(c);
				switch(cell.getCellType())
				{
				case STRING:System.out.print(cell.getStringCellValue()); break;
				case NUMERIC:System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print("    :  ");
			}
			System.out.println(" ");
		}

	}

}
