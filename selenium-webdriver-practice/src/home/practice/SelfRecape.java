package home.practice;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import predefine.methods.DriverMethods;
import predefine.methods.VtigerLoginPage;

public class SelfRecape extends DriverMethods {

	public  ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		SelfRecape obj=new SelfRecape();
		obj.loginVtiger();
		obj.loginPage() ;
		obj.homePage();
		obj.verifyLink();
		obj.checkBox();
		obj.deleteXPath();

	}




	public  void verifyLink() {

		List<WebElement> weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//descendant::a[contains(@href,'index.php')]"));
		int linkCount=weTabLink.size();
		List<WebElement> weIframe=driver.findElements(By.xpath("//iframe"));
		System.out.println(weIframe.size());
		for(int i=0; i<linkCount; i++) {
			weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//descendant::a[contains(@href,'index.php')]"));
			WebElement linkText=weTabLink.get(i);
			String tabInnerText=linkText.getText();
			System.out.println(" == "+tabInnerText+" == ");
			List<WebElement> weIframe1=driver.findElements(By.xpath("//iframe"));
			System.out.println(weIframe1.size());
			linkText.click();

			List<WebElement> obj=driver.findElements(By.xpath("//table[@class='level2Bg']//a"));
			for(int j=0; j<obj.size(); j++) {
				obj=driver.findElements(By.xpath("//table[@class='level2Bg']//a"));
				System.out.println(obj.get(j).getText());
				obj.get(j).click();
				obj=driver.findElements(By.xpath("//table[@class='level2Bg']//a"));
				List<WebElement> weIframe2=driver.findElements(By.xpath("//iframe"));
				System.out.println(weIframe2.size());
				if(obj.get(j).getText().equalsIgnoreCase("Webmail")==false && obj.get(j).getText().equalsIgnoreCase("Settings")==false && obj.get(j).getText().equalsIgnoreCase("Module Manager")==false) {
					WebElement weMod=driver.findElement(By.xpath("//td[@class='moduleName']"));
					System.out.println(weMod.getText());

				}
			}
		}

		System.out.println();

		List<WebElement> webBox=driver.findElements(By.xpath("//div[@id='MainMatrix']//descendant::tr[@class='headerrow']//b"));
		int webBoxCount=webBox.size();

		for(int i=0; i<webBoxCount; i++) {
			WebElement weBoxText=webBox.get(i);
			String WebBoxInnerText=weBoxText.getText();
			System.out.println(WebBoxInnerText);
		}
	}
	

	public  void checkBox() throws InterruptedException {

		driver.findElement(By.linkText("Marketing")).click();
		List<WebElement> weCheakBox=driver.findElements(By.xpath("//a[@title='Campaigns']"));
		int count=weCheakBox.size();
		for(int i=0; i<count; i++) {
			String listBoxText=weCheakBox.get(i).getText();
			if(listBoxText.equalsIgnoreCase("Hello")) {
				List<WebElement> weCheckBox=driver.findElements(By.xpath("//input[@name='selected_id']"));
				int count1=weCheckBox.size();
				for(int j=0; j<count1; j++) {
					weCheckBox.get(i).click();
					if(weCheckBox.get(i).isSelected()==true) {
						driver.findElement(By.xpath("//input[contains(@onclick,'Marketing')]//preceding-sibling::input")).click();
						driver.switchTo().alert().dismiss();
					}
				}
			}
		}
	}
	
	

	public   void deleteXPath() {

		driver.findElement(By.linkText("Marketing")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		driver.findElement(By.xpath("//input[@name='campaignname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")).click();
		String popupText=driver.switchTo().alert().getText();
		System.out.println("Popup Text = "+popupText);
		driver.switchTo().alert().dismiss();


	}



	public  void loginPage() {


		searchElement("//input[@name='user_name']").sendKeys("admin");
		displayedOfUserName();
		getValueFromUserBox("admin", "value");
		sizeOfUserName();
		locationOfUserName();
		colorOfUserBox("color");
		
		
		System.out.println();

	    searchElement("//input[@name='user_password']").sendKeys("admin");
	    displayedOfPassword();
		getValueFromPasswordBox("admin", "value");
		sizeOfPassword();
		locationOfPassword();
		colorOfPasswordBox("color");
		

	   
		System.out.println();
		
		WebElement objOfWebE=driver.findElement(By.name("login_theme"));

		boolean colorTheamVisiable=objOfWebE.isDisplayed();
		if(colorTheamVisiable) {
			System.out.println("ColorTheam Is Visiable");
		}else {
			System.out.println("ColorTheam Is Invisiable");
		}

		Select objOfSelect=new Select(objOfWebE);
		boolean typeOfDropdown=objOfSelect.isMultiple();
		if(typeOfDropdown==false){
			System.out.println("ColorTheam DropDown Is Single Selection");
		}else {
			System.out.println("ColorTheam DropDown Is Multi Selection");
		}

		objOfSelect.selectByVisibleText("alphagrey");
		objOfSelect.selectByIndex(3);
		objOfSelect.selectByValue("softed");


		WebElement objOfFirstSelection=objOfSelect.getFirstSelectedOption();
		String gtextofColorTheam=objOfFirstSelection.getText();
		System.out.println("ByDefault Value In Color DropDown = "+gtextofColorTheam);

		System.out.println("All Value is Persent In Dropdown "+objOfWebE.getText());


		//(4)
		System.out.println();
		WebElement obOfweble=driver.findElement(By.xpath("//select[@name='login_language']"));
		boolean visiableLanguage=obOfweble.isDisplayed();
		if(visiableLanguage==true) {
			System.out.println("Language dropdown is visiable");
		}else {
			System.out.println("Language dropdown is Invisiable");
		}

		Select objOfSelectlan=new Select(obOfweble);
		boolean typeoflang=objOfSelectlan.isMultiple();
		if(typeoflang==true) {
			System.out.println("Language dropdown is Single Selection");
		}else {
			System.out.println("Language dropdown is Multi Selection");
		}

		objOfSelectlan.selectByVisibleText("Francais");
		objOfSelectlan.selectByIndex(3);
		objOfSelectlan.selectByValue("en_us");


		WebElement firstSelection=objOfSelectlan.getFirstSelectedOption();
		String gtextofLanguage=firstSelection.getText();
		System.out.println("ByDefault Value In Language DropDown = "+gtextofLanguage);

		System.out.println("All Value is Persent In Dropdown "+obOfweble.getText());


		// (5)
		System.out.println();
		WebElement objOfLogin=driver.findElement(By.xpath("//input[@name='Login']"));
		boolean loginVisiable=objOfLogin.isDisplayed();
		if(loginVisiable==true) {
			System.out.println("Login Button Is Visiable");
		}else {
			System.out.println("Login Button Is Invisiable");
		}

		boolean loginEnabled=objOfLogin.isEnabled();
		if(loginEnabled==true) {
			System.out.println("Login Button Is Enabled");
		}else {
			System.out.println("Login Button Is Disabled");
		}

		String logintext=objOfLogin.getText();
		System.out.println("Inner Text = "+logintext);

		Dimension sizeOflogin=objOfLogin.getSize();
		int loginHeight=sizeOflogin.getHeight();
		int loginWidth=sizeOflogin.getWidth();
		System.out.println("Size of Login Button = "+loginHeight+","+loginWidth);

		Point locationOflogin=objOfLogin.getLocation();
		int loginHorigental=locationOflogin.getX();
		int loginVertical=locationOflogin.getY();
		System.out.println("Location Of Login Button = "+loginHorigental+","+loginVertical);

		String ColorOflogin=objOfLogin.getCssValue("color");
		System.out.println("Color Of Login Button = "+ColorOflogin);

		objOfLogin.click();

}

	
	
	

	public  void homePage() {

		String title=driver.getTitle();
		System.out.println("Home Page Title = "+title);

		String url=driver.getCurrentUrl();
		System.out.println("Current URL OF Home Page = "+url);

		WebElement gtext=driver.findElement(By.xpath("//td[@class='moduleName']"));
		String innerText=gtext.getText();
		System.out.println("Inner Text Of Home Page = "+innerText);

		WebElement  Marketing=driver.findElement(By.xpath("//a[text()='Marketing']"));
		WebElement Leads=driver.findElement(By.xpath("(//a[text()='Leads'])[3]"));
		Actions act=new Actions(driver);
		act.moveToElement(Marketing).click(Leads).build().perform();

		//		    act.click(Leads).build().perform();
		//	act.doubleClick(Leads).build().perform();

		WebElement objOfwe=driver.findElement(By.xpath("//input[@name='selectall']"));
		boolean checkbox=objOfwe.isSelected();
		if(checkbox==true) {
			System.out.println("CheckBox iS Not Selected");
		}else {
			System.out.println("CheckBox iS  Selected");
		}
		objOfwe.click();

		WebElement search=driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
		Select objOfselect=new Select(search);
		objOfselect.selectByValue("website");

		WebElement viewname=driver.findElement(By.xpath("//select[@id='viewname']"));
		Select selectveiw=new Select(viewname);
		selectveiw.selectByVisibleText("Hot Leads");

		driver.findElement(By.xpath("//a[text()='Go to Advanced Search']")).click();
		WebElement field=driver.findElement(By.xpath("//select[@id='Fields0']"));
		Select selectfield=new Select(field);
		selectfield.selectByVisibleText("Email");

		WebElement Vondition=driver.findElement(By.xpath("//select[@id='Condition0']"));
		Select condi=new Select(Vondition);
		condi.selectByValue("s");

		//		 WebElement objOfplush=driver.findElementByXPath("//img[@title='Create Lead...']");
		//		 act.contextClick(objOfplush).build().perform();		 


		WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
		WebElement SalesOrder=driver.findElement(By.xpath("(//a[text()='Sales Order'])[3]"));
		act.moveToElement(Sales).click(SalesOrder).build().perform();


		WebElement searchfield=driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
		Select objOfsearchfield=new Select(searchfield);
		objOfsearchfield.selectByValue("assigned_user_id");

		driver.findElement(By.xpath("//a[text()='New']")).click();


	}
}
