package demo.handling.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Handling Frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Frame1 text");
		driver.switchTo().defaultContent();
		
		//switch to Frame5 then handle iFrame or innerFrames
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
		driver.switchTo().frame(frame5);
		//driver.findElement(By.xpath("//a[@href='https://a9t9.com']")).click();
		WebElement iFrame = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://a9t9.com']")));
		iFrame.click();
		WebElement iFrameLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']")));
		if(iFrameLogo.isDisplayed()) {
			System.out.println("Logo is present in the inner frame of Frame5......");
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='user manual']")).click();
		System.out.println("clicked on UserManual in iFrame");
		WebElement link1 = driver.findElement(By.xpath("//span[normalize-space()='1. Get Ui.Vision (free)']"));
		link1.click();
		if(link1.isEnabled()) {
			System.out.println("Link1 is clicked successfully...");
		}
		driver.switchTo().defaultContent();
		
	}

}
