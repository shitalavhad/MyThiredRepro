package dataDrivenTestingP;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	
	@DataProvider(name="loginData")
   public Object[][] getData() throws IOException
   {
		String path="D:\\testData\\loginData.xlsx";
		
		ExcelUtilities xils=new ExcelUtilities(path);
		
		int rows = xils.getRowCount("Sheet1");
		int cols = xils.getCellCount("Sheet1", 1);
		
		Object[][] logindata=new Object[rows][cols];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				logindata[i-1][j]=xils.getCellData("Sheet1", i, j);
			}
		}
   	return logindata;	
}
}