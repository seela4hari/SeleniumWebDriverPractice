package demo.handling.mouse.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoublClickDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("(//input[@id='field2'])"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		System.out.println("Field1 getText() :"+ field1.getText());
		System.out.println("Field2 getText() :"+ field2.getText());
		
		Actions action = new Actions(driver);
		field1.clear();
		field1.sendKeys("SEELA HARI");
		//double click action
		action.doubleClick(button).perform();
		System.out.println("Field1 getAttribute() :"+ field1.getAttribute("value"));
		System.out.println("Field2 getAttribute() :"+ field2.getAttribute("value"));
		
		if(field1.getAttribute("value").equals(field2.getAttribute("value"))) {
			System.out.println("Field1 copied to Field2 correctly.....");
		}
		else
			System.out.println("Field1 copied to Field2 Incorrectly.....");
		
		//drag and drop action
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		action.dragAndDrop(drag, drop).perform();
		
		WebElement successDrop = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		if(successDrop.getText().equals("Dropped!")) {
			System.out.println("Drag and Drop done successfully.......");
		}
		
	}

}
