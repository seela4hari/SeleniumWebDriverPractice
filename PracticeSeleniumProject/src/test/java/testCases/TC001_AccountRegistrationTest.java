package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(priority=1, groups = {"sanity","master"})
	public void testRegistration() {
		
		try {
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		HomePage homePage = new HomePage(driver);
		logger.info("Clicked on My Account button...");
		homePage.clickMyAccount();
		logger.info("Clicked on Register button...");
		homePage.clickRegister();
		
		logger.info("Entering all details of new user account...");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setPhone(randomNumber());
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		logger.info("Accepting policy by clicking on check box...");
		regPage.clicAgreePolicy();
		logger.info("Clicked on Continue to create new account for the user...");
		regPage.clickContinue();
		logger.info("Validating success message after successful creating new account...");
		
		if(regPage.getConfirmMessage().equals("Your Account Has Been Created!")) {
			logger.info("Your new account has been registered");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Account registration is failed....");
			logger.debug("Debug logs for New Account registration......");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(regPage.getConfirmMessage(), "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail();
		}
	}
}
