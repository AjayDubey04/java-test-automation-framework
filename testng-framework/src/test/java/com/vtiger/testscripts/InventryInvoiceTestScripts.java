
package com.vtiger.testscripts;

import org.testng.annotations.Test;

import com.vtiger.baseclass.BaseClass;
import com.vtiger.pages.common.CommonReusableCodes;
import com.vtiger.pages.inventry.invoice.InventoryInvoiceNewCreateInvoice;
import com.vtiger.utils.WebUtil;

public class InventryInvoiceTestScripts extends BaseClass{

	///  requirement   Testing Logic  TestCase TestScript
	///  TDD -  Test Driven Development

	@Test
	public void verifyAccountAndContactAddOnInvoiceForm_VT006() {
		wt.printMessage("====  verifyAccountAndContactAddOnInvoiceForm_VT006 starts from here====");
		cc.goToInventoryInvoiceLink();
		cc.creatNewPluseButton();
		InventoryInvoiceNewCreateInvoice creatInvoice= new InventoryInvoiceNewCreateInvoice(wt);
		creatInvoice.fillUpInvoiceInformation("Test Account Name And Contact Name Addition");
		wt.printMessage("====  verifyAccountAndContactAddOnInvoiceForm_VT006 ends from here====");

	}

}
