package com.vtigercrm.testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;
import com.vtigercrm.common.reusablecodes.VtigerCommonReusableCodes;
import com.vtigercrm.marketing.accounts.MarketingAccountsLandingPage;
import com.vtigercrm.marketing.accounts.MarketingAccountsNewAccountCreatePage;


public class VerifyMarketingAccount {

	public void verifyMarketingAccountCreationTC001() throws InterruptedException {

		VtigerCommonReusableCodes login=new VtigerCommonReusableCodes();
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		MarketingAccountsLandingPage mlp=new MarketingAccountsLandingPage();
		mlp.marketingAccountsCreateButton();

		MarketingAccountsNewAccountCreatePage mcp=new MarketingAccountsNewAccountCreatePage();
		mcp.marketingAccountsCreateInfo();
		mcp.marketingAccountsCreateSaveButton();


	}

	public void verifytMarketingAccountChecBoxesTC002() throws InterruptedException {

		VtigerCommonReusableCodes login=new VtigerCommonReusableCodes();
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		WebUtil.checkAllCheckBoxes(By.xpath("//input[@name='selected_id']"), "Marketing Account Table ");
		WebUtil.unCheckAllCheckBoxes(By.xpath("//input[@name='selected_id']"), "Marketing Account Table ");

		ArrayList<String> columnList = WebUtil.getTableColumnNameInList(By.xpath("//a[@class='listFormHeaderLinks']"), "Marketing Account ");
		for (String string : columnList) {
			System.out.println(string);

			login.vtigerLogOut();	

		}
	}



	public void verifyAccountTableRowCountTC003() throws InterruptedException {

		VtigerCommonReusableCodes login=new VtigerCommonReusableCodes();
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();


		int before_creation=WebUtil.getTableRowCount(By.xpath("//table[@class='lvt small']//tr/following-sibling::tr"),"Marketing Account");

		WebUtil.myClick(By.xpath("//img[@title='Create Account...']"),"Plush Icon button");


		WebUtil.mySendkeys(By.xpath("//input[@name='accountname']"), "Hii76","Account Name TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='website']"),"www.google.com", "Website TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='phone']"), "8735676786","Phone TextBox");
		WebUtil.mySendkeys(By.xpath(" //input[@name='fax']"), "Hii56","Fax TextBox"); 
		WebUtil.myActionsClick(By.xpath("//input[@name='accountname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"), "First Sava button");

		Thread.sleep(1000);

		login.goToMarketingAccountsPage();

		int ofter_creation=WebUtil.getTableRowCount(By.xpath("//table[@class='lvt small']//tr/following-sibling::tr"),"Marketing Account"); 
		int expOfter_creation=ofter_creation-1;

		WebUtil.verifyNumberData(before_creation, expOfter_creation);

		login.vtigerLogOut();	

	}


	public  void verifyMerketingAccountTableRowTC004() throws InterruptedException {

		VtigerCommonReusableCodes login=new VtigerCommonReusableCodes();
		login.validVtigerLogin();
		login.goToMarketingAccountsPage();

		int count = WebUtil.getTableRowCount(By.xpath("//table[@class='lvt small']//tr/following-sibling::tr"),"Marketing Account");
		System.out.println("Marketing Account ==> " + count);

		System.out.println("======= Get Column Number By Column Name ===========");
		int columnNumber = WebUtil.getColumnNumberByColumnName(By.xpath("//a[@class='listFormHeaderLinks']"),"Billing City", "Marketing Account");
		System.out.println("Marketing Account Column Number ==> " + columnNumber);


		System.out.println("======= Get Column Data By Column Number ===========");
		ArrayList<String> listColumnDataByNo = WebUtil.getColumnDataByColumnNo("//table[@class='lvt small']", 2);
		for (String string : listColumnDataByNo) {
			System.out.println(string);
		}

		System.out.println("======= Get Column Data By Column Name ===========");
		ArrayList<String> listColumnData = WebUtil.getColumnDataByColumnName("//table[@class='lvt small']//a[@class='listFormHeaderLinks']", "//span[@vtfieldname='accountname']","Account Name");
		for (String string : listColumnData) {
			System.out.println(string);
		}

		System.out.println("======= Get Row Data By Row Number ===========");
		ArrayList<String> listRowData = WebUtil.getRowDataByRowNo("//table[@class='lvt small']", 11);
		for (String string : listRowData) {
			System.out.println(string);
		}

		int rowId = WebUtil.getRowNumberByRowId("//span[@vtfieldname='account_no']", "ACC5");
		System.out.println("row id ==>> " + rowId);

		login.vtigerLogOut();	

	}

}
