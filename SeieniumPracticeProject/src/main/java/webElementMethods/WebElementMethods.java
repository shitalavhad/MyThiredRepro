package webElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Colors;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;



public class WebElementMethods {

	public static void main(String[] args) {
		//lunch the browser
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//open the application
		openApplication(driver);
		
		//sendKeys method
		WebElement emailIDField=driver.findElement(By.xpath("//input[@id='email']"));
		//emailIDField.sendKeys("avhadshital8@gmail.com");
		
		
		//enterTheEmailID(driver);
		
		//using javascriptExecutor
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document. getElementById('email').value='avahdshital8@gmail.com';",emailIDField);
		//js.executeScript("arguments[0].value='avhadshital8@gmail.com';",emailIDField);
		
		//how to clear the text inside the text field
		//emailIDField.clear();
		
		//how to click on button,links.ckeakboxes
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
		String color = createNewAccountButton.getCssValue(" background-color");
		System.out.println(color);
		//Color co=Color.fromString(color);
		//System.out.println(co.asHex());
		//createNewAccountButton.click();
		//clickOnButton(driver);
		
		//using javascripExecutor
		//JavascriptExecutor js1=(JavascriptExecutor)driver;
		//js1.executeScript("arguments[0].click();", createNewAccountButton);
				
		
		//how to get the text
	/*	WebElement text=driver.findElement(By.xpath("//div[@class='_8esl']//h2"));
		//System.out.println("text is  :"+text.getText());
	  //validation
	 String 	expectedText="Facebook helps you connect and share with the people in your life.";
	 String actualText=text.getText();
	 if(actualText.equals(expectedText))
	 {
		 System.out.println("Test case is passed ");
	 }
	 else
	 {
		 System.out.println("Test case is failed");
	 }
	 //how to get the attribute vlaue of the webElement
	 WebElement getAttributeValue=driver.findElement(By.xpath("//input[@id='email']"));
	System.out.println( getAttributeValue.getAttribute("placeholder"));
	
	//how to get the size and location of the webElement
	//size
    Dimension d=	emailIDField.getSize();
    System.out.println("Element heigth is: "+d.height);
    System.out.println("Element width is: "+d.width);
    
    //location
    Point p=emailIDField.getLocation();
    System.out.println("Element x coordinate :"+p.x);
    System.out.println("Element y coordunate :"+p.y);
    
	//how to get the color of webElement
  String color = createNewAccountButton.getCssValue("    background-color");
  //Color co=Color.fromString(color);
 // System.out.println("Button backgriound color is :"+co.asHex());
  
  //how to get the html code for specific webelement
//String htmlCode  =createNewAccountButton.getAttribute("outerHTML");
//System.out.println("HTML code for the specific webElement :"+htmlCode);
  getHtmlCode(driver);*/
   
		
		

	}
	//genaric method for open the application
	public static void openApplication(WebDriver driver)
	{
		String url="https://www.facebook.com/";
		driver.get(url);
	}
	
	//genaric function for enter the text inside the email field
	public static void enterTheEmailID(WebDriver driver)
	{
		WebElement emailIDField=driver.findElement(By.xpath("//input[@id='email']"));
		emailIDField.sendKeys("avhadshital8@gmail.com");
	}
	//genaric method for click the webelemet
	public static void clickOnButton(WebDriver driver)
	{
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
		createNewAccountButton.click();
	}
	
	//genaric method for to get the html code for the specific webelement
	public static String getHtmlCode(WebDriver driver)
	{
		WebElement createNewAccountButton=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
		String getHtml=createNewAccountButton.getAttribute("outerHTML");
		System.out.println("Element HTML code is:  "+getHtml);
		return getHtml;
	}

}
