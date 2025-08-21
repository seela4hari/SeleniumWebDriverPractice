package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups = {"regression","master"})
	public void test_Login() {
		
		try {
		logger.info("*** Starting TC002_LoginTest ****");
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();
		logger.info("Clicked on login");
		
		logger.info("Entering login credentials from properties file....");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(properties.getProperty("email"));
		loginPage.setPassword(properties.getProperty("password"));
		logger.info("Clicking on Login button....");
		loginPage.clickLogin();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		boolean accountDisplay = myAccountPage.isMyAccountDisplayed();
		logger.info("Validating credentials provided.....");
		if(accountDisplay==true) {
			logger.info("Login successful......");
			Assert.assertTrue(true);
		  }
		else {
			logger.info("Login Failed......");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			logger.error("Login failed....");
			Assert.fail();
		}
		
	}

}
