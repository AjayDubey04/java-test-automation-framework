package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class MarketingLeadsInformationPageOr {
	
	public MarketingLeadsInformationPageOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(),this);
	}
 
	@FindBy(xpath="//td[text()='Lead No']/following-sibling::td")
	private WebElement leadNumber;
	
	@FindBy(xpath="//td[text()='Actions']/preceding::input[@title='Delete [Alt+D]']")
	private WebElement deleteBT;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement leadStatus;

	@FindBy(xpath="//span[@id='dtlview_First Name']")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLeadNumber() {
		return leadNumber;
	}

	public WebElement getDeleteBT() {
		return deleteBT;
	}

	public WebElement getLeadStatus() {
		return leadStatus;
	}
	
	}

