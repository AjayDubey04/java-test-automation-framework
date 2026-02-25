package com.vtiger.baseclass;


import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vtiger.pages.common.CommonReusableCodes;
import com.vtiger.utils.WebUtil;


public class BaseClass {
	
	protected WebUtil wt=new WebUtil();
	protected CommonReusableCodes cc;

	private ExtentReports extent;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Extends Report intialization");
	    extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("test-output//Sprint-1.html");
		extent.attachReporter(spark);
	}
	

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		System.out.println("Extends Report finalization");
	}


	@BeforeTest
	public void beforeTest() {
		System.out.println("connect data base connection ");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("disconnect data base connection ");
	}
	
	

	@Parameters({"Browser"})
	@BeforeClass
	public void beforeClass(String browser) {
		wt.launchBrowser(browser);
		wt.goToHitUrl("http://localhost:8888");
	}

	@AfterClass
	public void afterClass() {
		cc.Quit();
	}

	
	@Parameters({"UserName","Password"})
	@BeforeMethod
	public void beforeMethod(String username,String pass,Method mt){
		ExtentTest exeTest=extent.createTest(mt.getName());
		wt.setExeTest(exeTest);
	    cc=new CommonReusableCodes(wt);
		cc.login( username, pass);
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result){
		
		if(result.getStatus()==result.FAILURE) {
			String snapStr=wt.takeSnapshot(result.getName());
			wt.getExeTest().addScreenCaptureFromPath(snapStr);
		}
		else if(result.getStatus()==result.SUCCESS) {
			wt.getExeTest().log(Status.PASS, result.getName()+" is Passed ");
		}
		else if(result.getStatus()==result.SKIP) {		
			wt.getExeTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is Skipped ",ExtentColor.RED));
		}
		
		cc.logOut();
		extent.flush();
		
	}

}
