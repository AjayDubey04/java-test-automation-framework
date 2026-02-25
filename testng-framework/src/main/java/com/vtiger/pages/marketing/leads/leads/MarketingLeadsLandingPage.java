package com.vtiger.pages.marketing.leads.leads;

import com.vtiger.orlayer.MarketingLeadsLandingPageOr;
import com.vtiger.pages.common.CommonReusableCodes;
import com.vtiger.utils.WebUtil;

public class MarketingLeadsLandingPage extends MarketingLeadsLandingPageOr {
	
	WebUtil webtl;
	public MarketingLeadsLandingPage(WebUtil webtl) {
		super(webtl);
		this.webtl=webtl;
	}
	
	public String innerTextOfSearchedElement(String searchName,String SearchTypeAttributValue) {
		CommonReusableCodes cc=new CommonReusableCodes(webtl);
		cc.searchForElement(searchName,SearchTypeAttributValue );
		String actAccountName=webtl.myInnerText(getAccountNameTB());
		webtl.click(getFirstName());
		return actAccountName;
	}
}
