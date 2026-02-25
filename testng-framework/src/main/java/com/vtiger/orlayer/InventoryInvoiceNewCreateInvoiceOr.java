package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class InventoryInvoiceNewCreateInvoiceOr {
	
	public InventoryInvoiceNewCreateInvoiceOr(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(),this );
	}
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement expSubjectNameTB;
	
	@FindBy(xpath="//input[@name='customerno']")
	private WebElement CustomerNumberTB;
	
	@FindBy(xpath="//input[@name='contact_id']/following-sibling::img")
	private WebElement SelectContactBT;
	
	@FindBy(xpath="//input[@name='vtiger_purchaseorder']")
	private WebElement PurchaseOrderTB;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement AccountNameTB;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement BillingAddressTB;
	
	@FindBy(xpath="//input[@name='bill_pobox']")
	private WebElement billPoBoxTB;
	
	@FindBy(xpath="//input[@name='bill_city']")
	private WebElement billCityTB ;
	
	@FindBy(xpath="//input[@name='bill_state']")
	private WebElement billStateTB;
	
	@FindBy(xpath="//input[@name='bill_code']")
	private WebElement billCodeTB;
	
	@FindBy(xpath="//input[@name='bill_country']")
	private WebElement billCountryTB;
	
	@FindBy(xpath="//b[text()='Copy Shipping address']/parent::td/following-sibling::td//input")
	private WebElement CopyBillingAddressRB;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement productLNK;

	public WebElement getExpSubjectNameTB() {
		return expSubjectNameTB;
	}

	public WebElement getCustomerNumberTB() {
		return CustomerNumberTB;
	}

	public WebElement getSelectContactBT() {
		return SelectContactBT;
	}

	public WebElement getPurchaseOrderTB() {
		return PurchaseOrderTB;
	}

	public WebElement getAccountNameTB() {
		return AccountNameTB;
	}

	public WebElement getBillingAddressTB() {
		return BillingAddressTB;
	}

	public WebElement getBillPoBoxTB() {
		return billPoBoxTB;
	}

	public WebElement getBillCityTB() {
		return billCityTB;
	}

	public WebElement getBillStateTB() {
		return billStateTB;
	}

	public WebElement getBillCodeTB() {
		return billCodeTB;
	}

	public WebElement getBillCountryTB() {
		return billCountryTB;
	}

	public WebElement getCopyBillingAddressRB() {
		return CopyBillingAddressRB;
	}

	public WebElement getProductLNK() {
		return productLNK;
	}
	
	
}
