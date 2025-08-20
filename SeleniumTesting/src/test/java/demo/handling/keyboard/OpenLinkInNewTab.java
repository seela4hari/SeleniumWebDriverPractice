package demo.handling.keyboard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		Actions action = new Actions(driver);
		
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		//Ctrl+click on regLink
		action.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("SEELA");
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Laptop");
		
		

	}

}
