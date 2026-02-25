package oops.automation;



public class ExecuteTestCase  {

	public static void main(String[] args) {


		/*
		 * with parameter 
		 * UseableMethods use=new UseableMethods();
		 * use.launchBrowser(); WebDriver driver=use.login();
		 */

		/*
		 * CampaignTestCase obj=new CampaignTestCase();
		 * obj.verifyCampaignCreation(driver); obj.verifyCreationEdit(driver);
		 * obj.verifyDeleteCompaing(driver);
		 */
		

		// without parameter // 
		CampaignTestCase obj=new CampaignTestCase();
		obj.launchBrowser();
		obj.login();
		obj.verifyCampaignCreation();
		obj.verifyCreationEdit();
		obj.verifyDeleteCompaing();

		//		obj.verifyLeadsByName();


	}

}
