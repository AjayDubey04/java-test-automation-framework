package exception;

import java.util.concurrent.TimeUnit;
import java.lang.IllegalStateException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.ConnectionFailedException;


public class ExceptionHandlePractice {

	public static WebDriver driver;

	ExceptionHandlePractice() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins");
		
		try { 
			driver = new ChromeDriver(options);
			
		}  catch(IllegalStateException ill) {
			
				System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
				ChromeOptions options2= new ChromeOptions();
				options2.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options2);
			}
	

		try {
			driver.manage().timeouts().implicitlyWait(-1,TimeUnit.SECONDS);
			driver.get("facebook.com");
		}catch(InvalidArgumentException aie) {
			System.out.println(aie);
		}


	}


	public static void main(String[] args) throws InterruptedException {

		ExceptionHandlePractice obj=new ExceptionHandlePractice();
		obj.loginForExceptionHandle(); 
		obj.exceptionDemo();
		obj.exceptionDemo_1();
		
	}


	public void loginForExceptionHandle() {

		driver.get("http://localhost:8888");

		WebElement user_name=driver.findElement(By.name("user_name"));
		user_name.sendKeys("admin");
		driver.navigate().refresh();
		try {
			user_name.sendKeys("admin");
		}catch(StaleElementReferenceException sr) {
			user_name=driver.findElement(By.name("user_name"));
			user_name.sendKeys("admin");
		}
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();


	}

	public void exceptionDemo() throws InterruptedException {

		WebElement we=driver.findElement(By.linkText("Marketing"));
		we.click();
		Actions act=new Actions(driver);
		try {
			//			driver.findElement(By.linkText("HelloMarketing")).click();
			act.moveToElement(we).perform();
		}catch(StaleElementReferenceException st) {
			Thread.sleep(6000);
			we=driver.findElement(By.xpath("//a[text()='Marketing']"));
			act.moveToElement(we).perform();
			//			driver.findElement(By.linkText("Marketing")).click();
		}
		Thread.sleep(2000);
		//		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Marketing']"))).perform();

		try {
			driver.findElement(By.linkText("Contacts")).click();
		}catch(ElementClickInterceptedException ie) {
			System.out.println(ie);
			JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()", driver.findElement(By.linkText("Contacts")));

		}
	}

	public void exceptionDemo_1() {

		try {
			driver.findElement(By.xpath("//input[[name='selectall']")).click();
		}catch(InvalidSelectorException ie) {
			driver.findElement(By.xpath("//input[@name='selectall']")).click();
		}

		try {
			driver.switchTo().alert().accept();
		}catch(NoAlertPresentException na) {
			driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
			driver.switchTo().alert().dismiss();
		}


		//		unHandleAlertException
		//		JavaScriptException
		//		TimeException
		//		SessionNotCreatedException
		//		NoSuchSessionException
		//		WebDriverException
		//		FileNotFoundException
		//		NoSuchFrameException
		//		ElementNotIntractableException


	}

	public void exceptionDemo_2() {

		
		try {
			System.out.println("This Is a Try Block");
			System.out.println(10/0);
		}catch(Exception e) {
			System.out.println("This Is a Catch Block");
		}finally {
			System.out.println("This Is a Finally Block");
			System.out.println("it is always Executed");
		}

		
		




	}


}
