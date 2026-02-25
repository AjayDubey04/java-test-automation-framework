package com.vtigercrm.marketing.stepdefinitions;



import com.vtigercrm.page.marketingaccounts.MarketingAccountsCreateNewAccountPage;
import com.vtigercrm.page.marketingaccounts.MarketingLandingAccountsPage;
import com.vtigercrm.utilitylayer.WebUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MarketingAccountStepDefinitions  {


	private WebUtil util=WebUtil.getObject();



	@When("^user click on create new account option$")
	public void createNewAccountsOptions() {
		MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
		mlap.marketingAccountsCreateButton();
		util.logger.info("Executing When step: user click on create new account option");

	}



	@And("^enter all information  like unique accounts as (.*) , firtsName lastName etc and click on save button$")
	public void createAccountInfo(String accName) {
		MarketingAccountsCreateNewAccountPage mcp=new MarketingAccountsCreateNewAccountPage(util);
		mcp.marketingAccountsCreateInfo(accName);
		mcp.marketingCreatingNewAccountSaveButton();
		util.logger.info("Executing And step: enter all information  like unique accounts as  firtsName lastName etc and click on save button");

	}



	@Then("^user accounts Should Be created with valid information$")
	public void verifyAccountInformation() throws InterruptedException {
		Thread.sleep(5000);
		//		int x=10;
		//		Assert.assertEquals(x, 15);
		util.logger.info("Executing Then step: user accounts Should Be created with valid information");
	}





	//	Delete Accounts Scenario -- 2

	@When("^user search accounts by  accounts name as (.*) and click on delete button$")
	public void deleteAccounts(String accountsname) throws InterruptedException {

		MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
		mlap.searchAndDeleteAccounts(accountsname);
		util.logger.info("Executing When step: user search accounts by  accounts name and click on delete button");

	}

	@Then("^user accounts should be deleted by accepting popup$")
	public void verifyAccountsIsDeleted() throws InterruptedException {
		Thread.sleep(5000);
		util.logger.info("Executing Then step: user accounts should be deleted by accepting popup");
	}


}