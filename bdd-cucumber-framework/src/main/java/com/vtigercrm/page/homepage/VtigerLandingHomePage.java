package com.vtigercrm.page.homepage;

import java.util.List;
import org.openqa.selenium.WebElement;

import com.vtigercrm.utilitylayer.WebUtil;


public class VtigerLandingHomePage extends VtigerLandingHomePageOR{


	private WebUtil wu;

	public VtigerLandingHomePage(WebUtil wt) {
		super(wt);
		this.wu=wt;
	}


	public void getHomePageHadaerText() throws InterruptedException {
		wu.myGetText(getHomePageModulexpath());
	}


	public void getHomePageUrl() {
		wu.myGetCurrentUrl("Home Page");
	}


	public void getHomePageTitle() {
		wu.myGetTitle("Home Page");
	}



	public void performHomePageDragAndDrop() throws InterruptedException {

		wu.myActionsDragAndDrop(getTopAccountDragXpath(), getMyRecentDropXpath());	
	}


	public void clickToAllHomePageTabLink() {
		List<WebElement> list=getAllTLXpath();
		for (int i=0; i<list.size(); i++) {
			WebElement we=list.get(i);
			String linkText=we.getText();
			System.out.println("===== "+linkText+" =====");
			we.click();
			clickToAllHomePageSubTabLink();
		}
	}

	public void clickToAllHomePageSubTabLink() {
		List<WebElement> list=getAllSubTLXpath();
		for (int i=0; i<list.size(); i++) {
			WebElement we=list.get(i);
			String subLinkText=we.getText();
			System.out.println(subLinkText);
			we.click();

		}
	}

	public void xHomePageScroll() {
		wu.jsScrolBy(5000, 0);
	}


	public void yHomePageScroll() {
		//          wu.jsScrolTo();
		wu.jsScrolBy(0, 1000);
	}


	public void veiwToHomePageElementScroll() throws InterruptedException {
		wu.jsScrollIntoView(getVeiwToScrollElementXpath());	
	}

}
