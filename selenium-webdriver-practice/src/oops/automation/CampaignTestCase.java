package oops.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// Child                // parent 
public class CampaignTestCase extends UseableMethods {


	//  WebDriver driver as parameter
	public void verifyCampaignCreation() {

		WebElement we_link=DRIVER.findElement(By.linkText("Marketing"));
		Actions act=new Actions(DRIVER);
		act.moveToElement(we_link).perform();
		DRIVER.findElement(By.linkText("Campaigns")).click();

		DRIVER.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		WebElement campaign_name=DRIVER.findElement(By.name("campaignname"));
		campaign_name.sendKeys("VTiger");
		String expected_campaign_value=campaign_name.getAttribute("value");

		WebElement sponsor_name=DRIVER.findElement(By.id("sponsor"));
		sponsor_name.sendKeys("EVS");

		WebElement we_save=DRIVER.findElement(By.xpath("//input[@name='campaignname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"));
		we_save.click();

		String actual_campaign_value=DRIVER.findElement(By.id("dtlview_Campaign Name")).getText();
		if(expected_campaign_value.equals(actual_campaign_value)) {
			System.out.println("expected_campaign_value  Same As actual_campaign_value ");
		}else {
			System.out.println("expected_campaign_value  Different As actual_campaign_value ");
		}

	}

	//  WebDriver driver as parameter
	public void verifyCreationEdit() {

		DRIVER.findElement(By.name("Edit")).click();

		WebElement change_campaing_name=DRIVER.findElement(By.name("campaignname"));
		change_campaing_name.clear();
		change_campaing_name.sendKeys("customer_campaing");
		String expected_edit_value=change_campaing_name.getAttribute("value");


		WebElement save_again=DRIVER.findElement(By.xpath("//input[@name='campaignname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"));
		save_again.click();
		String actual_edit_value=DRIVER.findElement(By.id("dtlview_Campaign Name")).getText();
		if(expected_edit_value.equals(actual_edit_value)) {
			System.out.println(" expected_edit_value Same As actual_edit_value ");
		}else {
			System.out.println(" expected_edit_value Different As actual_edit_value ");
		}

	}


	//  WebDriver driver as parameter
	public void verifyDeleteCompaing() {

		DRIVER.findElement(By.linkText("Campaigns")).click();

		DRIVER.findElement(By.name("search_text")).sendKeys("customer_campaing");
		Select obj=new Select(DRIVER.findElement(By.id("bas_searchfield")));
		obj.selectByValue("campaignname");
		DRIVER.findElement(By.name("submit")).click();

		boolean visiable=DRIVER.findElement(By.xpath("//a[contains(@href,'index.php?module=Campaigns&parenttab=Marketing&action=DetailView&record')]")).isDisplayed();
		if(visiable==true) {
			System.out.println("customer_campaing is visiable");
		}else {
			System.out.println("customer_campaing is not visiable");
		}

		DRIVER.findElement(By.name("selectall")).click();

		DRIVER.findElement(By.xpath("//input[contains(@onclick,'Marketing')]/preceding-sibling::input")).click();
		DRIVER.switchTo().alert().accept();

		boolean visiable_again=DRIVER.findElement(By.xpath("//a[contains(@href,'index.php?module=Campaigns&parenttab=Marketing&action=DetailView&record')]")).isDisplayed();

		if(visiable_again==true) {
			System.out.println("customer_campaing is visiable");
		}else {
			System.out.println("customer_campaing is not visiable");
		}
	}


	public void verifyLeadsByName() {

		//td[@class='lvtCol']/parent::tr/following-sibling::tr/descendant::span[@vtfieldname="bill_city"]/parent::td
		//a[text()='Billing City']/parent::td/parent::tr/following-sibling::tr/descendant::span[@vtfieldname='bill_city']/parent::td

		WebElement support_link=DRIVER.findElement(By.linkText("Support"));
		Actions act=new Actions(DRIVER);
		act.moveToElement(support_link).perform();

		DRIVER.findElement(By.partialLinkText("Accounts")).click();

		List<WebElement> we_leads=DRIVER.findElements(By.xpath("//a[text()='Billing City']/parent::td/parent::tr/following-sibling::tr/descendant::span[@vtfieldname='bill_city']/parent::td"));
		for (WebElement leads : we_leads) {
			String leads_text=leads.getText();
			if(leads_text.equals("San Mateo")) {
				System.out.println("passed");
			}else {
				System.out.println("failed");
			}
		}

	}

}
