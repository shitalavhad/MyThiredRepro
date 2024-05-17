package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomClasses.LoginOrSignupPage;
import pomClasses.SignUpPage;

public class TestClass3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  
		  WebDriver driver=new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		  driver.manage().window().maximize();
		  
		  driver.get("https://facebook.com/");
		  
		  //navigation step
		  LoginOrSignupPage loginOrSignupPage=new LoginOrSignupPage(driver);
		  //loginOrSignupPage.sendEmailAddressOrPhoneNo();
		  //loginOrSignupPage.sendPassword();
		  loginOrSignupPage.clcikOnCreateNewAccountButton();
		  
		  SignUpPage signUpPage=new SignUpPage(driver);
		  signUpPage.selectValueFromDayDrp();

	}

}
