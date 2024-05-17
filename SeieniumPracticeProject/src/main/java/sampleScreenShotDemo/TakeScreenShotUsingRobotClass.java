package sampleScreenShotDemo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotUsingRobotClass {

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub4
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		Robot robot=new Robot();
		
	    Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
	    Rectangle react=new Rectangle(dimension);
	   BufferedImage buffredImage = robot.createScreenCapture(react);
	  String path=System.getProperty("user.dir")+"//screenshot//robotImage.png";
	  File destFile=new File(path);
	  ImageIO.write(buffredImage, "png", destFile);
	  
	  driver.quit();
		

	}

}
