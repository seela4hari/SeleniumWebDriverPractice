package demo.handling.checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//selecting specific check box
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='monday' and @type='checkbox']"));
		checkbox.click();
		
	/*	//select all checkboxes
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[contains(@id,'day') and (@type='checkbox')]"));
		for(WebElement checkbox:checkboxes) {
			checkbox.click();
		}
	*/
		
		//select last three checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[(@class='form-check-input') and (@type='checkbox')]"));
		for(int i=4;i<checkboxes.size();i++) {
			checkboxes.get(i).click();			
		}
		
		//unselect selected checkboxes
		Thread.sleep(5000);
		for(int i=0;i<checkboxes.size();i++) {
			if (checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
