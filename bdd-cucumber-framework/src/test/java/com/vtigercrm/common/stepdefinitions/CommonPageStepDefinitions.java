package com.vtigercrm.common.stepdefinitions;


import com.vtigercrm.page.common.CommonPageCodes;
import com.vtigercrm.utilitylayer.WebUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonPageStepDefinitions  {

	private WebUtil util= WebUtil.getObject();

	
	
	
//	@Given("^user is already logged vtiger application with userName as (.*) and password as (.*)$")
//	public void loginVtigerApplication(String uesrName,String passwrod) throws InterruptedException {

//		util.launchBrowserAndOpenVtigerLoginPage();

//		CommonPageCodes login=new CommonPageCodes(util);
//		login.validVtigerLogin(uesrName,passwrod);
//	}


	@When("^user performed mouse over on marketing module link and click on accounts sub module link$")
	public void marketingMouseOver() throws InterruptedException {
		CommonPageCodes mouseOver=new CommonPageCodes(util);
		mouseOver.goToMarketingAccountsPage();
		util.logger.info("Executing When step: user performed mouse over on marketing module link and click on accounts sub module link");

	}

	
	@Then(value="^user should be navigate marketing accounts landing page$")
	public void verifyMarketingAccountsLandingPage() {
		util.logger.info("Executing Then step: user should be navigate marketing accounts landing page");
	}

//	@And("^browser is closed$")
//	public void closeBrowser() {
//		CommonPageCodes mouseOver=new CommonPageCodes(util);
//		mouseOver.vtigerClose();	
//	}
	

//	public void vtigerLogout() throws InterruptedException {
//		CommonPageCodes mouseOver=new CommonPageCodes(util);
//		mouseOver.vtigerLogOut();	
//	}

}
