package excelSheetStudy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataIntoExcel {
	
	@Test
	public void writeDataIntoExcel()
	{
		//String path="D:\\testData\\testData1.xlsx";
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("D:\\testData\\testData2.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook();
			
			XSSFSheet sheet = workbook.createSheet("Sheet2");
			XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("shital");
			row1.createCell(1).setCellValue(1234);
			row1.createCell(2).setCellValue("Automation");
			
			XSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("Valibhav");
			row2.createCell(1).setCellValue(5673);
			row2.createCell(2).setCellValue("Manul");
			
			XSSFRow row3=sheet.createRow(2);
			row3.createCell(0).setCellValue("Mayank");
			row3.createCell(1).setCellValue(8910);
			row3.createCell(2).setCellValue("Automation");
			
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("File is succesfully created");
	}

}
