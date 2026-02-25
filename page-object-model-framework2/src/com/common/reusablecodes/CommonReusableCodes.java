package com.common.reusablecodes;



import com.utility.layer.WebUtil;



public class CommonReusableCodes  extends CommonReusableCodesOR{


	private WebUtil wu;

	public CommonReusableCodes(WebUtil wt){
		super(wt);
		this.wu=wt;
	}
	

	public  void validVtigerLogin() throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), "admin");
		wu.mySendkeys(getPasswordTbXpath(), "admin");
		wu.myClick(getLoginBtXpath());
	}

	public  void invalidVtigerLogin() throws InterruptedException {
		wu.mySendkeys(getUserNameTbXpath(), "admin");
		wu.mySendkeys(getPasswordTbXpath(), "76578");
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


}
