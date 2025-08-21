package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	//browser setup
	@BeforeClass(groups = {"sanity","master"})
	@Parameters({"os" , "browser"})
	public void setup(String os, String br) throws IOException {
		
		//adding log manager to generate logs
		logger = LogManager.getLogger(this.getClass());
		
		//reading parameters for browser
		//driver instances
		switch(br.toLowerCase()){
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser...");
			return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		properties = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		properties.load(file);	
		driver.get(properties.getProperty("appUrl")); //reading app url using properties file
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
	}
	
	//browser closing
	@AfterClass (groups = {"regression","master"})
	public void tearDown() {
		driver.quit();
	}
	

	//Generating random string
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}
	
	//Random number generating
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	//generating password contains some random numbers and random string
	public String randomAlphaNumeric() {
		String randomString = RandomStringUtils.randomAlphabetic(4);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		return randomString+"@@"+randomNumber;
	}
	
	
	public String captureScreenshot(String tname) {
		
		String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date()); 
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFilePath = screenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"//Screenshots//"+tname+"_"+timeStamp;
		File targetFile = new File(targetFilePath);		
		sourceFilePath.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	
	
	
}









