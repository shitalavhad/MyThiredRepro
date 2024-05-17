package calenderHandling;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleCalenderHandling {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data: ");
		String expectedDate=sc.nextLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(expectedDate, dtf);
		
	    int month = ld.getMonthValue();
	    String expectedMonth=null;
	    if(month<10)
		   {
			   expectedMonth="0"+month;
		   }
		   else
		   {
			   expectedMonth.valueOf(month);
		   }
	     int year = ld.getYear();
	    String expectedYear = String.valueOf(year);
	   int day = ld.getDayOfMonth();
	   String expectedDay=null;
	   if(day<10)
	   {
		   expectedDay="0"+day;
	   }
	   else
	   {
		   expectedDay.valueOf(day);
	   }
	    
	   
	   
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		WebElement dataField=driver.findElement(By.xpath("//input[@id='datepicker']"));
		dataField.click();
		

		WebElement currentMonthElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[1]"));
		String currentMonth=currentMonthElement.getText();
		
		WebElement currentYearElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[2]"));
		String currentYear=currentYearElement.getText();
		
		//String expectedMonth="March";
		//String expectedYear="2025";
		//String expectedDate="29";
		
		while(!(currentMonth.equals(expectedMonth) && (currentYear.equals(expectedYear))))
		{
			WebElement nextOption=driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next ui-corner-all')]"));
			nextOption.click();
			
		    currentMonthElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[1]"));
			currentMonth=currentMonthElement.getText();
			
			currentYearElement=driver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker')])[2]"));
			currentYear=currentYearElement.getText();
		}
		String xpath="//td[@data-handler='selectDay']/a[text()='"+expectedDate+"']";
		WebElement data=driver.findElement(By.xpath(xpath));
		data.click();
		
		
	}
	public static String getMonthFromeenteredData(String userEnterdDate)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(userEnterdDate, dtf);
		
	    int month = ld.getMonthValue();
	    String expectedMonth=null;
	    if(month<10)
		   {
			   expectedMonth="0"+month;
		   }
		   else
		   {
			   expectedMonth.valueOf(month);
		   }
	   
	    return expectedMonth;
	}
	public static String getDayFromEnteredData(String userEnterdDate)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(userEnterdDate, dtf);
		
		 int day = ld.getDayOfMonth();
		   String expectedDay=null;
		   if(day<10)
		   {
			   expectedDay="0"+day;
		   }
		   else
		   {
			   expectedDay.valueOf(day);
		   }
		   return    expectedDay;
		
	}
	/*public static String getYearFromeEnterdData(String userEnteredData)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(userEnteredData, dtf);
		int year=ld.getYear();
		
		
	}*/

}
