package excelSheetStudy;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoWriteDataIntoExcel {

	public static void main(String[] args) throws IOException {
		try {
		FileOutputStream fileOutputStream=new FileOutputStream("‪D:\\testData\\myFile.xlsx");
	    //create workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		//create sheet
		XSSFSheet sheet=workbook.createSheet("Data");
		//create row
		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("shital");
		row0.createCell(1).setCellValue("9673002305");
		row0.createCell(2).setCellValue("pune");
		
	    XSSFRow row1=sheet.createRow(1);
	    row1.createCell(0).setCellValue("vaibhav");
	    row1.createCell(1).setCellValue("9673002309");
	    row1.createCell(4).setCellValue("Mumbai");
	    
	    workbook.write(fileOutputStream);
	    workbook.close();
	    fileOutputStream.close();
	   // System.out.println("File is created......................");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		   System.out.println("File is created......................");
		
		

	}

}
