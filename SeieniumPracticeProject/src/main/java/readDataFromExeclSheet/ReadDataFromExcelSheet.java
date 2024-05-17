package readDataFromExeclSheet;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
      //first provide the destination location of file
		
		String execlFilePath="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		//create the instance of the FileInputStream and the pass the path as a argument
		FileInputStream fileInputStream=new FileInputStream(execlFilePath);
		
		//create the instance of the Workbook class
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		
		//get the sheet
	    XSSFSheet	sheet=workbook.getSheet("Sheet1");
	    //once get the sheet then easly fech the row and cols
	    int rows=sheet.getLastRowNum();
	    
				

	}

}
