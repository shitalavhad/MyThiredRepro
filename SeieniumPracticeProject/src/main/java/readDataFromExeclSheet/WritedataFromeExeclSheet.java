package readDataFromExeclSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritedataFromeExeclSheet {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Emp Info");
		
		Object empdata[][]= {
				                                 {"EmpID","Name","Job"},  
				                                 {"101","Shital","Automation Tester"},
				                                 {"102","Vaibhav","Manager"},
				                                 {"103","Prajakta","Manual Tester"},
				                                 {"104","Vinayak","Devloper"},
		};
		int rows = empdata.length;
		int cols=empdata[0].length;
		System.out.println("Totle no of rows :"+rows);
		System.out.println("Totle no of rows :"+cols);
		
	/*	for(int r=0;r<rows;r++)
		{
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell = row.createCell(c);
				Object value = empdata[r][c];
				if(value instanceof String)
					cell.setCellValue((String) value);
				if(value instanceof Integer)
					cell.setCellValue((Integer) value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}*/
		
		//using foreach loop
		
		String filepath="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\EmployInfo.xlsx";
		FileOutputStream fileOutputFile=new FileOutputStream(filepath)	;
			workbook.write(fileOutputFile);
			//workbook.close();
			fileOutputFile.close();
			System.out.println("successfully-----------");
			
		


		
	}

}
