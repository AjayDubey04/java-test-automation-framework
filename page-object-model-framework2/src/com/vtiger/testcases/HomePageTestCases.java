package com.vtiger.testcases;

import com.common.reusablecodes.CommonReusableCodes;
import com.utility.layer.WebUtil;
import com.vtiger.homepage.page.VtigerLandingHomePage;

public class HomePageTestCases {




	public void verifyToGetHomePageHaderTextTC005() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.getHomePageHadaerText();

	}


	public void verifyToGetHomePageUrlTC006() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.getHomePageUrl();


	}


	public void verifyToGetHomePageTitleTC007() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.getHomePageTitle();

	}



	public void verifyToPerfornHomePageDragAndDropTC008() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		
		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();
		

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.performHomePageDragAndDrop();

	}


	public void verifyToClickAllTabAndSubTabLinkTC009() throws InterruptedException {

		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj) ;
		vlhp.clickToAllHomePageTabLink();


	}	
	
	public void VerifyToPerFormXScroll()throws InterruptedException {
		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.xHomePageScroll();
		
	}
	
	public void VerifyToPerFormYScroll() throws InterruptedException {
		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.yHomePageScroll();
		
	}
	
	public void VerifyToPerFormVeiwToElementScroll()throws InterruptedException {
		
		WebUtil obj=new WebUtil();
		obj.launchedBrowserOpenVtigerLoginPage();

		CommonReusableCodes login=new CommonReusableCodes(obj);
		login.validVtigerLogin();

		VtigerLandingHomePage vlhp=new VtigerLandingHomePage(obj);
		vlhp.veiwToHomePageElementScroll();
		
		
	}

}
