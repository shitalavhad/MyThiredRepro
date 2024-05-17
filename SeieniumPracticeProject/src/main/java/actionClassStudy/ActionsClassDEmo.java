package actionClassStudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassDEmo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		//dragAndDropOperatons
		Actions act=new Actions(driver);
		WebElement oslaCapital=driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement norwayCity=driver.findElement(By.xpath("//div[@id='box101']"));
		//act.clickAndHold(oslaCapital).moveToElement(norwayCity).release().build().perform();
		act.dragAndDrop(oslaCapital, norwayCity).perform();
		
		WebElement romeCapital=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
		act.dragAndDrop(romeCapital, italy).perform();
		

	}

}
