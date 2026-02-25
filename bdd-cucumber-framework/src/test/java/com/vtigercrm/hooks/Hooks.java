package com.vtigercrm.hooks;

import org.junit.AfterClass;

import com.vtigercrm.page.common.CommonPageCodes;
import com.vtigercrm.utilitylayer.WebUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 *  Hooks is also known as ScenarioManagment 
	 * 
	 * DateFormat date=new SimpleDateFormat("dd-MMMM-YYYY -->> hh:mm:ss:sss");
	 * String date2=date.format(new Date()); System.out.println(date2); }
	 * 
	 */


	private WebUtil util= WebUtil.getObject();


	// acending order ofter executing
	// execute before background and scenario
	@Before(order =1, value="@Retesting")
	public void beforeBackground() throws InterruptedException {

		util.launchBrowserAndOpenVtigerLoginPage();
		CommonPageCodes login=new CommonPageCodes(util);
		login.validVtigerLogin("admin","admin");
		
		util.logger.info("Executing @Before Hooks: Browser launched and login perform SuccessFully");
		System.out.println("Execute Before Scenario And Background -- 1`");

	}

//	@Before(order = 2)
	public void beforeBackground_1() throws InterruptedException {
		util.launchBrowserAndOpenVtigerLoginPage();

		CommonPageCodes login=new CommonPageCodes(util);
		login.validVtigerLogin("admin","admin");

		System.out.println("Execute Before Scenario And Background -- 1`");
		System.out.println("Execute Before Scenario And Background -- 2 ");

	}

	// execute Before each and every step
	@BeforeStep
	public void beforeStepDefs() {

		System.out.println(" Execute First Before Scenario Step ");

	}

	// execute After each and every step
	@AfterStep
	public void afterStepDefs() throws InterruptedException {
		System.out.println(" Execute First After Scenario Step ");

	}


	
	// decending order ofter executing
	// execute after scenario
	@After(order = 1,value="@Retesting")
	public void afterScenario() throws InterruptedException {
		CommonPageCodes cpc=new CommonPageCodes(util);
		cpc.vtigerClose();
		System.out.println("Execute After Scenario -- 1 ");
	}
	
	
	@After(order = 2)
	public void afterScenario_1() throws InterruptedException {
		CommonPageCodes cpc=new CommonPageCodes(util);
		cpc.vtigerQuit();
		System.out.println("Execute After Scenario -- 2 ");

	}
	

}
