package com.vtiger.pages.inventry.invoice;

import com.vtiger.orlayer.InventoryInvoiceNewCreateInvoiceCommonAddOr;
import com.vtiger.utils.WebUtil;

public class InventoryInvoiceNewCreateInvoiceCommonAdd extends InventoryInvoiceNewCreateInvoiceCommonAddOr{

	private WebUtil webtl;
	public InventoryInvoiceNewCreateInvoiceCommonAdd(WebUtil webtl) {
		super(webtl);
		this.webtl=webtl;
	}
	public String searchForElement(String expSearchName,String searchTypeAttributeValue) {
		webtl.sendKeys(getExpSearchNameTB(),expSearchName);
		webtl.selectByValueAttribute(getSearchTypeAttributeValueTB(), searchTypeAttributeValue);
		webtl.click(getSearchBT());
		return expSearchName;
	}	
	public void addElementName(String expSearchName,String valueAttribute) {
		webtl.switchToWindowByTitle("");
//		webtl.windowMaximize();
		InventoryInvoiceNewCreateInvoiceCommonAdd commonAdd= new InventoryInvoiceNewCreateInvoiceCommonAdd(webtl);
		commonAdd.searchForElement(expSearchName,valueAttribute);
		webtl.myThread(2000);
		webtl.click(getSearchNameValueClick());
		webtl.myThread(2000);
		webtl.popUpAccept();
		webtl.switchToWindowByTitle(getWindowTitle());
		webtl.myThread(2000);

	}
}
