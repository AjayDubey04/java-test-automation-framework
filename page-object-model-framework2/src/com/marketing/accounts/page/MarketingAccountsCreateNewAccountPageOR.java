package com.marketing.accounts.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.layer.WebUtil;

import lombok.Getter;


@Getter
public class MarketingAccountsCreateNewAccountPageOR {
	
	
	public MarketingAccountsCreateNewAccountPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);
	}
	
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountNameTBXpath;

	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTBXpath;
	
	@FindBy(xpath="//input[@name='tickersymbol']")
	private WebElement tickerSymbolTBXpath;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneTBXpath;
	
	@FindBy(xpath="//input[@name='fax']")
	private WebElement faxTBXpath;
	
	@FindBy(xpath="//input[@name='email1']")
	private WebElement email1TBXpath;
	
	@FindBy(xpath="description")
	private WebElement descriptionTBXpath;
	
	
	@FindBy(xpath="//input[@name='accountname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement createAccountsSaveBtXpath;
   
	@FindBy(xpath="")
	private WebElement createAccountsCancelBtXpath;
	
	
	
	

}
