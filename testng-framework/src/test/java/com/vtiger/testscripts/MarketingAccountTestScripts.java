package com.vtiger.testscripts;

import org.testng.annotations.Test;

import com.vtiger.baseclass.BaseClass;
import com.vtiger.pages.marketing.leads.accounts.MarketingAccountLandingPage;
import com.vtiger.pages.marketing.leads.accounts.MarketingAccountsNewCreateAccount;

public class MarketingAccountTestScripts extends BaseClass{

	@Test(priority = 1)
	public void verifyVT001CreateAccount() throws InterruptedException {
		/*
		 * WebUtil wt=new WebUtil();
		 * webtl.printMessage("====verifyVT001CreateAccount starts from here====");
		 * webtl.launchBrowser(); CommonReusableCodes cc=new CommonReusableCodes(webtl);
		 * webtl.goToHitUrl("http://localhost:8888"); cc.login();
		 */
		wt.printMessage("====verifyVT001CreateAccount starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String expAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		if (actAccountName.equalsIgnoreCase(expAccountName)) {
			wt.printMessage("Passed !,new Account is created successfully");
		} else {
			wt.printMessage("Failed !,new Account is not created successfully");
		}
		/*
		 * cc.logOut(); wt.myQuit();
		 */
		wt.printMessage("====  verifyVT001CreateAccount ends from here====");
	}



	@Test(priority=3 , dependsOnMethods = {"verifyVT001CreateAccount", "", ""}, alwaysRun = true)
	public void verifyVT002DeleteAccount() throws InterruptedException {
		wt.printMessage("====  verifyVT002DeleteAccount starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String actAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		acLandingPage.deleteAndSearchAccountStatus(actAccountName, "accountname");
		wt.printMessage("====  verifyVT002DeleteAccount ends from here====");
	}
	
	
	////  sorting

	@Test(priority = 2)
	public void verifyVT003SearchAccount() throws InterruptedException {
		wt.printMessage("====  verifyVT003SearchAccount Starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String expAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		if (actAccountName.equalsIgnoreCase(expAccountName)) {
			wt.printMessage("Passed!,your expected name is searched successfully");
		} else {
			wt.printMessage("failed!,your expected name is not searched successfully");
		}
		wt.printMessage("====  verifyVT003SearchAccount ends from here====");
	}
	
	

	@Test
	public void verifyVT004DuplicateAccount() {
		wt.printMessage("======= verifyVT004DuplicateAccount Starts from here ======");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		acLandingPage.DuplicateAndEditStatus();
		wt.printMessage("======= verifyVT004DuplicateAccount ends from here ======");
	}
	
	

	@Test(priority=-2)
	public void verifyVT005AccountEditable()  {
		wt.printMessage("===== verifyVT005AccountEditable starts from here ======");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String acNameBeforeEdit=malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String acNameAfterEdit=acLandingPage.editAccountInformation();
		if (!acNameBeforeEdit.equalsIgnoreCase(acNameAfterEdit)) {  ///  !...not equalsIgnoreCase
			System.out.println("Passed !,your Account name is editable because your before edit A/C name ="+acNameBeforeEdit+" "
					+ "and after edit A/C name ="+acNameAfterEdit+" is different");

		} else {
			System.out.println("Failed !,your Account name is editable because your before edit A/C name ="+acNameBeforeEdit+" "
					+ "and after edit A/C name ="+acNameAfterEdit+" is same");
		}
		wt.printMessage("===== verifyVT005AccountEditable ends from here ======");
	}
}