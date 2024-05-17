package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomClasses.ForgottenPasswordPage;
import pomClasses.LoginOrSignupPage;

public class TestClass2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  
		  WebDriver driverTest=new ChromeDriver();
		  
		  driverTest.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		  driverTest.manage().window().maximize();
		  
		  driverTest.get("https://facebook.com/");
		  
		  //navigation step
		  LoginOrSignupPage loginOrSignupPage=new LoginOrSignupPage(driverTest);
		  loginOrSignupPage.sendEmailAddressOrPhoneNo();
		  loginOrSignupPage.sendPassword();
		  loginOrSignupPage.clickOnForgottenPasswordLink();
		  
		  
		  ForgottenPasswordPage forgottenPasswordPage=new ForgottenPasswordPage(driverTest);
		  forgottenPasswordPage.getTextMessage();
		  forgottenPasswordPage.sendEmailAddressOrMobileNumber();
		  forgottenPasswordPage.clickOnCancelButton();
		  

	}

}
