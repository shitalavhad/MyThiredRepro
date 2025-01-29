package screenShotStudy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;


public class CaptureScreenshotUsingRobotClass {

	public static void main(String[] args) throws AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.facebook.com/");
		
	/*	Robot rb=new Robot();
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle r=new Rectangle(d);
		BufferedImage bufferImage = rb.createScreenCapture(r);
		
		String path=System.getProperty("user.dir")+"\\screenshot\\"+"myScreen.jpg";
		File targetLocation=new File (path);
		
		ImageIO.write(bufferImage, "jpg", targetLocation);*/
		captureScreeRobot("robot");
		
      
	}
	public static String captureScreeRobot(String tname) throws AWTException, IOException
	{
		String timeStamp=new SimpleDateFormat("YYYY.MM.dd.hh.mm").format(new Date());
        Robot rb=new Robot();
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle r=new Rectangle(d);
		BufferedImage bufferImage = rb.createScreenCapture(r);
		
		String path=System.getProperty("user.dir")+"\\screenshot\\"+tname+"-"+".png";
		File targetLocation=new File (path);
		
		ImageIO.write(bufferImage, "png", targetLocation);
		return path;
		
	}

}
