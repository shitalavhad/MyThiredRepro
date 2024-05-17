package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class ForgottenPasswordPage {
	
	//declare the variable-->WebElement
	@FindBy(xpath="//div[@class='_9nq2 marginBottom16px']")
	private WebElement textMessage;
	
	@FindBy(xpath="//input[@id='identify_email']")
	private WebElement emailAddressOrMobileNumber;
	
	@FindBy(xpath="//a[contains(@class,'_42ft _4jy0 _9nq1 text')]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//button[@id='did_submit']")
	private WebElement searchButton;
	
	//constuctor
	//driver=driverTest=new ChromeDriver
	public ForgottenPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void getTextMessage()
	{
		String myText=textMessage.getText();
		System.out.println("page text is : "+myText);
	}
	
	public void sendEmailAddressOrMobileNumber()
	{
		emailAddressOrMobileNumber.sendKeys("9673002305");
	}
	
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	
	public void clickOnSearchButton()
	{
		 searchButton.click();
	}

}
