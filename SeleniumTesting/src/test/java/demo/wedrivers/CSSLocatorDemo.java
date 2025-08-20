package demo.wedrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocatorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("CDs");
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("CDDS");
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Laptops");
		driver.findElement(By.cssSelector("input.search-box-text[placeholder=\"Search store\"]")).sendKeys("MACs");
		
	}

}
