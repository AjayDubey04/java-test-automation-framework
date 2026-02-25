package com.vtiger.pages.common;
 
import com.vtiger.utils.WebUtil;

public class CommonReusableCodes extends CommonReusableCodesOr{
    
	private WebUtil wt;// null
	public CommonReusableCodes(WebUtil wu) {
		super(wu);
		this.wt=wu;
	}
	
	
	public void login(String username,String pass) {
		wt.windowMaximize();
		wt.myIplicitilyWait(60);
		wt.sendKeys(getUserNameTB(),"admin");
		wt.sendKeys(getPasswordTB(),"admin");
		wt.click(getLoginBT());
	}

	public void logOut() {
		wt.click(getSignOutBT());
	}
	
	public void close() {
		wt.myClose();
	}
	
	public void Quit() {
		wt.myQuit();
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
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingLK());
	}

	public void goToMarketingCampaignsLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingCampaignsLK());
	}

	public void goToMarketingAccountsLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingAccountsLK());
	}

	public void goToMarketingContactsLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingContactsLK());
	}
	public void goToMarketingWebmailLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingWebmailLK());
	}
	public void goToMarketingLeadsLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingLeadsLK());
	}
	public void goToMarketingCalendarLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingCalendarLK());
	}
	public void goToMarketingDocumentsLink() {
		wt.mouseMoveToElement(getMarketingLK());
		wt.click(getMarketingDocumentsLK());
	}

	//     _______________ Sales Methods ___________________

	public void goToSalesLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesLK());
	}
	public void goToSalesLeadsLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesLeadsLK());
	}
	public void goToSalesContactsLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesContactsLK());
	}
	public void goToSalesPotentialsLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesPotentialsLK());
	}
	public void goToSalesQuotesLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesQuotesLK());
	}
	public void goToSalesSalesOrderLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesSalesOrderLK());
	}
	public void goToSalesInvoiceLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesInvoiceLK());
	}
	public void goToSalesPriceBooksLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesPriceBooksLK());
	}
	public void goToSalesDocumentsLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesDocumentsLK());
	}
	public void goToSalesCalendarLink() {
		wt.mouseMoveToElement(getSalesLK());
		wt.click(getSalesCalendarLK());
	}

	//  _______________ Inventory Methods ___________________

	public void goToInventoryLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryLK());
	}
	public void goToInventoryProductsLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryProductsLK());
	}
	public void goToInventoryVendorsLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryVendorsLK());
	}
	public void goToInventoryPriceBooksLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryPriceBooksLK());
	}
	public void goToInventoryPurchaseOrderLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryPurchaseOrderLK());
	}
	public void goToInventorySalesOrderLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventorySalesOrderLK());
	}
	public void goToInventoryQuotesLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryQuotesLK());
	}
	public void goToInventoryInvoiceLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryInvoiceLK());
	}
	public void goToInventoryServicesLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryServicesLK());
	}
	public void goToInventoryAssetsLink() {
		wt.mouseMoveToElement(getInventoryLK());
		wt.click(getInventoryAssetsLK());
	}
}
