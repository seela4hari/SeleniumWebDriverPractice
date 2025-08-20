package demo.testNG.grouping;

import org.testng.annotations.Test;

public class LoginGroupTest {
	
	@Test(priority=1, groups = {"sanity"})
	void testFBLogin() {
		System.out.println("Login with FB ....");
	}
	
	@Test(priority=2, groups = {"regression"})
	void testGmailLogin() {
		System.out.println("Login with Gmail ....");
	}
	
	@Test(priority=3, groups = {"sanity","regression","functional"})
	void testInstaLogin() {
		System.out.println("Login with Insta ....");
	}

}
