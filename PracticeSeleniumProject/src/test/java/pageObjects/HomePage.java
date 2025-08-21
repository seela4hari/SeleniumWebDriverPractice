package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement btnMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement btnRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btnLogin;

	//Action methods for locators
	public void clickMyAccount() {
		btnMyAccount.click();
	}
	public void clickRegister() {
		btnRegister.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
