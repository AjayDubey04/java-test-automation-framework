package com.vtigercrm.page.marketingaccounts;




import java.util.List;

import com.vtigercrm.utilitylayer.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingAccountsCreateNewAccountPage extends MarketingAccountsCreateNewAccountPageOR {


	private WebUtil wu;

	public MarketingAccountsCreateNewAccountPage(WebUtil wt) {
		super(wt);
		this.wu=wt;
	}

	public  void marketingAccountsCreateInfo(String accounName) {

		wu.mySendkeys(getAccountNameTBXpath(), accounName);
		wu.mySendkeys(getWebsiteTBXpath(), "www.google.com");
		wu.mySendkeys(getTickerSymbolTBXpath(), "EVS");
		wu.mySendkeys(getPhoneTBXpath(), "8735676786");
		wu.mySendkeys(getFaxTBXpath(), "Hii");
		wu.mySendkeys(getEmail1TBXpath(), "hiievs34@gmail.com");
		wu.mySendkeys(getDescriptionTBXpath(), "Hi I Am Creating New Marketing Accounts");

	}


	public  void marketingAccountsCreateInfoForScenarioOutline(String accname,String website,String ticker,String phone,String fax,String email,String descreption) {

		RandomString rs=new RandomString(5);
		String random=rs.nextString();

		wu.mySendkeys(getAccountNameTBXpath(), accname+random);
		wu.mySendkeys(getWebsiteTBXpath(), website);
		wu.mySendkeys(getTickerSymbolTBXpath(), ticker);
		wu.mySendkeys(getPhoneTBXpath(), phone);
		wu.mySendkeys(getFaxTBXpath(), fax);
		wu.mySendkeys(getEmail1TBXpath(), email);
		wu.mySendkeys(getDescriptionTBXpath(), descreption);
		wu.myActionsClick(getCreateAccountsSaveBtXpath());

	}


	public  void marketingAccountsCreateInfoForDataTable(List<String> dtaList) {

		RandomString rs=new RandomString(5);
		String random=rs.nextString();

		wu.mySendkeys(getAccountNameTBXpath(), dtaList.get(0)+random);
		wu.mySendkeys(getWebsiteTBXpath(), dtaList.get(1));
		wu.mySendkeys(getTickerSymbolTBXpath(), dtaList.get(2));
		wu.mySendkeys(getPhoneTBXpath(), dtaList.get(3));
		wu.mySendkeys(getFaxTBXpath(), dtaList.get(4));
		wu.mySendkeys(getEmail1TBXpath(), dtaList.get(5));
		wu.mySendkeys(getDescriptionTBXpath(), dtaList.get(6));
		wu.myActionsClick(getCreateAccountsSaveBtXpath());

	}

	public  void marketingCreatingNewAccountSaveButton()  {
		wu.myActionsClick(getCreateAccountsSaveBtXpath());
	}

	public  void MarketingCreatingNewAccountCancelButton() {
		wu.myActionsClick(getCreateAccountsCancelBtXpath());
	}


}
