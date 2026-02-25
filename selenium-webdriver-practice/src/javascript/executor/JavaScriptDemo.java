package javascript.executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptDemo {

	WebDriver driver;

	JavaScriptDemo() {

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);

	}

	public static void main(String[] args) {

		JavaScriptDemo obj=new JavaScriptDemo();
		obj.loginByJavaScript();


	}


	public void loginByJavaScript() {

		driver.get("http://localhost:8888");

		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='admin'",driver.findElement(By.name("user_name")));
		jse.executeScript("arguments[0].value='admin'",driver.findElement(By.name("user_password")));
		jse.executeScript("arguments[0].click()",driver.findElement(By.name("Login")));


		innerTextByJavascript(driver.findElement(By.className("moduleName")));
		returnTitleByJavaScript();
		scrollByJavascript(0,500);
		generatePopByJavascript();

	}

	public void returnTitleByJavaScript() {

		JavascriptExecutor jse=(JavascriptExecutor) driver;
		System.out.println(jse.executeScript("return document.title").toString());

	}

	public void innerTextByJavascript(WebElement we) {

		JavascriptExecutor jse=(JavascriptExecutor) driver;
//		jse.executeScript("return arguments[0].value",driver.findElement(By.className("moduleName")));
		String innerText= (String) jse.executeScript("return arguments[0].value", we);
		System. out. println(innerText);	

	}


	public void scrollByJavascript(int x , int y) {

		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");

	}

	public void generatePopByJavascript() {

		// Generate Alert Pop Window
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("alert('Home Page Alert')"); 

		try {
			driver.findElement(By.linkText("Marketing")).click();
		}
		catch(UnhandledAlertException e) {
			System.out.println(e);
		}
	}



	// Asynchronous javascript code
	//	jse.executeAsyncScript("window.setTimeout(function(){alert('Hello');},4000);alert('Java')");



}
