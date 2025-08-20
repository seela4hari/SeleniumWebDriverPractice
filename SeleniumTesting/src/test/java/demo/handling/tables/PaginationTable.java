package demo.handling.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testautomationpractice.blogspot.com/");

		// getting total number of rows
		int totalPages = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		int totalRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
		int totalCols = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
		System.out.println("Total rows in the table: " + totalRows);
		System.out.println("Total columns in the table: " + totalCols);
		// clicking on each page and retreiving the data from table.
		for (int p = 1; p <= totalPages; p++) {
			WebElement activePage = driver.findElement(By.xpath("//ul[@id='pagination']//li[" + p + "]"));

			if (p > 1) {
				activePage.click();
				// Thread.sleep(3000);
			}

			// retrieving data from table and selecting checkbox
			for (int r = 1; r <= totalRows; r++) {
				for (int c = 1; c <= totalCols; c++) {
					String data = driver
							.findElement(By.xpath("//table[@id='productTable']//*/tr[" + r + "]/td[" + c + "]"))
							.getText();
					WebElement checkboxes = driver
							.findElement(By.xpath("//table[@id='productTable']//tr[" + r + "]/td[4]/input"));
					if (!checkboxes.isSelected()) {
						checkboxes.click();
					}
					System.out.print(data + "\t");
				}
				System.out.println();

			}

		}

	}

}
