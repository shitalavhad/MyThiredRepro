package sampleScreenShotDemo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAlertScreenshot {

	public static void main(String[] args) throws AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		WebElement submitButton=driver.findElement(By.xpath("//input[@name='submit']"));
		
		submitButton.click();
		
		WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.alertIsPresent());
		getScreenshotRobot(1);
		driver.quit();
		
		
		
		
		
		

	}
	public static void getScreenshotRobot(int i) throws AWTException, IOException
	{
		Robot robot=new Robot();
		
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(dimension);
		BufferedImage bufferdImage = robot.createScreenCapture(rect);
		String path=System.getProperty("user.dir")+"\\screenshot\\alertRobotImage"+i+".png";
		File dest=new File(path);
		ImageIO.write(bufferdImage, "png", dest);
		
		
	}

}
