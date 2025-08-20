package demo.methods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethodsDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.nopcommerce.com");
		//driver.navigate().to("https://demo.nopcommerce.com");
		@SuppressWarnings("deprecation")
		URL myUrl = new URL("https://demo.nopcommerce.com");
		driver.navigate().to(myUrl);
		driver.manage().window().maximize();
		System.out.println("First URL: "+driver.getCurrentUrl());
		
		//opening another URL
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Second URL: "+driver.getCurrentUrl());
		Thread.sleep(5000);
		driver.navigate().back();
		System.out.println("back url: "+driver.getCurrentUrl());
		Thread.sleep(5000);
		driver.navigate().forward();
		System.out.println("forward url :"+driver.getCurrentUrl());
		
		Thread.sleep(5000);
		driver.navigate().refresh();
	}

}
