package demo.handling.javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		
		//passing text to input box using JavascriptExecutor, without using sendKeys()
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','SEELA HARI')", name);
		
		//clicking on radio button using JavascriptExecutor, without using driver click() method
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radioButton);
		
		
		

	}

}
