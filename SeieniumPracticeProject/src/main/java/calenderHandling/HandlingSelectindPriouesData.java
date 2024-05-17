package calenderHandling;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSelectindPriouesData {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data in this formate : dd/MM/yyyy");
	   String userInput	=sc.nextLine();
	   sc.close();
	   
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	   LocalDate ld = LocalDate.parse(userInput,dtf);
	   
	  int expectedMonth= ld.getMonthValue();
	  System.out.println(expectedMonth);
	  // Month month = ld.getMonth();
	  // String expectedMonth = month.toString();
	  // System.out.println("ExpectedMonth IS:"+expectedMonth);
	   
	  int year= ld.getYear();
	//  String expectedYear=String.valueOf(year);
	  int expectedYear = ld.getYear();
	  System.out.println(expectedYear);
	  
	  int day=ld.getDayOfMonth();
	  String expectedDay=String.valueOf(day);
	  System.out.println(expectedDay);
	   
		WebDriverManager.chromedriver().setup();

		 WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		WebElement dataField=driver.findElement(By.xpath("//input[@id='datepicker']"));
		dataField.click();
		
		WebElement currentMonthElement=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		String currentMonthText = currentMonthElement.getText();
		//int currentMonth = Integer.parseInt(currentMonthText);
		
		
	    WebElement currentYearElement=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
	   String currentYearText = currentYearElement.getText();
		System.out.println("Current year is: "+currentYearText);
		int currentYear = Integer.parseInt(currentYearText);
	    if(expectedYear>currentYear)
		{
			while(currentYear!=expectedYear)
			{
				WebElement nextOption=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				nextOption.click();
				 currentYearElement=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			    currentYearText = currentYearElement.getText();
				currentYear = Integer.parseInt(currentYearText);	
			}
	     	}else if(currentYear>expectedYear)
			{
	     		while(currentYear!=expectedYear)
	     		{
	     			
	     		WebElement prevOption=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
				prevOption.click();
				 currentYearElement=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			    currentYearText = currentYearElement.getText();
				currentYear = Integer.parseInt(currentYearText);	
			}
		}
	    
	/*    if(currentMonth<expectedMonth)
	    {
	    	while(currentMonth!=expectedMonth)
	    	{
	    		WebElement nextOption=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				nextOption.click();
				 currentMonthElement=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
				 currentMonthText = currentMonthElement.getText();
		         currentMonth = Integer.parseInt(currentMonthText);
				
	    	}
	    }
	    else if(currentMonth>expectedMonth)
	    {
	    	while(currentMonth!=expectedMonth)
	    	{
	    		WebElement prevOption=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
				prevOption.click();
				
				  
	    	}
	    }*/
		
	}	

}




