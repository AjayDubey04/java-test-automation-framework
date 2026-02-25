package com.vtiger.orlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utils.WebUtil;

public class InventoryProductsNewCreatProductFormOr {
	
	public InventoryProductsNewCreatProductFormOr(WebUtil webtl) {
		PageFactory.initElements(webtl.getDriver(), this);
	}

	@FindBy(xpath="//input[@name='productname']")
	protected WebElement productNameTB;
	
	@FindBy(xpath="//input[@name='productcode']")
	protected WebElement partNumberTB;
	
	@FindBy(xpath="//input[@name='sales_start_date']")
	protected WebElement salesStartDate;
	
	@FindBy(xpath="//select[@name='manufacturer']")
	protected WebElement ManufactureDD;
	
	@FindBy(xpath="//select[@name='productcategory']")
	protected WebElement productCategryDD;
}
