package demo.handling.calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo {

	// DOB Selection method logic
	public static void DateSelection(WebDriver driver, String requiredYear, String requiredMonth, String requiredDay)
			throws InterruptedException {

		// selecting year
		WebElement expectedYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(expectedYear);
		selectYear.selectByVisibleText(requiredYear);

		// selecting month
		WebElement expectedMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth = new Select(expectedMonth);
		selectMonth.selectByVisibleText(requiredMonth);
		// Thread.sleep(3000);
		// selecting day of the month
		List<WebElement> allDays = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for (WebElement dayOfMonth : allDays) {
			if (dayOfMonth.getText().equals(requiredDay)) {
				dayOfMonth.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		WebElement ticketForVisa = driver.findElement(By.xpath("//ul[@id='checkout-products']/li//label/input[@id='product_550']"));
		if (!ticketForVisa.isSelected()) {
			ticketForVisa.click();
		}

		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("SEELA");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("HARI");
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys("Visa application ticket booking....");

		
		  // DOB selection logic // expected DOB 
		  String requiredYear = "2024"; String
		  requiredMonth = "Nov"; String requiredDay = "18";
		  driver.findElement(By.xpath("//input[@id='dob']")).click();
		  DateSelection(driver, requiredYear, requiredMonth, requiredDay);
		  
		  //selecting Male/Female
		  if(!driver.findElement(By.xpath("//input[@id='sex_1']")).isSelected()) {
		  driver.findElement(By.xpath("//input[@id='sex_1']")).click(); }
		  
		  //add more passengers checkbox, i don't want to add this but want to check it
		  //should not selected 
		  WebElement addMorePassenger =
		  driver.findElement(By.xpath("//input[@id='addmorepax']"));
		  if(addMorePassenger.isSelected()) { //if it was already selected then ituncheck the checkbox 
			  addMorePassenger.click(); 
			  }
		  
		  
		  
		  //selecting round trip
		  driver.findElement(By.xpath("//input[@id='traveltype_2']")).click();
		  
		  
		  //from city
		  driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Hyderabad")
		  ;
		  
		  //to city
		  driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Banglore");
		  
		  //departure date 
		  String departureYear = "2024"; String departureMonth =
		  "Dec"; String departureDay = "22";
		  driver.findElement(By.xpath("//input[@id='departon']")).click();
		  DateSelection(driver,departureYear,departureMonth,departureDay);
		  
		  //return date 
		  String returnYear = "2025"; String returnMonth = "Jan"; String
		  returnDay = "10";
		  driver.findElement(By.xpath("//input[@id='returndate']")).click();
		  DateSelection(driver,returnYear,returnMonth,returnDay);
		  
		  
		  // additional info 
		  driver.findElement(By.xpath("//textarea[@id='notes']")).
		  sendKeys("Please call before two hours departure.......");
		  
		  // purpose of ticket
		  driver.findElement(By.xpath("(//span[@id='select2-reasondummy-container'])"))
		  .click();
		  driver.findElement(By.xpath("//select[@id='reasondummy']/option[@value='6']")
		  ).click();
		  
		  // Appointment date 
		  WebElement apptDate =
		  driver.findElement(By.xpath("//input[@id='appoinmentdate']")); 
		  if(apptDate.isDisplayed()) { apptDate.click(); DateSelection(driver, "2025",
		  "Jan", "15"); }
		  
		  // receive ticket details via both email, whatsapp
		  driver.findElement(By.xpath("//input[@id='deliverymethod_3']")).click();
		  
		  // Billing details 
		  driver.findElement(By.xpath("//input[@id='billname']")).
		  sendKeys("Manvi industries.");
		  driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(
		  "9876543210");
		  driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(
		  "hari@gmail.com");
		  
		  
		  //List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
		  //int numberOfFrames = frames.size();
		//  System.out.println("Number of iframes: " + numberOfFrames);
		  
		  
		  // selecting country
		  driver.findElement(By.xpath("//span[@id='select2-billing_country-container']"
		  )).click(); driver.findElement(By.xpath(
		  "//select[@id='billing_country']/option[@value='AU']")).click();
		  
		  // postal code
		  driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(
		  "515641");
		  
		  // town/city
		  driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys(
		  "Anantapur");
		  
		  // street address
		  driver.findElement(By.xpath("//input[@id='billing_address_1']")).
		  sendKeys("5-74 and M cherlopalli");
		  driver.findElement(By.xpath("//input[@id='billing_address_2']")).
		  sendKeys("Manvi building");
		  
		 		
		// selecting State
		 driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
	     driver.findElement(By.xpath("//select[@id='billing_state']/option[@value='SA']")).click();

		// click on Place Order button
		 WebElement submitButton = driver.findElement(By.xpath("//button[@id='place_order']"));
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 jsExecutor.executeScript("arguments[0].click();", submitButton); 
		
		
		
		 
		 
		
		
	}

}
