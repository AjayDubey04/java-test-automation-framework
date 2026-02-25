package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class MarketingLeadsLandingPageOr {

	public MarketingLeadsLandingPageOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(),this );
	}
	
	@FindBy(xpath="//table[@class='lvt small']//tr[2]//td[4]//a")
	private WebElement accountNameTB;
	
	@FindBy(xpath="//table[@class='lvt small']//tr[2]//td[4]")
	private WebElement firstNameLNK;
	 
	public WebElement getAccountNameTB() {
		return accountNameTB;
	}
	public WebElement getFirstName() {
		return firstNameLNK;
	}
}
