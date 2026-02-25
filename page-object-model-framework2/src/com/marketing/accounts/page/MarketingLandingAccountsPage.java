package com.marketing.accounts.page;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.utility.layer.WebUtil;

import lombok.Getter;


public class MarketingLandingAccountsPage extends MarketingLandingAccountsPageOR {


	private WebUtil wu;

	public MarketingLandingAccountsPage(WebUtil wt){
		super(wt);
		this.wu=wt;
	}


	public  String getMarketingAccountsPageHader() throws InterruptedException {
		String hader=wu.myGetText(getMarketingAccountsModuleXpath());
		return 	hader;
	}

	public  void marketingAccountsCreateButton() throws InterruptedException {
		wu.myClick(getMarketingAccountsCBTXpath());
	}

	public void checkedAllcheckBoxes() {
		wu.checkAllCheckBoxes(getCheckedAllCBXpath());
	}

	public void uncheckedAllcheckBoxes() {
		wu.unCheckAllCheckBoxes(getUnCheckedAllCBXpath());
	}

	public void getTableListColumnName() {
		ArrayList<String> columnList =wu.getTableColumnNameInList(getGetAllCNXpath());
		for (String string : columnList) {
			System.out.println(string);
		}
	}

	public int countTableRow() {
		int count=wu.getTableRowCount(getTableRowCountXpath());
		return count;
	}


	public int getColumnNumberByColumnName() {
		int number =wu.getColumnNumberByColumnName(getGetColumnNoByNameXpath(),"Billing City");
		return number;
	}	
}
