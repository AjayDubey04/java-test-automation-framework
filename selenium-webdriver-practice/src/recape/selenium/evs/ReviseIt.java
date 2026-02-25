package recape.selenium.evs;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ReviseIt {


	private static WebDriver driver;
	private WebElement we;

	public static void main(String[] args) throws InterruptedException {

		// Set the path to the ChromeDriver executable
		System.setProperty(".Driver.Webdriver.Chrome", "Chromedriver.exe");
		// Create an instance of the WebDriver (Chrome)
		driver=new ChromeDriver();
		// Navigate to a web page
		driver.get("http://localhost:8888");

		driver.switchTo().activeElement().sendKeys("admin",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("admin",Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
		Thread.sleep(4000);
		System.out.println(driver.switchTo().activeElement().getText());


	}


	public void WebDriverMethods() {	

		//   Initializes a new instance of the ChromeDriver to control a Chrome web browser.
		driver=new ChromeDriver();

		//	 Navigates the browser to the specified URL.
		driver.get("http://localhost:8888");

		//	Returns the  URL of the current web page.
		driver.getCurrentUrl();

		//	Returns the title of the current web page.
		driver.getTitle();

		//	Returns the source code of the current web page.
		driver.getPageSource();

		//	Returns a unique identifier for the currently focused browser window or tab.
		driver.getWindowHandle();

		//	Returns a set of unique identifiers for all open browser windows or tabs.
		driver.getWindowHandles();

		//  Closes the current browser window or tab.
		driver.close();

		//  Closes all browser windows or tabs and ends the WebDriver session.
		driver.quit();

		//	 Returns an instance of Options, which allows you to manage various browser settings and behaviors.
		Options options=driver.manage();
		//		Adds a cookie to the current session. You should pass a Cookie object as an argument.
		options.addCookie(null); 
		//		Retrieves all cookies associated with the current session and returns them as a set of Cookie objects.
		Set<Cookie> c=options.getCookies();
		//		Retrieves a specific cookie by its name.
		options.getCookieNamed("cookie Name");
		//		Deletes all cookies from the current session.
		options.deleteAllCookies();
		//		Deletes a specific cookie by passing a Cookie object as an argument.
		options.deleteCookie(null); 
		//		Deletes a specific cookie by its name.
		options.deleteCookieNamed("cookie name");


		//		Returns an instance of Timeouts, which is used to set various timeout intervals.
		Timeouts timeOuts=options.timeouts();

		//		Duration object specifying the duration of the implicit wait timeout.
		//		 Sets the implicit wait timeout, which tells WebDriver to wait for up to 60 
		timeOuts.implicitlyWait(Duration.ofSeconds(60)); // returns Timeoutes 

		//		60: An integer representing the duration of the implicit wait timeout.
		//		TimeUnit.SECONDS: The time unit for the duration.
		timeOuts.implicitlyWait(60, TimeUnit.SECONDS); // returns Timeoutes 


		//		Returns an instance of Window, which allows you to manage browser window properties.
		Window window=options.window();

		//		Maximizes the current browser window.
		window.maximize();
		//		Minimizes the current browser window.
		window.minimize();
		//		Returns the position of the current browser window as a Point object.
		window.getPosition();
		//		Makes the current browser window fullscreen.
		window.fullscreen();
		//		Returns the size of the current browser window as a Dimension object.
		window.getSize();


		//		Returns an instance of Navigation, which allows you to navigate back, forward, refresh, and to specific URLs.
		Navigation navigation=driver.navigate();

		//		Navigates the browser back one page in the browsing history.
		navigation.back();
		//		Navigates the browser forward one page in the browsing history.
		navigation.forward();
		//		This method refreshes the current page.
		navigation.refresh();
		//		This method navigates to the specified URL. 
		navigation.to("url");


		//		In Selenium WebDriver, TargetLocator is an interface that provides methods for switching the focus of the WebDriver between different browsing iframe window
		//		 Returns an instance of TargetLocator, which allows you to switch between different browsing contexts like frames, windows, and alerts.
		TargetLocator targetLocator=driver.switchTo();

		//		This method allows you to switch to an iframe based on its index, which is a 0-based integer. 
		//		For example, driver.switchTo().frame(0) will switch to the first iframe on the page.
		targetLocator.frame(0);
		//		Use this method to switch to an iframe based on its name or ID attribute. 
		//		For instance, driver.switchTo().frame("frameName") will switch to the iframe with the name "frameName."
		targetLocator.frame("nameOrId");

		//		 You can switch to an iframe by passing a reference to the iframe's WebElement obtained via driver.findElement().
		//		For example, driver.switchTo().frame(iframeElement) will switch to the iframe represented by iframeElement.
		targetLocator.frame("");
		//		Switches back to the default content, 
		targetLocator.defaultContent();
		//		Switches to the parent frame if the currently focused is inside a nested frame on web page.
		targetLocator.parentFrame();
		//		Opens a new browser window and switches to it for working with multiple browser windows or tabs. 
		targetLocator.newWindow(WindowType.WINDOW);
		//		 Returns the currently focused element on the page.
		targetLocator.activeElement();
		//		Switches to a window or tab with the specified window handle.
		targetLocator.window("String type window Handle Value");


		//      the switchTo().alert() method is used to switch the focus of the WebDriver to a JavaScript alert, confirm, or prompt dialog that might appear in a web application.
		//		These dialogs are often used to display important messages, ask for user confirmation, or collect input from the user.
		//		Selenium provides the Alert interface to interact with these types of JavaScript pop-up dialogs. 
		Alert javaScriptAlert=targetLocator.alert();

		//		Accept the alert (click "OK" or "Yes" to confirm).
		javaScriptAlert.accept();
		//		 Dismiss the alert (click "Cancel" or "No" to cancel).
		javaScriptAlert.dismiss();
		//		Retrieve the text displayed in the alert.
		javaScriptAlert.getText();
		//		Enter text into the input field of a prompt alert.
		javaScriptAlert.sendKeys("Hello JavaScript Alert");


	}

	public void webElementMethods() {

		// Clears the text or input value from a text field or input element.
		we.clear();
		// click on the web element, such as a button or a link.
		we.click();
		// Finds and returns the first web element matching the specified locator strategy.
		we.findElement(By.id(null));
		//  Finds and returns a list of web elements matching the specified locator strategy.
		we.findElements(By.xpath(null));
		// Retrieves the accessible name attribute of the web element, often used for web accessibility.
		we.getAccessibleName();
		// Retrieves the ARIA role attribute of the web element, used for web accessibility.
		we.getAriaRole();
		// Retrieves the value of the specified attribute of the web element.
		we.getAttribute("Attribute value name");
		// Retrieves the value of the specified CSS property of the web element.
		we.getCssValue("property name");
		// Retrieves the value of the specified DOM attribute of the web element.
		we.getDomAttribute("dom Attribute name");
		//  Retrieves the value of the specified DOM property of the web element.
		we.getDomProperty("dom Property name");

		// Retrieves the location of the top-left corner of the web element on the page.
		Point loc=we.getLocation();
		// You can then use loc.getX() and loc.getY() to get the X and Y coordinates, respectively.
		loc.getX();
		loc.getY();

		// Retrieves the dimensions and location of the web element as a Rect object.
		we.getRect();
		// Captures a screenshot of the web element and returns it as a File object.
		we.getScreenshotAs(OutputType.FILE);
		// Returns the shadow root element of a web component, if applicable.
		we.getShadowRoot();

		// Retrieves the dimensions (width and height) of the web element
		Dimension dme=we.getSize();
		// You can  use dme.getHeight() and dme.getWidth() to get the height and width, respectively.
		dme.getHeight();
		dme.getWidth();

		// Retrieves the HTML tag name of the web element.
		we.getTagName();
		//  Retrieves the visible text of the web element.
		we.getText();
		// Checks if the web element is displayed on the page (visible to the user).
		we.isDisplayed();
		//  Checks if the web element is enabled (i.e., can be interacted with).
		we.isEnabled();
		// Checks if the web element is selected (e.g., for checkboxes or radio buttons).
		we.isSelected();
		// Enters text or sends keyboard keys to an input element.
		we.sendKeys("admin");
		// Submits a form (if the web element represents a form element like a submit button).
		we.submit();

	}



	public void selectClassMethods() {

		Select sl=new Select(we);
		// Deselects all options within a multi-select dropdown.
		sl.deselectAll();
		// Deselects the option at the specified index within a multi-select dropdown.
		sl.deselectByIndex(0);
		// Deselects the option with the specified value attribute within a multi-select dropdown.
		sl.deselectByValue(null);
		// Deselects the option with the specified visible text within a multi-select dropdown.
		sl.deselectByVisibleText(null);
		// Retrieves all currently selected options within a multi-select dropdown as a list 
		sl.getAllSelectedOptions();
		//  Retrieves all available options within the dropdown as a list of WebElement objects.
		sl.getOptions();
		//  Retrieves the first selected option within a multi-select dropdown as a 
		sl.getFirstSelectedOption();
		//  Returns the WebElement that is being wrapped by the Select instance.
		sl.getWrappedElement();
		// Checks if the dropdown allows multiple selections (returns true for multi-select dropdowns and false for single-select dropdowns).
		sl.isMultiple();
		// Selects the option at the specified index within the dropdown.
		sl.selectByIndex(0);
		//  Selects the option with the specified value attribute within the dropdown.
		sl.selectByValue(null);
		// Selects the option with the specified visible text within the dropdown.
		sl.selectByVisibleText(null);



	}


	public void ActionsClassMethods() {

		Actions  act=new Actions(driver);
		// Constructs a composite action by combining individual actions methods.
		act.build();
		// Performs a click operation on the specified WebElement.
		act.click(we);
		// Clicks and holds the mouse button on the specified WebElement.
		act.clickAndHold(we);
		// Performs a context click (right-click) on the specified WebElement.
		act.contextClick(we);
		// Performs a double-click on the specified WebElement.
		act.doubleClick(we);
		// Drags an element from the source and drops it onto the target element.
		act.dragAndDrop(we, we);
		// Drags an element by an offset and drops it at the new location.
		act.dragAndDropBy(we, 0, 0);
		// Retrieves the active keyboard interface for sending keyboard input.
		act.getActiveKeyboard();
		// Retrieves the active mouse pointer interface for performing mouse-related actions.
		act.getActivePointer();
		// Retrieves the active mouse wheel interface for performing mouse wheel-related actions.
		act.getActiveWheel();
		// Presses and holds the specified keyboard key while interacting with the WebElement.
		act.keyDown(we, null);
		//  Releases the specified keyboard key while interacting with the WebElement.		
		act.keyUp(we, null);
		// Moves the mouse pointer by the specified offsets from its current position.
		act.moveByOffset(0, 0);
		// Moves the mouse pointer to the center of the specified WebElement.
		act.moveToElement(we);
		//  Moves the mouse pointer to the specified WebElement with the given offsets.
		act.moveToElement(we, 0, 0);
		// Introduces a pause in the action sequence for the specified duration.
		act.pause(null);
		// Executes the sequence of actions defined by the Actions object.
		act.perform();
		// Releases the mouse button previously clicked and held on the specified WebElement.
		act.release(we);
		// Scrolls the view by the specified horizontal and vertical amounts.
		act.scrollByAmount(0, 0);
		// Scrolls the view by the specified horizontal and vertical amounts from the origin.
		act.scrollFromOrigin(null, 0, 0);
		// Scrolls the view to bring the specified WebElement into the visible area.
		act.scrollToElement(we);
		// Sends a series of keyboard input to the specified WebElement.
		act.sendKeys(we, null);
		// Sets a custom keyboard interface for sending keyboard input.
		act.setActiveKeyboard(null);
		// Sets a custom mouse interface for performing mouse-related actions.
		act.setActivePointer(null, null);
		// Sets a custom mouse wheel interface for performing mouse wheel-related 
		act.setActiveWheel(null);
		// Sets a custom clock interface for timing actions.
		act.tick(null);



	}


	public void javascriptExecutoerInterfaceMethods() {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		// Executes JavaScript code asynchronously within the current browser window.
		//		This method is used for executing scripts that might take some time to complete, such as AJAX requests. 
		//		It returns the result of the JavaScript code execution.
		js.executeAsyncScript(null, null);
		// Retrieves a list of scripts that have been pinned (kept in memory) for execution on the current page.
		js.getPinnedScripts();
		// Pins a JavaScript script for later execution. Pinned scripts are stored in memory and can be executed using js.executeScript().
		js.pin(null);
		//  Unpins (removes from memory) a previously pinned JavaScript script.
		js.unpin(null);
		/*
		 * Executes JavaScript code synchronously within the current browser window.
		 * This method is used for performing various actions and operations on the web
		 * page by executing custom JavaScript code. It returns the result of the
		 * JavaScript code execution.
		 */
		js.executeScript("", null);
		/*
		 * script: The JavaScript code to execute asynchronously. 
		 * args: Optional arguments to pass to the JavaScript code.
		 */


	}

	public void takesScreenshotInterfaceMethods() {

		/*
		 * The TakesScreenshot interface in Selenium provides a way to capture
		 * screenshots of the current state of the WebDriver browser window. It has one
		 * method, getScreenshotAs(), which allows you to capture screenshots in
		 * different formats (e.g., as a File, byte[], or OutputType) depending on your
		 * needs. Here's an explanation of the method along with its return type and
		 * possible argument parameters:
		 */		
		TakesScreenshot ts=(TakesScreenshot)driver;
		// Captures a screenshot of the current state of the WebDriver browser window 
		// in the specified format and returns it as an object of the specified OutputType.
		// An OutputType specifying the desired format in which the screenshot should be captured.
		// X (Generic type)
		ts.getScreenshotAs(OutputType.FILE);

	}


	public void webDriverWaitClass() {

		/*
		 * The WebDriverWait class in Selenium is used for waiting for certain
		 * conditions to be met before proceeding with the automation script. It allows
		 * you to set a maximum time duration and a condition that needs to be satisfied
		 * within that duration. Here's an explanation of the code snippet you provided,
		 * including its components:
		 */		

		/*
		 * This line of code initializes a WebDriverWait instance named wt with a
		 * specified maximum wait time of 60 seconds. The WebDriverWait will use the
		 * provided driver to wait for conditions to be met.
		 */		
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(60));
		//  This line of code tells the WebDriverWait to wait until a specific condition is met. In this case, the condition is specified using the 
		wt.until(ExpectedConditions.alertIsPresent());


	}


	public void recapMethods() throws IOException, AWTException {
		
		
		WebDriver driver=null;
		WebElement we=null;
		Select sel=new Select(we);
		Actions act=new Actions(driver);
		
		// java script code 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", we);
		js.executeScript("arguments[0].value='admin'", we);
		js.executeScript("window.scrollBy(0,989)");
		js.executeScript("window.scrollTo(8798,0)");
		js.executeScript("arguments[0].scrollIntoView()",we);
		js.executeScript("location.reload()");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		// takes screen shot code 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tem=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("file//path");
		Files.copy(tem, des);
		
		// download file code 
		
		Map<String,Object> perfs=new HashMap<String,Object>();
		perfs.put("download.prompt_for_download", false);
		perfs.put("download.default_directory", "files//path");
		ChromeOptions cp=new ChromeOptions();
		cp.setExperimentalOption("perfs", perfs);
		new ChromeDriver(cp);
		
		// by Robot class 
		StringSelection ss=new StringSelection("file//path");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot rt=new Robot();
		rt.delay(5000);
		
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
	}

}
