package demo.wedrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		//driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// absolute xpath
		// driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/input")).sendKeys("TABLETS");

		// relative xpath with single attribute
		// driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("TABLETS");

		// relative xpath with multiple attibutes
		//driver.findElement(By.xpath("//input[@id=\"small-searchterms\"] [@aria-label=\"Search store\"]")).sendKeys("Tables");
		
		//relative xpath with 'and' , 'or' operators
		//driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys("Glasses");
		//driver.findElement(By.xpath("//input[@placeholder=\"Search store\" or @name=\"q1\"]")).sendKeys("Glass");
		
		//xpath with inner text
		//driver.findElement(By.xpath("//a[text()=\" Electronics \"]")).click();
		//System.out.println(driver.findElement(By.xpath("//strong[text()=\"Featured products\"]")).getText());
		
		//xpath with contains() method
		//driver.findElement(By.xpath("//input[contains(@class,'search-box-text')]")).sendKeys("XYzz");
		
		//xpath with starts-with() method
		//driver.findElement(By.xpath("//input[starts-with(@id, \"small-\")]")).sendKeys("starts-with()");
		
		//chained xpath
		//driver.findElement(By.xpath("//div[@class=\"header-lower\"]/div/form/input")).sendKeys("chained xpath");
		
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("virat kohli");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		
	}

}
