package com.example.page.common;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.example.utils.WebUtil;

import lombok.Getter;

@Getter
public class CommonReusableCodesOr {
	
	public CommonReusableCodesOr(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(),this);// 8 byte
	}
	
	//     _______________ login ___________________

	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userNameTB;

	@FindBy(xpath="//input[@name='user_password']")
	
	private WebElement passwordTB;

	@FindBy(xpath="//input[@title='Login [Alt+L]']")
	private WebElement loginBT;

	//   _______________ logOut ___________________

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutBT;

	//  _______________ creatNewPluseButton ___________________

	

	@FindBy(xpath="//img[contains(@title,'Create ') or @title='']")
	private WebElement creatNewPluseBT;

	//  _______________ searchForElement ___________________

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchforTB;

	@FindBy(xpath="//div[@id='basicsearchcolumns_real']//select[@id='bas_searchfield']")
	private WebElement selectTypeDD;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchButtonBT;

	//  _______________ saveButton ___________________

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBT;

	//  _______________ searchForElement ___________________

	@FindBys(@FindBy(xpath="//table[@class='lvtBg']//tr[1]//td"))
	private List<WebElement> listColumns;

	@FindBys(@FindBy(xpath="//table[@class='lvtBg']//tr"))
	private List<WebElement> weRowsList;
	
//  _______________ Marketing ___________________

	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketingLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Campaigns']")
	private WebElement MarketingCampaignsLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Accounts']")
	private WebElement MarketingAccountsLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Contacts']")
	private WebElement MarketingContactsLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Webmail']")
	private WebElement MarketingWebmailLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Leads']")
	private WebElement MarketingLeadsLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Calendar']")
	private WebElement MarketingCalendarLK;

	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Documents']")
	private WebElement MarketingDocumentsLK;
	
	//     _______________ Sales ___________________

	@FindBy(xpath="//a[text()='Sales']")
	private WebElement SalesLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Leads']")
	private WebElement SalesLeadsLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Accounts']")
	private WebElement SalesAccountsLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Contacts']")
	private WebElement SalesContactsLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Potentials']")
	private WebElement SalesPotentialsLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Quotes']")
	private WebElement SalesQuotesLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Sales Order']")
	private WebElement SalesSalesOrderLK;

	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Invoice']")
	private WebElement SalesInvoiceLK;
	
	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Price Books']")
	private WebElement SalesPriceBooksLK;
	
	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Documents']")
	private WebElement SalesDocumentsLK;
	
	@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Calendar']")
	private WebElement SalesCalendarLK;

//_______________ Inventory ___________________

	@FindBy(xpath="//a[text()='Inventory']")
	private WebElement InventoryLK;

	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Products']")
	private WebElement InventoryProductsLK;

	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Vendors']")
	private WebElement InventoryVendorsLK;

	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Price Books']")
	private WebElement InventoryPriceBooksLK;
	
	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Purchase Order']")
	private WebElement InventoryPurchaseOrderLK;

	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Sales Order']")
	private WebElement InventorySalesOrderLK;
	
	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Quotes']")
	private WebElement InventoryQuotesLK;

	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Invoice']")
	private WebElement InventoryInvoiceLK;
	
	@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Services']")
	private WebElement InventoryServicesLK;
	 
	@FindBy(xpath="//div[@id='Inventory_sub']//a[text()='Assets']")
	private WebElement InventoryAssetsLK;

	
	
}
