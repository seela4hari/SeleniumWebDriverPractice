package demo.handling.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootstrapDropdowns {

	public static void main(String[] args) throws InterruptedException {
		//jRXnhhZmRGuAuOJdRT1zSVFtFqAHk1FzIK8inmXv11o
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		//finding dropdown then click to open dropdown
		driver.findElement(By.xpath("//button[contains(@class,'multiselect') and @type=\"button\"]")).click();
		//selecting couple option in dropdown
		//driver.findElement(By.xpath("//input[@value=\"Bootstrap\"]")).click();
		//driver.findElement(By.xpath("//input[@value=\"Angular\"]")).click();
		
		List<WebElement> dropElements= driver.findElements(By.xpath("//li/a[@tabindex='0']"));
		System.out.println(dropElements.size());
	
		for(WebElement option:dropElements) {
			//if(option.getText().equals("Java")||option.getText().equals("jQuery")){
				option.click();
				System.out.println("selected options: "+option.getText());
			//}
			
		}
				
	}

}
