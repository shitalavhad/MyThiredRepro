package excelSheetDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enetr row number here");
		int row = sc.nextInt();
		System.out.println("Enter cell number here");
		int cell=sc.nextInt();
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\teatData\\file.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("sheet1");
		
		for(int r=0;r<=row;r++)
		{
			XSSFRow currentRow = sheet.createRow(r);
			for(int c=0;c<cell;c++)
			{
				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created_______________");
		

	}

}
