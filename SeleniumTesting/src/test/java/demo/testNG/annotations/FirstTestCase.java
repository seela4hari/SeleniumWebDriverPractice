package demo.testNG.annotations;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test(priority=0)
	void openApp() {
		System.out.println("Opening application...");
	}
	
	@Test(priority=1)
	void loginApp() {
		System.out.println("Logging into application...");
	}
	
	@Test(priority=2)
	void logoutApp() {
		System.out.println("Logout from application...");
	}

}
