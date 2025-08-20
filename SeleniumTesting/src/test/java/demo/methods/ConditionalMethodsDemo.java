package demo.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethodsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		//isDisplayed() method -- we can check display status of element
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo: "+element.isDisplayed());
		
		//isEnabled() method --> used to check input, dropdowns, checkboxes, radiobuttons...
		Boolean enableElement= driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).isEnabled();
		System.out.println("First name enable status: "+enableElement);
		
		//isSelected() method --> used to check selection status of element ex. radio buttons, checkboxes.....
		WebElement male_rb = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rb = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selecting radio buttons........");
		System.out.println("Male button selection status: "+male_rb.isSelected());
		System.out.println("Female button selection status: "+female_rb.isSelected());
		
		male_rb.click();
		System.out.println("After selecting Male radio button....");
		System.out.println("Male button selection status: "+male_rb.isSelected());
		System.out.println("Female button selection status: "+female_rb.isSelected());
		
		
	}

}
