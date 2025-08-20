package demo.testNG.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotationsDemo {
	
	
	@Test(priority=1)
	void m3() {
		System.out.println("m3 -- @Test1");
	}
	@Test(priority=2)
	void m4() {
		System.out.println("m4 -- @Test2");
	}

	@BeforeMethod
	void m1() {
		System.out.println("m1 -- @BeforeMethod");
	}
	
	@AfterMethod
	void m2() {
		System.out.println("m2 -- @AfterMethod");
	}
	
	@BeforeClass
	void m5() {
		System.out.println("m5: -- @BeforeClass");
	}
	@AfterClass
	void m6() {
		System.out.println("m6: -- @AfterClass");
	}
	@BeforeTest
	void m7() {
		System.out.println("m7: -- @BeforeTest");
	}
	@AfterTest
	void m8() {
		System.out.println("m8: -- @AfterTest");
	}
	
	@BeforeSuite
	void m9() {
		System.out.println("m9: -- @BeforeSuite");
	}
	@AfterSuite
	void m10() {
		System.out.println("m10: -- @AfterSuite");
	}
	
}
