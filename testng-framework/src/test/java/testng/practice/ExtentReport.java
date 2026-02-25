package testng.practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {


	private static WebDriver driver;

	public static void main(String[] args) {

		//		Reporter  re=new Reporter();
		//		re.log("Hii TestNG");

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		//		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		extentReport();

	}

	public static void extentReport() {

		// Directory where output is to be printed
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output//ExtentReport.html");
		ExtentReports extent = new ExtentReports();

		// Setting system information for the report
		extent.setSystemInfo("Machine", "HP");
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("User", "Ajay");
		extent.setSystemInfo("Browser", "Chrome");

		// Configuring the appearance and format of the report
		spark.config().setDocumentTitle("Extent Report Demo");
		spark.config().setReportName("Test Report");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");

		// Attaching the ExtentSparkReporter to the ExtentReports instance
		extent.attachReporter(spark);

		// Creating test cases and logging status and messages
		ExtentTest exeTest1 = extent.createTest("TC001");
		exeTest1.log(Status.PASS, "Passed");
		exeTest1.log(Status.FAIL, "Failed");

		ExtentTest exeTest2 = extent.createTest("TC002");
		exeTest2.log(Status.PASS, "Passed");
		exeTest2.log(Status.FAIL, "Failed");

		ExtentTest exeTest3 = extent.createTest("TC003");
		exeTest3.log(Status.PASS, "Passed");
		exeTest3.log(Status.FAIL, "Failed");
		exeTest3.log(Status.INFO, "Information");
		exeTest3.log(Status.SKIP, "Ignore");

		// Capturing a screenshot and saving it to a file
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFileObj = ts.getScreenshotAs(OutputType.FILE);
		File destinationFileObj = new File("test-output//vtigerLoginPage.png");

		try {
		    Files.copy(sourceFileObj, destinationFileObj);
		} catch (IOException e) {
		    e.printStackTrace();
		}

		// Adding the captured screenshot to the Extent Report
		exeTest3.addScreenCaptureFromPath(destinationFileObj.getAbsolutePath());

		// Flushing the report to generate it
		extent.flush();

	}

}
