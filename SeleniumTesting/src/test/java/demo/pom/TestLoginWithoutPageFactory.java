package demo.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginWithoutPageFactory {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	void testLogin() {
		
		LoginPageWithoutPageFactory loginPage = new LoginPageWithoutPageFactory(driver);
		loginPage.setUserName("Admin");
		loginPage.setPassword("admin123");
		loginPage.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
