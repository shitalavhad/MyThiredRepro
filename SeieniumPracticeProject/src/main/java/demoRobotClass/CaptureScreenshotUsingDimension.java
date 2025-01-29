package demoRobotClass;

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

public class CaptureScreenshotUsingDimension {
	public static void main(String[] args) throws AWTException, IOException {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://tutorialsninja.com/demo/");
	
	//capture screenshot using robot class
	Robot robot=new Robot();
    Dimension	dimension=Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle rect=new Rectangle(dimension);
    BufferedImage bufferdImage = robot.createScreenCapture(rect);
    File sreFile=new File("./screenshot/robotDimension.png");
    ImageIO.write(bufferdImage, "PNG", sreFile);
	
}

}
