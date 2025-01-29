package studyDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class SelectOptionFromeDropDown {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("https://www.facebook.com/");

WebElement createNewAccountButton=driver.findElement(By.xpath("//a[contains(@id,'u_')]"));
createNewAccountButton.click();

WebElement monthDrp=driver.findElement(By.xpath("//select[@id='month']"));
Select sc=new Select(monthDrp);
sc.selectByIndex(1);

WebElement yearDrp=driver.findElement(By.xpath("//select[@id='year']"));
Select sc1=new Select(yearDrp);
sc1.selectByValue("2020");

WebElement dayDrp=driver.findElement(By.xpath("//select[@id='day']"));
Select sc2=new Select(dayDrp);
sc2.selectByVisibleText("6");

driver.quit();
	}

}
