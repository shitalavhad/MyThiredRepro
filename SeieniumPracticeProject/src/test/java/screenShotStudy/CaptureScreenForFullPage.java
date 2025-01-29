package screenShotStudy;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenForFullPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32 (6)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		try {
		Robot rb=new Robot();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle r=new Rectangle(d);
		BufferedImage bufferImage = rb.createScreenCapture(r);
		String path="D:\\Screenshot\\fullScreen.png";
		File target=new File(path);
		ImageIO.write(bufferImage, "png", target);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
