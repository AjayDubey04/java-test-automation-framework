package TestListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListner implements ITestListener{


	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("TestStart--> "+result.getName());
	}


	public  void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("TestSuccess--> "+result.getName());
	}


	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("TestFailure--> "+result.getName());
	}


	public void onFinish(ITestContext context) {
		// not implemented
	}

}
