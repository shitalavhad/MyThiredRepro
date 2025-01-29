package popUpHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class AlertHandling {

	public static void main(String[] args) {
   System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://demo.automationtesting.in/Alerts.html");
	
	//handling simple alert
	/*WebElement alertWithOkButton=driver.findElement(By.xpath("//a[text()='Alert with OK ']"));
	alertWithOkButton.click();
	
	WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	System.out.println(button.getText());
	button.click();
	
	Alert alt=driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.accept();*/
	
	//handle confirmation alert
	WebElement alertWithOkCancleButton=driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
	alertWithOkCancleButton.click();
	
	WebElement button=driver.findElement(By.xpath("(//button[contains(@class,'btn btn')])[2]"));
	System.out.println(button.getText());
	button.click();
	
	Alert alt=driver.switchTo().alert();
	alt.dismiss();
	
	driver.quit();
	
	

	}

}
