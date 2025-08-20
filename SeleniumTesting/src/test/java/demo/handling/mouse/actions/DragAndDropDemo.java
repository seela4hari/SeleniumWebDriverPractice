package demo.handling.mouse.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		WebElement debitAccountSource = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement debitAccountTarget = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		WebElement debitAmountSource = driver.findElement(By.xpath("//div[@id='products']//a[text()=' 5000 ']"));
		WebElement debitAmountTarget = driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
		
		
		WebElement creditAccountSource = driver.findElement(By.xpath("//div[@id='products']//li//a[text()=' SALES ']"));
		WebElement creditAccountTarget = driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		
		WebElement creditAmountSource = driver.findElement(By.xpath("//div[@id='products']//a[text()=' 5000']"));
		WebElement creditAmountTarget = driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(debitAccountSource, debitAccountTarget).perform();
		action.dragAndDrop(debitAmountSource, debitAmountTarget).perform();
		action.dragAndDrop(creditAccountSource, creditAccountTarget).perform();
		action.dragAndDrop(creditAmountSource, creditAmountTarget).perform();
		
		//validating success message
		WebElement success = driver.findElement(By.xpath("//div[@id='equal']/a[text()='Perfect!']"));
		
		if(success.getText().equals("Perfect!")){
			System.out.println("Drag and Drop done successfully......");
		}
		
		

	}

}
