package testng.practice;

import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class CustomListener implements ITestListener {
	
	
	/*
	 * Create a Java class that implements one of the TestNG listener interfaces.
	 * For example, ITestListener, ISuiteListener, IInvokedMethodListener, etc.
	 * Implement the methods of the chosen interface according to your requirements.
	 * Here's an example of a simple ITestListener implementation:
	 */	

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }

    // Implement other methods if needed (onTestSkipped, onTestFailedButWithinSuccessPercentage, etc.)
}



@Listeners(CustomListener.class)
 class MyTestClass {
	
		/*
		 * You can associate the listener with your test class or suite in the following
		 * ways: Using @Listeners Annotation (for a single test class)
		 */
	
	
		/*
		 * In this example, the @Listeners(CustomListener.class) annotation is used to
		 * associate the CustomListener with the MyTestClass.
		 */	
	
    @Test
    public void testMethod1() {
        System.out.println("Executing Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing Test Method 2");
    }
}

