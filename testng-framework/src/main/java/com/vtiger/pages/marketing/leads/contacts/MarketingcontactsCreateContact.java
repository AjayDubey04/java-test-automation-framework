package com.vtiger.pages.marketing.leads.contacts;

import com.vtiger.orlayer.MarketingcontactsCreateContactOr;
import com.vtiger.utils.WebUtil;

public class MarketingcontactsCreateContact extends MarketingcontactsCreateContactOr{

	private WebUtil webtl;
	public MarketingcontactsCreateContact(WebUtil webtl) {
		super(webtl);
		this.webtl=webtl;

	}

	public String newCreateMarketingContacts(String expContactsName) {
		webtl.selectByValueAttribute(getSirNameTB(),  "Mr.");	
		webtl.sendKeys(getFirstNameTB(),expContactsName);
		webtl.sendKeys(getLastNameTB(),"EVA");
		webtl.sendKeys(getPhoneTB(),"8764564654");
		webtl.sendKeys(getEmailNameTB(),""+expContactsName+".tester@qa.com");
		webtl.myThread(3000);
		webtl.sendKeys(getMailingStreetTB(),"Sant Ravidash nagar near khamharia village");
		webtl.sendKeys(getMaillingPoBoxTB(),"bhadohi");
		webtl.sendKeys(getMaillingCityTB(),"varanashi");
		webtl.sendKeys(getMailingStateTB(),"utter pradesh");
		webtl.sendKeys(getMaillingCountryTB(),"india");
		webtl.click(getCopyMailingAddressRB());
		webtl.sendKeys(getDescriptionTB(),"“Set your goals high, and don't stop till you get there.”");
		return expContactsName;
	}

}
