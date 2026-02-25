package com.vtigercrm.common.reusablecodes;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;

public class VtigerCommonReusableCodes {



	private String userNameTbXpath="user_name";
	private String passwordTbXpath="user_password";
	private String loginBtXpath="Login";
	private String logoutXpath="Sign Out";

	private String marketingLinkXpath="//a[text()='Marketing']";
	private String marketingAccountSubLinkXpath="//div[@id='Marketing_sub']//a[text()='Accounts']";

	private String inventoryLinkXpath="//a[text()='Inventory']";
	private String inventoryInvoiceSubLinkXpath="//div[@id='Inventory_sub']//a[text()='Invoice']";



	private void openVtigerLoginPage() throws InterruptedException {
		WebUtil.launchBrowser("chrome");
		WebUtil.openUrl("http://localhost:8888");
	}

	public  void validVtigerLogin() throws InterruptedException {
		openVtigerLoginPage();
		WebUtil.mySendkeys(By.name(userNameTbXpath), "admin", "UserName TextBox");
		WebUtil.mySendkeys(By.name(passwordTbXpath), "admin", "Password TextBox");
		WebUtil.myClick(By.name(loginBtXpath), "Login Button");
	}

	public  void invalidVtigerLogin() throws InterruptedException {
		openVtigerLoginPage();
		WebUtil.mySendkeys(By.name(userNameTbXpath), "admin", "UserName TextBox");
		WebUtil.mySendkeys(By.name(passwordTbXpath), "76578", "Password TextBox");
		WebUtil.myClick(By.name(loginBtXpath), "Login Button");
	}

	public  void vtigerLogOut() throws InterruptedException {
		WebUtil.myClick(By.linkText(logoutXpath), "Logout");	
	}


	public  void goToMarketingAccountsPage() throws InterruptedException {
		WebUtil.myMouseOver(By.xpath(marketingLinkXpath), "Marketing Link");
		WebUtil.myActionsClick(By.xpath(marketingAccountSubLinkXpath), "Marketing Accounts Sub Link");
	}	

	public  void goToInventoryInvoicePage() throws InterruptedException {
		WebUtil.myMouseOver(By.xpath(inventoryLinkXpath), "Inventory Link");
		WebUtil.myActionsClick(By.xpath(inventoryInvoiceSubLinkXpath), "Inventory Invoice Sub Link");
	}	


}
