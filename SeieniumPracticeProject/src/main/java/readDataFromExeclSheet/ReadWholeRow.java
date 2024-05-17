package readDataFromExeclSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWholeRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//create the instance of the FileInputStream
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx");
		
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet=book.getSheet("Sheet1");
		for(int i=0;i<=1;i++)
		{
			for(int j=0;j<=1;j++)
			{
			String value=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(value+"  ");
			}
			
		}
		
		
		

	}

}
