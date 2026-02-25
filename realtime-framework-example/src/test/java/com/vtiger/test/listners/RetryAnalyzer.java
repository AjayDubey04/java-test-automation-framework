package com.vtiger.test.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class RetryAnalyzer implements IRetryAnalyzer {


	/*
	 * IRetryAnalyzer is an interface in TestNG that allows you to implement custom
	 * logic for retrying failed test methods. It provides a way to control the
	 * retry behavior for specific test methods, enabling them to be executed
	 * multiple times until they pass or until the maximum retry count is reached.
	 * 
	 * Here's a real-time example to illustrate the use of IRetryAnalyzer:
	 * 
	 * Scenario: Imagine you have a test that occasionally fails due to network
	 * issues or intermittent problems. Instead of marking the test as failed, you
	 * want to retry it a few times before giving up.
	 */



	private static final int MAX_RETRY_COUNT = 3;
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRY_COUNT) {
			System.out.println("Retrying test " + result.getName() + " for the " + (retryCount + 1) + " time.");
			retryCount++;
			return true;
		}
		return false;
	}

}
