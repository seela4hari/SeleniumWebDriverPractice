package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	//Constructor
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	//Elements locators
	@FindBy(xpath="(//input[@id='input-firstname'])")
	WebElement txtFirstName;
	
	@FindBy(xpath="(//input[@id='input-lastname'])")
	WebElement txtLastName;
	
	@FindBy(xpath="(//input[@id='input-email'])") 
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="(//input[@id='input-password'])")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgreePolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMessage;
	
	//Action methods for each locator
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}
	
	public void clicAgreePolicy() {
		chkAgreePolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmMessage() {
		try {
			return confirmationMessage.getText();
		} catch (Exception e) {
			return e.getMessage();
		} 
	}
}
