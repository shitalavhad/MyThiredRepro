package readDataFromExeclSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormattingCellColor {

	public static void main(String[] args) throws IOException {
		//CREATE WOORKBOOK
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//creatr sheet
		XSSFSheet sheet=workbook.createSheet("Sheet1");
		
		//create row
		XSSFRow row=sheet.createRow(1);
		
		//background color
		XSSFCellStyle style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		
		//create cell
	  XSSFCell cell	=row.createCell(1);
	  cell.setCellValue("Welcome");
	  cell.setCellStyle(style);
	  
	  //setting Forground color
	  style=workbook.createCellStyle();
	  style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	  style.setFillPattern(FillPatternType.SPARSE_DOTS);
	  cell=row.createCell(2);
	  cell.setCellValue("Automations");
	  cell.setCellStyle(style);
	  
	  String path="C:\\Users\\SAI\\eclipse-workspace\\SeieniumPracticeProject\\src\\test\\resources\\dataFiles\\style.xlsx";
	  
	  FileOutputStream fileOutputStream=new FileOutputStream(path);
	  workbook.write(fileOutputStream);
	  workbook.close();
	  fileOutputStream.close();
	  System.out.println("Done !!!!!");
	}

}
