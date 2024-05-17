package studyForxmlFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XML_File_Study {
	 static WebDriver driver;
	@Test
	public void openApplication()
	{
		WebDriverManager.chromedriver().setup();
		
	   driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test
	public void login() {
		WebElement emaliIDField=driver.findElement(By.xpath("//input[@name='username']"));
		emaliIDField.sendKeys(" Admin");
		
		WebElement passWordField=driver.findElement(By.xpath("//input[@name='password']"));
		passWordField.sendKeys("admin123");
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
	}
	@Test
	public void verifyMyInfo()
	{
		WebElement text=driver.findElement((By.xpath("//span[@class='oxd-userdropdown-tab']")));
		System.out.println("actuat Text Is: "+text.getText());
		
	}
	@Test
	public void myInfoDisplay()
	{
		WebElement myInfo=driver.findElement(By.xpath("(//span[contains(@class,'oxd-text oxd-text')])[6]"));
		myInfo.click();
		WebElement info=driver.findElement(By.xpath("//div[@class='oxd-layout-context']"));
		System.out.println(info.isDisplayed());
		
	}
	@Test
	public void openFaceBookApplication()
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	}

}
