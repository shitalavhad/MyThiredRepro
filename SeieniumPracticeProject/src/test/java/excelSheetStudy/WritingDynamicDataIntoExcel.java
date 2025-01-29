package excelSheetStudy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class WritingDynamicDataIntoExcel {
	
	@Test
	public void writeDynamicDataIntoExecl()
	{
		//open the sheet in writing mode
		String path="D:\\testData\\testData3D.xlsx";
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(path);
			
			//create the sheet
			XSSFWorkbook workbook=new XSSFWorkbook();
			
			//create sheet
			XSSFSheet sheet = workbook.createSheet("data");
			
			//take the data frome user
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter how many rows?");
			int noOfrows = sc.nextInt();
			
			System.out.println("Enter how many cells");
		   int noOfCells = sc.nextInt();
		   
			for( int r=0;r<=noOfrows;r++)
			{
				XSSFRow currentRow = sheet.createRow(r);
				for(int c=0;c< noOfCells ;c++)
			   
				{
					XSSFCell cell = currentRow.createCell(c);
					cell.setCellValue(sc.next());
				}
			}
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
