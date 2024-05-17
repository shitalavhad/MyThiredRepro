package readDataFromExeclSheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExeclSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//create the object of the FileInptStream and pass the File path
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx");
		//File file=new File("‪‪C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx");
		
	//	String value1=WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		//System.out.println(value1);
		Sheet sheet = WorkbookFactory.create(fileInputStream).getSheet("Sheet1");
		String value = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(value);
		
		//fetch second value
		Sheet sheet1=WorkbookFactory.create(fileInputStream).getSheet("Sheet1");
		 double value1 = sheet1.getRow(0).getCell(1).getNumericCellValue();
		System.out.println(value1);

	
	}
	

}
