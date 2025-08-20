package demo.handling.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationAlerts {

	public static void main(String[] args) {
		
		String actualURL = "https://the-internet.herokuapp.com/basic_auth";
		//providing userName and Password in the URL itself
		String skipPopupURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		WebDriver driver = new ChromeDriver();
		driver.get(actualURL);
		driver.manage().window().maximize();
		driver.get(skipPopupURL);
	}

}
