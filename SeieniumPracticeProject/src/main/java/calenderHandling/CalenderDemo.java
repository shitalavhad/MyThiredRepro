package calenderHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		 Scanner sc=new Scanner(System.in);
	      System.out.println("Enter any date :");
	     String userInput =sc.nextLine();
	     sc.close(); 
	     
      WebDriverManager.chromedriver().setup();
      
      WebDriver driver=new ChromeDriver();
      
      driver.manage().window().maximize();
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      driver.get("https://www.path2usa.com/travel-companion/");
      
      WebElement dateField=driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
      JavascriptExecutor js=(JavascriptExecutor)driver;
      js.executeScript("arguments[0].scrollIntoView();", dateField);
  	Thread.sleep(1000);
      dateField.click();
      
    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate ld = LocalDate.parse(userInput, dtf);
    int day = ld.getDayOfMonth();
   int month=ld.getMonthValue();
   
   int year=ld.getYear();
   
   WebElement currentYearElement=driver.findElement(By.xpath("//input[@class='numInput cur-year']"));
 String currentYearText = currentYearElement.getAttribute("min");
 int currentYear=Integer.parseInt(currentYearText);
 
 WebElement currentMonthElement=driver.findElement(By.xpath("//span[@class='cur-month']"));
 String currentMonthOrg=currentMonthElement.getText();
 String currentMonthText=currentMonthOrg.trim();
Calendar cal= Calendar.getInstance();
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");


cal.setTime(null);
   
      while(currentYear!=year)
      {
    	  WebElement arrowUpElement=driver.findElement(By.xpath("//span[@class='arrowUp']"));
    	  arrowUpElement.click();
    	  currentYearElement=driver.findElement(By.xpath("//input[@class='numInput cur-year']"));
    	  currentYearText = currentYearElement.getAttribute("min");
    	  currentYear=Integer.parseInt(currentYearText);
      }
      
      
      
	}

}
