package com.vtigercrm.testcases;

import com.vitigercrm.Inventory.Invoice.InventoryIInvoiceLandingPage;
import com.vitigercrm.Inventory.Invoice.InventoryInvoiceCreateInvoicePage;
import com.vtigercrm.common.reusablecodes.VtigerCommonReusableCodes;

public class VerifyInventoryInvoice {


	public void	verifyInventoryInvoiceCreationTC005() throws InterruptedException{

		VtigerCommonReusableCodes vcr=new VtigerCommonReusableCodes();
		vcr.validVtigerLogin();
		vcr.goToInventoryInvoicePage();

		InventoryIInvoiceLandingPage ilp=new InventoryIInvoiceLandingPage();
		ilp.clickOnCreateInvoiceButton();

		InventoryInvoiceCreateInvoicePage icp=new InventoryInvoiceCreateInvoicePage();
		icp.createAndSaveInventoryInvoiceInfo();

	}

	public void verifyInventoryInvoiceIsVisiableTC006() throws InterruptedException {

		VtigerCommonReusableCodes vcr=new VtigerCommonReusableCodes();
		vcr.goToInventoryInvoicePage();

		InventoryIInvoiceLandingPage ilp=new InventoryIInvoiceLandingPage();
		ilp.isDisplayedInventoryInvoiceIs();
	}

}
