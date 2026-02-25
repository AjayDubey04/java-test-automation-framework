package com.vtigercrm.datatable.stepdefinitions;



import java.util.List;
import java.util.Map;

import com.vtigercrm.page.common.CommonPageCodes;
import com.vtigercrm.page.marketingaccounts.MarketingAccountsCreateNewAccountPage;
import com.vtigercrm.page.marketingaccounts.MarketingLandingAccountsPage;
import com.vtigercrm.utilitylayer.WebUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MultipleDataByDataTable {


	private WebUtil util= WebUtil.getObject();

	@Given("^user is already logged vtiger application with userName and password$")
	public void VtigerLogin(DataTable dt) throws InterruptedException {

		util.launchBrowserAndOpenVtigerLoginPage();
		List<Map<String,String>> dataListMap=dt.asMaps();
		Map<String,String> dataMap=dataListMap.get(0);
		CommonPageCodes login=new CommonPageCodes(util);
		login.validVtigerLoginByDataTable(dataMap);
	}


	@When("^user click on Vtiger marketing Accounts link$")
	public void goToMarketingAccounts() throws InterruptedException {

		CommonPageCodes mouseOver=new CommonPageCodes(util);
		mouseOver.goToMarketingAccountsPage();
	}


	@And("^user click on create new account button$")
	public void createNewAccountsImg() {

		MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
		mlap.marketingAccountsCreateButton();
	}



	@When("^enter all information and click on save button$")
	public void createAccountInformation(DataTable dt) throws InterruptedException {

		MarketingAccountsCreateNewAccountPage mcp=new MarketingAccountsCreateNewAccountPage(util);
		List<List<String>> dataList=dt.asLists();
		for (int i=0; i<dataList.size(); i++) {
			List<String> dtaListList=dataList.get(i);
			mcp.marketingAccountsCreateInfoForDataTable(dtaListList);
			MarketingLandingAccountsPage mlap=new MarketingLandingAccountsPage(util);
			mlap.marketingAccountsCreateButton();
		}
	}



	@Then("^user accounts Should Be created$")
	public void verifyAccountInfor() {

		System.out.println("User Accounts Is Created");
	}

}


	