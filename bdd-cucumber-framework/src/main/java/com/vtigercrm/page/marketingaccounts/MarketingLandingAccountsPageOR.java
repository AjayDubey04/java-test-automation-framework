package com.vtigercrm.page.marketingaccounts;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.utilitylayer.WebUtil;

import lombok.Getter;

@Getter
public class MarketingLandingAccountsPageOR {
	


	public MarketingLandingAccountsPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);
	}

	
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement marketingAccountsModuleXpath;


	@FindBy(xpath="//img[@title='Create Account...']")
	private WebElement marketingAccountsCBTXpath;


	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchFieldTB;


	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBT;


	@FindBy(xpath="//select[@name='search_field']")
	private WebElement accountsDD;

	@FindBy(xpath="//a[@title='Accounts']")
	private WebElement accountsName;

	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBt;

}
