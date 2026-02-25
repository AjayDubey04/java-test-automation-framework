package com.example.tests;


import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.page.common.CommonReusableCodes;
import com.example.utils.ReadConfig;
import com.example.utils.WebUtil;

public class BaseTest {


	protected WebUtil wt = WebUtil.getInstance();
	protected CommonReusableCodes cc;

	ReadConfig  readProperty = new ReadConfig("config");
	private String URL=readProperty.getApplicationURL();
	


	// Method executed before the first test method in the current class
	@Parameters({"Browser"}) 
	@BeforeClass
	public void beforeClass(String browserName) {
		wt.launchBrowser(browserName);
		wt.goToHitUrl(URL);
		wt.windowMaximize();
		wt.myImpliciteWait(60);
	}



	// Method executed before each test method
	@BeforeMethod
	public void beforeMethod(Method mt) throws InterruptedException {
		cc = new CommonReusableCodes(wt);
		cc.login();
	}



	// Method executed after each test method
	@AfterMethod
	public void afterMethod(ITestResult result) {
		cc.logOut();
	}


	// Method executed after the last test method in the current class
	@AfterClass
	public void afterClass() {
		cc.close();
	}



}
