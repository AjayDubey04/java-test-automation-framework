package com.vtigercrm.page.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.utilitylayer.WebUtil;

import lombok.Getter;

@Getter
public class CommonPageOR {

	public CommonPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(name = "user_name")
	private WebElement userNameTbXpath;

	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordTbXpath;

	@FindBy(xpath = "//input[@name='Login']")
	private WebElement loginBtXpath;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logoutXpath;

	@FindBy(xpath = "//a[text()='Marketing']")
	private WebElement marketingLkXpath;

	@FindBy(xpath = "//div[@id='Marketing_sub']//a[text()='Accounts']")
	private WebElement marketingAccountSubLkXpath;

	@FindBy(xpath = "//a[text()='Inventory']")
	private WebElement inventoryLkXpath;

	@FindBy(xpath = "//div[@id='Inventory_sub']//a[text()='Invoice']")
	private WebElement inventoryInvoiceSubLkXpath;

}
