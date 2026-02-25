package com.vtigercrm.marketing.accounts;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;

public class MarketingAccountsLandingPage {


	private String marketingAccountsModuleXpath="//td[@class='moduleName']";
	private String marketingAccountsCbXpath="//img[@title='Create Account...']";
	
	
	public  String getMarketingAccountsPageHader() throws InterruptedException {
		String hader= WebUtil.myGetText(By.xpath(marketingAccountsModuleXpath),"Marketing Accounts ModuleName");
		return 	hader;
	}

	
	public  void marketingAccountsCreateButton() throws InterruptedException {
		WebUtil.myClick(By.xpath(marketingAccountsCbXpath), "Plush Icon button");
	}

}
