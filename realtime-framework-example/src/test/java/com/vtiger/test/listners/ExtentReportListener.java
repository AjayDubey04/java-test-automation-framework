package com.vtiger.test.listners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.utils.WebUtil;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;

	WebUtil wt = WebUtil.getInstance();

	@Override
	public  void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repName = "src\\test\\resources\\ExtentReport\\" + timeStamp;

		sparkReporter = new ExtentSparkReporter(repName+"ExtenteReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Ajay");
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Java Version", "18");

		sparkReporter.config().setDocumentTitle("VtigerCRM Test Project");
		sparkReporter.config().setReportName("Functional Test Report");
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
		sparkReporter.config().setTheme(Theme.DARK);

	}


	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest logger = extent.createTest(result.getName());
		wt.setExtentTest(logger);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		wt.getExtentTest().log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		wt.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String snapStr = wt.takeSnapshot(timeStamp+result.getName());
		wt.getExtentTest().addScreenCaptureFromPath(snapStr);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		wt.getExtentTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
