package com.vtigercrm.marketing.accounts;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;

public class MarketingAccountsNewAccountCreatePage {


	private String createAccountsSaveBtXpath="//input[@name='accountname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']";
    private String createAccountsCancelBtXpath="";
	
	
	public  void marketingAccountsCreateInfo() throws InterruptedException {

		WebUtil.mySendkeys(By.xpath("//input[@name='accountname']"), "Hello Evs", "Account Name TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='website']"), "www.google.com", "Website TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='tickersymbol']"), "EVS", "Ticker Symbol TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='phone']"), "8735676786", "Phone TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='fax']"), "Hii", "Fax TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='email1']"), "hiievs34@gmail.com", "Email1 TextBox");
		WebUtil.mySendkeys(By.name("description"), "Hi I Am Creating New Marketing Accounts","Description TextBox");


	}

	public  void marketingAccountsCreateSaveButton() throws InterruptedException {
		WebUtil.myActionsClick(By.xpath(createAccountsSaveBtXpath),"First Sava button");
	}
	
	public  void createMarketingAccountsCancelButton() throws InterruptedException {
		WebUtil.myActionsClick(By.xpath(createAccountsCancelBtXpath),"First Cancel button");
	}


}
