package com.vtiger.pages.marketing.leads.accounts;

import com.vtiger.orlayer.MarketingAccountLandingPageOr;
import com.vtiger.pages.common.CommonReusableCodes;
import com.vtiger.utils.WebUtil;

public class MarketingAccountLandingPage extends MarketingAccountLandingPageOr{

	private WebUtil webtl;
	public MarketingAccountLandingPage(WebUtil webtl) {
		super(webtl);
			this.webtl=webtl;

	}

	public String innerTextOfSearchedElement(String searchName,String SearchTypeAttributValue) {
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.searchForElement(searchName,SearchTypeAttributValue );
		webtl.myThread(4000);
		String actAccountName=webtl.myInnerText(getAccountNameTB());
		return actAccountName;
	}
	public String clickOfSearchedElement(String searchName,String SearchTypeAttributValue) {
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.searchForElement(searchName,SearchTypeAttributValue );
		webtl.click(getAccountNameTB());
		String actAccountName=webtl.myInnerText(getAccountNameTB());
		return actAccountName;

	}

	public void deleteAndSearchAccountStatus(String searchName,String SearchTypeAttributValue) {
		webtl.click(getAccountDelete());
		webtl.popUpAccept();
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.searchForElement(searchName,SearchTypeAttributValue );
		String expResult="No Account Found !";
		String actResult=webtl.myInnerText(getSearchResult());
		if(expResult.equalsIgnoreCase(actResult)) {
			System.out.println("Passed!,your created lead has been deleted successfully");
		}else {
			System.out.println("failed!,your created lead hasn't been deleted successfully");
		}
	}
	public void DuplicateAndEditStatus() {
		String emailBeforeDuplicate=webtl.myInnerText(getEmailTb());
		webtl.click(getDuplicateBT());
		webtl.myClear(getAcName1());
		String accountName=webtl.getRandomName(10);
		webtl.sendKeys(getAcName1(),accountName);
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.saveButton();
		String emailAfterDuplicate=webtl.myInnerText(getEmailTb());
		if (emailBeforeDuplicate.equalsIgnoreCase(emailAfterDuplicate)) {
			webtl.printMessage("Passed !,the privious data "+emailBeforeDuplicate+" and current data "+emailAfterDuplicate+" is matched successfully");
		} else {
			webtl.printMessage("Failed !,the privious data "+emailBeforeDuplicate+" and current data "+emailAfterDuplicate+" is matched successfully");
		}
	}

	public String editAccountInformation() {
		webtl.click(getEditBT());
		webtl.myClear(getAcName1());
		String acNameAfrterEdit=webtl.getRandomName(10);
		webtl.sendKeys(getAcName1(),acNameAfrterEdit);
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.saveButton();
		String acNameAfterEdit=webtl.myInnerText(getAcName2());
		return acNameAfterEdit;
	}
}
