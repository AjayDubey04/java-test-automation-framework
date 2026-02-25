package com.example.pages.MarketingLeadsAccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountLandingPageOr {
	public MarketingAccountLandingPageOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(),this);
	}
	@FindBy(xpath="//table[@class='lvt small']//tr[2]//td[3]//a")
	private WebElement accountNameTB;

	@FindBy(xpath="//td[text()='Actions']/preceding::input[@title='Delete [Alt+D]']")
	private WebElement accountDelete;

	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement searchResult ;

	@FindBy(xpath="//td[text()='Actions']/preceding::input[@title='Duplicate [Alt+U]']")
	private WebElement duplicateBT;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement acName1;

	@FindBy(xpath="//span[@id='dtlview_Account Name']")
	private WebElement acName2;

	@FindBy(xpath="//span[@id='dtlview_Email']")
	private WebElement emailTb;

	@FindBy(xpath="//td[text()='Actions']/preceding::input[@title='Edit [Alt+E]']")
	private WebElement editBT;

	public WebElement getAccountNameTB() {
		return accountNameTB;
	}

	public WebElement getAccountDelete() {
		return accountDelete;
	}

	public WebElement getSearchResult() {
		return searchResult;
	}

	public WebElement getDuplicateBT() {
		return duplicateBT;
	}

	public WebElement getAcName1() {
		return acName1;
	}

	public WebElement getAcName2() {
		return acName2;
	}

	public WebElement getEmailTb() {
		return emailTb;
	}

	public WebElement getEditBT() {
		return editBT;
	}
}
