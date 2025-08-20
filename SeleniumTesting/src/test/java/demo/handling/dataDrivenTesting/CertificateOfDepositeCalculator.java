package demo.handling.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CertificateOfDepositeCalculator {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		//Headless testing
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//reading url from properties file
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\TestData\\config.properties"));
		String url = properties.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir")+"\\TestData\\cdcalculator.xlsx";
		//getting excel row count and column counts
		int noOfRows = ExcelUtils.getRowCount(filePath,"Sheet1");
		System.out.println("noOfRows: "+noOfRows);
		for(int r=1;r<=noOfRows;r++) {
					
				
				//1. Reading excel data
				
				String intDepositAmt = ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
				//removing .0 in the number in the end 
				String intDepAmt = intDepositAmt.replace(".0", "");
				  
				String months = ExcelUtils.getCellData(filePath, "Sheet1", r, 1); 
				//removing .0 in the number in the end 
				String month = months.replace(".0", ""); 
				
				String interestRate = ExcelUtils.getCellData(filePath, "Sheet1", r, 2); 
				String compounding = ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
				String expetedTotalAmt = ExcelUtils.getCellData(filePath, "Sheet1", r, 4);
				
				//2. Interacting with application
				WebElement intDptAmt = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
				intDptAmt.clear();
				intDptAmt.sendKeys(intDepAmt);
				
				WebElement mnt = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
				mnt.clear();
				mnt.sendKeys(month);
				
				WebElement intRate = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
				intRate.clear();
				intRate.sendKeys(interestRate);
				
				WebElement comp = driver.findElement(By.xpath("//div[@class='mat-select-arrow ng-tns-c109-4']"));
				comp.click();
				
				List<WebElement> compElements = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option/span"));
				for(WebElement compElement:compElements) {
					String elementText = compElement.getText();
					if(elementText.equals(compounding)) {
						js.executeScript("arguments[0].click();", compElement);
					}
				}
				
				WebElement button = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));
				js.executeScript("arguments[0].click();", button);
				//3. Validating total amount
				String actualTotalAmt = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
				String expFinalAmt = expetedTotalAmt.replace("$", "");
				String actFinalAmt = actualTotalAmt.replace("$", "");
				String expAmtFinal = expFinalAmt.replace(",", "");
				String actAmtFinal = actFinalAmt.replace(",", "");
				Double expValue = Double.parseDouble(expAmtFinal);
				Double actValue = Double.parseDouble(actAmtFinal);
				System.out.println("Row No "+r+": "+" expValue: "+expValue+"\t"+"actValue: "+actValue);
				if(expValue.compareTo(actValue)==0) {
					System.out.println("Test passed...");
					ExcelUtils.setCellData(filePath, "Sheet1", r, 6, "Passed");
				}
				else {
					System.out.println("Test Failed...");
					ExcelUtils.setCellData(filePath, "Sheet1", r, 6, "Failed");
				}
				Thread.sleep(3000);
		}//for closed
		driver.quit();
	}
}
