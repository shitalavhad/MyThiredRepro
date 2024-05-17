package readDataFromExeclSheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writeopreation {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileOutputStream fileOutputStream;
	static FileInputStream fileInputStream;
	static String path;

	public static void main(String[] args) throws IOException {
		//create workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//crete sheet
	//	XSSFSheet sheet = workbook.createSheet("Test");
		path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		setCellData("Sheet1", 0, 0, "shital");
		
		

	}
	public static void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		fileInputStream =new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInputStream);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		fileOutputStream= new FileOutputStream(path);
		workbook.write(fileOutputStream);
		workbook.close();
		fileOutputStream.close();
	}

}
