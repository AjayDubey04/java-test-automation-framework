package com.vtiger.pages.marketing.leads.leads;

import com.vtiger.orlayer.MarketingLeadsInformationPageOr;
import com.vtiger.pages.common.CommonReusableCodes;
import com.vtiger.utils.WebUtil;

public class MarketingLeadsInformationPage extends MarketingLeadsInformationPageOr  {

	WebUtil webtl;
	public MarketingLeadsInformationPage(WebUtil webtl) {
		super(webtl);
		this.webtl=webtl;
	}

	public String innerTextsearchForLeadNumber() {
		String leadNumberText=webtl.myInnerText(getLeadNumber());
		String[] arrStr=leadNumberText.split("LEA");
		String leadNum=arrStr[1].trim();
		deleteButton();
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.searchForElement(leadNum, "lead_no");
		String leadResult=webtl.myInnerText(getLeadStatus());
		return leadResult;
	}
	public void deleteButton() {
		webtl.mouseClick(getDeleteBT());
		webtl.popUpAccept();
	}
	public String firstName() {
		String actName=webtl.myInnerText(getFirstName());
		return actName;
	}

}
