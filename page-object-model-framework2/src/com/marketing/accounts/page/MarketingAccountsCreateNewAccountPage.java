package com.marketing.accounts.page;




import com.utility.layer.WebUtil;

public class MarketingAccountsCreateNewAccountPage extends MarketingAccountsCreateNewAccountPageOR {


	private WebUtil wu;
	
	public MarketingAccountsCreateNewAccountPage(WebUtil wt) {
		super(wt);
		this.wu=wt;
	}

	public  void marketingAccountsCreateInfo() throws InterruptedException {

		wu.mySendkeys(getAccountNameTBXpath(), "Hello Evs");
		wu.mySendkeys(getWebsiteTBXpath(), "www.google.com");
		wu.mySendkeys(getTickerSymbolTBXpath(), "EVS");
		wu.mySendkeys(getPhoneTBXpath(), "8735676786");
		wu.mySendkeys(getFaxTBXpath(), "Hii");
		wu.mySendkeys(getEmail1TBXpath(), "hiievs34@gmail.com");
		wu.mySendkeys(getDescriptionTBXpath(), "Hi I Am Creating New Marketing Accounts");


	}

	public  void marketingAccountsCreateSaveButton() throws InterruptedException {
		wu.myActionsClick(getCreateAccountsSaveBtXpath());
	}

	public  void createMarketingAccountsCancelButton() throws InterruptedException {
		wu.myActionsClick(getCreateAccountsCancelBtXpath());
	}


}
