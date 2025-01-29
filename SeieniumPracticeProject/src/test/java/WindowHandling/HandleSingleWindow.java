package WindowHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class HandleSingleWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");
 WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
openNewWindowButton.click();

//get parentWindow adress
String parentWindowAddress=driver.getWindowHandle();

//get all Window Address
Set<String>address=driver.getWindowHandles();

List<String > handles=new ArrayList<String>(address);
for(String handle: handles)
{
	if(!handles.equals(parentWindowAddress))
	{
		driver.switchTo().window(handle);
		String childWindowTilte=driver.getTitle();
		System.out.println("ChildWindowTitle:"+ childWindowTilte);
		driver.close();
	}
}
driver.switchTo().window(parentWindowAddress);
String parentWindowTitle=driver.getTitle();
System.out.println("ParentWindowTitle :Title"+parentWindowTitle);
driver.quit();


			

	}

}
