package com.example.pages.MarketingLeadsAccounts;

import com.aventstack.extentreports.Status;
import com.example.page.common.CommonReusableCodes;
import com.example.utils.WebUtil;

public class MarketingAccountLandingPage extends MarketingAccountLandingPageOr{

	private WebUtil webtl=WebUtil.getInstance();
	private CommonReusableCodes cc=new CommonReusableCodes(webtl);
	public MarketingAccountLandingPage(WebUtil webtl) {
		super(webtl);
			this.webtl=webtl;

	}

	public String innerTextOfSearchedElement(String searchName,String SearchTypeAttributValue) {
		cc.searchForElement(searchName,SearchTypeAttributValue );
		webtl.myThread(4000);
		String actAccountName=webtl.myInnerText(getAccountNameTB());
		return actAccountName;
	}
	public String clickOfSearchedElement(String searchName,String SearchTypeAttributValue) {
		cc.searchForElement(searchName,SearchTypeAttributValue );
		webtl.click(getAccountNameTB());
		String actAccountName=webtl.myInnerText(getAccountNameTB());
		return actAccountName;

	}

	public void deleteAndSearchAccountStatus(String searchName,String SearchTypeAttributValue) {
		webtl.click(getAccountDelete());
		webtl.acceptAlert();
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
		cc.saveButton();
		String emailAfterDuplicate=webtl.myInnerText(getEmailTb());
		if (emailBeforeDuplicate.equalsIgnoreCase(emailAfterDuplicate)) {
			webtl.getExtentTest().log(Status.INFO,"Passed !,the privious data "+emailBeforeDuplicate+" and current data "+emailAfterDuplicate+" is matched successfully");
		} else {
			webtl.getExtentTest().log(Status.INFO,"Failed !,the privious data "+emailBeforeDuplicate+" and current data "+emailAfterDuplicate+" is matched successfully");
		}
	}

	public String editAccountInformation() {
		webtl.click(getEditBT());
		webtl.myClear(getAcName1());
		String acNameAfrterEdit=webtl.getRandomName(10);
		webtl.sendKeys(getAcName1(),acNameAfrterEdit);
		cc.saveButton();
		String acNameAfterEdit=webtl.myInnerText(getAcName2());
		return acNameAfterEdit;
	}
}
