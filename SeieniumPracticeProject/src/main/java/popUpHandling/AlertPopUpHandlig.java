package popUpHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

public class AlertPopUpHandlig {
	static Alert alt;

	public static void main(String[] args) throws InterruptedException {
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
       //open the application
		//driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
	//	driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		
		/*WebElement clickMeButton=driver.findElement(By.xpath("//button[@id='alertBox']"));
		clickMeButton.click();
		
		Thread.sleep(1000);
		//displayed the alert
	   	alt=driver.switchTo().alert();
	   alt.accept();//yes,approved,agree
	  System.out.println(alt.getText());*/
		/*WebElement clickMeButton1=driver.findElement(By.xpath("//button[@id='confirmBox']"));
		clickMeButton1.click();
		alt.dismiss();*/
		//driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
		//driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		//alt=driver.switchTo().alert();
	 // System.out.println(	alt.getText());
	//  alt.accept();
	//	alertHandling(driver);
	/*	driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		alt=driver.switchTo().alert();
		System.out.println("alert text :");
		alt.dismiss();*/
		WebElement button = driver.findElement(By.xpath(("//button[@id='sub-menu']")));
		Actions act=new Actions(driver);
		act.moveToElement(button).moveToElement(driver.findElement(By.xpath("//a[@id='link2']"))).click().build().perform();
		
		

	}
	public static void alertHandling(WebDriver driver)
	{
		alt=driver.switchTo().alert();
	    System.out.println("Alert text :"+alt.getText());
	    alt.accept();
	}

}
