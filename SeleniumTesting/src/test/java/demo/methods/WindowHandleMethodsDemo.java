package demo.methods;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleMethodsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		//Set collection extraction type1
		List<String> windowList = new LinkedList<String>(windowIDs);
		String parentID=windowList.get(0);
		String childID=windowList.get(1);
		System.out.println("Intial ID is Parent ID: "+driver.getTitle());
		
		//switching to child window
		driver.switchTo().window(childID);
		System.out.println("Child window title: "+driver.getTitle());
		//switch to parent window again
		driver.switchTo().window(parentID);
		System.out.println("Parent window title: "+driver.getTitle());
		
		//Set collection extraction type2
		for(String winID:windowIDs) {
			String childtitle = driver.switchTo().window(winID).getTitle();
			if(childtitle.equals("Human Resources Management Software | OrangeHRM")){ 
			System.out.println("child title: "+driver.getCurrentUrl());
			}
		}
		driver.quit();

	}

}
