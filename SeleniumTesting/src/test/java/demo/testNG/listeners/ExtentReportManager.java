package demo.testNG.listeners;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // used for UI of the report
	public ExtentReports extent; // used to populate common info on the report
	public ExtentTest test; // used to create test case entries in the report and updates status of the test menthods.
	
	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\myReport.html");
		sparkReporter.config().setDocumentTitle("SEELA TITLE");
		sparkReporter.config().setReportName("Seela Hari Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		//setting default system information
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "Local hose");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("Tester name", "SEELA HARI");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());  //creates new test entries in the report
		test.log(Status.PASS, "Test case Passed is: "+result.getName()); // updating the status of the test methods
		
	}
	
	

	public void onTestFailure(ITestResult result) {
		
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test case Failed Reason is: "+result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case Failed is: " + result.getName());

	}

	public void onFinish(ITestContext context) {
		
		extent.flush();  //this statement should be mandatory to add above all methods
	}
	
	
}
