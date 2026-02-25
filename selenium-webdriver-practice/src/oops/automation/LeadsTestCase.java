package oops.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import predefine.methods.VtigerLoginPage;

public class LeadsTestCase extends VtigerLoginPage {



	public void verifyCreateLeads() {
		
		 //  verify Account Leads //
		Actions act=new Actions(driver);
		WebElement weLink= driver.findElement(By.linkText("Marketing"));
		act.moveToElement(weLink).perform();
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();

		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Leads");
		String expectedFirstNameValue=firstName.getAttribute("value");


		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Automate");
		String expectedLastNameValue=lastName.getAttribute("value");


		WebElement company=driver.findElement(By.xpath("//input[@name='company']"));
		company.sendKeys("Marketing");
		String expectedCompanyValue=company.getAttribute("value");


		WebElement saveLeads=driver.findElement(By.xpath("//input[@name='firstname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"));
		saveLeads.click();

		String actualeFirstNameValue=driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		if(expectedFirstNameValue.equals(actualeFirstNameValue)) {
			System.out.println(" ExpectedFirstName Value Same As ActualeFirstName Value ");
		}else {
			System.out.println(" ExpectedFirstName Value Different As ActualeFirstName Value ");
		}

		String actualeLastNameValue=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(expectedLastNameValue.equals(actualeLastNameValue)) {
			System.out.println(" ExpectedLastName Value Same As ActualeLastName Value ");
		}else {
			System.out.println(" ExpectedLastName Value Different As ActualeLastName Value ");
		}


		String actualeCompanyValue=driver.findElement(By.xpath("//span[@id='dtlview_Company']")).getText();
		if(expectedCompanyValue.equals(actualeCompanyValue)) {
			System.out.println(" ExpectedCompany Value Same As ActualeCompany Value \n ");

		}else {
			System.out.println(" ExpectedCompany Value Different As ActualeCompany Value \n");
		}
	}


	public void verifyEditLeads() {
		
          //  verify Edit Leads //
		driver.findElement(By.xpath("//td[@class='dvtSelectedCell']/parent::tr/descendant::input[@name='Edit']")).click();
		WebElement editLastName=driver.findElement(By.name("lastname"));
		editLastName.clear();
		editLastName.sendKeys("Account");
		String expectedChangeLastNameValue=editLastName.getAttribute("value");

		WebElement reSave=driver.findElement(By.xpath("//input[@name='firstname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"));
		reSave.click();

		String actualeChangeLastNameVaue=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(expectedChangeLastNameValue.equals(actualeChangeLastNameVaue)) {
			System.out.println(" Same As Edit LastName Value \n");
		}else {
			System.out.println(" Different As  Edit LastName Value \n");
		}
	}


	public void verifyDeleteLeads() {
		
		 //  verify Delete Leads //
		driver.findElement(By.linkText("Leads")).click();
		Select obj=new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
		obj.selectByValue("lastname");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Account");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		WebElement leads=driver.findElement(By.linkText("Account"));
		boolean leadsVisibility=leads.isDisplayed();
		String leadsNo=leads.getText();
		if(leadsVisibility==true && leadsNo.equals("Account") ) {
			System.out.println(" Account Leads is visiable" );
		}else {
			System.out.println(" Account Leads is not visiable ");
		}

		driver.findElement(By.xpath("//input[@name='selectall']")).click();
		driver.findElement(By.xpath("//input[contains(@onclick,'Marketing')]/preceding-sibling::input[@value='Delete']")).click();      
		driver.switchTo().alert().accept();

		String leadNotFound=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		if(leadNotFound.equals("No Lead Found !")) {
			System.out.println(" Same As (No Lead Found !) Error ");
		}else {
			System.out.println(" Different As (No Lead Found !) Error ");
		}
	}

	public static void main(String[] args) {
		LeadsTestCase obj=new LeadsTestCase();
		obj.loginVtiger();
		obj.verifyCreateLeads();
		obj.verifyEditLeads();
		obj.verifyDeleteLeads();

	}

}
