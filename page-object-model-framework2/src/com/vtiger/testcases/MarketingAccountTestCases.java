package com.vtiger.testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;


import com.common.reusablecodes.CommonReusableCodes;
import com.marketing.accounts.page.MarketingAccountsCreateNewAccountPage;
import com.marketing.accounts.page.MarketingLandingAccountsPage;
import com.utility.layer.WebUtil;

import net.bytebuddy.description.type.TypeDescription.Generic;


public class MarketingAccountTestCases {



	public void verifyMarketingAccountCreationTC001() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		MarketingLandingAccountsPage mlp=new MarketingLandingAccountsPage(obj);
		mlp.marketingAccountsCreateButton();

		MarketingAccountsCreateNewAccountPage mcp=new MarketingAccountsCreateNewAccountPage(obj);
		mcp.marketingAccountsCreateInfo();
		mcp.marketingAccountsCreateSaveButton();


	}

	public void verifytMarketingAccountChecBoxesTC002() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		MarketingLandingAccountsPage malp=new MarketingLandingAccountsPage(obj);
		malp.checkedAllcheckBoxes();
		malp.uncheckedAllcheckBoxes();
		malp.getTableListColumnName();

		login.vtigerLogOut();	

	}




	public void verifyAccountTableRowCountTC003() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();



		MarketingLandingAccountsPage malp=new MarketingLandingAccountsPage(obj);
		int before_creation=malp.countTableRow();
		malp.marketingAccountsCreateButton();

		MarketingAccountsCreateNewAccountPage manacp=new MarketingAccountsCreateNewAccountPage(obj);
		manacp.marketingAccountsCreateInfo();
		manacp.marketingAccountsCreateSaveButton();

		Thread.sleep(1000);

		login.goToMarketingAccountsPage();

		int ofter_creation=malp.countTableRow(); 

		obj.verifyNumberData(before_creation, ofter_creation);

		login.vtigerLogOut();	

	}


	public  void verifyMerketingAccountTableRowTC004() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		MarketingLandingAccountsPage malp=new MarketingLandingAccountsPage(obj);

		int count=malp.countTableRow();
		System.out.println("Marketing Account ==> " + count);

		System.out.println("======= Get Column Number By Column Name ===========");
		int columnNumber = malp.getColumnNumberByColumnName();
		System.out.println("Marketing Account Column Number ==> " + columnNumber);


		System.out.println("======= Get Column Data By Column Number ===========");
		ArrayList<String> listColumnDataByNo = obj.getColumnDataByColumnNo("//table[@class='lvt small']", 2);
		for (String string : listColumnDataByNo) {
			System.out.println(string);
		}

		System.out.println("======= Get Column Data By Column Name ===========");
		ArrayList<String> listColumnData = obj.getColumnDataByColumnName("//table[@class='lvt small']//a[@class='listFormHeaderLinks']", "//span[@vtfieldname='accountname']","Account Name");
		for (String string : listColumnData) {
			System.out.println(string);
		}

		System.out.println("======= Get Row Data By Row Number ===========");
		ArrayList<String> listRowData = obj.getRowDataByRowNo("//table[@class='lvt small']", 11);
		for (String string : listRowData) {
			System.out.println(string);
		}

		int rowId = obj.getRowNumberByRowId("//span[@vtfieldname='account_no']", "ACC5");
		System.out.println("row id ==>> " + rowId);

		login.vtigerLogOut();	

	}

}
