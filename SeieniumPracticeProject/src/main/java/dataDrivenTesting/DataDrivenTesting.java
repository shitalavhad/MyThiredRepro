package dataDrivenTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@Test(dataProvider="loginData")
	public void loginTest(String user,String pwd,String exp)
	{
		//System.out.println(user    +pwd   +exp);
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		email.sendKeys(user);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		loginButton.click();
		
		String expTitle="Dashboard / nopCommerce administration";
		String actualTitle=driver.getTitle();
		
		//assertEquals(actualTitle,expTitle,"not matching");
		if(exp.equals("valid"))
		{
		   if(expTitle.equals(actualTitle))
		   {
			   driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
			   assertTrue(true);
		   }
		   else
		   {
			   assertTrue(false);
		   }
		   
		}
		else if(exp.equals("invalid"))
		{
			  if(expTitle.equals(actualTitle))
			  {
				  driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
				  assertTrue(false);
			  }
			  else
			  {
				  assertTrue(true);
			  }
		}
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="loginData")
	public Object[][] loginData() throws IOException
	{
		/*Object [][] data= {
				{"admin@yourstore.com","admin","valid"},
				{"admin@yourstre.com","admn","invalid"},
				{"admin@yourstoe.com","adin","invalid"}	
	};*/
		//String path=‪"‪C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		
		String path="C:\\Users\\SAI\\Desktop\\TestData\\loginData.xlsx";
		XLUtility utility=new XLUtility (path);
		
		//no of row
		int totleRow = utility.getRowCount("Sheet3");
		int totleCols = utility.getCellCount("Sheet3", 1);
		
		Object [] [] data=new Object[totleRow][totleCols];
		for(int r=0;r<totleRow;r++)
		{
			for(int c=0;c<totleCols;c++)
			{
				data[r-1][c]=utility.getCellData("Sheet3", r, c);
			}
		}
		
		
		
		return data;
}
	
	
}

