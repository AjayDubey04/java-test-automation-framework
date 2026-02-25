package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class MarketingcontactsCreateContactOr {
	public MarketingcontactsCreateContactOr(WebUtil webtl) {
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
	
	@FindBy(xpath="//textarea[@name='mailingstreet']")
	private WebElement mailingStreetTB;
	
	@FindBy(xpath="//input[@name='mailingpobox']")
	private WebElement maillingPoBoxTB;
	
	@FindBy(xpath="//input[@name='mailingcity']")
	private WebElement maillingCityTB;
	
	@FindBy(xpath="//input[@name='mailingstate']")
	private WebElement mailingStateTB;
	
	@FindBy(xpath="//input[@name='mailingcountry']")
	private WebElement maillingCountryTB;
	
	@FindBy(xpath="//b[text()='Copy Other Address']/following::input[@name='cpy']")
	private WebElement CopyMailingAddressRB;
	
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

	public WebElement getMailingStreetTB() {
		return mailingStreetTB;
	}

	public WebElement getMaillingPoBoxTB() {
		return maillingPoBoxTB;
	}

	public WebElement getMaillingCityTB() {
		return maillingCityTB;
	}

	public WebElement getMailingStateTB() {
		return mailingStateTB;
	}

	public WebElement getMaillingCountryTB() {
		return maillingCountryTB;
	}

	public WebElement getCopyMailingAddressRB() {
		return CopyMailingAddressRB;
	}

	public WebElement getDescriptionTB() {
		return descriptionTB;
	}

}
