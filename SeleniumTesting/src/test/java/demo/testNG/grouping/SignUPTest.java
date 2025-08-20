package demo.testNG.grouping;

import org.testng.annotations.Test;

public class SignUPTest {

	@Test(priority=1, groups = {"sanity"})
	void testFBSignUP() {
		System.out.println("SignUP with FB ....");
	}
	
	@Test(priority=2, groups = {"regression"})
	void testGmailSignUP() {
		System.out.println("SignUP with Gmail ....");
	}
	
	@Test(priority=3, groups = {"sanity","regression","functional"})
	void testInstaSignUP() {
		System.out.println("SignUP with Insta ....");
	}
}
