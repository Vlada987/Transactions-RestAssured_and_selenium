package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyExtentReport {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String testName;

	public String createPath() {

		String path = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\PaypalApi\\myReports";
		String number = String.valueOf(new File(path).listFiles().length + 1);
		return path + "\\reportNo" + number + ".html";

	}

	@BeforeSuite
	public void setExtent() {

		htmlReporter = new ExtentHtmlReporter(createPath());
		htmlReporter.config().setDocumentTitle("selenium/restAssured paypal");
		htmlReporter.config().setReportName("myReport");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "user");

	}

	@AfterTest
	public void endReport() {

		extent.flush();
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {

		testName = method.getName();

	}

	@BeforeMethod
	public void setTest() {

		test = extent.createTest(testName);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed " + result.getName());
			test.log(Status.FAIL, "***" + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed " + result.getName());
		}
	}

}