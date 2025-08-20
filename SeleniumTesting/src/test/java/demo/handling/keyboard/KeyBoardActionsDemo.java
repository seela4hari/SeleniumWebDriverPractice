package demo.handling.keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		Actions action = new Actions(driver);
		
		WebElement text = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		text.sendKeys("Welcome to Keyboard actions");
		
		//Ctrl+A
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		//Ctrl+C
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		//TAB
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//Ctrl+V
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		
		
		
		
		
		
		
	}

}
