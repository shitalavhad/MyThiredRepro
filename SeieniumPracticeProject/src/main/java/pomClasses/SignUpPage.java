package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	private WebDriver driver;
	//variable
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement sureName;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement emailAddressOrMobileNumber;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newPasswordField;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement dayDrp;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement monthDrp;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement yearDrp;
	
	@FindBy(xpath="(//input[@name='sex'])[1]")
	private WebElement femaleRadioButton;
	
	@FindBy(xpath="(//input[@name='sex'])[2]")
	private WebElement maleRadioButton;
	
	@FindBy(xpath="(//input[@name='sex'])[3]")
	private WebElement customRadioButton;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement signUpButton;
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//methods
	public void sendFirstName()
	{
		firstName.sendKeys("shital");
	}
	
	public void sendSureName()
	{
		sureName.sendKeys("avhad");
	}
	public void sendEmailAddressOrMobileNumber()
	{
		emailAddressOrMobileNumber.sendKeys("9673002305");
	}
	
	public void sendNewPassword()
	{
		newPasswordField.sendKeys("shital@123");
	}
  public void selectValueFromDayDrp()
  {
	  Select sc=new Select(dayDrp);
	  sc.selectByIndex(1); 
  }
  public void selectValueFromMonthDrp()
  {
	  Select sc=new Select(monthDrp);
	  sc.selectByIndex(1);
  }
  public void selectValueFromYearDrp()
  {
	  Select sc=new Select(yearDrp);
	  sc.selectByIndex(1);
  }
  public void clickOnFemaleRadioButton()
  {
	  femaleRadioButton.click();
  }
  public void clickOnmaleRadioButton()
  {
	  maleRadioButton.click();
  }
  public void clickOncustomRadioButton()
  {
	  customRadioButton.click();
  }
	
}