package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class MarketingLaedsNewCreateLeadOr {
	
	public MarketingLaedsNewCreateLeadOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(),this);
	}
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement sirNameTB;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTB;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneTB;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailNameTB;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyTB;
	
	@FindBy(xpath="//textarea[@name='lane']")
	private WebElement laneTB;
	
	@FindBy(xpath="//input[@name='mailingcity']")
	private WebElement CityTB;
	
	@FindBy(xpath="//input[@name='mailingstate']")
	private WebElement StateTB;
	
	@FindBy(xpath="//input[@id='country']")
	private WebElement countryTB;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTB;

	public WebElement getSirNameTB() {
		return sirNameTB;
	}

	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	public WebElement getPhoneTB() {
		return phoneTB;
	}

	public WebElement getEmailNameTB() {
		return emailNameTB;
	}

	public WebElement getCompanyTB() {
		return companyTB;
	}

	public WebElement getLaneTB() {
		return laneTB;
	}

	public WebElement getCityTB() {
		return CityTB;
	}

	public WebElement getStateTB() {
		return StateTB;
	}

	public WebElement getCountryTB() {
		return countryTB;
	}

	public WebElement getDescriptionTB() {
		return descriptionTB;
	}

}
