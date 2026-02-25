package com.testscript.runner;


import com.vtiger.testcases.HomePageTestCases;
import com.vtiger.testcases.MarketingAccountTestCases;


public class TestCaseRunner {


	public static void main(String[] args) throws InterruptedException {


		MarketingAccountTestCases vmap=new MarketingAccountTestCases() ;
		vmap.verifytMarketingAccountChecBoxesTC002();


		HomePageTestCases vatl=new HomePageTestCases();
		vatl.verifyToPerfornHomePageDragAndDropTC008();

		




	}

}
