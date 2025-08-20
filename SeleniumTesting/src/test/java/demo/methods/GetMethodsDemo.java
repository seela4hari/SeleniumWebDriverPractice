package demo.methods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		System.out.println("current URL: "+driver.getCurrentUrl());
		System.out.println("Title: "+driver.getTitle());
		System.out.println("window ID: "+driver.getWindowHandle());
		//System.out.println(driver.getPageSource());
		Thread.sleep(5000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowIds=driver.getWindowHandles();
		System.out.println("Windows IDs: "+windowIds);
		Thread.sleep(5000);
		driver.quit();

	}

}
