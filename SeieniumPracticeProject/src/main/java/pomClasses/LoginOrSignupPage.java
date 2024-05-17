package pomClasses;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrSignupPage {
	private WebDriver driver;
	private Actions act;
	private JavascriptExecutor js;
	private WebDriverWait ewait;
	
	
	//declare the variable as WebElement accessModifire private
	@FindBy(xpath="//input[@id='email']")
	private WebElement  emailAddressOrPhoneNoField;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[contains(@class,'_42ft _4jy0 _6lti ')]")
	private WebElement createNewAccountButton;
	
	@FindBy(xpath="//div[@class='_6ltj']//a")
	private WebElement forgottenPasswordLink;
	
	@FindBy(xpath="//div[@id='pageFooter']")
	private List<WebElement> links;
	
	@FindBy(xpath="//a")
	private List<WebElement> links1;
	
	//initalize the webelement---accesslevel public
	public LoginOrSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    this.	driver=driver;
	    act=new Actions(driver);
	    js=(JavascriptExecutor)driver;
	    ewait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//method--actions
	public void sendEmailAddressOrPhoneNo()
	{
		//emailAddressOrPhoneNoField.sendKeys("avhadshital");
		
		//sendKeys using Actions class
		//act.sendKeys(emailAddressOrPhoneNoField, "avhadshital").perform();;
	
		//apply the wait
		ewait.until(ExpectedConditions.visibilityOf(emailAddressOrPhoneNoField));
		
		//sendKeys method using javascriptExecutor
		js.executeScript("arguments[0].value='shitalavhasd';", emailAddressOrPhoneNoField);
		
	}
	
	public void sendPassword()
	{
		// passwordField.sendKeys("shital2123");
		//sendKeys using Actions class
		//act.sendKeys(passwordField, "shital123").perform();;
		
		//sendKeys using javascriptExecutor
		js.executeScript("arguments[0].value='shital123';", passwordField);
	}
	
	public void clickOnLoginButton()
	{
		//loginButton.click();
		
		//click usind ActionsClass
		//act.click(loginButton).perform();;
		
		//click using javascriptExecutor
		js.executeScript("arguments[0].click();", loginButton);
	}
	
	public void clcikOnCreateNewAccountButton()
	{
		//createNewAccountButton.click();
		//act.click(createNewAccountButton).perform();;
		
		//click using javascriptExecutor
		js.executeScript("arguments[0].click();", createNewAccountButton);
	}
	
	public void clickOnForgottenPasswordLink()
	{
		//forgottenPasswordLink.click();
		//act.click(forgottenPasswordLink).perform();;
		
		//click using javascriptExecutor
		js.executeScript("arguments[0].click();",forgottenPasswordLink );
		
	}
	public void getAllLinks()
	{
		for(WebElement e:links)
		{
			System.out.println("links :"+e.getText());
		}
	}
	
	public String getLink(int index)
	{
		String attribute=links1.get(index).getAttribute("href");
		System.out.println(attribute);
		return attribute;
	}

}
