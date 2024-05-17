
package readDataFromExeclSheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelDemo {

	public static void main(String[] args) throws IOException {
		
		//create blank workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//create the sheet
		
		XSSFSheet sheet = workbook.createSheet("emp info");
		
		//taking object 2dimentional array
		Object empdata[][]= { { "EmpID" ,"Name","Job"},
				                                {   101,"shital","QA"},
				                                {   102,"vaibhav","Tester"},
				                                {   103,"vinayak","devloper"},
				                                {   104,"prajakta","SrumMaster"}
		                                        };
		//using normal for loop
		int rows=empdata.length;
		int cols=empdata[0].length;
		System.out.println(rows);//4
		System.out.println(cols);//3
		for(int r=0;r<rows;r++)
		{
			 XSSFRow row = sheet.createRow(r);
			 for(int c=0;c<cols;c++)
			 {
				XSSFCell cell = row.createCell(c);
				Object value=empdata[r][c];
				if(value instanceof String)
					cell.setCellValue((String) value);
				if(value instanceof Integer)
					cell.setCellValue((Integer) value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean) value);
				
			 }
		}
		//String filepath="‪‪C:\\Users\\SAI\\Desktop\\TestData\\Employ.xlsx";
		String  filepath="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\Employee.xlsx";
		//String filepath="‪C:\\\\Users\\\\SAI\\\\Desktop\\\\TestData\\\\loginData1.xlsx";
		FileOutputStream fileInputStream=new FileOutputStream(filepath);
		workbook.write(fileInputStream);
		fileInputStream.close();
		System.out.println("file create sucessfully====");
			
	}

}
