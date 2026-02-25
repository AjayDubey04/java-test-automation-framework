package TestListners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalizerListner implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
