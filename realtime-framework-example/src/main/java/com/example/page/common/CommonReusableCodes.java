package com.example.page.common;

import com.example.utils.ReadConfig;
import com.example.utils.WebUtil;

public class CommonReusableCodes extends CommonReusableCodesOr{
    
	private WebUtil wt;// null
	public CommonReusableCodes(WebUtil wu) {
		super(wu);
		this.wt=wu;
	}
	
	ReadConfig  readProperty = new ReadConfig("config");
	 
	 
	
	public void login() throws InterruptedException {
		wt.sendKeys(getUserNameTB(),readProperty.getUserName());
		wt.sendKeys(getPasswordTB(),readProperty.getPassword());
		wt.click(getLoginBT());
	}

	public void logOut() {
		wt.click(getSignOutBT());
	}
	
	public void close() {
		wt.myClose();
	}

	public  void creatNewPluseButton() {
		wt.click(getCreatNewPluseBT());
	}

	public void saveButton() {
		wt.click(getSaveBT());

	}
	public void searchForElement(String expName,String searchTypeAttributeValue) {
		wt.sendKeys(getSearchforTB(), expName);
		wt.selectByValueAttribute(getSelectTypeDD(), searchTypeAttributeValue);
		wt.click(getSearchButtonBT());
		wt.myThread(3000);
	}

	public int getTableColumnHeaderCount() {
		int countColumn=getListColumns().size();
		return  countColumn;
	}  
 
	//     _______________ Marketing Methods ___________________

	public void goToMarketing() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingLK());
	}

	public void goToMarketingCampaignsLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingCampaignsLK());
	}

	public void goToMarketingAccountsLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingAccountsLK());
	}

	public void goToMarketingContactsLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingContactsLK());
	}
	public void goToMarketingWebmailLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingWebmailLK());
	}
	public void goToMarketingLeadsLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingLeadsLK());
	}
	public void goToMarketingCalendarLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingCalendarLK());
	}
	public void goToMarketingDocumentsLink() {
		wt.mouseToElement(getMarketingLK());
		wt.click(getMarketingDocumentsLK());
	}

	//     _______________ Sales Methods ___________________

	public void goToSalesLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesLK());
	}
	public void goToSalesLeadsLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesLeadsLK());
	}
	public void goToSalesContactsLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesContactsLK());
	}
	public void goToSalesPotentialsLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesPotentialsLK());
	}
	public void goToSalesQuotesLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesQuotesLK());
	}
	public void goToSalesSalesOrderLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesSalesOrderLK());
	}
	public void goToSalesInvoiceLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesInvoiceLK());
	}
	public void goToSalesPriceBooksLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesPriceBooksLK());
	}
	public void goToSalesDocumentsLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesDocumentsLK());
	}
	public void goToSalesCalendarLink() {
		wt.mouseToElement(getSalesLK());
		wt.click(getSalesCalendarLK());
	}

	//  _______________ Inventory Methods ___________________

	public void goToInventoryLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryLK());
	}
	public void goToInventoryProductsLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryProductsLK());
	}
	public void goToInventoryVendorsLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryVendorsLK());
	}
	public void goToInventoryPriceBooksLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryPriceBooksLK());
	}
	public void goToInventoryPurchaseOrderLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryPurchaseOrderLK());
	}
	public void goToInventorySalesOrderLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventorySalesOrderLK());
	}
	public void goToInventoryQuotesLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryQuotesLK());
	}
	public void goToInventoryInvoiceLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryInvoiceLK());
	}
	public void goToInventoryServicesLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryServicesLK());
	}
	public void goToInventoryAssetsLink() {
		wt.mouseToElement(getInventoryLK());
		wt.click(getInventoryAssetsLK());
	}
}
