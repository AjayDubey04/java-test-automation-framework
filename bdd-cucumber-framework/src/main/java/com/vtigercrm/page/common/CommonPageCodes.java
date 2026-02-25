package com.vtigercrm.page.common;



import java.util.Map;

import com.vtigercrm.utilitylayer.WebUtil;



public class CommonPageCodes  extends CommonPageOR{


	private WebUtil wu;

	public CommonPageCodes(WebUtil wt){
		super(wt);
		this.wu=wt;
	}

	public  void validVtigerLogin(String userName,String passName) throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), userName);
		wu.mySendkeys(getPasswordTbXpath(), passName);
		wu.myClick(getLoginBtXpath());
	}
	
	public  void validVtigerLoginByDataTable(Map<String,String> dataMap) throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), dataMap.get("UserName"));
		wu.mySendkeys(getPasswordTbXpath(), dataMap.get("Password"));
		wu.myClick(getLoginBtXpath());
	}
	
	public  void validLoginByScenarioOutline(String username,String password) throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), username);
		wu.mySendkeys(getPasswordTbXpath(), password);
		wu.myClick(getLoginBtXpath());
	}

	public  void invalidVtigerLogin(String userName,String passName) throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), userName);
		wu.mySendkeys(getPasswordTbXpath(), passName);
		wu.myClick(getLoginBtXpath());
	}

	public  void vtigerLogOut() throws InterruptedException {
		wu.myClick(getLogoutXpath());	
	}


	public  void goToMarketingAccountsPage() throws InterruptedException {
		wu.myMouseOver(getMarketingLkXpath());
		wu.myActionsClick(getMarketingAccountSubLkXpath());
	}
	

	public  void goToInventoryInvoicePage() throws InterruptedException {
		wu.myMouseOver(getInventoryLkXpath());
		wu.myActionsClick(getInventoryInvoiceSubLkXpath());
	}	

	
	public void vtigerClose() {
		wu.myClose();
	}
	
	public void vtigerQuit() {
		wu.myQuit();
	}

}
