package excelSheetStudy;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromeExcelSheet {
	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	
	@Test
	public void readDataFromeExcelSheet()
	{
		String path="D:\\testData\\testData1.xlsx";
		//path of excel where excetly youer file present on youer local machine
		try {
		 fileInputStream=new FileInputStream(path);
		
	    workbook=new XSSFWorkbook(fileInputStream);//get workbook

		XSSFSheet sheet=workbook.getSheet("Sheet1");//get sheet --->getSheetAt(0)--->using the index
		
		//number of row
		 int rowCount=sheet.getLastRowNum();
		 
		 //number of cell
		int  cellCount = sheet.getRow(0).getLastCellNum();
		 
		 System.out.println("How many row is there : "+rowCount);//--->4
		 System.out.println("How manay cell is there :"+cellCount);//---->3
		 
		 for(int i=0;i<=rowCount;i++)
		 {
			 XSSFRow row = sheet.getRow(i);
			 for(int j=0;j<cellCount;j++)
			 {
				XSSFCell cell = row.getCell(j);
		     System.out.print(  cell.toString() +  "\t");
			 }
			 System.out.println("    ");
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				workbook.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
