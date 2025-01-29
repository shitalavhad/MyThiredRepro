package excelSheetStudy;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoReadDataFromeExcel {
	   
	public static void main(String[] args) throws IOException {
		//file path
		String path="D:\\testData\\testData1.xlsx";
		try
		{
			//open the file in reading mode
		  FileInputStream	 fileInputStream=new FileInputStream(path);
			
			//get the workbook frome file
			XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
			
			//get the sheet from workbook
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			//get last row frome sheet
			int rowNum=sheet.getLastRowNum();
			System.out.println("Number of row :"+rowNum);
			
			//get cell from row
			int cellNum=sheet.getRow(1).getLastCellNum();
			System.out.println("Number of cell"+cellNum);
			
			//retrive the data fromeexeclsheet
			for(int r=0;r<=rowNum;r++)
			{
				XSSFRow currentRow=sheet.getRow(r);
				for(int c=0;c<cellNum;c++)
				{
					XSSFCell cueerntCell=currentRow.getCell(c);
					System.out.print(cueerntCell.toString()      +   "\t");
				}
				System.out.println(      );
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
			
			
	

	}

}
