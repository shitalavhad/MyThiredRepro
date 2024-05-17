package readDataFromExeclSheet;
import java.io.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulaCell {

	public static void main(String[] args) throws IOException {
	String path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
	
	//create the instance of the FileInputStream and provide the location of the file
	FileInputStream fileInputStream=new FileInputStream(path);
	
	//create the instance of the Workbook class
	XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
	
	XSSFSheet sheet=workbook.getSheet("Sheet2");
	
	int rows = sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	
	for(int r=0;r<=rows;r++)
	{
		XSSFRow row = sheet.getRow(r);
		
		for(int c=0;c<cols;c++)
		{
			XSSFCell cell = row.getCell(c);
			switch(cell.getCellType())
			{
			case STRING:System.out.print(cell.getStringCellValue());break;
			case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
			case FORMULA:System.out.print(cell.getNumericCellValue());break;
			}
			System.out.print("    I  ");
		}
		System.out.println( );
	}

	}

}
