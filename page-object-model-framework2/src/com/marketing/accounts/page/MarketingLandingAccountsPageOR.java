package com.marketing.accounts.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.utility.layer.WebUtil;
import lombok.Getter;

@Getter
public class MarketingLandingAccountsPageOR {
	


	public MarketingLandingAccountsPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);
	}

	
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement marketingAccountsModuleXpath;


	@FindBy(xpath="//img[@title='Create Account...']")
	private WebElement marketingAccountsCBTXpath;


	@FindBys(value={@FindBy(xpath="//input[@name='selected_id']")})
	private List<WebElement> checkedAllCBXpath;


	@FindBys(@FindBy(xpath="//input[@name='selected_id']"))
	private List<WebElement> unCheckedAllCBXpath;


	@FindBys(@FindBy(xpath="//a[@class='listFormHeaderLinks']"))
	private List<WebElement> getAllCNXpath;

	@FindBys(@FindBy(xpath="//table[@class='lvt small']//tr/following-sibling::tr"))
	private List<WebElement> tableRowCountXpath;

	@FindBys(@FindBy(xpath="//a[@class='listFormHeaderLinks']"))
	private List<WebElement> getColumnNoByNameXpath;

}
