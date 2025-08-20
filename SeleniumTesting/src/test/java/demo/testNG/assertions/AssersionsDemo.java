package demo.testNG.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssersionsDemo {

	@Test
	void openapp() {
		System.out.println("Opening app...");
		Assert.assertEquals(123, 123);
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("Searching method....");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	void logout() {
		System.out.println("Logging out...");
		Assert.assertTrue(false);
	}
	
}
