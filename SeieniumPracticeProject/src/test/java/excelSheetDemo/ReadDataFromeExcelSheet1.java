package excelSheetDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromeExcelSheet1 {

	public static void main(String[] args) throws IOException {
	//deal with excelsheet
		FileInputStream file=new FileInputStream("D:\\AutomationData\\testData.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		int rowNumber=sheet.getLastRowNum();
		
		int cellNumber=sheet.getRow(1).getLastCellNum();
		System.out.println("Totle no of row :"+rowNumber   +  "Totle no of cell :"+cellNumber);
		
		for(int r=0;r<=rowNumber;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cellNumber;c++)
			{
			 XSSFCell	cell=row.getCell(c);
			 System.out.print(cell.toString() +      "\t" );
			}
			System.out.println("                        ");
		}

	}

}
