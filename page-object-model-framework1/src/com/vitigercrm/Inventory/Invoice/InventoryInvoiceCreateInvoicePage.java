package com.vitigercrm.Inventory.Invoice;

import org.openqa.selenium.By;

import com.generic.layer.WebUtil;

public class InventoryInvoiceCreateInvoicePage {


	public void createAndSaveInventoryInvoiceInfo() throws InterruptedException {

		WebUtil.mySendkeys(By.name("subject"), "Hello Invoice", "Subject TextBox");
		WebUtil.mySendkeys(By.name("customerno"), "8767", "Customer No TextBox");

		String handlValue=WebUtil.fetchMainHandleValue();

		WebUtil.myActionsClick(By.xpath("//input[@name='contact_id']/following-sibling::img[@title='Select']"), "Contact Name Select button");
		WebUtil.threadWait(3000);
		WebUtil.switchToMultipleWindowByUrl("http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView");
		WebUtil.mySendkeys(By.name("search_text"), "willi", "Search TextBox");
		WebUtil.myClick(By.name("search"), "Search Button");
		WebUtil.myClick(By.xpath("//a[text()='Williams Linda']"), "Williams Linda Option");
		WebUtil.acceptAlert();

		WebUtil.switchToMainWindow(handlValue);

		WebUtil.myActionsClick(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']"), "Account Name Select button");
		WebUtil.threadWait(3000);
		WebUtil.switchToMultipleWindowByUrl("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
		WebUtil.mySendkeys(By.name("search_text"), "vtiger", "Search TextBox");
		WebUtil.myClick(By.name("search"), "Search Button");
		WebUtil.myClick(By.xpath("//a[text()='vtiger']"), "Vtiger Option");
		WebUtil.acceptAlert();

		WebUtil.switchToMainWindow(handlValue);

		WebUtil.myActionsClick(By.xpath("//input[@name='salesorder_id']/following-sibling::img"), "Sales Order Select button");
		WebUtil.threadWait(3000);
		WebUtil.switchToMultipleWindowByUrl("http://localhost:8888/index.php?module=SalesOrder&action=Popup&html=Popup_picker&popuptype=specific&form=EditView&&");
		WebUtil.mySendkeys(By.name("search_text"), "so1", "Search TextBox");
		WebUtil.myClick(By.name("search"), "Search Button");
		WebUtil.myClick(By.xpath("//a[text()='SO_vtiger']"), "SO1 Option");

		WebUtil.switchToMainWindow(handlValue);
		WebUtil.myClick(By.xpath("(//input[@title='Save [Alt+S]'])[1]"), "Save Button");
		WebUtil.acceptAlert();

	}

}
