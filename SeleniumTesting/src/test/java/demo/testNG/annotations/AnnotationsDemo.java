package demo.testNG.annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	
	@BeforeMethod
	void loginTest() {
		System.out.println("Login test with @BeforeTest annotation...");
	}
	
	@Test(priority=1)
	void searchText() {
		System.out.println("Search text with @Test annotation....");
	}
	@Test(priority=2)
	void searchAdvText() {
		System.out.println("Advance search text with @Test annotation....");
	}
	
	@AfterMethod
	void logoutTest() {
		System.out.println("Logout test with @AfterTest annotation...");
	}

}
