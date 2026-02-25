package home.practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import predefine.methods.VtigerLoginPage;

public class Revise extends VtigerLoginPage {

	static ChromeDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		
		  String loginPageTitle=driver.getTitle();
		  System.out.println("Login Page Title = "+loginPageTitle);
		  
		  String loginPageUrl=driver.getCurrentUrl();
		  System.out.println("Login Page Url = "+loginPageUrl);
		 
		method_1();
		method_2();
		method_3();
		method_4();
		
		WebElement weLogin=driver.findElement(By.name("Login"));
		boolean loginVisiable=weLogin.isEnabled();
		if(loginVisiable==true) {
			System.out.println("Login Button Is Enable");
		}else {
			System.out.println("Login Button Is Disable");
		}
		weLogin.click();
		
		  System.out.println("===== Home Page ====="); String
		  homePageTitle=driver.getTitle();
		  System.out.println("Login Page Title = "+homePageTitle);
		  
		  String homePageUrl=driver.getCurrentUrl();
		  System.out.println("Login Page Url = "+homePageUrl);
		  
		  String
		  homePageHeader=driver.findElement(By.xpath("//td[@class='moduleName']")).getText
		  (); if(homePageHeader.equals("My Home Page > Home")) {
		  System.out.println("Same As Home Page Header"); }else {
		  System.out.println("Same As Not Home Page Header"); }
		 
		  
		  method_5();
		  method_6();
		  method_7();
		  
	}

	public static void method_1() {
		
		System.out.println("==== USER NAME ====");
		WebElement weUserName=driver.findElement(By.name("user_name"));
		boolean userNameVisisable=weUserName.isDisplayed();
		if(userNameVisisable==true) {
			System.out.println("UserName Is Appered");
		}else {
			System.out.println("UserName Is DisAppered");
		}
		
		weUserName.sendKeys("admns");
		
		String userNameValue=weUserName.getAttribute("value");
		if(userNameValue.equals("admin")) {
			System.out.println("Same As Condition");
		}else {
			System.out.println("Same As Not Condition");
		}
		
		Dimension  userNameSize=weUserName.getSize();
		int userNameHeight=userNameSize.getHeight();
		int userNameWidth=userNameSize.getWidth();
		System.out.println("Size = "+userNameHeight+" "+userNameWidth);
		
		Point userNameLocation=weUserName.getLocation();
		int userNameX=userNameLocation.getX();
		int userNameY=userNameLocation.getY();
		System.out.println("Location = "+userNameX+" "+userNameY);
		
		WebElement Header=weUserName.findElement(By.xpath("//input[@name='user_name']//parent::td//preceding-sibling::td"));
		String userNameText=Header.getText();
		System.out.println("UserName Header = "+userNameText);
		
		String userNameTag=weUserName.getTagName();
		System.out.println("TagName = "+userNameTag);
		
		weUserName.clear();
		weUserName.sendKeys("admin");
	
		
	}
		public static void method_2() {
			
			System.out.println("==== PASSWORD ====");
			WebElement wePassword=driver.findElement(By.name("user_password"));
//			wePassword.sendKeys("admin");
			
			boolean passVisiable=wePassword.isDisplayed();
			if(passVisiable==true) {
				System.out.println("Password Is Visiable");
			}else {
				System.out.println("Password Is Not Visiable");
			}
			wePassword.sendKeys("admin");
			
			String passValue=wePassword.getAttribute("value");
			if(passValue.equals("admin")) {
				System.out.println("Same As Password Value");
			}else {
				System.out.println("Same As Password Value");
			}
			
			Dimension passSize=wePassword.getSize();
			int passHeight=passSize.getHeight();
			int passWidth=passSize.getWidth();
			System.out.println("Password Size = "+passHeight+" "+passWidth);
			
			Point passLocation=wePassword.getLocation();
			int passX=passLocation.getX();
			int passY=passLocation.getY();
			System.out.println("Password Location = "+passX+" "+passY);
			
			String passTag=wePassword.getTagName();
			System.out.println("Password TagName = "+passTag);
			
			 String passText=wePassword.findElement(By.xpath("//input[@name='user_password']//parent::td//preceding-sibling::td")).getText();
			 System.out.println("Password Header = "+passText);
			 
//			===doubt===
//			String ab=wePassword.findElement(By.xpath("(//td[@align='right'])[4]")).getAttribute("textContent");
//			System.out.println(ab);
			 
		}

		public static void method_3() { 
			
		    System.out.println("==== Color Theme ====");
			WebElement weDropAndDown=driver.findElement(By.name("login_theme"));
			Select dD=new Select(weDropAndDown);
			
			WebElement selectedOption=dD.getFirstSelectedOption();
			String selectedOptionText=selectedOption.getText();
			System.out.println(selectedOptionText);
			
			boolean dDtype=dD.isMultiple();
			if(dDtype==true) {
				System.out.println("Single Selection DropDown");
			}else {
				System.out.println("Multiple Selection DropDown");
			}
			
			dD.selectByIndex(0);
			dD.selectByValue("woodspice");
			dD.selectByVisibleText("bluelagoon");
			
			List<WebElement> optionCount=dD.getOptions();
			System.out.println(optionCount.size());
			
			WebElement optionList=dD.getWrappedElement();
			System.out.println(optionList.getText());
			
//	(2)		
		System.out.println(weDropAndDown.getText());
		
		List<WebElement> weOption=weDropAndDown.findElements(By.tagName("option"));
		for (WebElement Element : weOption) {
			System.out.println(Element.getText());
			 weOption.get(3).click();
		}
		
// (3)	 
			 weDropAndDown.click();	
			 weDropAndDown.findElement(By.xpath("//option[@value='woodspice']")).click();
			 weDropAndDown.click();
			 
//			 
			 weDropAndDown.sendKeys("softed"); 
	
			 Dimension theamSize=weDropAndDown.getSize();
			 System.out.println(theamSize.getHeight()+" "+theamSize.getWidth());
			 
			 Point theamLocation=weDropAndDown.getLocation();
			 System.out.println(theamLocation.getX()+" "+theamLocation.getY());
			 
			 String themeHeader=weDropAndDown.findElement(By.xpath("//select[@name='login_theme']/parent::td/preceding-sibling::td")).getText();
				System.out.println("Color Theme Header = "+themeHeader);
				
	}
		
		public static void method_4() {
		
			System.out.println("==== Language ====");
			WebElement dropDown=driver.findElement(By.xpath("//select[@name='login_language']"));
			Select selectObj=new Select(dropDown);
			
			WebElement defaultOption=selectObj.getFirstSelectedOption();
			if(defaultOption.getText().equals("US English")) {
				System.out.println("Same As Default Value");
			}else {
				System.out.println("Same As Not Default Value");
			}
			
			boolean dropDownType=selectObj.isMultiple();
			if(dropDownType==false) {
				System.out.println("Language is a Single Selection");
			}else {
				System.out.println("Language is a multiple Selection");
			}
			
			List <WebElement> langOptionsCount=selectObj.getOptions();
			System.out.println(langOptionsCount.size());
			
			WebElement optionsValue=selectObj.getWrappedElement();
			System.out.println(optionsValue.getText());
			
			selectObj.selectByIndex(0);
			selectObj.selectByValue("de_de");
			selectObj.selectByVisibleText("US English");
			
			Dimension langSize=dropDown.getSize();
			System.out.println(langSize.getHeight()+" "+langSize.getWidth());
			
			Point langLocation=dropDown.getLocation();
			System.out.println(langLocation.getX()+" "+langLocation.getY());
			
			String languageHeader=dropDown.findElement(By.xpath("//select[@name='login_language']/parent::td/preceding-sibling::td")).getText();
			System.out.println("Language Header = "+languageHeader);
			
		}
		
		public static void method_5() {
			
//			driver.findElementsByXPath("//div[@id='miniCal']/preceding-sibling::table//descendant::table//descendant::a");
			
			List<WebElement> topLinkList=driver.findElements(By.xpath("//td[@style='padding-left:10px;padding-right:10px']"));
//			int topLinkCount=topLinkList.size();
			for (WebElement Element : topLinkList) {
				String topLinkText=Element.getText();
				System.out.println(topLinkText);
			}
			
			WebElement dropDown=driver.findElement(By.id("qccombo"));
			Select objSelect=new Select(dropDown);
			objSelect.selectByValue("Accounts");
			driver.findElement(By.xpath("//table[@class='qcTransport']//descendant::input[@title='Cancel [Alt+X]']")).click();
			
			
			Actions act=new Actions(driver);
			WebElement drag=driver.findElement(By.xpath("//b[contains(text(),'My New Leads')]"));
			WebElement drop=driver.findElement(By.xpath("//b[contains(text(),'Tag Cloud')]"));
			act.dragAndDrop(drag, drop).perform();
//			act.clickAndHold(drag).moveToElement(drag).release(drop).build().perform();
			
			
			List<WebElement> weLinkList=driver.findElements(By.xpath("//td[@class='tabSelected']/parent::tr//descendant::a"));
			int listCount=weLinkList.size();
			for(int i=0; i<listCount; i++) {
				weLinkList=driver.findElements(By.xpath("//td[@class='tabSelected']/parent::tr//descendant::a"));
				act.moveToElement(weLinkList.get(i)).perform();
				String linkText=weLinkList.get(i).getText();
				System.out.println("===== "+linkText+" =====");
				weLinkList.get(i).click();
				
			List<WebElement> weSubLinkList=driver.findElements(By.xpath("//td[@class='level2SelTab']/parent::tr//descendant::a"));
			int subLinkCount=weSubLinkList.size();
			for(int j=0; j<=subLinkCount-1; j++) {
				 weSubLinkList=driver.findElements(By.xpath("//td[@class='level2SelTab']/parent::tr//descendant::a"));
//				driver.findElementsByXPath("(//td[@class='level2SelTab']/parent::tr//descendant::a)["+i+"]");
				String subLinkText=weSubLinkList.get(j).getText();
				System.out.println(subLinkText);
				weSubLinkList.get(j).click();
		
				if(subLinkText.equalsIgnoreCase("Webmail")==false && subLinkText.equalsIgnoreCase("Settings")==false && subLinkText.equalsIgnoreCase("Module Manager")==false ) {
					System.out.println("My Home Page > "+subLinkText);
				}
				}
			}
		}
		
		public static void method_6() {
			System.out.println("===== CheckBox =====");
//			driver.findElementByPartialLinkText("Marketing").click();
			driver.findElement(By.linkText("Marketing")).click();
			driver.findElement(By.linkText("Leads")).click();
//			==========================================================================
			WebElement weMainBox=driver.findElement(By.xpath("//input[@name='selectall']"));
			weMainBox.click();
			List<WebElement> weCheckBox=driver.findElements(By.xpath("//input[@name='selected_id']"));
			for (WebElement Element : weCheckBox) {
				boolean lowerCheckBox=Element.isSelected();
				if(lowerCheckBox==true) {
					System.out.println("lowerCheckBox is Selected");
				}else {
					System.out.println("lowerCheckBox is Selected");
				}
			}
			weMainBox.click();
//			=============================================================================
			for (WebElement webElement : weCheckBox) {
				webElement.click();
			}
			boolean listBox=weMainBox.isSelected();
			if(listBox==true) {
				System.out.println("selectall CheckBox Is Selected");
			}else {
				System.out.println("selectall CheckBox Is Not Selected");
			}
			
			
			List<WebElement> weAlpha=driver.findElements(By.xpath("//td[@class='searchAlph']"));
			for (WebElement latter : weAlpha) {
				String alphaText=latter.getText();
				System.out.print(alphaText+" ");
			}
			
			driver.findElement(By.xpath("//input[contains(@onclick,'Marketing')]/preceding-sibling::input[@value='Delete']")).click();
//			driver.switchTo().alert().accept();
			driver.switchTo().alert().dismiss();
//			driver.switchTo().alert().getText();
//			driver.switchTo().alert().sendKeys("");
			
//			Actions act=new Actions(driver);
//			act.contextClick(driver.findElementByXPath("//img[@title='Create Lead...']")).perform();
			
			
		}
		
		public static void method_7() {
		System.out.println();
		driver.findElement(By.linkText("My Home Page")).click();
		
		List<WebElement> weNotFound=driver.findElements(By.xpath("//div[@class='componentName']"));
		for (WebElement webElement : weNotFound) {
		String notFoundText=webElement.getText();
		System.out.println(notFoundText);
		
		}
		
		List<WebElement> topHeader=driver.findElements(By.xpath("//div[@id='MainMatrix']//descendant::b"));
		 int count=topHeader.size();
		 for(int i=0; i<count; i++) {
			 String text=topHeader.get(i).getText();
			 System.out.println(text);
		 }
		 
		 WebElement weLink=driver.findElement(By.linkText("Marketing"));
		 Actions act=new Actions(driver);
		 act.moveToElement(weLink).doubleClick(weLink).build().perform();
		 
		 driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 
		WebElement weSaveButton=driver.findElement(By.xpath("//b[text()='Campaign Information']/parent::td/parent::tr/preceding-sibling::tr//descendant::input[@title='Save [Alt+S]']"));
		act.doubleClick(weSaveButton).perform();
		
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		
		}
		
}


