package com.vitigercrm.Inventory.Invoice;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;

public class InventoryIInvoiceLandingPage {


	public  void clickOnCreateInvoiceButton() throws InterruptedException {
		WebUtil.myClick(By.xpath("//img[@title='Create Invoice...']"), "Create Invoice Plush Button");
	}


	public void isDisplayedInventoryInvoiceIs() throws InterruptedException {
		
    WebUtil.mySendkeys(By.name("search_text"),"Hello Invoice", "search_text TextBox");
    WebUtil.mySelectByValue(By.xpath("//select[@name='search_field']"), "search_field DropDown", "subject");
    WebUtil.myClick(By.name("submit"), "Search Button");
    WebUtil.displayedElement(By.xpath("(//a[text()='Hello Invoice'])[2]"), "Hello Invoice InventoryInvoice");

	}


}
