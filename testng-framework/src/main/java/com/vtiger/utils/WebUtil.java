package com.vtiger.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;


/**
 * @author Man Singh
 *
 */
@Getter
@Setter
public class WebUtil  {

	private  WebDriver driver;

	private ExtentTest exeTest;
	public void setExTentTest(ExtentTest exeTest) {
		this.exeTest=exeTest;
	}
	public ExtentTest getExTentTest() {
		return this.exeTest;
	}



	public  void printMessage(String yourString) {
		System.out.println(yourString);
	}

	public  void openLoginPage() {
		launchBrowser("chrome");
		goToHitUrl("http://localhost:8888");
		windowMaximize();
		myIplicitilyWait(60);
	}

	////////////   myThread  \\\\\\\\\\

	public  void myThread(long duration)  {
		try {
			Thread.sleep(duration);
			printMessage("we have given "+duration +" millies seconds to the element");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	////////////   launchBrowser  \\\\\\\\\\

	public  void launchBrowser(String browserName) {
		try {
			if(browserName.equalsIgnoreCase("chrome"))
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
//			ChromeOptions co=new ChromeOptions();
//			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver();
			printMessage("Browser is launched sucessfully");
//			exeTest.log(Status.INFO, "Browser is launched sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
//			exeTest.log(Status.INFO, "Browser is not launched sucessfully");
		}
	}



	public String takeSnapshot(String testCaseName) {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File fileObj=ts.getScreenshotAs(OutputType.FILE);
		File desiredLocation=new File("test-output\\"+testCaseName+".png");
		try {
			Files.copy(fileObj, desiredLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return desiredLocation.getAbsolutePath();

	}


	////////////   windowMaximize  \\\\\\\\\\

	public  void windowMaximize() {

		try {
			driver.manage().window().maximize();
			printMessage("the window is maximized");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is maximized");
		}
	}

	////////////windowMinimize  \\\\\\\\\\

	public  void windowMinimize() {

		try {
			driver.manage().window().minimize();
			printMessage("the window is minimized");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not minimized");
		}
	}


	////////////   myIplicitilyWait  \\\\\\\\\\


	public  void  myIplicitilyWait(long seconds) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			printMessage("the maximum timeouts for waiting is "+seconds);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	////////////   openUrl  \\\\\\\\\\

	/**
	 * @param url
	 * @throws Exception 
	 */
	public  void openUrl(String url) throws Exception {
		try {
			driver.get(url);
			printMessage("the given url :-"+url+" is launched sucessfully");
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "window.location.href='" + url + "';";
			jsExecutor.executeScript(script);
			printMessage("the given url :-"+url+" is launched sucessfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the given url :-"+url+" is not launched sucessfully");
			throw e;

		}
	}

	////////////   goToBackPage  \\\\\\\\\\

	/**
	 * by using of this method we can go to back page from the current page...
	 * 
	 */
	public  void goToBackPage() {
		try {
			driver.navigate().back();
			printMessage("the Page has been backed sucessfully");
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to go back
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.history.back();");
			printMessage("the Page has been backed sucessfully");
		}catch(WebDriverException e) {

			//WebDriverException:-----WebDriverException can be thrown for various reasons, such as invalid URL, 
			//                        network issues, browser crashes, or any other unexpected 
			//	                      errors during the navigation.......
			e.printStackTrace();
			printMessage("the Page hasn't been backed sucessfully");
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the Page hasn't been backed sucessfully");
			throw e;
		}
	}


	////////////   goToForwardPage  \\\\\\\\\\
	/**
	 * by using of this method we can go to forword page from the current page...
	 * @throws Exception 
	 * 
	 */

	public  void goToForwardPage() throws Exception {
		try {
			driver.navigate().forward();
			printMessage("the Page has been forwarded sucessfully");
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to go forward
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.history.forward();");
			printMessage("the Page has been forwarded sucessfully");
		}catch(WebDriverException e) {

			//WebDriverException:-----WebDriverException can be thrown for various reasons, such as invalid URL, 
			//                        network issues, browser crashes, or any other unexpected 
			//	                      errors during the navigation.......
			e.printStackTrace();
			printMessage("the Page hasn't been forwarded sucessfully");
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the Page hasn't been forwarded sucessfully");
			throw e;
		}
	}


	////////////   goToRefeshPage  \\\\\\\\\\
	/**
	 * by using of this method we can refresh to the current page...
	 * 
	 */

	public  void goToRefreshPage() {
		try {
			driver.navigate().refresh();
			printMessage("the Page has been refreshed sucessfully");
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to refresh the page
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("location.reload();");
			printMessage("the Page has been refreshed sucessfully");
		}catch(WebDriverException e) {

			//WebDriverException:-----WebDriverException can be thrown for various reasons, such as invalid URL, 
			//                        network issues, browser crashes, or any other unexpected 
			//	                      errors during the navigation.......
			e.printStackTrace();
			printMessage("the Page hasn't been refreshed sucessfully");
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the Page hasn't been refreshed sucessfully");
			throw e;
		}
	}

	////////////   goToHitUrl  \\\\\\\\\\

	/**
	 * with the help of this method i.e goToHitUrl() we can hit any url in the browser.
	 * 
	 * @param url
	 *        by using of  this url we can hit any url to the browser
	 */
	public  void goToHitUrl(String url) {
		try {
			driver.navigate().to(url);
			printMessage("the given url :- "+url+" is hit successfully");
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.location.href = '" + url + "';");
			printMessage("the given url :- "+url+" is hit successfully");
		}catch(WebDriverException e) {

			//WebDriverException:-----WebDriverException can be thrown for various reasons, such as invalid URL, 
			//                        network issues, browser crashes, or any other unexpected 
			//	                      errors during the navigation.......
			e.printStackTrace();
			printMessage("the given url :- "+url+" is not hit successfully");
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the given url :- "+url+" is not hit successfully");
			throw e;
		}
	}

	////////////   getPresentUrl  \\\\\\\\\\

	/**
	 * this method is commonaly used to get current url of the current page.
	 *  
	 * @return this method is return String as url.
	 */
	public  String getPresentUrl() {
		String pageUrl=null;
		try {
			pageUrl=driver.getCurrentUrl();
			printMessage("find the current page url :-"+pageUrl);

		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return window.location.href;";
			pageUrl = (String) jsExecutor.executeScript(script);
			printMessage("find the current page url :-"+pageUrl);
			return 	pageUrl;	
		}catch(Exception e) {
			e.printStackTrace();
			printMessage(" Did't find the current page url ");
			throw e;
		}
		return pageUrl;

	}

	////////////   getPageTitle  \\\\\\\\\\

	/**
	 * with the help of this method we can easily find the title of the
	 * current page..
	 * 
	 * @return it returns string as a title of the current page
	 */
	public  String getPageTitle() {
		String pageTitle=null;
		try {
			pageTitle=driver.getTitle();
			printMessage("find the title of the page is :-"+pageTitle);

		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page title
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return document.title;";
			pageTitle = (String) jsExecutor.executeScript(script);
			printMessage("find the title of the page is :-"+pageTitle);
			return pageTitle;
		}
		catch(Exception e) {
			e.printStackTrace();
			printMessage("Didn't find the title of the page");
		}
		return pageTitle;
	}

	////////////   getPageSourceCode  \\\\\\\\\\

	public  String getPageSourceCode() {
		String sourceCode=null;
		try {
			sourceCode=driver.getPageSource();
			printMessage("find the source code of the page :-"+sourceCode);
		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page source code
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return document.documentElement.outerHTML;";
			sourceCode = (String) jsExecutor.executeScript(script);
			printMessage("find the source code of the page :-"+sourceCode);
			return sourceCode;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Didn't find the source code of the page");

		}
		return sourceCode;
	}

	////////////   myClose  \\\\\\\\\\

	public  void myClose() {

		try {
			driver.close();
			printMessage("the current window or tab is closed successfully");

		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to close the current browser window
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.close();");
			printMessage("the current window or tab is closed successfully");
		}catch(NoSuchWindowException e) {
			//NoSuchWindowException: If the current window or tab is already closed or does not exist.
			e.printStackTrace();
			printMessage("the current window or tab is not closed successfully");
			throw e;
		}catch(WebDriverException e) {
			//WebDriverException can be caused by a variety of factors, such as invalid driver parameters,
			//network errors, or unexpected JavaScript errors....
			e.printStackTrace();
			printMessage("the current window or tab is not closed successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the current window or tab is not closed successfully");
			throw e;
		}
	}

	////////////   myQuit  \\\\\\\\\\

	public  void myQuit() {

		try {
			driver.quit();
			printMessage("All the  window or tab is closed successfully");

		}catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to quit the entire WebDriver session
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.open('', '_self', ''); window.close();");
			printMessage("All the  window or tab is closed successfully");
		}catch(NoSuchSessionException e) {

			//The NoSuchSessionException is an exception raised by Selenium WebDriver when 
			//it tries to perform an operation on a session that does not exist...	
			e.printStackTrace();
			printMessage("All the window or tab is not closed successfully");
			throw e;
		}catch(WebDriverException e) {
			//WebDriverException can be caused by a variety of factors, such as invalid driver parameters,
			//network errors, or unexpected JavaScript errors....
			e.printStackTrace();
			printMessage("All the  window or tab is not closed successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("All the  window or tab is not closed successfully");
			throw e;
		}
	}
	////////////   switchToWindowByTitle  \\\\\\\\\\

	public  void switchToWindowByTitle(String expectPageTitle) {

		//		NoSuchWindowException: This exception occurs when you try to switch to a window 
		//		using a window handle that does not exist or has been closed.......

		try {
			Set<String>setWindowHandles	=driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle=driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}
			printMessage("the Window is switched by title :- "+expectPageTitle+" successfully");
		}catch(StaleElementReferenceException e) {
			Set<String>setWindowHandles	=driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle=driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}
			printMessage("the Window is  switched by title :- "+expectPageTitle+" successfully");

		}catch(NoSuchWindowException e) {
			e.printStackTrace();
			printMessage("the Window is not switched by title :- "+expectPageTitle+" successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the Window is not switched by title :- "+expectPageTitle+" successfully");
			throw e;

		}

	}

	////////////   switchToWindowByUrl  \\\\\\\\\\

	public  void switchToWindowByUrl(String expectPageUrl) {

		try {
			Set<String>setWindowHandles	=driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageUrl=driver.getCurrentUrl();
				if (actPageUrl.equalsIgnoreCase(expectPageUrl)) {
					break;
				}
			}
			printMessage("the Window is switched by title :- "+expectPageUrl+" successfully");
		}catch(StaleElementReferenceException e) {
			Set<String>setWindowHandles	=driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageUrl=driver.getCurrentUrl();
				if (actPageUrl.equalsIgnoreCase(expectPageUrl)) {
					break;
				}
			}
			printMessage("the Window is switched by url :- "+expectPageUrl+" successfully");
		}catch(NoSuchWindowException e) {
			e.printStackTrace();
			printMessage("the Window is not switched by url :- "+expectPageUrl+" successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the Window is not switched by url :- "+expectPageUrl+" successfully");
			throw e;
		}

	}

