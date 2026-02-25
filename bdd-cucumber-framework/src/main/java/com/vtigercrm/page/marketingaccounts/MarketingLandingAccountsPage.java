package com.vtigercrm.page.marketingaccounts;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.utilitylayer.WebUtil;

import lombok.Getter;


public class MarketingLandingAccountsPage extends MarketingLandingAccountsPageOR {


	private WebUtil wu;

	public MarketingLandingAccountsPage(WebUtil wt){
		super(wt);
		this.wu=wt;
	}


	public  String getMarketingAccountsPageHader() throws InterruptedException {
		String hader=wu.myGetText(getMarketingAccountsModuleXpath());
		return 	hader;
	}

	
	
	public  void marketingAccountsCreateButton()  {
		wu.myClick(getMarketingAccountsCBTXpath());
	}

	

	public void searchAndDeleteAccounts(String accName) throws InterruptedException {
		wu.mySendkeys(getSearchFieldTB(),accName);
		wu.mySelectByValue(getAccountsDD(), "accountname");
		wu.myClick(getSubmitBT());
		wu.myClick(getAccountsName());
		wu.myClick(getDeleteBt());
		wu.acceptAlert();
	}
	
}
