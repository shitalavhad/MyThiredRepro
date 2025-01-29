import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stube
		WebDriverManager.chromedriver().setup();
		
	  WebDriver driver=new ChromeDriver();
		
	 driver.manage().window().maximize();
		
	driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		
		   /* String number1="+ ₹391";
			String	no1=number1.substring(3);
			System.out.println(no1);
			int i=Integer.parseInt(no1); 
			System.out.println(i);
			
			String number2="- ₹50";
			String	no2=number2.substring(3);
			System.out.println(no2);
			int j=Integer.parseInt(no2); 
			System.out.println(j);
			
		int totleorder=i-j;
		System.out.println(totleorder);*/
		
			
			
		
	
		
		
		

	}

	
	}


