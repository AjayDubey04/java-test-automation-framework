package com.example.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

@Getter
@Setter
public class WebUtil {

	private WebDriver driver;

	private static WebUtil wt;
	private WebUtil() {

	}
	public static WebUtil getInstance() {
		if (wt == null) {
			wt = new WebUtil();
		}
		return wt;
	}

	
	
	private ExtentTest logger;
	public void setExtentTest(ExtentTest logger1) {
		this.logger=logger1;
	}

	public ExtentTest getExtentTest() {
		return this.logger;
	}

	public void myThread(long duration) {

		try {
			Thread.sleep(duration);
			logger.log(Status.INFO, "we have given " + duration + " millies seconds to the element");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void launchBrowser(String browserName) {

		switch (browserName) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched Successfully");
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("FireFox Browser Launched Successfully");
			break;
		}
		case "edge": {
			System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("Edge Browser Launched Successfully");
			break;
		}
		default: {
			throw new IllegalArgumentException("Invalid browser option");
		}
		}
	}

	public String takeSnapshot(String testCaseName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File fileObj = ts.getScreenshotAs(OutputType.FILE);
		File desiredLocation = new File("src\\test\\resources\\Screenshot\\" + testCaseName + ".png");
		try {
			Files.copy(fileObj, desiredLocation);
			logger.log(Status.INFO, "Taked Screenshot Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return desiredLocation.getAbsolutePath();

	}

	public void windowMaximize() {

		try {
			driver.manage().window().maximize();
//			logger.log(Status.INFO, "the window is maximized");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the window is maximized");
		}
	}

	public void windowMinimize() {

		try {
			driver.manage().window().minimize();
			logger.log(Status.INFO, "the window is minimized");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the window is not minimized");
		}
	}

	public void myImpliciteWait(long seconds) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
//			logger.log(Status.INFO, "the maximum timeouts for waiting is " + seconds);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void openUrl(String url) throws Exception {

		try {
			driver.get(url);
			logger.log(Status.INFO, "the given url :-" + url + " is launched sucessfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "window.location.href='" + url + "';";
			jsExecutor.executeScript(script);
			logger.log(Status.INFO, "the given url :-" + url + " is launched sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToBackPage() {

		try {
			driver.navigate().back();
			logger.log(Status.INFO, "the Page has been backed sucessfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to go back
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.history.back();");
			logger.log(Status.INFO, "the Page has been backed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the Page hasn't been backed sucessfully");
		}
	}

	public void goToForwardPage() throws Exception {

		try {
			driver.navigate().forward();
			logger.log(Status.INFO, "the Page has been forwarded sucessfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to go forward
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.history.forward();");
			logger.log(Status.INFO, "the Page has been forwarded sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToRefreshPage() {

		try {
			driver.navigate().refresh();
			logger.log(Status.INFO, "the Page has been refreshed sucessfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to refresh the page
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("location.reload();");
			logger.log(Status.INFO, "the Page has been refreshed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToHitUrl(String url) {

		try {
			driver.navigate().to(url);
//			exeTest.log(Status.INFO,"the given url < "+url+" > Hited successfully");
			System.out.println("the given url < " + url + " > Hited successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.location.href = '" + url + "';");
			System.out.println("the given url < " + url + " > Hited successfully");
//			exeTest.log(Status.INFO,"the given url < "+url+" > Hited successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPresentUrl() {

		String pageUrl = null;
		try {
			pageUrl = driver.getCurrentUrl();
			logger.log(Status.INFO, "find the current page url :-" + pageUrl);
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return window.location.href;";
			pageUrl = (String) jsExecutor.executeScript(script);
			logger.log(Status.INFO, "find the current page url :-" + pageUrl);
			return pageUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageUrl;

	}

	public String getPageTitle() {

		String pageTitle = null;
		try {
			pageTitle = driver.getTitle();
			logger.log(Status.INFO, "find the title of the page is :-" + pageTitle);
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page title
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return document.title;";
			pageTitle = (String) jsExecutor.executeScript(script);
			logger.log(Status.INFO, "find the title of the page is :-" + pageTitle);
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTitle;
	}

	public String getPageSourceCode() {

		String sourceCode = null;
		try {
			sourceCode = driver.getPageSource();
			logger.log(Status.INFO, "find the source code of the page :-" + sourceCode);
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page source
			// code
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return document.documentElement.outerHTML;";
			sourceCode = (String) jsExecutor.executeScript(script);
			logger.log(Status.INFO, "find the source code of the page :-" + sourceCode);
			return sourceCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceCode;
	}

	public void myClose() {

		try {
			driver.close();
			logger.log(Status.INFO, "the current window or tab is closed successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to close the current browser window
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.close();");
			logger.log(Status.INFO, "the current window or tab is closed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void myQuit() {

		try {
			driver.quit();
			logger.log(Status.INFO, "All the  window or tab is closed successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to quit the entire WebDriver session
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.open('', '_self', ''); window.close();");
			logger.log(Status.INFO, "All the  window or tab is closed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToWindowByTitle(String expectPageTitle) {

		try {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by title :- " + expectPageTitle + " successfully");
		} catch (StaleElementReferenceException e) {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is  switched by title :- " + expectPageTitle + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToWindowByUrl(String expectPageUrl) {

		try {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageUrl = driver.getCurrentUrl();
				if (actPageUrl.equalsIgnoreCase(expectPageUrl)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by title :- " + expectPageUrl + " successfully");
		} catch (StaleElementReferenceException e) {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageUrl = driver.getCurrentUrl();
				if (actPageUrl.equalsIgnoreCase(expectPageUrl)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by url :- " + expectPageUrl + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToWindowByDynamicTitle(String dynamicTitle) {

		try {
			Set<String> handleValues = driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.contains(dynamicTitle)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by title :- " + dynamicTitle + " successfully");
		} catch (StaleElementReferenceException e) {
			Set<String> handleValues = driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.contains(dynamicTitle)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by dynamic  title :- " + dynamicTitle + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToWindowByDynamicUrl(String dynamicUrl) {

		try {
			Set<String> handleValues = driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageUrl = driver.getCurrentUrl();
				if (actPageUrl.contains(dynamicUrl)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by title :- " + dynamicUrl + " successfully");
		} catch (StaleElementReferenceException e) {
			Set<String> handleValues = driver.getWindowHandles();
			for (String handleValue : handleValues) {
				driver.switchTo().window(handleValue);
				String actPageUrl = driver.getCurrentUrl();
				if (actPageUrl.contains(dynamicUrl)) {
					break;
				}
			}
			logger.log(Status.INFO, "the Window is switched by title :- " + dynamicUrl + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrameByWebElement(WebElement weFrame) {

		String elementName = weFrame.getAccessibleName();
		try {
			driver.switchTo().frame(weFrame);
			logger.log(Status.INFO, "the window is switched into the frame " + elementName + "  suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrameByIndex(String elementName, int frameIndex) {

		try {
			driver.switchTo().frame(frameIndex);
			logger.log(Status.INFO, "the window is switched into the frame " + elementName + "  suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrameByNameOrId(String NameOrId) {

		try {
			driver.switchTo().frame(NameOrId);
			logger.log(Status.INFO, "the window is switched into the frame by Name or Id  suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToParentFrame(String elementName) {

		try {
			driver.switchTo().parentFrame();
			logger.log(Status.INFO, "the window is switched into the parentFrame suceessfully");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().parentFrame();
			logger.log(Status.INFO, "the window is switched into the parentFrame suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the window is not switched into the parentFrame suceessfully");
			throw e;
		}
	}

	public void switchToMainWindow(String elementName) {

		try {
			driver.switchTo().defaultContent();
			logger.log(Status.INFO, "the window is switched into the  Main Window suceessfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the window is not switched into the  Main Window suceessfully");
			throw e;
		}
	}

	public void acceptAlert() {

		// NoAlertPresentException: This exception occurs when there is no alert present
		// on the web page
		// at the time you attempt to interact with it..............

		try {
			driver.switchTo().alert().accept();
			logger.log(Status.INFO, "Pop up is accepted successfully");
		} catch (NoAlertPresentException e) {
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			logger.log(Status.INFO, " Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			logger.log(Status.INFO, "Switch to the alert and perform operations if needed");
			driver.switchTo().alert().accept();
			logger.log(Status.INFO, "Pop up is accepted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Pop up is not accepted successfully");
			throw e;
		}

	}

	public void DismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			logger.log(Status.INFO, "Pop up is dismissed successfully");
		} catch (NoAlertPresentException e) {
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			logger.log(Status.INFO, " Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			logger.log(Status.INFO, "Switch to the alert and perform operations if needed");
			driver.switchTo().alert().dismiss();
			logger.log(Status.INFO, "Pop up is dismissed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Pop up is not dismissed successfully");
			throw e;
		}
	}

	public void alertSendKeys(String popUpKeyText) {
		try {
			driver.switchTo().alert().sendKeys(popUpKeyText);
			logger.log(Status.INFO, "Pop up is  " + popUpKeyText + "  successfully");
		} catch (NoAlertPresentException e) {
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			logger.log(Status.INFO, " Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			logger.log(Status.INFO, "Switch to the alert and perform operations if needed");
			driver.switchTo().alert().sendKeys(popUpKeyText);
			logger.log(Status.INFO, "Pop up is  " + popUpKeyText + "  successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Pop up is  not " + popUpKeyText + "  successfully");
			throw e;
		}

	}

	public void alertGetText() {
		try {
			driver.switchTo().alert().getText();
			logger.log(Status.INFO, "the text of Pop up is found successfully");
		} catch (NoAlertPresentException e) {
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			logger.log(Status.INFO, " Wait for the alert to be present (timeout for 30 seconds)");
			webWait.until(ExpectedConditions.alertIsPresent());
			logger.log(Status.INFO, "Switch to the alert and perform operations if needed");
			driver.switchTo().alert().getText();
			logger.log(Status.INFO, "the text of Pop up is found successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "the text of Pop up is not found successfully");
			throw e;
		}

	}

	// mySendKeys \\
	/**
	 * this method is commonaly used to send value in input box or input field.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param inputValue  we have to send the input value in the textbox or input
	 *                    field
	 * 
	 * @throws ElementClickInterceptedException this type exception occures when the
	 *                                          element is hidden so we can use to
	 *                                          overcome this exception hen we can
	 *                                          use java script because
	 *                                          JavasriptExecutorenters any value or
	 *                                          action whether any element hidden or
	 *                                          not hidden in UI.........
	 * 
	 */
	public void sendKeys(WebElement webObj, String inputValue) throws ElementClickInterceptedException {

		// WebElement
		String elementName = webObj.getAccessibleName();
		if (webObj.isDisplayed() && webObj.isEnabled()) {
//			logger.log(Status.INFO, "Element is Displayed and enabled ");

			try {
				webObj.clear();
				webObj.sendKeys(inputValue);
//				logger.log(Status.INFO, inputValue + " value is passed in " + elementName + " textbox successfully");

			} catch (ElementNotInteractableException e) {

				/**
				 * ElementNotInteractableException :- this type exception occures when the
				 * element is hidden so we can use to overcome this exception then we can use
				 * java script because JavasriptExecutorenters any value or action whether any
				 * element hidden or not hidden in UI.........
				 */
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].value='" + inputValue + "'", webObj);
				logger.log(Status.INFO, inputValue + " value has entered in " + elementName + " textbox successfully");
			} catch (StaleElementReferenceException e) {
				webObj = driver.findElement(By.xpath("//input[@name='" + inputValue + "']"));
				logger.log(Status.INFO, "we have found " + elementName + " successfully");
				webObj.sendKeys(inputValue);
				logger.log(Status.INFO, inputValue + " value has entered in " + elementName + " textbox successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO,
						inputValue + " value hasn't entered in " + elementName + " textbox successfully");
				throw e;
			}

		} else {
			logger.log(Status.INFO, "Element is Displayed and enabled");
		}
	}

	// getAttributeValue \\
	/**
	 * this method is used to find the attribute value with the help of attribute
	 * name.
	 * 
	 * @param xpath         it is used to find element which we have to perform
	 *                      operation.
	 * 
	 * @param elementName   this shows in which element we are working and print a
	 *                      proper message in the console.
	 * 
	 * @param attributeName we have to find the attribute value from attribute name
	 *                      in the form of string formate
	 * 
	 * @return it returns String i.e attrubute value as a string
	 * 
	 * @throws ElementClickInterceptedException this type exception occures when the
	 *                                          element is hidden so we can use to
	 *                                          overcome this exception hen we can
	 *                                          use java script because
	 *                                          JavasriptExecutorenters any value or
	 *                                          action whether any element hidden or
	 *                                          not hidden in UI.........
	 * 
	 */
	public String getAttributeValue(WebElement webObj, String attributeName) throws ElementClickInterceptedException {
		String elementName = webObj.getAccessibleName();

		String attributeValue = null;
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is Displayed and enabled ");
			try {
				attributeValue = webObj.getAttribute(attributeName);
				logger.log(Status.INFO, attributeName + " Attribute value of " + elementName + " :-" + attributeValue
						+ " is found successfully ");
			} catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and get the attribute value
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				// Replace with the actual attribute name you want to retrieve
				String script = "return arguments[0].getAttribute('" + attributeName + "');";
				attributeValue = (String) jsExecutor.executeScript(script, webObj);
				logger.log(Status.INFO, attributeName + " Attribute value of " + elementName + " :-" + attributeValue
						+ " is found successfully ");
				return attributeValue;
			} catch (StaleElementReferenceException e) {
				// StaleElementReferenceException :---when the page has been updated or
				// refressed then
				// this type of exception will get....

				attributeValue = webObj.getAttribute(attributeName);
				logger.log(Status.INFO, attributeName + " Attribute value of " + elementName + " :-" + attributeValue
						+ " is found successfully ");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, attributeName + " Attribute value of " + elementName + " :-" + attributeValue
						+ " is not found successfully ");
				throw e;
			}

		} else {
			logger.log(Status.INFO, "Element is Displayed and enabled");
		}

		return attributeValue;
	}

	// myClear \\
	/**
	 * The myClear() method is commonly used to clear to the textbox or input field
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void myClear(WebElement webObj) {
		String elementName = webObj.getAccessibleName();
		logger.log(Status.INFO, "we have found " + elementName + " successfully");

		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is Displayed and enabled ");
			try {
				webObj.clear();
				logger.log(Status.INFO, elementName + " textbox is cleared successfully");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value=''", webObj);
				logger.log(Status.INFO, elementName + " textbox is cleared successfully");
			} catch (StaleElementReferenceException e) {
				logger.log(Status.INFO, "we have found " + elementName + " successfully");
				webObj.clear();
				logger.log(Status.INFO, elementName + " textbox is cleared successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, elementName + " textbox is  not cleared successfully");
				throw e;
			}

		} else {

			logger.log(Status.INFO, "Element is not Displayed and enabled ");

		}

	}

	// myClick \\
	/**
	 * The myClick() method is commonly used to click to the element
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void click(WebElement webObj) {

		String elementName = webObj.getAccessibleName();
		if (webObj.isDisplayed() && webObj.isEnabled()) {

//			logger.log(Status.INFO, "Element is Displayed and enabled");
			try {
				webObj.click();
//				logger.log(Status.INFO, elementName + " element is clicked successfully");

			} catch (ElementClickInterceptedException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", webObj);
				logger.log(Status.INFO, elementName + " element is clicked successfully");

			} catch (StaleElementReferenceException e) {
				webObj.click();
				logger.log(Status.INFO, elementName + " element is clicked successfully");

			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, elementName + " element is not clicked successfully");
				throw e;

			}
		} else {
			logger.log(Status.INFO, "Element is not Displayed and enabled ");

		}
	}

	// checkAllCheckBoxes \\
	/**
	 * this method is used to check all the check boxes whether they are already
	 * checked or unchecked.
	 * 
	 * @param xpath it is used to find element which we have to perform operation.
	 */
	public void checkAllCheckBoxes(List<WebElement> webList) {

		if (webList.isEmpty() == false) {
			try {
				for (int i = 0; i < webList.size(); i++) {
					WebElement web = webList.get(i);
					if (web.isSelected() == false) {
						try {
							web.click();
						} catch (ElementNotInteractableException e) {
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].click()", web);
						}
					}
					logger.log(Status.INFO, "All the checkBoxes is checked successfully");
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "All the checkBoxes is not checked successfully");

			}

			logger.log(Status.INFO, "this List is not empty");

		} else {
			logger.log(Status.INFO, "this List is empty");
		}

	}

	// uncheckAllCheckBoxes \\
	/**
	 * this method is used to uncheck all the check boxes whether they are already
	 * checked or unchecked.
	 * 
	 * @param xpath it is used to find the element which we have to perform
	 *              operation.
	 */
	public void uncheckAllCheckBoxes(List<WebElement> webList) {

		if (webList.isEmpty() == false) {
			try {
				for (int i = 0; i < webList.size(); i++) {
					WebElement web = webList.get(i);
					if (web.isSelected() == true) {
						try {
							web.click();
						} catch (ElementNotInteractableException e) {
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].click()", web);
						}
					}
					logger.log(Status.INFO, "All the checkBoxes is unchecked successfully");
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "All the checkBoxes is  checked successfully");

			}
			logger.log(Status.INFO, "this List is not empty");

		} else {
			logger.log(Status.INFO, "this List is empty");
		}

	}

	// myInnerText \\
	/**
	 * The myInnerText() method is commonly used to find the inner text of any
	 * element.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 */
	public String myInnerText(WebElement webObj) {

		String innerText = null;
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and enabled");
			try {
				innerText = webObj.getText();
				logger.log(Status.INFO, "Inner Text :-" + innerText + " is Found Successfully");
			} catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and get the inner text
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "return arguments[0].innerText;";
				innerText = (String) jsExecutor.executeScript(script, webObj);
				logger.log(Status.INFO, "Inner Text :-" + innerText + " is Found Successfully");
				return innerText;
			} catch (StaleElementReferenceException e) {

				innerText = webObj.getText();
				logger.log(Status.INFO, "Inner Text :-" + innerText + " is Found Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Inner Text :-" + innerText + " is not Found Successfully");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is displayed and enabled");
		}
		return innerText;
	}

	// getXAndYOffSet \\
	/**
	 * The getXAndYOffSet() method is commonly used to find the location of any
	 * element that means x offset and y offset.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns the object of Point class.
	 * 
	 */
	public Point getXAndYOffSet(WebElement webObj) {

		Point location = null;
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and enabled");
			try {
				location = webObj.getLocation();
				logger.log(Status.INFO, "the location of the element is found successfully");
			} catch (StaleElementReferenceException e) {

				location = webObj.getLocation();
				logger.log(Status.INFO, "the location of the element is found successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "the location of the element is not found successfully");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is displayed and enabled");
		}
		return location;
	}

	// getHeightAndWidth \\
	/**
	 * The getHeightAndWidth() method is commonly used to find height and weidth of
	 * any element.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns the object of Dimension class.
	 * 
	 */
	public Dimension getHeightAndWidth(WebElement webObj) {

		Dimension size = null;
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and enabled");

			try {
				size = webObj.getSize();
				logger.log(Status.INFO, "the size of the element is found successfully");
			} catch (StaleElementReferenceException e) {
				size = webObj.getSize();
				logger.log(Status.INFO, "the size of the element is found successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "the size of the element is not found successfully");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is displayed and enabled");
		}
		return size;
	}

	// verifyString \\
	/**
	 * it is used to verify two String that is equal , same or not.
	 * 
	 * @param actStr it refers to the actual text.
	 * 
	 * @param expStr it refers to the expected text.
	 */
	public void verifyString(String actStr, String expStr) {

		if (actStr.equalsIgnoreCase(expStr)) {
			logger.log(Status.INFO,
					"the actual string :-" + actStr + " and expected string :-" + expStr + " both are same");
		} else {
			logger.log(Status.INFO,
					"the actual string :-" + actStr + " and expected string :-" + expStr + " both are not same");
		}

	}

	// verifyInt \\
	/**
	 * it is used to verify two integer number that is same or not.
	 * 
	 * @param actInt it refers to the actual number.
	 * 
	 * @param expInt it refers to the expected number.
	 */
	public void verifyInt(int actInt, int expInt) {

		if (actInt == expInt) {
			logger.log(Status.INFO,
					"the actual integer :-" + actInt + " and expected integer :-" + expInt + " both are same");
		} else {
			logger.log(Status.INFO,
					"the actual integer :-" + actInt + " and expected integer :-" + expInt + " both are not same");
		}
	}

	// isDisplayed \\
	/**
	 * The checkDisplayed() method is commonly used to check the element that is
	 * display or not
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns boolean i.e true or false
	 * 
	 */
	public boolean checkDisplayed(WebElement webObj) {

		boolean status = false;
		try {
			status = webObj.isDisplayed();
			logger.log(Status.INFO, "Element is displayed");
		} catch (StaleElementReferenceException e) {

			status = webObj.isDisplayed();
			logger.log(Status.INFO, "Element is displayed");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Element is not displayed");
			throw e;

		}
		return status;
	}

	// isEnabled \\
	/**
	 * The checkEnabled() method is commonly used to check the element that is
	 * enable or not
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns boolean i.e true or false
	 * 
	 */
	public boolean checkEnabled(WebElement webObj) {
		boolean status = false;
		try {
			status = webObj.isEnabled();
			logger.log(Status.INFO, "Element is enabled");
		} catch (ElementNotInteractableException e) {
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			webWait.until(ExpectedConditions.visibilityOf(webObj));
		} catch (StaleElementReferenceException e) {

			status = webObj.isEnabled();
			logger.log(Status.INFO, "Element is enabled");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Element is not enabled");
			throw e;

		}
		return status;

	}

	// isSelected \\
	/**
	 * The isSelected() method is commonly used with radio buttons, checkboxes, and
	 * options in a select dropdown.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns boolean i.e true or false
	 * 
	 */
	public boolean checkSelected(WebElement webObj) {

		// The isSelected() method is commonly used with radio buttons, checkboxes,
		// and options in a select dropdown.

		boolean status = false;
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and enabked");

			try {
				status = webObj.isSelected();
				logger.log(Status.INFO,
						"textBox or radio button or option in select dropDown is selected successfilly");
			} catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code and check if the element is
				// selected
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				status = (boolean) jsExecutor.executeScript("return arguments[0].selected;", webObj);
				logger.log(Status.INFO,
						"textBox or radio button or option in select dropDown is selected successfilly");
				return status;
			} catch (StaleElementReferenceException e) {
				status = webObj.isSelected();
				logger.log(Status.INFO,
						"textBox or radio button or option in select dropDown is selected successfilly");

			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO,
						"textBox or radio button or option in select dropDown is not selected successfilly");

			}

		} else {
			logger.log(Status.INFO, "Element is  not displayed and enabked");

		}

		return status;
	}

	// selectByValueAttribute \\
	/**
	 * with the help of this method we can select the element by it's value
	 * attributes from drop down.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param value       it is used to select by value attribute
	 */
	public void selectByValueAttribute(WebElement webObj, String value) {

		Select slct = new Select(webObj);

		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is Displayed and enabled");
			try {
				slct.selectByValue(value);
				logger.log(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (ElementNotInteractableException eo) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='" + value + "'", webObj);
				logger.log(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (StaleElementReferenceException e) {

				slct.selectByValue(value);
				logger.log(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (NullPointerException e) {

				slct.selectByValue(value);
				logger.log(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "you haven't selected the element in dropDown by it's value :--" + value);
				throw e;

			}
		} else {
			logger.log(Status.INFO, "Element is not Displayed and enabled ");
		}
	}

	// selectByIndexNumber \\
	/**
	 * it is used to select that element with the help of it's index number from
	 * drop down the index number is starts 0 to number-1
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param indexNumber it refers to the index number of drop down
	 */
	public void selectByIndexNumber(WebElement webObj, int indexNumber) {

		Select slct = new Select(webObj);

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			logger.log(Status.INFO, "Element is Displayed and enabled");
			try {
				slct.selectByIndex(indexNumber);
				logger.log(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);
			} catch (StaleElementReferenceException e) {
				slct.selectByIndex(indexNumber);
				logger.log(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);

			} catch (NullPointerException e) {
				slct.selectByIndex(indexNumber);
				logger.log(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO,
						"you haven't selected the element in dropDown by it's index number :--" + indexNumber);
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is not Displayed and enabled ");
		}
	}

	// selectByVisibleString \\
	/**
	 * it is used to select that element with the help of inner text or that we are
	 * seeing the element in UI.
	 * 
	 * @param xpath         it is used to find element which we have to perform
	 *                      operation.
	 * 
	 * @param elementName   this shows in which element we are working and print a
	 *                      proper message in the console.
	 * 
	 * @param visibleString it refers to String as a text
	 */
	public void selectByVisibleString(WebElement webObj, String visibleString) {

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			Select slct = new Select(webObj);
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				slct.selectByVisibleText(visibleString);
				logger.log(Status.INFO,
						"you have selected the element in dropDown by it's visible String :--" + visibleString);
			} catch (StaleElementReferenceException e) {

				slct.selectByVisibleText(visibleString);
				logger.log(Status.INFO,
						"you have selected the element in dropDown by it's visible String :--" + visibleString);
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO,
						"you haven't selected the element in dropDown by it's visible String :--" + visibleString);
				throw e;
			}

		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");

		}
	}

	// getFirstSelectedElement \\
	/**
	 * this method is used to Fetch the element that is by defult selected in the
	 * dropDown with the help of getFirstSelectedElement method.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public String getFirstSelectedElement(WebElement webObj) {

		String elementName = webObj.getAccessibleName();

		Select slt = new Select(webObj);
		String firstSelected = null;
		try {
			firstSelected = slt.getFirstSelectedOption().getText();
			logger.log(Status.INFO, "Fetch the first selected element :- " + firstSelected + " of " + elementName
					+ " dropDown  successfully");
		} catch (StaleElementReferenceException e) {
			firstSelected = slt.getFirstSelectedOption().getText();
			logger.log(Status.INFO, "Fetch the first selected element :- " + firstSelected + " of " + elementName
					+ " dropDown  successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "arguments[0].selectedIndex = 0;";
			firstSelected = (String) jsExecutor.executeScript(script, webObj);
			logger.log(Status.INFO, "Fetch the first selected element :- " + firstSelected + " of " + elementName
					+ " dropDown  successfully");
			return firstSelected;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Didn't Fetch the first selected element :- " + firstSelected + " of "
					+ elementName + " dropDown successfully");
		}
		return firstSelected;
	}

	// getAllElements \\
	/**
	 * this method is used to Fetch all the webElements from the dropDown with the
	 * help of getAllElements method.
	 * 
	 * @param xpath       it is used to find multiple elements which we have to
	 *                    perform operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public List<WebElement> getAllElements(WebElement webObj) {

		Select slctObj = new Select(webObj);
		List<WebElement> lstElements = null;
		try {
			lstElements = slctObj.getOptions();
			logger.log(Status.INFO, "Fetched all the elements from the dropDown successfully ");
		} catch (StaleElementReferenceException e) {

			lstElements = slctObj.getOptions();
			logger.log(Status.INFO, "Fetched all the elements from the dropDown successfully ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Didn't Fetch all the elements from the dropDown successfully ");
		}
		return lstElements;
	}

	// selectedByTextContains \\
	/**
	 * it is used to select the element with the help of contains text in drop down.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param selectText  it refers to the string as a text that shows which text we
	 *                    have to selected in drop down.....
	 */
	public void selectedByTextContains(WebElement webObj, String selectText) {

		int indexNumber = 0;
		Select slct = new Select(webObj);
		try {
			List<WebElement> webListOptions = slct.getOptions();
			logger.log(Status.INFO, "All the WebElement of dropDown is fetched");
			for (int i = 0; i < webListOptions.size(); i++) {
				String optionText = webListOptions.get(i).getText();
				boolean status = optionText.contains(selectText);
				if (status == true) {
					indexNumber = i;
					break;
				}
			}
			slct.selectByIndex(indexNumber);
			logger.log(Status.INFO, "select text " + selectText + "  is selected from dropDown successfully");
		} catch (StaleElementReferenceException e) {

			List<WebElement> webListOptions = slct.getOptions();
			logger.log(Status.INFO, "All the WebElement of dropDown is fetched");
			for (int i = 0; i < webListOptions.size(); i++) {
				String optionText = webListOptions.get(i).getText();

				boolean status = optionText.contains(selectText);
				if (status == true) {
					indexNumber = i;
					break;
				}
				slct.selectByIndex(indexNumber);
				logger.log(Status.INFO, "select text " + selectText + "  is selected from dropDown successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "select text " + selectText + "  is not selected from dropDown successfully");

		}
	}

	// getOptionsCount \\

	/**
	 * it is used to get the total number of element in drop down.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns int i.e count of option in dropDown
	 */
	public int getOptionsCount(WebElement webObj) {

		Select slt = new Select(webObj);
		int optionCount = 0;
		try {
			optionCount = slt.getOptions().size();
			logger.log(Status.INFO, "Fetch the total element of the dropDown is " + optionCount);
		} catch (StaleElementReferenceException e) {

			optionCount = slt.getOptions().size();
			logger.log(Status.INFO, "Fetch the total element of the dropDown is " + optionCount);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.INFO, "Fetch the total element of the dropDown is " + optionCount);
		}
		return optionCount;
	}

	// mouseClick \\
	/**
	 * this method is used to click action on the webElement with the help of
	 * mouseClick method using Actions class.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void mouseClick(WebElement webObj) {

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			logger.log(Status.INFO, "Element is displayed and enabled");
			Actions act = new Actions(driver);
			try {
				act.click(webObj).build().perform();
				logger.log(Status.INFO, "Click action is done successfully by Actions method");
			} catch (StaleElementReferenceException e) {

				act.click(webObj).build().perform();
				logger.log(Status.INFO, "Click action is done successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click()", webObj);
				logger.log(Status.INFO, "Click action is done successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Click Action is not done successfully by Actions method");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is not displayed and enabled");

		}
	}

	// mouseRightClick \\
	/**
	 * this method is used to right click action on the webElement with the help of
	 * mouseRightClick method using Actions class.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void mouseRightClick(WebElement webObj) {

		Actions act = new Actions(driver);
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				act.contextClick(webObj).build().perform();
				logger.log(Status.INFO, "Right click is performed successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute the right-click event
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "var event = new MouseEvent('contextmenu', { 'bubbles': true, "
						+ "'cancelable': true });" + "arguments[0].dispatchEvent(event);";
				jsExecutor.executeScript(script, webObj);
				logger.log(Status.INFO, "Right click is  performed successfully by Actions method");

			} catch (StaleElementReferenceException e) {

				act.contextClick(webObj).build().perform();
				logger.log(Status.INFO, "Right click is performed successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Right click is not performed successfully by Actions method");
				throw e;
			}

		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");

		}
	}

	// mouseDoubleClick \\
	/**
	 * this method is used to perform double click action on the webElement with the
	 * help of mouseDoubleClick method using Actions class.
	 * 
	 * @param xpath       with the help of xpath we find the element by
	 *                    myFindElement method.
	 * 
	 * @param elementName this is the element name where we have to perform action
	 *                    on an element.
	 * 
	 */
	public void mouseDoubleClick(WebElement webObj) {

		Actions act = new Actions(driver);
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				act.doubleClick(webObj).build().perform();
				logger.log(Status.INFO, "Double click is performed successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript(
						"arguments[0].dispatchEvent(new MouseEvent('dblclick'," + " { bubbles: true }));", webObj);
				logger.log(Status.INFO, "Double click is performed successfully by Actions method");
			} catch (StaleElementReferenceException e) {
				act.doubleClick(webObj).build().perform();
				logger.log(Status.INFO, "Double click is performed successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Double click is not performed successfully by Actions method");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");

		}
	}

	// mouseSendKeys \\
	/**
	 * this method is used to send any input value in textbox or any input field
	 * with the help of mouseSendKeys method using Actions class.
	 * 
	 * @param xpath       with the help of xpath we find the element by
	 *                    myFindElement method.
	 * 
	 * @param elementName this is the element name where we have to send input
	 *                    value.
	 * 
	 * @param inputValue  here we have to send input value
	 * 
	 */
	public void mouseSendKeys(WebElement webObj, String inputValue) {

		Actions act = new Actions(driver);
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				webObj.clear();
				act.sendKeys(webObj, inputValue).build().perform();
				logger.log(Status.INFO, "SendKeys is performed successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].value='" + inputValue + "'", webObj);
				logger.log(Status.INFO, "SendKeys is performed successfully by Actions method");
			} catch (StaleElementReferenceException e) {

				act.sendKeys(webObj, inputValue).build().perform();
				logger.log(Status.INFO, "SendKeys is performed successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "SendKeys is not performed successfully by Actions method");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");
		}
	}

	// scrollingToElement \\
	/**
	 * this method is used to scroll to any particular element.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void scrollingToElement(WebElement webObj) {

		Actions act = new Actions(driver);
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				act.scrollToElement(webObj).build().perform();
				logger.log(Status.INFO, "scrolling to the element is performed successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", webObj);
				logger.log(Status.INFO, "scrolling to the element is performed successfully by Actions method");
			} catch (StaleElementReferenceException e) {
				act.scrollToElement(webObj).build().perform();
				logger.log(Status.INFO, "scrolling to the element is performed successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "scrolling to the element is not performed successfully by Actions method");
				throw e;
			}
		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");
		}
	}

	// mouseDragDrop \\
	/**
	 * this method is especially designed to drag and drop operation from one
	 * webElement to another webElement
	 * 
	 * @param dragXpath       this is the source element xpath which we have to drag
	 * @param dragElementName this is the drag element name which is draged
	 * 
	 * @param dropXpath       this is the target element xpath which we have to drop
	 * 
	 * @param dropElementName this is the drop element name where we have to drop.
	 */
	public void mouseDragDrop(WebElement dragWeb, WebElement dropWeb) {
		String dragElementName = dragWeb.getAccessibleName();
		String dropElementName = dropWeb.getAccessibleName();
		Actions ac = new Actions(driver);
		if (dragWeb.isDisplayed() && dropWeb.isEnabled() && dropWeb.isDisplayed() && dropWeb.isEnabled()) {
			logger.log(Status.INFO,
					"Both element " + dragElementName + " and " + dropElementName + "is disable and enable");
			try {
				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				logger.log(Status.INFO, "Drag operation " + dragElementName + " is  droped to the " + dropElementName
						+ " successfully");
			} catch (StaleElementReferenceException e) {

				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				logger.log(Status.INFO, "Drag operation " + dragElementName + " is  droped to the " + dropElementName
						+ " successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Drag operation " + dragElementName + " is not droped to the "
						+ dropElementName + " successfully");
				throw e;
			}

		} else {
			logger.log(Status.INFO,
					"Both element " + dragElementName + " and " + dropElementName + "is not disable and enable");
		}
	}

	// mouseClickAndHold \\
	/**
	 * this method is used to click and hold of that element with the help of mouse
	 * it means that pressing the left button on an element without releasing
	 * it.This method is often used in combination with other Actions methods to
	 * perform complex interactions like drag-and-drop.
	 * 
	 * @param xpath       it is used to find the element with the help of
	 *                    myFindElement method.
	 * 
	 * @param elementName it is used in which element we are working and print a
	 *                    proper message to include this.
	 */
	public void mouseClickAndHold(WebElement webClickHold) {

		Actions ac = new Actions(driver);
		if (webClickHold.isDisplayed() && webClickHold.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				ac.clickAndHold(webClickHold).build().perform();
				logger.log(Status.INFO, "Element is clicked and hold on successfully");
			} catch (StaleElementReferenceException e) {
				ac.clickAndHold(webClickHold).build().perform();
				logger.log(Status.INFO, "Element is clicked and hold on successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Element is not clicked and hold on successfully");
			}

		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");
		}

	}

	// mouseReleaseElement \\
	/**
	 * it is used to release mouse button after performing mouse related action. the
	 * release() method should be called after performing mouse action just like
	 * clickAndHold,click and moveToElement.
	 * 
	 * @param xpath       with the help of xpath we can easily find the element via
	 *                    myFindElement method if xpath is wrong then it throws
	 *                    NoSuchElementException and in case of syntax of xpath is
	 *                    wrong then it throws InvalidSelectorException.
	 * 
	 * @param elementName we need to element name to write a sitable message In case
	 *                    of fail and pass conditions .
	 */
	public void releaseToElement(WebElement webRelease) {

		Actions ac = new Actions(driver);
		if (webRelease.isDisplayed() && webRelease.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				ac.release(webRelease).build().perform();
				logger.log(Status.INFO, "Element is released successfully");
			} catch (StaleElementReferenceException e) {
				ac.release(webRelease).build().perform();
				logger.log(Status.INFO, "Element is released successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Element is not released successfully");
			}

		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");
		}

	}

	// mouseMoveToElement \\
	/**
	 * with the help of mouseMoveToElement method we can mouse hover of any element
	 * it means that we can move to the mouse in any given element
	 * 
	 * @param xpath       we pass xpath to the findElement method to find the
	 *                    element.
	 * @param elementName we needs to give the name of any element to print a
	 *                    suitable message .
	 */
	public void mouseToElement(WebElement webMoveToElement) {
		Actions ac = new Actions(driver);
		if (webMoveToElement.isDisplayed() && webMoveToElement.isEnabled()) {
			logger.log(Status.INFO, "Element is displayed and Enabled");
			try {
				ac.moveToElement(webMoveToElement).build().perform();
				logger.log(Status.INFO, "Move to Element is performed successfully");

			} catch (StaleElementReferenceException e) {

				ac.release(webMoveToElement).build().perform();
				logger.log(Status.INFO, "Move to Element is performed successfully");
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.INFO, "Move to Element is not performed successfully");
			}

		} else {
			logger.log(Status.INFO, "Element is not displayed and Enabled");
		}

	}

	public String getRandomName(int i) {
		RandomString rs = new RandomString();
		String str = rs.nextString();
		return str;
	}

}
