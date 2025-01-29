package table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://practice.expandtesting.com/dynamic-table");

	}

}
