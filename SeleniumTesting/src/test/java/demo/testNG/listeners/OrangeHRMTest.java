package demo.testNG.listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	//@BeforeClass
	@Test(priority=1)
	void testLogin() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Assert.assertTrue(true);
		
	}
	
	@Test(priority=2)
	void testTitle() {
		
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Orange");
		
	}
	
	
	@Test(priority =3, dependsOnMethods = "testTitle")
	void testLogout() {
		
		driver.quit();
		
	}

}
