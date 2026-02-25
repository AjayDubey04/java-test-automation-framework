package com.vtiger.homepage.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.utility.layer.WebUtil;

import lombok.Getter;


@Getter
public class VtigerLandingHomePageOR {


	public VtigerLandingHomePageOR(WebUtil wt){
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement homePageModulexpath; 
	
	@FindBy(xpath="//tr[@id='headerrow_14']")
	private WebElement topAccountDragXpath;
	
	@FindBy(xpath="//tr[@id='headerrow_1']")
	private WebElement myRecentDropXpath;
	
	@FindBy(xpath="//a[text()='vtiger.com']")
	private WebElement veiwToScrollElementXpath;

	@FindBys(value = { @FindBy(xpath="//table[@class='hdrTabBg']/descendant::a[contains(@href,'index.php?module')]") })
	private List<WebElement> allTLXpath;

	@FindBys(@FindBy(xpath="//table[@class='level2Bg']/descendant::a[contains(@href,'index.php?module')]"))
	private List<WebElement> allSubTLXpath;

}
