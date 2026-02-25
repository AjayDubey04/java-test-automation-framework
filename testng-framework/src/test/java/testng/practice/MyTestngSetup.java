package testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MyTestngSetup {


	/*
	 * The @BeforeSuite annotation is used to denote a method that will be executed
	 * once before all tests in the suite, and @AfterSuite is used for methods that
	 * run after all tests in the suite.
	 */
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite: This method runs before the test suite starts.");
		// Setup tasks specific to the entire suite
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite: This method runs after all tests in the suite have run.");
		// Suite-level teardown tasks
	}

	
	
	/*
	 * The @BeforeTest annotation is used for methods that run before any test
	 * method belonging to a <test> tag in testng.xml. @AfterTest is for methods
	 * that run after all test methods in the <test> tag.
	 * 
	 */
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test: This method runs before any test methods in the <test> tag.");
		// Common setup tasks for all tests in the <test> tag
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test: This method runs after all test methods in the <test> tag.");
		// Test-level teardown tasks
	}


	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class: This method runs before the first test method in the class.");
		// Class-level setup tasks
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class: This method runs after all test methods in the class.");
		// Class-level teardown tasks
	}

	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method: This method runs before every test method.");
		// Test-specific setup tasks
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method: This method runs after every test method.");
		// Test-specific teardown tasks
	}
	
	

	@BeforeGroups("myGroup")
	public void beforeGroup() {
		System.out.println("Before Group: This method runs before the first test method in the specified group.");
		// Group-specific setup tasks
	}

	@AfterGroups("myGroup")
	public void afterGroup() {
		System.out.println("After Group: This method runs after the last test method in the specified group.");
		// Group-specific teardown tasks
	}

	//The @Test annotation is used to mark a method as a test case.	
	@Test(groups = "myGroup")
	public void groupTestMethod1() {
		System.out.println("Grouped Test Method 1");
	}

	@Test(groups = "myGroup")
	public void groupTestMethod2() {
		System.out.println("Grouped Test Method 2");
	}



	/*
	 * The @Test annotation has an enabled attribute that allows you to
	 * conditionally enable or disable a test method. By setting enabled = false,
	 * you can skip the test:
	 */
	@Test(enabled = false)
	public void testToBeSkipped() {
		// Your test logic goes here
		System.out.println("testToBeSkipped");
	}

	

	/*
	 * @Ignore is used in JUnit (not TestNG) to dynamically skip tests. It allows
	 * you to skip tests based on runtime conditions or configuration files. It's
	 * often used in JUnit 4 for temporarily disabling tests.
	 */	
	@Ignore
	public void testToBeIgnore() {
		// Your test logic goes here
		System.out.println("testToBeIgnore");
	}



	/*
	 * priority Attribute 
	 * The priority attribute is used to specify the order in
	 * which test methods should be executed within a class. Methods with lower
	 * priority values will be executed first.
	 */
	@Test(priority = 1)
	public void testMethod1() {
		// Test logic for method 1
		System.out.println("testMethod1");
	}

	@Test(priority = 2)
	public void testMethod2() {
		// Test logic for method 2
		System.out.println("testMethod2");
	}



	/*
	 * dependsOnMethods Attribute 
	 * The dependsOnMethods attribute allows you to
	 * specify dependencies between test methods. The annotated method will only run
	 * if the methods specified in dependsOnMethods have successfully completed.
	 */
	@Test
	public void login() {
		// Login logic
		System.out.println("Login Vtiger Page");
	}

	@Test(dependsOnMethods = "login")
	public void performActionAfterLogin() {
		// Test logic after login
		System.out.println("click On Marketing Vtiger Page");
	}
	
	
	/*
	 * The alwaysRun attribute ensures that a method specified
	 * in @BeforeMethod, @AfterMethod, @BeforeClass, or @AfterClass is executed even
	 * if it depends on a method that failed.
	 */
	    @Test(alwaysRun = true)
	    public void cleanupMethod() {
	        // This method will run even if dependentTestMethod fails
	        // Cleanup logic goes here
	    	System.out.println("Cleanup Code");
	    }

}
