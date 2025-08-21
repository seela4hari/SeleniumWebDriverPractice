package utilities;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // used for UI of the report
	public ExtentReports extent; // used to populate common info on the report
	public ExtentTest test; // used to create test case entries in the report and updates status of the test methods.
	String reportName;
	
	public void onStart(ITestContext context) {

		
		String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date()); //time stamp
		reportName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+reportName);
		sparkReporter.config().setDocumentTitle("SEELA TITLE");
		sparkReporter.config().setReportName("Seela Hari Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		//setting default system information
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application Name", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", System.getProperty("user.name"));
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty()) {
			extent.setSystemInfo("Groups", groups.toString());
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getClass().getName());  //creates new test entries in the report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" test is passed succesfully...."); // updating the status of the test methods
		
	}


	public void onTestFailure(ITestResult result) {
		
		
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" Is failed....");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		//taking screenshot when test fails
		try {
		String filePath = new BaseClass().captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(filePath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" Test is Skipped....");
		test.log(Status.INFO, result.getThrowable().getMessage());

	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();  //this statement should be mandatory to add above all methods
		
		//to open report automatically in browser
		String reportPath = System.getProperty("user.dir")+"//reports//"+reportName;
		File extentReport = new File(reportPath);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	/*	
		// to send an automatic email with report as attachment
		try {
			URL url = new URL("file://"+System.getProperty("user.dir")+"//reports//"+reportName);
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("seela4hari@gmail.com", "password"));
			email.setSSLOnConnect(true);
			email.setFrom("seela4hari@gmail.com");//sender
			email.setSubject("Testing report");
			email.setMsg("Please find the testing report attachment");
			email.addTo("hari3seela@gmail.com");//receiver email
			email.attach(url,"Extent report","Please check report...");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	*/	
		
	}
	
	
}
