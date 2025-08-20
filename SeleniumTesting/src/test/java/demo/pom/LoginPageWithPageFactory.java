package demo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {
	
	WebDriver driver;
	
	//1.constructor
	public LoginPageWithPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//2.Locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txt_userName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_login;
	
	
	//3. action methods for each locator
	public void setUserName(String userName) {
		txt_userName.sendKeys(userName);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
}
