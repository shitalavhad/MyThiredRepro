package cookieStudy;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Set<Cookie> cookies = driver.manage().getCookies();
		//cheake how manay cookies are present
		System.out.println("Totle no of cookies :"+cookies.size());
		
		//get the all cookies
	/*	for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}*/
		
		//add the cookies
		Cookie c=new Cookie("myCookies123","12345asddv123866##");
	   driver.manage().addCookie(c);
		System.out.println("totle no of cookies after adding :"+cookies.size());
		
		
		
		
	}

}
