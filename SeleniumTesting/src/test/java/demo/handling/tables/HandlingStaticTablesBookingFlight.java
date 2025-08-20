package demo.handling.tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingStaticTablesBookingFlight {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://blazedemo.com");

		// selecting departure city
		WebElement depatCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select selectDepat = new Select(depatCity);
		selectDepat.selectByVisibleText("Boston");
		WebElement selectedOption = selectDepat.getFirstSelectedOption();
		String selectedDeparture = selectedOption.getText();
		// selecting destination city
		WebElement destCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select selectDest = new Select(destCity);
		selectDest.selectByValue("London");
		WebElement selectedOption2 = selectDest.getFirstSelectedOption();
		String selectedDestination = selectedOption2.getText();
		// searching button
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

		// getting table rows count
		int tableRows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		int tableColumns = driver.findElements(By.xpath("//table[@class='table']//th")).size();
		System.out.println("No. of Table rows :" + tableRows + "\t" + "No. of table columns: " + tableColumns);

		// Getting prices then converting to double then sorting in ascending order
		List<Double> flightPrices = new ArrayList<>();
		for (int r = 1; r < tableRows; r++) {
			String priceValues = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]/td[6]")).getText();
			String numericValue = priceValues.replace("$", "");
			double flightPrice = Double.parseDouble(numericValue);
			flightPrices.add(flightPrice);
		}
		Collections.sort(flightPrices);
		Double leastPrice = flightPrices.getFirst();
		System.out.println("Least price: " + leastPrice);

		// getting prices to compare with least price
		for (int r = 1; r < tableRows; r++) {
			// Thread.sleep(5000);
			String priceValues = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]/td[6]")).getText();
			String numericValue = priceValues.replace("$", "");
			Double flightPrice1 = Double.parseDouble(numericValue);
			int temp = Double.compare(leastPrice, flightPrice1);
			if (temp == 0) {
				// Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]/td[1]")).click();
				System.out.println("Selected least price flight for booking....");
				break;
			}
		}

		// Fill the details in the form to book flight then submit.
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("SEELA HARI");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("5-74, Cherlopalli");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Anantapur");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Andhra Pradesh");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("515641");
		WebElement cardType = driver.findElement(By.xpath("//select[@id='cardType']"));
		cardType.click();
		Select selectCard = new Select(cardType);
		selectCard.selectByValue("amex");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1234567890");
		WebElement cardMonth = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
		cardMonth.clear();
		cardMonth.sendKeys("10");
		WebElement cardYear = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
		cardYear.clear();
		cardYear.sendKeys("2026");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("MANVI SEELA");
		WebElement rememberCheckbox = driver.findElement(By.xpath("//input[@id='rememberMe']"));
		if (!rememberCheckbox.isSelected()) {
			rememberCheckbox.click();
		}
		// click on button to purchase tickets
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		// validating success message
		String successMsg = driver.findElement(By.xpath("//div[@class='container hero-unit']//h1")).getText();
		if (successMsg.equalsIgnoreCase("Thank you for your purchase today!")) {
			System.out.println("Flight booked successfully... " + selectedDeparture + " To " + selectedDestination);
		}
	}

}
