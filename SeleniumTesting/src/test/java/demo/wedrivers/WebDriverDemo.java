package demo.wedrivers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("small-searchterms")).sendKeys("Mac");
		//System.out.println(driver.findElement(By.name("customerCurrency")).isDisplayed());
		//driver.findElement(By.linkText("Digital downloads")).click();
		//driver.findElement(By.partialLinkText("Digital")).click();
		//List<WebElement> webList = driver.findElements(By.className("current-item"));
	//	System.out.println("number of links "+webList.size());
		List<WebElement> webList1 = driver.findElements(By.tagName("div"));
		System.out.println("number of tags "+webList1.size());
		
		
		
	}

}
