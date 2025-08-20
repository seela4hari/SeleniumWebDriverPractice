package demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageWithoutPageFactory {
	
	WebDriver driver;
	
	//1. constructor
	public LoginPageWithoutPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	//2.Locatorss
	By txt_userName_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login = By.xpath("//button[normalize-space()='Login']");
	
	//3.Action methods --> each locator should have one action method
	public void setUserName(String userName) {
		
		driver.findElement(txt_userName_loc).sendKeys(userName);
	}
	
	public void setPassword(String password) {
		driver.findElement(txt_password_loc).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	

}
