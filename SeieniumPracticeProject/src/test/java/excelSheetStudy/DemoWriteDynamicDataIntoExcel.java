package excelSheetStudy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoWriteDynamicDataIntoExcel {
	@Test
	public void writeDataIntoExcel() throws IOException
	{
		FileOutputStream fileOutputStream=new FileOutputStream(System.getProperty("user.dir")+"\\teatData\\myFile.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook();
	    XSSFSheet	sheet =workbook.createSheet("Data");
	    Scanner sc=new Scanner(System.in);
	   int rowNum =sc.nextInt();
	   System.out.println("How many rows you want?");
	   
	   int cellNum=sc.nextInt();
	   System.out.println("how many cell you want?");
	   
	   for(int r=0;r<=rowNum;r++)
	   {
		  XSSFRow currentRow= sheet.createRow(r);
		   for(int c=0;c<cellNum;c++)
		   {
			 XSSFCell cell= currentRow.createCell(c);
			 cell.setCellValue(sc.next());
		   }
	   }
	   workbook.write(fileOutputStream);
	   workbook.close();
	   fileOutputStream.close();
	   
	    
		 
	}

}
