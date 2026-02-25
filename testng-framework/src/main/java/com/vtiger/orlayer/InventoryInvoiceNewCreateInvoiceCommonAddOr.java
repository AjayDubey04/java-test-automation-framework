package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

import lombok.Getter;

@Getter
public class InventoryInvoiceNewCreateInvoiceCommonAddOr {

	public InventoryInvoiceNewCreateInvoiceCommonAddOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(),this);
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement expSearchNameTB;

	@FindBy(xpath="//input[@name='search_text']/parent::td/following-sibling::td//select")
	private WebElement searchTypeAttributeValueTB;

	@FindBy(xpath="//input[@name='search_text']/parent::td/following-sibling::td[last()]//input")
	private WebElement searchBT;

	@FindBy(xpath="//*[@id='ListViewContents']//tr[2]//tr[2]//a")
	private WebElement SearchNameValueClick;

	private String windowTitle="admin - Inventory - Invoice - vtiger CRM 5 - Commercial Open Source CRM";
	
	public WebElement getExpSearchNameTB() {
		return expSearchNameTB;
	}

	public WebElement getSearchTypeAttributeValueTB() {
		return searchTypeAttributeValueTB;
	}

	public WebElement getSearchBT() {
		return searchBT;
	}

	public WebElement getSearchNameValueClick() {
		return SearchNameValueClick;
	}

	public String getWindowTitle() {
		return windowTitle;
	}

}
