package demo.testNG.grouping;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test(priority = 1, groups = {"sanity"})
	void payWithRupees() {
		System.out.println("Pay with Rupees...");
	}
	
	@Test(priority = 2, groups = {"regression"})
	void payWithDollar() {
		System.out.println("Pay with Dollar...");
	}
	
	
	@Test(priority = 3, groups = {"sanity","regression","functional"})
	void payWithPound() {
		System.out.println("Pay with Pound...");
	}

}
