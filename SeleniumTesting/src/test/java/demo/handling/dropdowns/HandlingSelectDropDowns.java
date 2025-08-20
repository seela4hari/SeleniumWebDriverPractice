package demo.handling.dropdowns;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelectDropDowns {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement countryElement = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		
		Select countries = new Select(countryElement);
		countries.selectByVisibleText("Canada");
		countries.selectByValue("uk");
		countries.selectByIndex(9);
		//to print selected options
		List<WebElement> countries1 = countries.getAllSelectedOptions();
		System.out.println("Selected dropdown option: ");
		for(WebElement country:countries1) {
			System.out.println(country.getText());
		}
		//to print all options available on dropdown
		List<WebElement> countries2 = countries.getOptions();
		System.out.println("All available options: ");
		for(WebElement country:countries2) {
			System.out.println(country.getText());
		}
		
		
	}

}
