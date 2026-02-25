package window.handle;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;


public class GetWindowPractice extends GetWindowHandleMethods {

	private WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		GetWindowPractice obj=new GetWindowPractice();
		obj.getWindowHandles();
		obj. new_Window_Tab();

	}


	public void getWindowHandle() {

		driver=loginVtiger();
		mainWindowHandle(driver);

		driver.findElement(By.linkText("Help")).click();
		mainWindowHandle(driver);

		driver.get("http://flipkart.com"); 
		mainWindowHandle(driver);

	}

	public void getWindowHandles() {

		driver=loginVtiger();

		driver.findElement(By.linkText("About Us")).click();
		driver.findElement(By.linkText("Feedback")).click();
		driver.findElement(By.linkText("My Preferences")).click();
		driver.findElement(By.xpath("//input[@onclick='showAuditTrail();']")).click();

		getWindowSwitchByTitle(driver, "vtiger CRM 5 - Free, Commercial grade Open Source CRM");
		driver.findElement(By.name("close")).click(); 

		closeWindowByHandleValue(driver, "");
		System.out.println(driver.getCurrentUrl());


	}

	public void new_Window_Tab() throws InterruptedException {

		// launch the browser
		driver=loginVtiger(); 


		// it will load new page in browser
		driver.navigate().to("http://google.com");

		// it will open new window on browser
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://localhost:8888");

		// it will open new tab inside window
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://flipkart.com");


		// it will close all window and tab
		//		driver.quit();

		// it will close only focus window
		driver.close();
		driver.close();

	}


}
