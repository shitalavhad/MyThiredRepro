package excelSheetDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("D:\\AutomationData\\testData.xlsx");
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet3");
		int rowNumber=sheet.getLastRowNum();
		int cellNumber=sheet.getRow(1).getLastCellNum();
		System.out.println("Totle row number :"+rowNumber  +"Totle cell number :"+cellNumber);
		for(int r=0;r<=rowNumber;r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<cellNumber;c++)
			{
				XSSFCell currentCell = currentRow.getCell(c);
			//	System.out.print(currentCell.toString()  +          "\t");
				CellType cellType = currentCell.getCellType();
				switch(cellType) {
				case STRING:System.out.print(currentCell.getStringCellValue()  + "    ");break;
				case BOOLEAN:System.out.print(currentCell.getBooleanCellValue() + "    ");break;
				case NUMERIC:System.out.print(currentCell.getNumericCellValue()+ "     ");break;
				   
			}
				
			}
			System.out.println("                   ");
		}
		
		}
		

	}


