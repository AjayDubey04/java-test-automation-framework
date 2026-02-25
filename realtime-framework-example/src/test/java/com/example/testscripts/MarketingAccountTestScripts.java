package com.example.testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.MarketingLeadsAccounts.MarketingAccountLandingPage;
import com.example.pages.MarketingLeadsAccounts.MarketingAccountsNewCreateAccount;
import com.example.tests.BaseTest;
import com.example.utils.ExcelUtils;

public class MarketingAccountTestScripts extends BaseTest{


	
	@DataProvider(name="accountInfo")
	public Object[][] accountInfo() {
		
//		String[]arr=new  String[8];
//		arr[0]="Abhi";
//		arr[1]="abhi.evs@gmail.com";
//		arr[2]="8947863734";
//		arr[3]="A fax called telecopying";
//		arr[4]="utter pradesh";
//		arr[5]="68536";
//		arr[6]="india";
//		arr[7]="Do work hard until you do";
		
		String[] arr1=new  String[8];
		arr1[0]="Ajay";
		arr1[1]="shubham.evs@gmail.com";
		arr1[2]="8947863734";
		arr1[3]="A fax called telecopying";
		arr1[4]="utter pradesh";
		arr1[5]="68536";
		arr1[6]="india";
		arr1[7]="Do work hard until you do";
		
		String[][] arr2=new  String[1][8];
//		arr2[0]=arr;
		arr2[0]=arr1;
		
		return arr2;
		
	}
	
	
	
	@DataProvider(name = "excelData")
    public Object[][] provideExcelData()  {
        // Replace with the actual path to your Excel file and sheet name
		String filePath = "src\\test\\resources\\testData\\testdata.xlsx";
		String sheetName = "Sheet1";

        List<List<String>> excelData = ExcelUtils.readExcelData(filePath, sheetName);

        Object[][] data = new Object[excelData.size()][8];

        for (int i = 0; i < excelData.size(); i++) {
            data[i][8] = excelData.get(i);
        }

        return data;
    }
	
	
	@Test(priority = 1,dataProvider ="accountInfo")
	public void verifyCreateAccountTC001(String accname,String email,String contact,String msg,String state,String pincode,String country,String sms) throws InterruptedException {

//		wt.getExtentTest().log(Status.INFO,"====verifyVT001CreateAccount starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String expAccountName =malp.fillUpBasicInformation(accname,email,contact,msg,state,pincode,country,sms);		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		Assert.assertEquals(actAccountName,expAccountName);
		wt.getExtentTest().log(Status.INFO,"Passed !,new Account is created successfully");
//		wt.getExtentTest().log(Status.INFO,"====  verifyVT001CreateAccount ends from here====");

	}
	

	/*
	 * @Test(priority = 1) public void verifyCreateAccountTC001() throws
	 * InterruptedException {
	 * 
	 * wt.getExtentTest().log(Status.
	 * INFO,"====verifyVT001CreateAccount starts from here====");
	 * cc.goToMarketingAccountsLink(); cc.creatNewPluseButton();
	 * MarketingAccountsNewCreateAccount malp= new
	 * MarketingAccountsNewCreateAccount(wt); String expAccountName
	 * =malp.fillUpBasicInformation(); cc.saveButton(); cc.goToMarketing();
	 * cc.goToMarketingAccountsLink(); MarketingAccountLandingPage acLandingPage=
	 * new MarketingAccountLandingPage(wt); String
	 * actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName,
	 * "accountname"); Assert.assertEquals(actAccountName,expAccountName); //
	 * wt.getExtentTest().log(Status.
	 * INFO,"Passed !,new Account is created successfully");
	 * wt.getExtentTest().log(Status.
	 * INFO,"====  verifyVT001CreateAccount ends from here====");
	 * 
	 * }
	 */



	@Test(priority=2,dataProvider ="accountInfo")
	public void verifySearchAccountTC002(String accname,String email,String contact,String msg,String state,String pincode,String country,String sms) throws InterruptedException {

//		wt.getExtentTest().log(Status.INFO,"====  verifyVT003SearchAccount Starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String expAccountName =malp.fillUpBasicInformation(accname,email,contact,msg,state,pincode,country,sms);		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		Assert.assertEquals(actAccountName,expAccountName);
		wt.getExtentTest().log(Status.INFO,"Passed!,your expected name is searched successfully");
//		wt.getExtentTest().log(Status.INFO,"====  verifyVT003SearchAccount ends from here====");

	}



	@Test(priority = 3,dataProvider ="accountInfo")
	public void verifyDuplicateAccountTC003(String accname,String email,String contact,String msg,String state,String pincode,String country,String sms) {

//		wt.getExtentTest().log(Status.INFO,"======= verifyVT004DuplicateAccount Starts from here ======");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		malp.fillUpBasicInformation(accname,email,contact,msg,state,pincode,country,sms);		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		acLandingPage.DuplicateAndEditStatus();
//		wt.getExtentTest().log(Status.INFO,"======= verifyVT004DuplicateAccount ends from here ======");

	}




	@Test(priority = 4,dataProvider ="accountInfo")
	public void verifyAccountEditableTC004(String accname,String email,String contact,String msg,String state,String pincode,String country,String sms)  {

//		wt.getExtentTest().log(Status.INFO,"===== verifyVT005AccountEditable starts from here ======");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String acNameBeforeEdit=malp.fillUpBasicInformation(accname,email,contact,msg,state,pincode,country,sms);		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		String acNameAfterEdit=acLandingPage.editAccountInformation();
		Assert.assertEquals(acNameBeforeEdit,acNameAfterEdit);
		wt.getExtentTest().log(Status.INFO,"Passed !,your Account name is editable because your before edit A/C name ="+acNameBeforeEdit+" "
				+ "and after edit A/C name ="+acNameAfterEdit+" is different");
//		wt.getExtentTest().log(Status.INFO,"===== verifyVT005AccountEditable ends from here ======");

	}


	@Test(priority = 5,dataProvider ="accountInfo")
	public void verifyDeleteAccountTC005(String accname,String email,String contact,String msg,String state,String pincode,String country,String sms) throws InterruptedException {

//		wt.getExtentTest().log(Status.INFO,"====  verifyVT002DeleteAccount starts from here====");
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(wt);
		String actAccountName =malp.fillUpBasicInformation(accname,email,contact,msg,state,pincode,country,sms);		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(wt);
		acLandingPage.deleteAndSearchAccountStatus(actAccountName, "accountname");
//		wt.getExtentTest().log(Status.INFO,"====  verifyVT002DeleteAccount ends from here====");

	}


}