package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

	
		@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups = {"regression","master"})
		public void loginDDTTest(String email, String password, String expResult) {
		try {
		logger.info("****Starting TC003_LoginDataDrivenTest *****");
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();
		logger.info("****Entering credentials **********");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean targetPage = myAcc.isMyAccountDisplayed();
		
		/*
		//Validations for login
		Valid Data: login success --> test pass --> logout
					login failed --> test fail
		Invalid data: login success --> test fail --> logout
					  login failed --> test pass
		*/
		
		//validations for Valid data 
		if(expResult.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				myAcc.clickLogout();
				logger.info("****Login success with Valid data then click on Logout --> Test pass *****");
				Assert.assertTrue(true);
			}
			else {
				logger.info("****Login failed with valid data --> Test fail *****");
				Assert.assertTrue(false);
			}
		}
		//validations for invalid data
		else if(expResult.equalsIgnoreCase("Invalid")){
			
			if(targetPage==true) {
				myAcc.clickLogout();
				logger.info("****Login success with Invalid data so click on Logout --> Test fail *****");
				Assert.assertTrue(false);
			}
			else {
				logger.info("****Login fail with Invalid data --> Test pass *****");
				Assert.assertTrue(true);
			}
			
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** TC003_LoginDataDrivenTest compledted *****");
	
	}

}
