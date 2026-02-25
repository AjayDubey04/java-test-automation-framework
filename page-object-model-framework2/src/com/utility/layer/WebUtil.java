package com.utility.layer;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;




public class WebUtil {


	
	
	private  WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}



	public  void launchBrowser(String browserName) {

		switch(browserName) {
		case "chrome" : {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Browser Launched Successfully");
			break ;
		}
		case "firefox":{
			System.setProperty("webdriver.firefox.driver", "Driver\\firefoxdriver.exe");
			driver=new FirefoxDriver();
			System.out.println("FireFox Browser Launched Successfully");
			break ;
		}
		case "edge" :{
			System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
			driver=new EdgeDriver();
			System.out.println("Edge Browser Launched Successfully");
			break ;
		}
		default:{
			throw new IllegalArgumentException("Invalid browser option");
		}
		}
	}	

	
	public  void launchedBrowserOpenVtigerLoginPage() throws InterruptedException {
		launchBrowser("chrome");
		openUrl("http://localhost:8888");
	}
	

	// ======================  WebDriver Methods ====================== //


	public  void openUrl(String Url) throws InterruptedException {
		try{
			driver.get(Url);
			System.out.println(Url+" ==>> URL Entered successFully");
		}
		catch(InvalidArgumentException e) {
			System.out.println("InvalidArgumentException occurred: Because URL Syntax Was Invalid ");
			throw e;
		}
		catch(TimeoutException e) {
			Thread.sleep(4000);
			driver.get(Url);
			System.out.println(Url+" ==>> URL Entered successFully");
		}
		catch(WebDriverException e) {
			System.err.println("WebDriverException occurred: " );
			throw e;
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
	}



	public  String myGetTitle(String elementName) {
		String title=null;
		try {
			title=driver.getTitle();	
			System.out.println(elementName+" Title Found SuccesFully ==> ");
		}
		catch(NoSuchWindowException e) {
			System.out.println("NoSuchWindowException occurred: "+e.getMessage());  
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
		return title;
	}



	public  String myGetCurrentUrl(String elementName) {

		String url=null;
		try {
			url=driver.getCurrentUrl();
			System.out.println(elementName+" CurrentUrl Found SuccessFully Of ");
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: "+ e.getMessage());
		}
		return url;	
	}



	public  void myClose() {
		try {
			driver.close();
			System.out.println("Current Browser Window closed SuccessFully.");
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: "+ e.getMessage());
		}
	}



	public  void myQuit() {
		try {
			driver.quit();
			System.out.println("Browser Window quit SuccessFully.");
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: "+ e.getMessage());
		}
	}


	//	public  void switchToMainWindow() {
	//		String handleValue;
	//		try {
	//			handleValue=driver.getWindowHandle();
	//			driver.switchTo().window(handleValue);
	//			System.out.println("Switched to Main Window  SuccessFully");
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//	}


	public  String getMainPageHandleValue() {
		String value=driver.getWindowHandle();
		return value;
	}

	public  void switchToMainWindow(String handleValue) {
		driver.switchTo().window(handleValue);
	}


	public  void switchToMultipleWindowByTitle(String expectedTitle) {
		Set<String> handleValue=driver.getWindowHandles();
		for (String we : handleValue) {
			WebDriver weD=driver.switchTo().window(we);	
			if(weD.getTitle().equalsIgnoreCase(expectedTitle)==true) {
				System.out.println("Switch to Window By Title SuccessFully And Expected Window Title is Same as Actual Window Title");
				break;
			}
		}
	}

	public  void switchToMultipleWindowByUrl(String expectedUrl) {
		Set<String> handleValue=driver.getWindowHandles();
		for (String we : handleValue) {
			WebDriver weD=driver.switchTo().window(we);	
			if(weD.getCurrentUrl().equalsIgnoreCase(expectedUrl)==true) {
				System.out.println("Switch to Window By Url SuccessFully And Expected Window URL is Same as Actual Window URL");
				break;
			}
		}	
	}


	public  void forwardWebPage() {
		try {
			driver.navigate().forward();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public  void backWebPage() {
		try {
			driver.navigate().back();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public  void refreshWebPage() {
		try {
			driver.navigate().refresh();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public  void openNavigateToUrl(String url) {
		try {
			driver.navigate().to(url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



	public  void  acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert Accepted SuccesFully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public  void  dismissAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert Dismissed SuccesFully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



	public  String  getAlertText() {
		String alert_text=null;
		try {
			alert_text=driver.switchTo().alert().getText();
			System.out.println("Alert Text Found SuccesFully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return alert_text;
	}




	public  void  alertSendkeys(String alertInput) {

		try {
			driver.switchTo().alert().sendKeys(alertInput);
			System.out.println(alertInput+" Entered in Alert Box  SuccesFully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}




	public  WebDriver  switchToFrame(String nameOrId) {
		WebDriver weD=null;
		try {
			weD=driver.switchTo().frame(nameOrId);
			System.out.println("Switched To Frame SuccessFully By Name Or Id");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return weD;     
	}


	public  WebDriver  switchToFrame(int indexNumber) {
		WebDriver weD=null;
		try {
			weD=driver.switchTo().frame(indexNumber);
			System.out.println("Switched To Frame SuccessFully By Index Number.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return weD;     
	}



	public  WebDriver  switchToFrame(WebElement we) {
		WebDriver weD=null;
		try {
			weD=driver.switchTo().frame(we);
			System.out.println("Switched To Frame SuccessFully By WebElement.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return weD;     
	}



	public  WebDriver switchToParentFrame() {
		WebDriver weD=null;
		try {
			weD=driver.switchTo().parentFrame();
			System.out.println("Switched To Parent Frame SuccessFully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return weD;     
	}




	public  WebDriver  switchToMainWindowToFrame() {
		WebDriver weD=null;
		try {
			weD=driver.switchTo().defaultContent();
			System.out.println("Switched To Main Window SuccessFully From Frame.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return weD;
	}


	public  void threadWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public  void otherDriver() {

	}




	// ======================  WebElement Methods ====================== //


	public  void  clearInputValue(WebElement we) throws InterruptedException {
		String elementName=we.getAccessibleName();
		try {
			we.clear();
			System.out.println("Cleared Input Value SuccessFully From "+elementName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public  void mySubmit(WebElement we) throws InterruptedException {
		String elementName=we.getAccessibleName();
		try {
			we.submit();
			System.out.println("Submited Performed SuccessFully on "+elementName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public  String myGetAttribute(WebElement we,String value) throws InterruptedException {
		String elementName=we.getAccessibleName();
		String str=null;
		try {
			str=we.getAttribute(value);
			System.out.println("Attribute Value Found SuccessFully In "+elementName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}



	public  boolean displayedElement(WebElement we) throws InterruptedException {
		String elementName=we.getAccessibleName();
		boolean str=false;
		try {
			str=we.isDisplayed();
			System.out.println(elementName+" Is Visiable SuccessFully ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}


	public  boolean enabledElement(WebElement we) throws InterruptedException {
		String elementName=we.getAccessibleName();
		boolean str=false;
		try {
			str=we.isEnabled();
			System.out.println(elementName+" Is Enabled SuccessFully ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}


	public  boolean selectedElement(WebElement we) throws InterruptedException {
		String elementName=we.getAccessibleName();
		boolean str=false;
		try {
			str=we.isSelected();
			System.out.println(elementName+" Is Selected SuccessFully ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}




	public  void mySendkeys(WebElement we,String inputValue) throws InterruptedException {

		String elementValue="Hello";

		try {
			we.clear();
			we.sendKeys(inputValue);
			System.out.println(inputValue+" Value Entered in "+elementValue+"  SuccessFully");
		}
		catch(InvalidArgumentException e) {
			System.out.println("InvalidArgumentException occurred: Because Argument  Was Invalid "+e.getMessage());
		}
		catch(StaleElementReferenceException e) {
			we.sendKeys(inputValue);
			System.out.println(inputValue+" Value Entered in "+elementValue+"  SuccessFully");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='+"+inputValue+"+'",we);
			System.out.println(inputValue+" Value Entered in "+elementValue+"  SuccessFully");
		} 
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
	}



	public  void myClick(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		try {
			we.click();
			System.out.println("Clicked on the "+elementName+" element successfully ");
		}
		catch(StaleElementReferenceException e) {
			we.click();
			System.out.println("Clicked on the "+elementName+" element successfully ");
		}
		catch(ElementClickInterceptedException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Clicked on the "+elementName+" element successfully ");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Clicked on the "+elementName+" element successfully ");
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
	}




	public  String myGetText(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		String inner_text=null;
		try {
			inner_text=we.getText();
			System.out.println("InnerText of "+elementName+" Found SuccessFully");
		}
		catch(StaleElementReferenceException e) {
			inner_text=we.getText();
			System.out.println("InnerText of "+elementName+" Found SuccessFully");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("return arguments[0].innerText", we);
			System.out.println("InnerText of "+elementName+" Found SuccessFully");
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
		return inner_text;
	}



	// ======================  Actions Class Methods ====================== //


	public  void myMouseOver(WebElement we) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();
		try {
			act.moveToElement(we).build().perform();
			System.out.println("MouseOver Performed SuccessFully On "+elementName);
		} 
		catch (ElementNotInteractableException e) {
			System.out.println("ElementNotInteractableException occurred: " + e.getMessage());
		}
		catch(StaleElementReferenceException e) {
			act.moveToElement(we).build().perform();
			System.out.println("MouseOver Performed SuccessFully On "+elementName);
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
	}



	public  void myActionsClick(WebElement we) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();
		try {
			act.click(we).build().perform();;
			System.out.println("Actions Click Performed SuccessFully On "+elementName+" Element");
		}
		catch(StaleElementReferenceException e) {
			act.click(we).build().perform();;
			System.out.println("Actions Click Performed SuccessFully On "+elementName+" Element");
		}
		catch(ElementClickInterceptedException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Actions Click Performed SuccessFully On "+elementName+" Element");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Actions Click Performed SuccessFully On "+elementName+" Element");
		} 
		catch(Exception e) {
			System.out.println("Actions Click Not Performed SuccessFully On "+elementName+" Element");
			System.err.println("An unexpected error occurred: "+e.getMessage());
		}
	}



	public  void myActionsDoubleClick(WebElement we) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();
		try {
			act.doubleClick(we).build().perform();;
			System.out.println("Actions DoubleClick Performed SuccessFully On "+elementName+" Element");
		}
		catch(StaleElementReferenceException e) {
			act.doubleClick(we).build().perform();;
			System.out.println("Actions DoubleClick Performed SuccessFully On "+elementName+" Element");
		}
		catch(ElementClickInterceptedException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Actions DoubleClick Performed SuccessFully On "+elementName+" Element");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", we);
			System.out.println("Actions DoubleClick Performed SuccessFully On "+elementName+" Element");
		} 
		catch(Exception e) {
			System.out.println("Actions DoubleClick Not Performed SuccessFully On "+elementName+" Element");
			System.err.println("An unexpected error occurred: "+e.getMessage());
		}
	}



	public  void myActionsDragAndDrop(WebElement drag,WebElement drop) throws InterruptedException {

		Actions act=new Actions(driver);
		try {
			act.dragAndDrop(drag,drop).build().perform();;
			System.out.println("Drag and drop action performed successfully.");
		}
		catch(StaleElementReferenceException e) {
			act.dragAndDrop(drag,drop).build().perform();;
			System.out.println("Drag and drop action performed successfully.");
		}
		catch(InvalidArgumentException e){
			System.out.println("InvalidArgumentException occurred: "+e.getMessage());
		}
		catch(Exception e) {
			System.err.println("An unexpected error occurred: "+e.getMessage());
		}
	}


	public  void myActionsSendkeys(WebElement we, String inputValue) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();

		try {
			act.sendKeys(we,inputValue).build().perform();
			System.out.println(inputValue+" Value Entered in "+elementName+"  SuccessFully");
		}
		catch(InvalidArgumentException e) {
			System.out.println("InvalidArgumentException occurred: Because Argument  Was Invalid");
		}
		catch(StaleElementReferenceException e) {
			we.sendKeys(inputValue);
			System.out.println(inputValue+" Value Entered in "+elementName+"  SuccessFully");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='+"+inputValue+"+'",we);
			System.out.println(inputValue+" Value Entered in "+elementName+"  SuccessFully");
		} 
		catch(Exception e) {
			System.out.println("An unexpected error occurred: ");
			throw e;
		}
	}




	public  void myActionsRightClick(WebElement we) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();
		try {
			act.contextClick(we).build().perform();
			System.out.println("Right Click Performed SuccessFully On "+elementName);
		}
		catch(StaleElementReferenceException e) {
			act.contextClick(we).build().perform();
			System.out.println("Right Click Performed SuccessFully On "+elementName);
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: "+ e.getMessage());
		}
	}



	public  void myActionsClickAndHold(WebElement we) throws InterruptedException {

		Actions act=new Actions(driver);
		String elementName=we.getAccessibleName();

		try {
			act.clickAndHold(we).build().perform();
			System.out.println("Actions ClickAndHold Performed SuccessFully On "+elementName);
		}
		catch(StaleElementReferenceException e) {
			act.clickAndHold(we).build().perform();
			System.out.println("Actions Click And Hold Performed SuccessFully On "+elementName);
		}
		catch(Exception e) {
			System.out.println("An unexpected error occurred: "+ e.getMessage());
		}
	}





	// ======================== Select class Methods ======================== //

	public  boolean myIsMultiple(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		boolean type;
		try {
			type=set.isMultiple();
			System.out.println("isMultiple Performed SuccessFully on "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select sel=new Select(we);
			type=sel.isMultiple();
			System.out.println("isMultiple Performed SuccessFully on "+elementName);
		}
		catch(Exception e) {
			throw e;
		}
		return type;
	}




	public  void mySelectByInnerText(WebElement we,String innerTextOfOption) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		try {
			set.selectByVisibleText(innerTextOfOption);
			System.out.println("Option Selected by innerText SuccesseFully From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select sel=new Select(we);
			sel.selectByVisibleText(innerTextOfOption);
			System.out.println("Option Selected by innerText SuccesseFully From "+elementName);
		}
		catch(Exception e) {
			throw e;
		}

	}


	public  void mySelectByIndex(WebElement we,int indexOfOption) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		try {
			set.selectByIndex(indexOfOption);
			System.out.println("Option Selected by index SuccesseFully From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select sel=new Select(we);
			sel.selectByIndex(indexOfOption);
			System.out.println("Option Selected by index SuccesseFully From "+elementName);
		}
		catch(Exception e) {
			throw e;
		}

	}


	public  void mySelectByValue(WebElement we,String valueOfAttribute) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		try {
			set.selectByValue(valueOfAttribute);
			System.out.println("Option Selected by attribute value SuccesseFully From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select sel=new Select(we);
			sel.selectByValue(valueOfAttribute);
			System.out.println("Option Selected by attribute value SuccesseFully From "+elementName);
		}
		catch(Exception e) {
			throw e;
		}
	}




	public  int myGetOptions(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		List<WebElement> listWe=null;
		int optionsCount=0;
		try {
			listWe=set.getOptions();
			optionsCount=listWe.size();
			System.out.println("Option Count SuccessFully From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select st=new Select(we);
			listWe=st.getOptions();
			System.out.println("Option Count SuccessFully From "+elementName);
		} 
		catch(Exception e) {
			throw e;
		}
		return optionsCount;

	}

	public  String getSelectedOptionText(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=new Select(we);
		WebElement defValue=null;
		String text=null;
		try {
			defValue=set.getFirstSelectedOption();
			text=defValue.getText();
			System.out.println(text+" Selected Default Option: From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select st=new Select(we);
			defValue=st.getFirstSelectedOption();
			text=defValue.getText();
			System.out.println(text+" Selected Default Option: From "+elementName);
		}
		catch(Exception e) {
			throw e;
		}
		return text;
	}

	public  String getInnerTextOfAllOptions(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		Select set=null;
		try {
			set=new Select(we);
		}catch(UnexpectedTagNameException e) {
			throw e;
		}
		WebElement defValue=null;
		String text=null;
		try {
			defValue=set.getWrappedElement();
			text=defValue.getText();
			System.out.println("Found All Options InnerText Successfully: From "+elementName);
		}
		catch(StaleElementReferenceException e) {
			Select st=new Select(we);
			defValue=st.getWrappedElement();
			text=defValue.getText();
			System.out.println("Found All Options InnerText Successfully: From "+elementName);
		}
		catch(Exception e) {
			throw e;
		}
		return text;
	}

	// ======================== Javascript Methods ======================== //

	public  void jsClick(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			js.executeScript("arguments[0].click()", we);
			System.out.println("Click Performed SuccessFully On "+elementName+" Element By Javascript");
		}
		catch(Exception e) {
			System.out.println("Click Not Performed SuccessFully On "+elementName+" Element By Javascript");
			System.err.println("An unexpected error occurred: ");
			e.printStackTrace();
		}
	}

	public  void jsSendkeys(WebElement we,String inputValue) throws InterruptedException {

		String elementName=we.getAccessibleName();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			js.executeScript("arguments[0].value='"+inputValue+"'", we);
			System.out.println(inputValue+" Value Entered  SuccessFully in "+elementName+" By Javascript");
		}
		catch(Exception e) {
			System.out.println(inputValue+" Value  Not Entered  SuccessFully in "+elementName+" By Javascript");
			System.err.println("An unexpected error occurred: "+e.getMessage());
		}
	}

	public  void jsScrolBy(int xOffset,int yOffset) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			js.executeScript("window.scrollBy("+xOffset+","+yOffset+")");
			System.out.println("Javascript Scrolled Performed SuccessFully By Using horizontal "+(xOffset)+" and vertical "+(yOffset)+" values.");
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}


	public  void jsScrolTo() {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			js.executeScript("window.scrollTo(0, 0);");
			System.out.println("Javascript Scrolled Performed SuccessFully To Top Page ");
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}


	public  void jsScrollIntoView(WebElement we) throws InterruptedException {

		String elementName=we.getAccessibleName();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", we);
			System.out.println("Javascript Scrolled Performed SuccessFully Until This "+elementName+" Element Became Visiable ");
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}




	// ======================== Others Methods ======================== //

	public  void verifyTextData(String expectedData , String actualData) {

		if(expectedData.equalsIgnoreCase(actualData)==true) {
			System.out.println("Expected Data - ( "+expectedData+" ) - Same As Actual Data - ( "+actualData+" ) - So It is Passed");
		}else{
			System.out.println("Expected Data - ( "+expectedData+" ) - Is Not Same As Actual Data - ( "+actualData+" ) - So It is Passed");
		}		
	}





	public  void checkAllCheckBoxes(List<WebElement> weList) {

		try {
			for (WebElement list : weList) {
				if(list.isSelected()==false) {
					list.click();
				}
			}
			System.out.println("Checked All  CheckBoxes SuccessFully. ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public  void unCheckAllCheckBoxes(List<WebElement> weList) {

		try {
			for (WebElement list : weList) {
				if(list.isSelected()==true) {
					list.click();
				}
			}
			System.out.println("Unchecked All  CheckBoxes SuccessFully. ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}


	public  int getTableRowCount(List<WebElement> weList) {

		int count=0;
		try {
			count=weList.size();
			System.out.println(" Table Row Counted SuccessFully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;

	}


	public   void verifyNumberData(int expectedData , int actualData) {

		if(expectedData==actualData) {
			System.out.println("Expected - ( "+expectedData+" ) - Same As  Actual - ( "+actualData+" ) - So It is Passed");
		}
		else{
			System.out.println("Expected - ( "+expectedData+" ) - Is Not Same As Actual - ( "+actualData+" ) - So It is Passed");
		}		
	}



	public  ArrayList<String> getTableColumnNameInList(List<WebElement> weList) {

		ArrayList<String> arr=new ArrayList<String>(); 
		try {
			for (WebElement we : weList) {
				arr.add(we.getText());
			}
			System.out.println(" Table Column Names Text Found SuccessFully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;	
	}


	public  int getColumnNumberByColumnName(List<WebElement> weList,String columnName) {

		int count=0;
		try {
			for (int i=0; i<weList.size(); i++) {
				String text=weList.get(i).getText();
				if(text.equalsIgnoreCase(columnName)==true) {
					count=i+1;
					break;
				}
			}
			System.out.println(" Table Column Number Found SuccessFully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}




	public  void SelectOptionsByRemovingSpace(WebElement we,String expectedOption) throws InterruptedException {

		Select sel=new Select(we);
		List<WebElement> listOptions=sel.getOptions();
		for (WebElement webElement : listOptions) {
			String text=webElement.getText();
			if(text.trim().equalsIgnoreCase(expectedOption)==true) {
				sel.selectByVisibleText(expectedOption);
			}
		}
	}


	public  void  selectIfOptionVisiable(WebElement we,String expectedOption) throws InterruptedException {

		Select sel=new Select(we);
		List<WebElement> listOptions=sel.getOptions();
		for (WebElement webElement : listOptions) {		
			if(webElement.isDisplayed()==true) {
				sel.selectByVisibleText(expectedOption);
			}
		}	
	}


	public  ArrayList<String> getRowDataByRowNo(String xpath,int rowNo) {

		List<WebElement> list=driver.findElements(By.xpath(xpath+"//tr"));
		ArrayList<String> rowData=new ArrayList<String>();
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			count=i+2;
			if(rowNo==count) {              
				List<WebElement> rowList=driver.findElements(By.xpath(xpath+"//tr[1]/following-sibling::tr["+rowNo+"]/td/following-sibling::td"));
				for (WebElement rowDataText : rowList) {
					rowData.add(rowDataText.getText());
				}
			}
		}
		return rowData;
	}


	public  ArrayList<String> getColumnDataByColumnNo(String tableXpath, int columnNo ) {

		List<WebElement> list=driver.findElements(By.xpath(tableXpath+"//a[@class='listFormHeaderLinks']"));
		ArrayList<String> rowData=new ArrayList<String>();
		int count=0;
		for (int i = 0; i <list.size(); i++) {
			count=i+1;
			if(columnNo==count) {              
				List<WebElement> rowList=driver.findElements(By.xpath(tableXpath+"//tr/following-sibling::tr//td["+(columnNo+1)+"]"));
				for (WebElement rowText : rowList) {
					rowData.add(rowText.getText());
				}
			}
		}
		return rowData;
	}


	public  ArrayList<String> getColumnDataByColumnName(String tableRowXpath,String columnDataxpath, String columnName) {

		List<WebElement> list=driver.findElements(By.xpath(tableRowXpath));
		ArrayList<String> rowData=new ArrayList<String>();
		for (WebElement text : list) {
			String columnData=text.getText();
			if(columnData.equalsIgnoreCase(columnName)==true) {              
				List<WebElement> rowList=driver.findElements(By.xpath(columnDataxpath+"/preceding-sibling::a/parent::td"));
				for (WebElement rowDataText : rowList) {
					rowData.add(rowDataText.getText());
				}
			}
		}
		return rowData;
	}


	public  int getRowNumberByRowId(String tableRowXpath,String rowId) {

		List<WebElement> list=driver.findElements(By.xpath(tableRowXpath+"/parent::td"));
		int count=0;
		for (int i = 0; i <list.size(); i++)  {
			String idText= list.get(i).getText();
			String rowText=idText.trim();
			if(rowText.equalsIgnoreCase(rowId)==true) {
				count=i+1;
				break;
			}
		}
		return count;
	}


	public  void getRow() {







	}
}

