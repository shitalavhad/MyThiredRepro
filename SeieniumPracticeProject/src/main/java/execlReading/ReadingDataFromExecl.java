package execlReading;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExecl {
	

	public static void main(String[] args) throws IOException {
	//String path="‪C:\\Users\\SAI\\Desktop\\TestData\\data.xlsx"	;
		String execlFilePath="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";

	FileInputStream fileInputStream;

		fileInputStream = new FileInputStream(execlFilePath);

		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		
		XSSFSheet sheet=workbook.getSheet("Sheet5");
		
		int totleRowCount=sheet.getLastRowNum();
		int totleColumeCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Totle row count is:"+totleRowCount);
		System.out.println("Totle cell count is :"+totleColumeCount);
		
		for(int r=0;r<=totleRowCount;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c< totleColumeCount;c++)
			{
				XSSFCell cell=row.getCell(c);
				//System.out.print(cell.getErrorCellString().toString()+"/t");
				System.out.print(cell.toString()  +"\t");
		}
		System.out.println( );
		
				
	workbook.close();
	fileInputStream.close();
		
		
			}
		}
		
		
		
	

	

	}


