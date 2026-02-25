package com.vtigercrm.scenariooutline.stepdefinitions;



import com.vtigercrm.page.common.CommonPageCodes;
import com.vtigercrm.page.marketingaccounts.MarketingAccountsCreateNewAccountPage;
import com.vtigercrm.page.marketingaccounts.MarketingLandingAccountsPage;
import com.vtigercrm.utilitylayer.WebUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleDataByScenarioOutline {

	private WebUtil util= WebUtil.getObject();

	@Given("^user is already logged vtiger CRM application with userName as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void VtigerLogin(String username,String password) throws InterruptedException {

		util.launchBrowserAndOpenVtigerLoginPage();
		CommonPageCodes login=new CommonPageCodes(util);
		login. validLoginByScenarioOutline(username,password);
	}


	@When("^user click on Vtiger marketing Accounts tabLink$")
	public void goToMarketingAccounts() throws InterruptedException {

		CommonPageCodes mouseOver=new CommonPageCodes(util);
		mouseOver.goToMarketingAccountsPage();
	}


	@And("^user click on create new account buttonImg$")
	public void createNewAccountsImg() {

		MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
		mlap.marketingAccountsCreateButton();
	}



	@When("^enter all information accountName as \"([^\"]*)\" website as \"([^\"]*)\" ticker as ([^\"]*) phone as \"([^\"]*)\" fax as \"([^\"]*)\"  email as \"([^\"]*)\" descreption as \"([^\"]*)\"and click on save button$")
	public void createAccountInformation(String accname,String website,String ticker,String phone,String fax,String email,String descreption) throws InterruptedException {

		MarketingAccountsCreateNewAccountPage mcp=new MarketingAccountsCreateNewAccountPage(util);
		mcp.marketingAccountsCreateInfoForScenarioOutline(accname,website,ticker,phone,fax,email,descreption);
		MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
		mlap.marketingAccountsCreateButton();

	}



	@Then("^user accounts Should Be created and browser is closed$")
	public void verifyAccountInfor() {
		System.out.println("User Accounts Is Created");
		CommonPageCodes cpc=new CommonPageCodes(util);
		cpc.vtigerClose();
	}

}
