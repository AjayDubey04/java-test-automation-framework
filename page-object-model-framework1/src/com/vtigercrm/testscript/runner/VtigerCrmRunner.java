package com.vtigercrm.testscript.runner;


import com.vtigercrm.testcases.VerifyInventoryInvoice;
import com.vtigercrm.testcases.VerifyMarketingAccount;

public class VtigerCrmRunner {

	public static void main(String[] args) throws InterruptedException {

		VerifyMarketingAccount obj=new VerifyMarketingAccount();
		obj.verifyMarketingAccountCreationTC001();
		//		obj.verifytMarketingAccountChecBoxesTC002();
		//		obj.verifyAccountTableRowCountTC003();
		//		obj.verifyMerketingAccountTableRowTC004();

		VerifyInventoryInvoice obj1=new VerifyInventoryInvoice();
		obj1.verifyInventoryInvoiceCreationTC005();
		obj1.verifyInventoryInvoiceIsVisiableTC006();

	}

}