	////////////   switchToWindowByDynamicTitle  \\\\\\\\\\

	public  void switchToWindowByDynamicTitle(String dynamicTitle) {

		try {
			Set<String> handleValues =driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageTitle=driver.getTitle();
				if (actPageTitle.contains(dynamicTitle)) {
					break;
				}
			}
			printMessage("the Window is switched by title :- "+dynamicTitle+" successfully");
		}catch(StaleElementReferenceException e) {
			Set<String> handleValues =driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageTitle=driver.getTitle();
				if (actPageTitle.contains(dynamicTitle)) {
					break;
				}
			}
			printMessage("the Window is switched by dynamic  title :- "+dynamicTitle+" successfully");
		}catch(NoSuchWindowException e) {
			e.printStackTrace();
			printMessage("the Window is not switched bydynamic  title :- "+dynamicTitle+" successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the Window is not switched by dynamic title :- "+dynamicTitle+" successfully");
			throw e;
		}
	}

	////////////switchToWindowByDynamicUrl  \\\\\\\\\\

	public  void switchToWindowByDynamicUrl(String dynamicUrl) {

		try {
			Set<String> handleValues =driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageUrl=driver.getCurrentUrl();
				if (actPageUrl.contains(dynamicUrl)) {
					break;
				}
			}
			printMessage("the Window is switched by title :- "+dynamicUrl+" successfully");
		}catch(StaleElementReferenceException e) {
			Set<String> handleValues =driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageUrl=driver.getCurrentUrl();
				if (actPageUrl.contains(dynamicUrl)) {
					break;
				}
			}
			printMessage("the Window is switched by title :- "+dynamicUrl+" successfully");
		}catch(NoSuchWindowException e) {
			e.printStackTrace();
			printMessage("the Window is not switched by dynamic url :- "+dynamicUrl+" successfully");
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the Window is not switched by dynamic url :- "+dynamicUrl+" successfully");
			throw e;
		}
	}

	////////////    switchToFrameByWebElement  \\\\\\\\\\

	public  void switchToFrameByWebElement(WebElement weFrame) {

		//		NoSuchFrameException:--This exception occurs when you attempt to switch to a frame 
		//			                    that does not exist or cannot be found.
		String elementName=weFrame.getAccessibleName();
		try {
			driver.switchTo().frame(weFrame);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");
		}catch (NoSuchFrameException e) {
			driver.switchTo().frame(weFrame);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");
		}catch (StaleElementReferenceException e) {

			driver.switchTo().frame(weFrame);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");	
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not switched into the frame "+elementName+"  suceessfully");
			throw e;
		} 
	}

	////////////switchToFrameByIndex  \\\\\\\\\\

	public  void switchToFrameByIndex(String elementName ,int frameIndex) {
		try {
			driver.switchTo().frame(frameIndex);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");
		}catch (NoSuchFrameException e) {
			driver.switchTo().frame(frameIndex);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");
		}catch (StaleElementReferenceException e) {
			driver.switchTo().frame(frameIndex);
			printMessage("the window is switched into the frame "+elementName+"  suceessfully");
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not switched into the frame "+elementName+"  suceessfully");
			throw e;
		} 
	}

	////////////switchToFrameByNameOrId  \\\\\\\\\\

	public  void switchToFrameByNameOrId(String NameOrId) {
		try {
			driver.switchTo().frame(NameOrId);
			printMessage("the window is switched into the frame by Name or Id  suceessfully");
		}catch (NoSuchFrameException e) {
			driver.switchTo().frame(NameOrId);
			printMessage("the window is switched into the frame by Name or Id  suceessfully");
		}catch (StaleElementReferenceException e) {
			driver.switchTo().frame(NameOrId);
			printMessage("the window is switched into the frame by Name or Id  suceessfully");
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not switched into the frame by Name or Id  suceessfully");
			throw e;
		} 
	}

	////////////switchToParentFrame  \\\\\\\\\\

	public  void switchToParentFrame(String elementName ) {
		try {
			driver.switchTo().parentFrame();
			printMessage("the window is switched into the parentFrame suceessfully");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().parentFrame();
			printMessage("the window is switched into the parentFrame suceessfully");
		}catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not switched into the parentFrame suceessfully");
			throw e;
		} 
	}

	////////////switchToMainWindow  \\\\\\\\\\

	public  void switchToMainWindow(String elementName ) {
		try {
			driver.switchTo().defaultContent();
			printMessage("the window is switched into the  Main Window suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("the window is not switched into the  Main Window suceessfully");
			throw e;
		} 
	}

	////////////   popUpAccept  \\\\\\\\\\
	/**
	 * with the help of this method we can easily accept the alert message. 
	 */
	public  void popUpAccept() {

		//		NoAlertPresentException: This exception occurs when there is no alert present on the web page
		//		at the time you attempt to interact with it..............

		try {
			driver.switchTo().alert().accept();
			printMessage("Pop up is accepted successfully");
		}catch(NoAlertPresentException e) {
			WebDriverWait webWait=	new WebDriverWait(driver,Duration.ofSeconds(30));
			printMessage(" Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			printMessage("Switch to the alert and perform operations if needed");
			driver.switchTo().alert().accept();
			printMessage("Pop up is accepted successfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Pop up is not accepted successfully");
			throw e;
		}

	}

	////////////   popUpDismiss  \\\\\\\\\\
	/**
	 * with the help of this method we can easily dismiss the alert message. 
	 */
	public  void popUpDismiss() {
		try {
			driver.switchTo().alert().dismiss();
			printMessage("Pop up is dismissed successfully");
		}catch(NoAlertPresentException e) {
			WebDriverWait webWait=	new WebDriverWait(driver,Duration.ofSeconds(30));
			printMessage(" Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			printMessage("Switch to the alert and perform operations if needed");
			driver.switchTo().alert().dismiss();
			printMessage("Pop up is dismissed successfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Pop up is not dismissed successfully");
			throw e;
		}
	}

	////////////   popUpSendKeys  \\\\\\\\\\
	/**
	 * with the help of this method we can easily send value in input box of the alert
	 * to accept or dismiss the alert message.  
	 */
	public  void popUpSendKeys(String popUpKeyText) {
		try {
			driver.switchTo().alert().sendKeys(popUpKeyText);
			printMessage("Pop up is  "+popUpKeyText+"  successfully");
		}catch(NoAlertPresentException e) {
			WebDriverWait webWait=	new WebDriverWait(driver,Duration.ofSeconds(30));
			printMessage(" Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			printMessage("Switch to the alert and perform operations if needed");
			driver.switchTo().alert().sendKeys(popUpKeyText);
			printMessage("Pop up is  "+popUpKeyText+"  successfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Pop up is  not "+popUpKeyText+"  successfully");
			throw e;
		}

	}

	////////////  popUpGetText  \\\\\\\\\\

	/**
	 * with the help of this method we can easily get inner text of alert message.  
	 */
	public  void popUpGetText() {
		try {
			driver.switchTo().alert().getText();
			printMessage("the text of Pop up is found successfully");
		}catch(NoAlertPresentException e) {
			WebDriverWait webWait=	new WebDriverWait(driver,Duration.ofSeconds(30));
			printMessage(" Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			printMessage("Switch to the alert and perform operations if needed");
			driver.switchTo().alert().getText();
			printMessage("the text of Pop up is found successfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("the text of Pop up is not found successfully");
			throw e;
		}

	}

	////////////   myFindElement  \\\\\\\\\\

	/**
	 * this method is the most commonaly used to find the element then 
	 * we perform any action.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return it returns the webElement
	 */


	////////////   myFindElements  \\\\\\\\\\

	/**
	 * this method is used to get multiple weblement as a list of webElement
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 * 
	 * @return it returns list of webElements
	 */
	public  List<WebElement> myFindElements(String xpath) {
		List<WebElement> webLsts=null;

		try {
			webLsts=driver.findElements(By.xpath(xpath));
			printMessage("The List of WebElements is found successfully");
		}catch(InvalidSelectorException e) {
			e.printStackTrace();
			printMessage("the list of webelement is not found because the syntax of xpath :-- "+xpath+"  is wrong");
			throw e;
		}catch(StaleElementReferenceException e) {
			webLsts=driver.findElements(By.xpath(xpath));
			printMessage("The List of WebElements is found successfully");
		}catch(ElementClickInterceptedException e) {
			/** 
			 * ElementClickInterceptedException :- it is the child class of ElementNotInteractableException
			 * this type exception occures when the  element is hidden so we can use to overcome 
			 * this exception then we can use java script because JavasriptExecutorenters any 
			 * value or action whether any element hidden or not hidden in UI.........	
			 */
			e.printStackTrace();
			printMessage("The List of WebElements is not found successfully");
			throw e;
		}catch(NullPointerException e) {
			webLsts=driver.findElements(By.xpath(xpath));
			printMessage("The List of WebElements is found successfully");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("The List of WebElements is not found successfully");
			throw e;
		}

		return webLsts;

	}

	////////////   getTableRowCount  \\\\\\\\\\
	/**
	 * this method is used to obtain row count of the table as a int.
	 * 
	 * @param tableXpath
	 *        with the help table xpath we can find those element that comes under the table
	 *        as multiple column list name 
	 * 
	 */
	public  int getTableRowCount(String tableXpath, String elementName) {

		List<WebElement> webList=myFindElements(tableXpath+"//tr");
		int countRow=-1;
		if (webList.isEmpty()==false) {
			try {
				countRow=webList.size();
				printMessage("total row count of leads table is ="+countRow);
			} catch (Exception e) {
				e.printStackTrace();
				printMessage("total row count of leads table is not counted");
				throw e;
			}

		} else {
			printMessage("List is empty there is no any element");
		}
		return countRow;

	}


	////////////   getTableColumnCount  \\\\\\\\\\
	/**
	 * this method is used to obtain column count of the table as a int.
	 * 
	 * @param tableXpath
	 *        with the help table xpath we can find those element that comes under the table
	 *        as multiple column list name 
	 * 
	 */
	public  int getTableColumnHeaderCount(String tableXpath,String elementName) {

		List<WebElement> webListColumns=myFindElements(tableXpath+"//tr[1]//td");
		int countColumn=-1;
		if (webListColumns.isEmpty()==false) {
			try {
				countColumn=webListColumns.size();
				printMessage("total column count of "+elementName+" leads table is ="+countColumn);
			} catch (Exception e) {
				e.printStackTrace();
				printMessage("total column count of "+elementName+" leads table is ="+countColumn);
				throw e;
			}

		} else {
			printMessage("List is empty there is no any element");
		}
		return  countColumn;
	}

	////////////getTableColumnNamesList  \\\\\\\\\\

	/**
	 * this method is used to obtain column name of table as a list
	 * 
	 * @param tableXpath
	 *        with the help table xpath we can find those element that comes under the table
	 *        as multiple column list name 
	 * 
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return it will return list of webElements
	 */
	public   List<String> getTableColumnNamesList(String tableXpath, String elementName) {

		List<WebElement> weListColumns=myFindElements(tableXpath);
		String columnName="";
		List<String> listColumnNames =new ArrayList<>();
		if (weListColumns.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");

			try {
				for (int i = 0; i < weListColumns.size(); i++) {
					WebElement weColumnHeader	=weListColumns.get(i);
					columnName=weColumnHeader.getText();
					listColumnNames.add(columnName);
				}
				printMessage("the list of column name is found from the table successfully");

			} catch (Exception e) {
				e.printStackTrace();
				printMessage("the list of column name is not found from the table successfully");
				throw e;
			}

		} else {
			printMessage("List is empty there is no any element");
		}
		return listColumnNames;
	}
	////////////     getColumnHeaderNumberByColumnName  \\\\\\\\\\

	/**
	 * @param tableXpath
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public  int getColumnHeaderNumberByColumnName(String tableXpath,String tableName,String columnName) {
		List<WebElement> columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
		int columnNumber=-1;
		if (columnNamesList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 0; i < columnNamesList.size(); i++) {
					WebElement webColumnNames=columnNamesList.get(i);
					String actcolumnName =webColumnNames.getText();
					if (actcolumnName.equalsIgnoreCase(columnName) ) {
						columnNumber=i+1;
						break;
					} 
				}
				printMessage("column header number of the list is found by column name so column header number="+columnNumber);
			} catch (StaleElementReferenceException e) {
				columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
				for (int i = 0; i < columnNamesList.size(); i++) {
					WebElement webColumnNames=columnNamesList.get(i);
					String actcolumnName =webColumnNames.getText();
					if (actcolumnName.equalsIgnoreCase(columnName) ) {
						columnNumber=i+1;
						break;
					} 
				}
				printMessage("column header number of the list is found by column name so column header number="+columnNumber);
				return columnNumber;
			}catch (ElementNotInteractableException e) {
				columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
				// Use JavascriptExecutor to execute JavaScript code and get the inner text
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				for (int i = 0; i < columnNamesList.size(); i++) {
					WebElement webColumnNames=columnNamesList.get(i);
					String script="return arguments[0].innerText;";
					String actcolumnName = (String) jsExecutor.executeScript(script, webColumnNames);
					if (actcolumnName.equalsIgnoreCase(columnName) ) {
						columnNumber=i+1;
						break;
					}
				}
				printMessage("column header number of the list is found by column name so column header number ="+columnNumber);
				return columnNumber;
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("column header number of the list is not found by column name successfully");
			}
		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return columnNumber;
	}


	////////////     getColumnHeaderNameByColumnNumber  \\\\\\\\\\

	/**
	 * @param tableXpath
	 * @param tableName
	 * @param number
	 * @return
	 */
	public  String getColumnHeaderNameByColumnNumber(String tableXpath,String tableName,int number) {
		List<WebElement> columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
		String columnHeaderName="";
		if (columnNamesList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements successfully");
			try {
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						columnHeaderName=columnNamesList.get(i).getText();
						break;
					}
				}
				printMessage("Column Header Name of the list is found by column number hence Column Header Name ="+columnHeaderName);
			} catch (StaleElementReferenceException e) {
				columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						columnHeaderName=columnNamesList.get(i).getText();
						break;
					}
				}
				printMessage("Column Header Name of the list is found by column number hence Column Header Name ="+columnHeaderName);
				return columnHeaderName;
			}catch (ElementNotInteractableException e) {
				columnNamesList=myFindElements(tableXpath+"//tr[1]//td");
				// Use JavascriptExecutor to execute JavaScript code and get the inner text
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						WebElement webcolumnHeaderName=columnNamesList.get(i);
						String script="return arguments[0].innerText;";
						columnHeaderName = (String) jsExecutor.executeScript(script, webcolumnHeaderName);
						break;
					}
				}
				printMessage("Column Header Name of the list is found by column number hence Column Header Name ="+columnHeaderName);
				return columnHeaderName;
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Column Header Name of the list is not found by column number successfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return columnHeaderName;
	}

	////////////     getColumnNameByColumnNumberOfHeader  \\\\\\\\\\


	/**
	 * @param tableXpath
	 * 
	 * @param tableName
	 * 
	 * @param number
	 * 
	 * @return
	 */
	public  String getColumnNameByColumnNumberOfHeader(String tableXpath,String tableName,int number) {

		List<WebElement> columnNamesList=myFindElements(tableXpath+"//tr["+number+"]//td");
		String columnName="";
		if (columnNamesList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						columnName=columnNamesList.get(i).getText();
						break;
					}
				}
				printMessage("Column Name of the list is found by column number hence Column Name ="+columnName);
			} catch (StaleElementReferenceException e) {
				columnNamesList=myFindElements(tableXpath+"//tr["+number+"]//td");
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						columnName=columnNamesList.get(i).getText();
						break;
					}
				}
				printMessage("Column Name of the list is found by column number hence Column Name ="+columnName);
				return columnName;
			}catch (ElementNotInteractableException e) {
				columnNamesList=myFindElements(tableXpath+"//tr["+number+"]//td");
				// Use JavascriptExecutor to execute JavaScript code and get the inner text
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				for (int i = 0; i < columnNamesList.size(); i++) {
					if (i==number-1) {
						WebElement webcolumnHeaderName=columnNamesList.get(i);
						String script="return arguments[0].innerText;";
						columnName = (String) jsExecutor.executeScript(script, webcolumnHeaderName);
						break;
					}
				}
				printMessage("Column Name of the list is found by column number hence Column Name ="+columnName);
				return columnName;
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Column Header Name of the list is not found by column number sucessfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return columnName;
	}
	////////////   getRowDetailsByRowNummber  \\\\\\\\\\

	/**
	 * @param tableXpath
	 * @param tableName
	 * @param rowNumber
	 * @return
	 */
	public  List<String> getRowDetailsByRowNummber(String tableXpath,String tableName,int rowNumber) {

		List<WebElement> rowDetailsList=myFindElements(tableXpath+"//tr["+(rowNumber+1)+"]//td");
		List<String> strList=new ArrayList<>();
		if (rowDetailsList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 0; i < rowDetailsList.size(); i++) {
					String rowDetail=rowDetailsList.get(i).getText();
					strList.add(rowDetail);
				}
				printMessage("Get row details of the list is found by row number sucessfully");
			} catch (StaleElementReferenceException e) {
				rowDetailsList=myFindElements(tableXpath+"//tr["+(rowNumber+1)+"]//td");
				for (int i = 0; i < rowDetailsList.size(); i++) {
					String rowDetail=rowDetailsList.get(i).getText();
					strList.add(rowDetail);
				}
				printMessage("Get row details of the list is found by row number sucessfully");
				return strList;
			}catch (ElementNotInteractableException e) {
				rowDetailsList=myFindElements(tableXpath+"//tr["+(rowNumber+1)+"]//td");
				JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
				for (int i = 0; i < rowDetailsList.size(); i++) {
					WebElement webRowDetail=rowDetailsList.get(i);
					String script="return arguments[0].innerText;"; 
					String	rowDetail=(String)jsExecutor.executeScript(script, webRowDetail);
					strList.add(rowDetail);
				}
				printMessage("Get row details of the list is found by row number sucessfully");
				return strList;
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Get row details of the list is not found by row number sucessfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return strList;
	}

	////////////   getRowDetailsByRowNummber  \\\\\\\\\\


	/**
	 * @param tableXpath
	 * 
	 * @param tableName
	 * 
	 * @param columnNumber
	 * 
	 * @return 
	 */
	public  List<String> getColumnDataListByColumnNumber(String tableXpath,String tableName,int columnNumber) {

		List<WebElement> columnsList=myFindElements( tableXpath+"//tr//td["+columnNumber+"]");
		List<String> columnNameList =new ArrayList<>();
		if (columnsList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 1; i < columnsList.size(); i++) {
					String columnName=columnsList.get(i).getText();
					columnNameList.add(columnName);
				}
				printMessage("Get column details of the list is found by column number sucessfully");
			} catch (StaleElementReferenceException e) {
				columnsList=myFindElements( tableXpath+"//tr//td["+columnNumber+"]");	
				for (int i = 1; i < columnsList.size(); i++) {
					String columnName=columnsList.get(i).getText();
					columnNameList.add(columnName);
				}
				printMessage("Get column details of the list is found by column number sucessfully");
				return columnNameList;
			}catch (ElementNotInteractableException e) {
				columnsList=myFindElements( tableXpath+"//tr//td["+columnNumber+"]");	
				JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
				for (int i = 0; i < columnsList.size(); i++) {
					WebElement webColumnDetail=columnsList.get(i);
					String script="return arguments[0].innerText;"; 
					String	rowDetail=(String)jsExecutor.executeScript(script, webColumnDetail);
					columnNameList.add(rowDetail);
				}
				printMessage("Get column details of the list is found by column number sucessfully");
				return columnNameList;
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Get column details of the list is not found by column number sucessfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return columnNameList;
	}

	////////////getColumnDataListByColumnName  \\\\\\\\\\

	public  List<String> getColumnDataListByColumnName(String tableXpath,String tableName,String columnName) {

		int columnNumber=getColumnHeaderNumberByColumnName(tableXpath, tableName, columnName);
		List<String> rowDetailsList=getColumnDataListByColumnNumber(tableXpath, tableName, columnNumber);

		return rowDetailsList;
	}

	////////////getRowNumberByUniqueColumnRowID  \\\\\\\\\\

	public  int getRowNumberByUniqueColumnRowID(String tableXpath,String tableName,String uniquColumnName,String uniqueColumnName) {
		List<String> columnDtailsList=getColumnDataListByColumnName(tableXpath, tableName, uniquColumnName);
		int rowNumber=-1;
		if (columnDtailsList.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 0; i < columnDtailsList.size(); i++) {
					String columnData=columnDtailsList.get(i);
					if (columnData.equalsIgnoreCase(uniqueColumnName)) {
						rowNumber=i+1;
						break;
					}
				}
				printMessage("Get row number of the list is found by row id sucessfully so row number="+rowNumber);
			} catch (StaleElementReferenceException e) {
				columnDtailsList=getColumnDataListByColumnName(tableXpath, tableName, uniquColumnName);
				for (int i = 0; i < columnDtailsList.size(); i++) {
					String columnData=columnDtailsList.get(i);
					if (columnData.equalsIgnoreCase(uniqueColumnName)) {
						rowNumber=i+1;
						break;
					}
				}
				printMessage("Get row number of the list is found by row id sucessfully so row number="+rowNumber);
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Get row details of the list is not found by row number sucessfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
		return rowNumber;

	}

	////////////   getRowDataListByRowID  \\\\\\\\\\

	/**
	 * with the help of this method we can find row detaills by using row id
	 * so first of all we will know row number by using row id after that we will 
	 * know row details by row number.
	 * 
	 * @param tableXpath 
	 *         
	 * @param tableName 
	 *        we require table name to print a proper message to the console and
	 *        this shows in which element we are working......
	 *
	 * @param uniqueData
	 *        with the help of this i.e uniqueData we can find those unique data
	 *        that have a unique id.
	 * 
	 * @param uniqueColumnName
	 * 
	 * @return it returns List of String i.e List<String>
	 */
	public  List<String> getRowDataListByRowID(String tableXpath,String tableName,String uniqueData,String uniqueColumnName) {
		int rowNumber=getRowNumberByUniqueColumnRowID(tableXpath, tableName, uniqueData, uniqueColumnName);
		List<String> rowDetails=getRowDetailsByRowNummber(tableXpath, tableName, rowNumber);
		return rowDetails;
	}   
	////////////   printAllTableData  \\\\\\\\\\

	/**
	 * this method is commonaly used to print all the data from the table.
	 * 
	 * @param tableXpath 
	 *         with the help of the table xpath we can find all the data frome the 
	 *         table because table xpath is concatinate with '//tr' so
	 *         full xpath of the taable is [tableXpath+"//tr"]   
	 * 
	 * @param tableName 
	 *        we require table name to print a proper message to the console and
	 *        this shows in which element we are working......
	 */
	public  void printAllTableData(String tableXpath,String tableName) {
		List<WebElement> allData=myFindElements(tableXpath+"//tr");
		if (allData.isEmpty()==false) {
			printMessage("List is not empty there are available multiple elements");
			try {
				for (int i = 0; i <  allData.size(); i++) {
					String text= allData.get(i).getText();
					System.out.println(text);
				}
				printMessage("Get  all data of the list is found sucessfully");
			} catch (StaleElementReferenceException e) {
				allData=myFindElements(tableXpath+"//tr");				 
				for (int i = 0; i <  allData.size(); i++) {
					String text= allData.get(i).getText();
					System.out.println(text);
				}
				printMessage("Get  all data of the list is found sucessfully");
			}catch (ElementNotInteractableException e) {
				JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
				allData=myFindElements(tableXpath+"//tr");				 
				for (int i = 0; i <  allData.size(); i++) {
					WebElement weAllData= allData.get(i);
					String script="return arguments[0].innerText;"; 
					String	allElement=(String)jsExecutor.executeScript(script, weAllData);
					System.out.println(allElement);
				}
				printMessage("Get  all data of the list is found sucessfully");
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Get  all data of the list is not found sucessfully");
			}

		} else {
			printMessage("List is empty there are not available multiple elements");
		}
	}


	////////////   mySendKeys  \\\\\\\\\\

	/**
	 * this method is commonaly used to send value in input box or input 
	 * field.
	 *  
	 * @param xpath
	 *         it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @param inputValue
	 *        we have to send the input value in the textbox or 
	 *        input field
	 * 
	 * @throws ElementClickInterceptedException
	 *         this type exception occures when the element is hidden
	 *         so we can use to overcome this exception hen we can use
	 *         java script because JavasriptExecutorenters any value or
	 *         action whether any element hidden or not hidden in UI.........
	 * 
	 */
	public  void sendKeys(WebElement webObj, String inputValue) throws ElementClickInterceptedException {

		//WebElement 
		String elementName=webObj.getAccessibleName();
		if(webObj.isDisplayed() && webObj.isEnabled()) {

			printMessage("Element is Displayed and enabled ");

			try {
				webObj.clear();
				webObj.sendKeys(inputValue);
				printMessage(inputValue+" value is passed in "+elementName+" textbox successfully");

			}catch(ElementNotInteractableException e) {

				/** ElementNotInteractableException :- this type exception occures when the 
				 * element is hidden so we can use to overcome this exception then we can use
				 *  java script because JavasriptExecutorenters any value or action whether any element
				 *  hidden or not hidden in UI.........		
				 */
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("arguments[0].value='"+inputValue+"'",webObj );
				printMessage(inputValue+" value has entered in "+elementName+" textbox successfully");
			}catch(StaleElementReferenceException e) {
				webObj=driver.findElement(By.xpath("//input[@name='"+inputValue+"']"));
				printMessage("we have found "+elementName+" successfully");
				webObj.sendKeys(inputValue);
				printMessage(inputValue+" value has entered in "+elementName+" textbox successfully");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage(inputValue+" value hasn't entered in "+elementName+" textbox successfully");
				throw e;
			}

		}else {
			printMessage("Element is Displayed and enabled");
		}
	}

	////////////   getAttributeValue  \\\\\\\\\\

	/**
	 * this method is used to find the attribute value with the help of
	 * attribute name. 
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 *        
	 * @param attributeName
	 *         we have to find the attribute value from attribute name in the
	 *         form of string formate 
	 * 
	 * @return it returns String i.e attrubute value as a string
	 * 
	 * @throws ElementClickInterceptedException
	 *         this type exception occures when the  element is hidden
	 *         so we can use to overcome this exception hen we can use
	 *         java script because JavasriptExecutorenters any value or
	 *         action whether any element hidden or not hidden in UI.........
	 *        		
	 */
	public  String getAttributeValue(WebElement webObj, String attributeName) throws ElementClickInterceptedException {
		String elementName = webObj.getAccessibleName();

		String attributeValue=null;
		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is Displayed and enabled ");
			try {
				attributeValue=webObj.getAttribute(attributeName);
				printMessage(attributeName+" Attribute value of "+elementName+" :-"+attributeValue+" is found successfully ");
			}catch(ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and get the attribute value
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				// Replace with the actual attribute name you want to retrieve
				String script = "return arguments[0].getAttribute('" + attributeName + "');";
				attributeValue = (String) jsExecutor.executeScript(script, webObj);
				printMessage(attributeName+" Attribute value of "+elementName+" :-"+attributeValue+" is found successfully ");
				return attributeValue;
			}catch(StaleElementReferenceException e) {
				// StaleElementReferenceException :---when the page has been updated or refressed then  
				//                                     this type of exception will get....

				attributeValue=webObj.getAttribute(attributeName);
				printMessage(attributeName+" Attribute value of "+elementName+" :-"+attributeValue+" is found successfully ");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage(attributeName+" Attribute value of "+elementName+" :-"+attributeValue+" is not found successfully ");
				throw e;
			}

		}else {
			printMessage("Element is Displayed and enabled");
		}

		return attributeValue;
	}

	////////////   myClear  \\\\\\\\\\
	/**
	 * The myClear() method is commonly used to clear to the textbox or input field  
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  void myClear(WebElement webObj) {
		String elementName = webObj.getAccessibleName();
		printMessage("we have found "+elementName+" successfully");

		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is Displayed and enabled ");
			try {
				webObj.clear();
				printMessage(elementName+" textbox is cleared successfully");

			}catch(ElementNotInteractableException e) {
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value=''",webObj);
				printMessage(elementName+" textbox is cleared successfully");
			}catch(StaleElementReferenceException e) {

				printMessage("we have found "+elementName+" successfully");
				webObj.clear();
				printMessage(elementName+" textbox is cleared successfully");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage(elementName+" textbox is  not cleared successfully");
				throw e;
			}

		}else {

			printMessage("Element is not Displayed and enabled ");

		}

	}

	////////////   myClick  \\\\\\\\\\

	/**
	 * The myClick() method is commonly used to click to the element  
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  void click(WebElement webObj) {
		String elementName=webObj.getAccessibleName();
		if(webObj.isDisplayed() && webObj.isEnabled()) {

			printMessage("Element is Displayed and enabled");
			try {
				webObj.click();
				printMessage(elementName+" element is clicked successfully");

			}catch(ElementClickInterceptedException e) {

				JavascriptExecutor js=(JavascriptExecutor)driver;

				js.executeScript("arguments[0].click()", webObj);
				printMessage(elementName+" element is clicked successfully");

				throw e;
			}catch(StaleElementReferenceException e) {

				webObj.click();
				printMessage(elementName+" element is clicked successfully");

			}catch(Exception e) {
				e.printStackTrace();
				printMessage(elementName+" element is not clicked successfully");
				throw e;

			}	
		} else {
			printMessage("Element is not Displayed and enabled ");

		}
	}

	////////////   checkAllCheckBoxes  \\\\\\\\\\
	/**
	 * this method is used to check all the check boxes whether they are already 
	 * checked or unchecked.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 */
	public  void checkAllCheckBoxes(String xpath) {
		List<WebElement> webList=myFindElements(xpath);

		if (webList.isEmpty()==false) {
			try {
				for (int i = 0; i < webList.size(); i++) {
					WebElement web=webList.get(i);
					if (web.isSelected()==false) {         // isSelected---checkbox or radio button is selected or not
						try {
							web.click();
						} catch (ElementNotInteractableException e) {
							JavascriptExecutor js=(JavascriptExecutor)driver;
							js.executeScript("arguments[0].click()",web);
						}
					}
					printMessage("All the checkBoxes is checked successfully");
				}

			}catch (Exception e) {
				e.printStackTrace();
				printMessage("All the checkBoxes is not checked successfully");

			}

			printMessage("this List is not empty");

		} else {
			printMessage("this List is empty");
		}

	}

	////////////   uncheckAllCheckBoxes  \\\\\\\\\\

	/**
	 * this method is used to uncheck all the check boxes whether they are already 
	 * checked or unchecked.
	 * 
	 * @param xpath
	 *        it is used to find the element which we have to perform operation.
	 */
	public  void uncheckAllCheckBoxes(String xpath) {

		List<WebElement> webList=myFindElements(xpath);

		if (webList.isEmpty()==false) {
			try {
				for (int i = 0; i < webList.size(); i++) {
					WebElement web=webList.get(i);
					if (web.isSelected()==true) {         // isSelected---checkbox or radio button is selected or not
						try {
							web.click();
						} catch (ElementNotInteractableException e) {
							JavascriptExecutor js=(JavascriptExecutor)driver;
							js.executeScript("arguments[0].click()",web);
						}
					}
					printMessage("All the checkBoxes is unchecked successfully");
				}

			}catch (Exception e) {
				e.printStackTrace();
				printMessage("All the checkBoxes is  checked successfully");

			}

			printMessage("this List is not empty");

		} else {
			printMessage("this List is empty");
		}

	}

	////////////   myInnerText  \\\\\\\\\\
	/**
	 * The myInnerText() method is commonly used to find the inner text
	 * of any element.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 *                
	 */
	public  String myInnerText(WebElement webObj) {
		String innerText=null;
		if(webObj.isDisplayed() &&webObj.isEnabled()) {
			printMessage("Element is displayed and enabled");
			try {
				innerText=webObj.getText();
				printMessage("Inner Text :-"+innerText +" is Found Successfully");
			}catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and get the inner text
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "return arguments[0].innerText;";
				innerText = (String) jsExecutor.executeScript(script, webObj);
				printMessage("Inner Text :-"+innerText +" is Found Successfully");
				return innerText;
			}catch(StaleElementReferenceException e) {

				innerText=webObj.getText();
				printMessage("Inner Text :-"+innerText +" is Found Successfully");
			}
			catch(Exception e) {
				e.printStackTrace();
				printMessage("Inner Text :-"+innerText +" is not Found Successfully");
				throw e;
			}
		}else {
			printMessage("Element is displayed and enabled");
		}
		return innerText;
	}


	////////////   getXAndYOffSet  \\\\\\\\\\
	/**
	 * The getXAndYOffSet() method is commonly used to find the location
	 * of any element that means x offset and y offset.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return
	 *        it returns the object of Point class.
	 *                
	 */
	public  Point getXAndYOffSet(WebElement webObj) {

		Point location=null;
		if(webObj.isDisplayed() &&webObj.isEnabled()) {
			printMessage("Element is displayed and enabled");
			try {
				location=webObj.getLocation();
				printMessage("the location of the element is found successfully");
			}catch(StaleElementReferenceException e) {

				location=webObj.getLocation();
				printMessage("the location of the element is found successfully");
			}
			catch(Exception e) {
				e.printStackTrace();
				printMessage("the location of the element is not found successfully");
				throw e;
			}
		}else {
			printMessage("Element is displayed and enabled");
		}
		return location;
	}

	////////////getHeightAndWidth  \\\\\\\\\\
	/**
	 * The getHeightAndWidth() method is commonly used to find height and weidth
	 * of any element.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return
	 *        it returns the object of Dimension class.
	 *                
	 */


	public  Dimension getHeightAndWidth(WebElement webObj) {

		Dimension size=null;
		if(webObj.isDisplayed() &&webObj.isEnabled()) {
			printMessage("Element is displayed and enabled");
			try {
				size=webObj.getSize();
				printMessage("the size of the element is found successfully");
			}catch(StaleElementReferenceException e) {

				size=webObj.getSize();
				printMessage("the size of the element is found successfully");
			}
			catch(Exception e) {
				e.printStackTrace();
				printMessage("the size of the element is not found successfully");
				throw e;
			}
		}else {
			printMessage("Element is displayed and enabled");
		}
		return size;
	}

	////////////   verifyString  \\\\\\\\\\

	/**
	 * it is used to verify two String that is equal , same or not.
	 * 
	 * @param actStr
	 *        it refers to the actual text.
	 *        
	 * @param expStr
	 *        it refers to the expected text.
	 */
	public  void verifyString(String actStr,String expStr) {

		if(actStr.equalsIgnoreCase(expStr)) {
			printMessage("the actual string :-"+actStr+" and expected string :-"+expStr+" both are same");
		}else {
			printMessage("the actual string :-"+actStr+" and expected string :-"+expStr+" both are not same");
		}

	}

	////////////verifyInt  \\\\\\\\\\

	/**
	 * it is used to verify two integer number that is same or not.
	 * 
	 * @param actInt
	 *        it refers to the actual number.
	 *        
	 * @param expInt
	 *        it refers to the expected number.
	 */
	public  void verifyInt(int actInt,int expInt) {

		if(actInt==expInt) {
			printMessage("the actual integer :-"+actInt+" and expected integer :-"+expInt+" both are same");
		}else {
			printMessage("the actual integer :-"+actInt+" and expected integer :-"+expInt+" both are not same");
		}
	}

	////////////   checkDisplayed  \\\\\\\\\\
	/**
	 * The checkDisplayed() method is commonly used to check the element that is display or not
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return
	 *        it returns boolean i.e true or false
	 *        
	 */
	public  boolean checkDisplayed(WebElement webObj) {

		boolean status=false;
		try {
			status =webObj.isDisplayed();
			printMessage("Element is displayed");
		}catch(StaleElementReferenceException e) {

			status =webObj.isDisplayed();
			printMessage("Element is displayed");
		}
		catch(Exception e) {
			e.printStackTrace();
			printMessage("Element is not displayed");
			throw e;

		}
		return status;
	}

	////////////   checkEnabled  \\\\\\\\\\
	/**
	 * The checkEnabled() method is commonly used to check the element that is enable or not
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return
	 *        it returns boolean i.e true or false
	 *        
	 */
	public  boolean checkEnabled(WebElement webObj) {
		boolean status=false;
		try {
			status =webObj.isEnabled();
			printMessage("Element is enabled");
		}catch(ElementNotInteractableException e) {
			WebDriverWait webWait=new WebDriverWait(driver,Duration.ofSeconds(30));
			webWait.until(ExpectedConditions.visibilityOf(webObj));
		}catch(StaleElementReferenceException e) {

			status =webObj.isEnabled();
			printMessage("Element is enabled");
		}
		catch(Exception e) {
			e.printStackTrace();
			printMessage("Element is not enabled");
			throw e;

		}
		return status;

	}

	////////////    isSelected  \\\\\\\\\\

	/**
	 * The isSelected() method is commonly used with radio buttons, checkboxes,
	 * and options in a select dropdown. 
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @return
	 *        it returns boolean i.e true or false
	 *        
	 */
	public  boolean checkSelected(WebElement webObj) {

		//	The isSelected() method is commonly used with radio buttons, checkboxes,
		//	and options in a select dropdown. 

		boolean status=false;
		if(webObj.isDisplayed() && webObj.isEnabled()) {

			printMessage("Element is displayed and enabked");

			try {
				status=webObj.isSelected();
				printMessage("textBox or radio button or option in select dropDown is selected successfilly");
			}catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and check if the element is selected
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				status = (boolean) jsExecutor.executeScript("return arguments[0].selected;", webObj);
				printMessage("textBox or radio button or option in select dropDown is selected successfilly");
				return status;
			}catch(StaleElementReferenceException e) {

				status=webObj.isSelected();
				printMessage("textBox or radio button or option in select dropDown is selected successfilly");

			}
			catch(Exception e) {
				e.printStackTrace();
				printMessage("textBox or radio button or option in select dropDown is not selected successfilly");

			}

		}else {
			printMessage("Element is  not displayed and enabked");

		}

		return status;
	}
	////////////   selectByValueAttribute  \\\\\\\\\\

	/**
	 * with the help of this method we can select the element by it's value attributes
	 * from drop down.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @param value
	 *        it is used to select by value attribute
	 */
	public  void selectByValueAttribute(WebElement webObj,String value) {


		Select slct=new Select(webObj);

		if(webObj.isDisplayed() && webObj.isEnabled()) {

			printMessage("Element is Displayed and enabled");
			try {
				slct.selectByValue(value);
				printMessage("you have selected the element in dropDown by it's value :--"+value);
			}catch(ElementNotInteractableException eo) {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value='"+value+"'",webObj);
				printMessage("you have selected the element in dropDown by it's value :--"+value);
			}catch(StaleElementReferenceException e) {

				slct.selectByValue(value);
				printMessage("you have selected the element in dropDown by it's value :--"+value);
			}catch(NullPointerException e) {

				slct.selectByValue(value);
				printMessage("you have selected the element in dropDown by it's value :--"+value);
			}catch(Exception e) {
				e.printStackTrace();
				printMessage("you haven't selected the element in dropDown by it's value :--"+value);
				throw e;

			}
		}else {
			printMessage("Element is not Displayed and enabled ");
		}
	}

	////////////   selectByIndexNumber  \\\\\\\\\\
	/**
	 * it is used to select that element with the help of it's index number from drop down 
	 * the index number is starts 0 to number-1 
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @param indexNumber
	 *        it refers to the index number of drop down   
	 */
	public  void selectByIndexNumber(WebElement webObj,int indexNumber) {


		Select slct=new Select(webObj);

		if(webObj.isDisplayed() && webObj.isEnabled()) {

			printMessage("Element is Displayed and enabled");
			try {
				slct.selectByIndex(indexNumber);
				printMessage("you have selected the element in dropDown by it's index number :--"+indexNumber);
			}catch(ElementNotInteractableException eo) {
				String script = "arguments[0].selectedIndex = " + indexNumber + "; " +
						"arguments[0].dispatchEvent(new Event('change'));";
				((JavascriptExecutor) driver).executeScript(script, webObj);
				printMessage("you have selected the element in dropDown by it's index number :--"+indexNumber);

			}
			catch(StaleElementReferenceException e) {

				slct.selectByIndex(indexNumber);
				printMessage("you have selected the element in dropDown by it's index number :--"+indexNumber);

			}catch(NullPointerException e) {

				slct.selectByIndex(indexNumber);
				printMessage("you have selected the element in dropDown by it's index number :--"+indexNumber);
			}
			catch(Exception e) {

				e.printStackTrace();
				printMessage("you haven't selected the element in dropDown by it's index number :--"+indexNumber);
				throw e;

			}
		}else {
			printMessage("Element is not Displayed and enabled ");
		}
	}

	////////////   selectByVisibleString  \\\\\\\\\\

	/**
	 * it is used to select that element with the help of inner text or that
	 * we are seeing the element in UI.
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 * 
	 * @param visibleString
	 *        it refers to String as a text
	 */
	public  void selectByVisibleString(WebElement webObj,String visibleString) {


		if(webObj.isDisplayed() && webObj.isEnabled()) {

			Select slct=new Select(webObj);
			printMessage("Element is displayed and Enabled");
			try {
				slct.selectByVisibleText(visibleString);
				printMessage("you have selected the element in dropDown by it's visible String :--"+visibleString);
			}catch(StaleElementReferenceException e) {

				slct.selectByVisibleText(visibleString);
				printMessage("you have selected the element in dropDown by it's visible String :--"+visibleString);
			}
			catch(Exception e){
				e.printStackTrace();
				printMessage("you haven't selected the element in dropDown by it's visible String :--"+visibleString);
				throw e;
			}

		}else {
			printMessage("Element is not displayed and Enabled");

		}
	}
	/**
	 * this method is used to Fetch the element that is by defult selected in the dropDown  with the 
	 * help of getFirstSelectedElement method.  
	 * 
	 * @param xpath
	 *        it is used to find element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	////////////   getFirstSelectedElement  \\\\\\\\\\

	public  String getFirstSelectedElement(WebElement webObj) {

		String elementName = webObj.getAccessibleName();

		Select slt=new Select(webObj);
		String firstSelected=null;
		try {
			firstSelected=slt.getFirstSelectedOption().getText();
			printMessage("Fetch the first selected element :- "+firstSelected+" of "+elementName+" dropDown  successfully");
		}catch(StaleElementReferenceException e) {

			firstSelected=slt.getFirstSelectedOption().getText();
			printMessage("Fetch the first selected element :- "+firstSelected+" of "+elementName+" dropDown  successfully");
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "arguments[0].selectedIndex = 0;";
			firstSelected =(String) jsExecutor.executeScript(script, webObj);
			printMessage("Fetch the first selected element :- "+firstSelected+" of "+elementName+" dropDown  successfully");
			return firstSelected;
		}
		catch(Exception e) {
			e.printStackTrace();
			printMessage("Didn't Fetch the first selected element :- "+firstSelected+" of "+elementName+" dropDown successfully");
		}
		return firstSelected;
	}


	////////////   getAllElements  \\\\\\\\\\
	/**
	 * this method is used to Fetch all the webElements from the dropDown  with the 
	 * help of getAllElements method.  
	 * 
	 * @param xpath
	 *        it is used to find multiple elements which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  List<WebElement> getAllElements(WebElement webObj) {

		Select slctObj	=new Select(webObj);
		List<WebElement> lstElements=null;
		try {
			lstElements=slctObj.getOptions();
			printMessage("Fetched all the elements from the dropDown successfully ");
		}catch(StaleElementReferenceException e) {

			lstElements=slctObj.getOptions();
			printMessage("Fetched all the elements from the dropDown successfully ");
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Didn't Fetch all the elements from the dropDown successfully ");
		}
		return  lstElements ;
	}

	////////////   selectedByTextContains  \\\\\\\\\\
	/**
	 * it is used to select the element with the help of contains text in drop down.
	 * 
	 * @param xpath
	 *        it is used to find that element which we have to perform operation.
	 * @param elementName 
	 *        this shows in which element we are working and print a proper 
	 *        message in the console.
	 *        
	 *  @param selectText
	 *         it refers to the string as a text that shows which text
	 *          we have to selected in drop down.....
	 */

	public  void  selectedByTextContains(WebElement webObj,String selectText) {

		int indexNumber=0;
		Select slct=new Select(webObj);
		try {
			List<WebElement> webListOptions=slct.getOptions();
			printMessage("All the WebElement of dropDown is fetched");
			for (int i = 0; i < webListOptions.size(); i++) {
				String optionText=webListOptions.get(i).getText();
				boolean status=	optionText.contains(selectText);
				if (status==true) {
					indexNumber=i;
					break;
				}
			}
			slct.selectByIndex(indexNumber);
			printMessage("select text "+selectText+"  is selected from dropDown successfully");
		}catch(StaleElementReferenceException e) {

			List<WebElement> webListOptions=slct.getOptions();
			printMessage("All the WebElement of dropDown is fetched");
			for (int i = 0; i < webListOptions.size(); i++) {
				String optionText=webListOptions.get(i).getText();

				boolean status=	optionText.contains(selectText);
				if (status==true) {
					indexNumber=i;
					break;
				}
				slct.selectByIndex(indexNumber);
				printMessage("select text "+selectText+"  is selected from dropDown successfully");
			}
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("select text "+selectText+"  is not selected from dropDown successfully");

		}
	}

	////////////getOptionsCount  \\\\\\\\\\

	/**
	 * it is used to get the total number of element in drop down.
	 * 
	 * @param xpath
	 *        it is used to find that element which we have to perform operation.
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console.
	 *        
	 * @return it returns int i.e count of option in dropDown
	 */
	public  int getOptionsCount(WebElement webObj) {

		Select slt=new Select(webObj);
		int optionCount=0;
		try {
			optionCount=slt.getOptions().size();
			printMessage("Fetch the total element of the dropDown is "+optionCount);
		}catch(StaleElementReferenceException e) {

			optionCount=slt.getOptions().size();
			printMessage("Fetch the total element of the dropDown is "+optionCount);
		}catch(Exception e) {
			e.printStackTrace();
			printMessage("Fetch the total element of the dropDown is "+optionCount);
		}
		return optionCount;
	}

	////////////   mouseClick  \\\\\\\\\\

	/**
	 * this method is used to click action on the webElement with the 
	 * help of mouseClick method using Actions class.
	 * 
	 * @param xpath
	 *        it is used to find that element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  void mouseClick(WebElement webObj) {

		if(webObj.isDisplayed() && webObj.isEnabled()) {  

			printMessage("Element is displayed and enabled");
			Actions act=new Actions(driver);
			try {
				act.click(webObj).build().perform();
				printMessage("Click action is done successfully by Actions method");
			}catch(StaleElementReferenceException e) {

				act.click(webObj).build().perform();
				printMessage("Click action is done successfully by Actions method");
			}catch(ElementNotInteractableException e) {
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", webObj);
				printMessage("Click action is done successfully by Actions method");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage("Click Action is not done successfully by Actions method");
				throw e;
			}
		}else {
			printMessage("Element is not displayed and enabled");

		}
	}

	////////////   mouseRightClick  \\\\\\\\\\

	/**
	 * this method is used to right click action on the webElement with the 
	 * help of mouseRightClick method using Actions class.
	 * 
	 * @param xpath
	 *        it is used to find that element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  void mouseRightClick(WebElement webObj) {

		Actions act=new Actions(driver);
		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is displayed and Enabled");
			try {
				act.contextClick(webObj).build().perform();
				printMessage("Right click is performed successfully by Actions method");
			}catch(ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute the right-click event
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "var event = new MouseEvent('contextmenu', { 'bubbles': true, "
						+ "'cancelable': true });"
						+ "arguments[0].dispatchEvent(event);";
				jsExecutor.executeScript(script, webObj);
				printMessage("Right click is  performed successfully by Actions method");

			}catch(StaleElementReferenceException e) {

				act.contextClick(webObj).build().perform();
				printMessage("Right click is performed successfully by Actions method");
			}
			catch(Exception e) {
				e.printStackTrace();
				printMessage("Right click is not performed successfully by Actions method");
				throw e;
			}

		}else {
			printMessage("Element is not displayed and Enabled");

		}
	}
	////////////   mouseDoubleClick  \\\\\\\\\\
	/**
	 * this method is used to perform double click action on the webElement with the 
	 * help of mouseDoubleClick method using Actions class.
	 * 
	 * @param xpath
	 *        with the help of xpath we find the element by myFindElement method.
	 *        
	 * @param elementName
	 *        this is the element name where we have to perform action on an element.
	 * 
	 */
	public  void mouseDoubleClick(WebElement webObj) {

		Actions act=new Actions(driver);
		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is displayed and Enabled");
			try {
				act. doubleClick(webObj).build().perform();
				printMessage("Double click is performed successfully by Actions method");
			}catch(ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick',"
						+ " { bubbles: true }));",webObj );
				printMessage("Double click is performed successfully by Actions method");
			}catch(StaleElementReferenceException e) {

				act.doubleClick(webObj).build().perform();
				printMessage("Double click is performed successfully by Actions method");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage("Double click is not performed successfully by Actions method");
				throw e;
			}
		}else {
			printMessage("Element is not displayed and Enabled");

		}
	}
	////////////   mouseSendKeys  \\\\\\\\\\

	/**
	 * this method is used to send any input value in textbox or any input field with the 
	 * help of mouseSendKeys method using Actions class.
	 * 
	 * @param xpath
	 *        with the help of xpath we find the element by myFindElement method.
	 *        
	 * @param elementName
	 *        this is the element name where we have to send input value.
	 *        
	 * @param inputValue
	 *         here we have to send input value
	 * 
	 */
	public  void mouseSendKeys(WebElement webObj,String inputValue) {

		Actions act=new Actions(driver);
		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is displayed and Enabled");
			try {
				//WebElement we=driver.findElement(By.xpath(""));
				webObj.clear();
				driver.navigate().refresh();
				webObj.getTagName();
				webObj.sendKeys("");

				webObj.clear();
				act.sendKeys(webObj,inputValue).build().perform();
				printMessage("SendKeys is performed successfully by Actions method");
			}catch(ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].value='"+inputValue+"'",webObj );
				printMessage("SendKeys is performed successfully by Actions method");
			}catch(StaleElementReferenceException e) {

				act.sendKeys(webObj,inputValue).build().perform();
				printMessage("SendKeys is performed successfully by Actions method");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage("SendKeys is not performed successfully by Actions method");
				throw e;
			}
		}else {
			printMessage("Element is not displayed and Enabled");

		}
	}

	////////////   scrollingToElement  \\\\\\\\\

	/**
	 * this method is used to scroll to any particular element.
	 * 
	 * @param xpath
	 *        it is used to find that element which we have to perform operation.
	 *        
	 * @param elementName
	 *        this shows in which element we are working and print a proper 
	 *        message in the console. 
	 */
	public  void scrollingToElement(WebElement webObj) {

		Actions act=new Actions(driver);
		if(webObj.isDisplayed() && webObj.isEnabled()) {
			printMessage("Element is displayed and Enabled");
			try {
				act.scrollToElement(webObj).build().perform();
				printMessage("scrolling to the element is performed successfully by Actions method");
			}catch(ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", webObj);			
				printMessage("scrolling to the element is performed successfully by Actions method");
			}catch(StaleElementReferenceException e) {

				act.scrollToElement(webObj).build().perform();
				printMessage("scrolling to the element is performed successfully by Actions method");
			}catch(Exception e) {
				e.printStackTrace();
				printMessage("scrolling to the element is not performed successfully by Actions method");
				throw e;
			}
		}else {
			printMessage("Element is not displayed and Enabled");

		}
	}

	////////////   mouseDragDrop  \\\\\\\\\

	/**
	 * this method is especially designed to drag and drop operation 
	 * from one webElement to another webElement
	 * 
	 * @param dragXpath
	 *         this is the source element xpath which we have to drag
	 * @param dragElementName
	 *        this is the drag element name which is draged 
	 * 
	 * @param dropXpath
	 *         this is the target element xpath which we have to drop
	 * 
	 * @param dropElementName
	 *        this is the drop element name where we have to drop.
	 */
	public  void mouseDragDrop(WebElement dragWeb, WebElement dropWeb) {
		String dragElementName=dragWeb.getAccessibleName();
		String dropElementName=dropWeb.getAccessibleName();
		Actions ac=new Actions(driver);
		if (dragWeb.isDisplayed() &&dropWeb.isEnabled() && dropWeb.isDisplayed() &&dropWeb.isEnabled()) {
			printMessage("Both element "+dragElementName+" and "+dropElementName +"is disable and enable");
			try {
				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				printMessage("Drag operation "+dragElementName +" is  droped to the "+dropElementName+" successfully");
			}catch (StaleElementReferenceException e) {

				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				printMessage("Drag operation "+dragElementName +" is  droped to the "+dropElementName+" successfully");
			}catch (ElementNotInteractableException e) {

				String xto=Integer.toString(dropWeb.getLocation().x);
				String yto=Integer.toString(dropWeb.getLocation().y);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("function simulate(f,c,d,e){var b,a=null;"
						+ "for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)"
						+ "return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\""
						+ "?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,"
						+ "d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),"
						+ "a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a."
						+ "altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));"
						+ "return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|"
						+ "change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick"
						+ "|mouse(?:down|up|over|move|out))$/}; " +
						"simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\""
						+ ",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
						dragWeb,xto,yto);
				printMessage("Drag operation "+dragElementName +" is not droped to the "+dropElementName+" successfully");
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Drag operation "+dragElementName +" is not droped to the "+dropElementName+" successfully");
				throw e;
			}

		} else {
			printMessage("Both element "+dragElementName+" and "+dropElementName +"is not disable and enable");
		}
	}

	////////////   mouseClickAndHold  \\\\\\\\\

	/**
	 * this method is used to click and hold of that element with the help of 
	 * mouse it means that pressing the left button on an element without releasing
	 * it.This method is often used in combination with other Actions methods to 
	 * perform complex interactions like drag-and-drop.
	 * 
	 * @param xpath
	 *        it is used to find the element with the help of myFindElement
	 *        method.
	 *         
	 * @param elementName
	 *        it is used in which element we are working and print a proper
	 *        message to include this.
	 */
	public  void mouseClickAndHold(WebElement webClickHold) {
		Actions ac=new Actions(driver);
		if (webClickHold.isDisplayed() && webClickHold.isEnabled() ) {
			printMessage("Element is displayed and Enabled");
			try {
				ac.clickAndHold(webClickHold).build().perform();
				printMessage("Element is clicked and hold on successfully");

			}catch (StaleElementReferenceException e) {

				ac.clickAndHold(webClickHold).build().perform();
				printMessage("Element is clicked and hold on successfully");
			}catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code for the click and hold action
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "function simulateClickAndHold(element) { " +
						"   var event = new MouseEvent('mousedown', { " +
						"       bubbles: true, " +
						"       cancelable: true, " +
						"       view: window, " +
						"       buttons: 1 " +
						"   }); " +
						"   element.dispatchEvent(event); " +
						"} " +
						"simulateClickAndHold(arguments[0]);";
				jsExecutor.executeScript(script, webClickHold);
				printMessage("Element is clicked and hold on successfully");
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Element is not clicked and hold on successfully");
			}

		}else {
			printMessage("Element is not displayed and Enabled");

		}

	}
	////////////   mouseReleaseElement  \\\\\\\\\

	/**
	 * it is used to release mouse button after performing mouse related action.
	 * the release() method should be called after performing mouse action
	 * just like clickAndHold,click and moveToElement.
	 * 
	 * @param xpath 
	 *        with the help of xpath we can easily find the element via myFindElement method
	 *        if xpath is wrong then it throws NoSuchElementException and in case of syntax of xpath
	 *        is wrong then it throws  InvalidSelectorException.
	 *        
	 * @param elementName
	 *        we need to element name to write a sitable message
	 *         In case of fail and pass conditions .
	 */
	public  void mouseReleaseElement(WebElement webRelease) {

		Actions ac=new Actions(driver);
		if (webRelease.isDisplayed() && webRelease.isEnabled() ) {
			printMessage("Element is displayed and Enabled");
			try {
				ac.release(webRelease).build().perform();
				printMessage("Element is released successfully");

			}catch (StaleElementReferenceException e) {

				ac.release(webRelease).build().perform();
				printMessage("Element is released successfully");
			}catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code for the click and hold action
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String releaseScript = "function simulateMouseRelease() { " +
						"   var event = new MouseEvent('mouseup', { " +
						"       bubbles: true, " +
						"       cancelable: true, " +
						"       view: window, " +
						"       buttons: 0 " +
						"   }); " +
						"   document.dispatchEvent(event); " +
						"} " +
						"simulateMouseRelease();";
				jsExecutor.executeScript(releaseScript);
				printMessage("Element is released successfully");
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Element is not released successfully");
			}

		}else {
			printMessage("Element is not displayed and Enabled");

		}

	}
	////////////   mouseMoveToElement  \\\\\\\\\

	/**
	 * with the help of mouseMoveToElement method we can mouse hover of any element
	 * it means that we can move to the mouse in any given element
	 * 
	 * @param xpath
	 *        we pass xpath to the findElement method to find
	 *        the element.  
	 * @param elementName
	 *        we needs to give the name of any element to 
	 *        print a suitable message .   
	 */
	public  void mouseMoveToElement(WebElement webMoveToElement) {
		Actions ac=new Actions(driver);
		if (webMoveToElement.isDisplayed() && webMoveToElement.isEnabled() ) {
			printMessage("Element is displayed and Enabled");
			try {
				ac.moveToElement(webMoveToElement).build().perform();
				printMessage("Move to Element is performed successfully");

			}catch (StaleElementReferenceException e) {

				ac.release(webMoveToElement).build().perform();
				printMessage("Move to Element is performed successfully");
			}catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code for moving to the element
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "var element = arguments[0];" +
						"var rect = element.getBoundingClientRect();" +
						"var centerX = rect.left + rect.width / 2;" +
						"var centerY = rect.top + rect.height / 2;" +
						"var mouseMoveEvent = new MouseEvent('mousemove', {" +
						"  bubbles: true," +
						"  cancelable: true," +
						"  view: window," +
						"  clientX: centerX," +
						"  clientY: centerY" +
						"});" +
						"element.dispatchEvent(mouseMoveEvent);";
				jsExecutor.executeScript(script, webMoveToElement);

				printMessage("Element is released successfully");
			}catch (Exception e) {
				e.printStackTrace();
				printMessage("Move to Element is not performed successfully");
			}

		}else {
			printMessage("Element is not displayed and Enabled");

		}

	}

	public  String getRandomName(int i) {
		RandomString rs=new RandomString();
		String str=rs.nextString();
		return str;
	}

}
