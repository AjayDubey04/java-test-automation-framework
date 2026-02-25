package evs.work;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.interactions.Actions;

public class ITBK_LoginTestCase {


	public WebDriver driver;

	ITBK_LoginTestCase() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.itbusinessbook.com/");

	}

	public static void main(String[] args) throws InterruptedException {

		ITBK_LoginTestCase itBk_obj=new ITBK_LoginTestCase();
		itBk_obj.ITBK_16();

	}


	public void ITBK_01() {

		WebElement 	signUp=driver.findElement(By.xpath("//div[@class='signin-pop']"));
		if(signUp.isDisplayed()==true) {
			System.out.println("User Is able to see all components on ITBusinessBook Login Page");
		}else {
			System.out.println("User Is unable to see all components on ITBusinessBook Login Page");
		}
	}


	public void ITBK_02() {

		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("OxyTech!2#");
		driver.findElement(By.id("ilogin")).click();

	}

	public void ITBK_03() throws InterruptedException {

		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@2secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("Oxy!332#");
		driver.findElement(By.id("ilogin")).click();	

		String expected_error="Hmm, we don't recognize that email. Please try again.";

		Thread.sleep(5000);
		String actual_error=driver.findElement(By.xpath("//span[@id='lemail_error_msg']")).getText();
		System.out.println(actual_error);
		if(expected_error.equals(actual_error)) {
			System.out.println("Same as Email Expected Error");

		}else {
			System.out.println("Different as Email Expected Error");
		}
	}


	public void ITBK_04() throws InterruptedException {

		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("Oxy!332#");
		Thread.sleep(3000);
		driver.findElement(By.id("ilogin")).click();	

		String expected_error="Hmm, that's not the right password. Please try again.";
		Thread.sleep(3000);
		String actual_error=driver.findElement(By.xpath("//span[@id='login_error_msg']")).getText();
		System.out.println(actual_error);
		if(expected_error.equals(actual_error)) {
			System.out.println("Same as Password Expected Error");

		}else {
			System.out.println("Different as Password Expected Error");
		}
	}


	public void ITBK_05() throws InterruptedException {

		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@2secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("OxyTech!2#");
		Thread.sleep(3000);
		driver.findElement(By.id("ilogin")).click();	

		String expected_error_email="Hmm, we don't recognize that email. Please try again.";
		String expected_error_password="Hmm, that's not the right password. Please try again.";

		Thread.sleep(3000);
		String actual_error_email=driver.findElement(By.xpath("//span[@id='lemail_error_msg']")).getText();
		if(expected_error_email.equals(actual_error_email)) {
			System.out.println("Same as Email Expected Error");

		}else {
			System.out.println("Different as Email Expected Error");
		}

		String actual_error_password=driver.findElement(By.xpath("//span[@id='login_error_msg']")).getText();
		if(expected_error_password.equals(actual_error_password)) {
			System.out.println("Same as Password Expected Error");

		}else {
			System.out.println("Different as Password Expected Error");
		}
	}


	public void ITBK_006() {

		driver.findElement(By.id("lemail")).sendKeys("");
		driver.findElement(By.id("lpassword")).sendKeys("");
		driver.findElement(By.id("ilogin")).click();	

	}



	public void ITBK_07() throws InterruptedException {

		driver.findElement(By.id("lemail")).sendKeys("");
		driver.findElement(By.id("lpassword")).sendKeys("OxyTech!2#");
		driver.findElement(By.id("ilogin")).click();	

		String expected_error_email="Hmm, we don't recognize that email. Please try again.";

		Thread.sleep(3000);
		String actual_error_email=driver.findElement(By.xpath("//span[@id='lemail_error_msg']")).getText();
		if(expected_error_email.equals(actual_error_email)) {
			System.out.println("Same as Email Expected Error");

		}else {
			System.out.println("Different as Email Expected Error");
		}
	}


	public void ITBK_08() throws InterruptedException {

		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("");
		driver.findElement(By.id("ilogin")).click();	

		String expected_error_password="Hmm, that's not the right password. Please try again.";

		Thread.sleep(3000);
		String actual_error_password=driver.findElement(By.xpath("//span[@id='login_error_msg']")).getText();
		if(expected_error_password.equals(actual_error_password)) {
			System.out.println("Same as Password Expected Error");

		}else {
			System.out.println("Different as Password Expected Error");
		}
	}


	public void ITBK_09() {

		driver.findElement(By.id("lpassword")).sendKeys("OxyTech!2#");

	}

	public void ITBK_10() {

		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		String  forget_page_title=driver.getTitle();
		System.out.println(forget_page_title);
		
		boolean userNameBox=driver.findElement(By.id("femail")).isDisplayed();
		boolean resetButton=driver.findElement(By.xpath("//button[text()='Reset Password']")).isDisplayed();
		if(userNameBox==true &&  resetButton==true) {
			System.out.println("userNameBox And ResetButton Is Visiable");
		}else {
			System.out.println("userNameBox And ResetButton Is Visiable");
		}

	}


	public void ITBK_11() {

		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		driver.findElement(By.id("femail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.xpath("//button[text()='Reset Password']")).click();

		String expected_msg="Password Sent Successfully on Your Registered Email";


	}
	
	
	public void ITBK_12(){
		
		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("New Password");
		driver.findElement(By.id("ilogin")).click();	
		
		String home_page_title=driver.getTitle();
		System.out.println(home_page_title);
	}
	
	
	public void ITBK_13() {
		
		driver.findElement(By.id("lemail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.id("lpassword")).sendKeys("Old Password");
		driver.findElement(By.id("ilogin")).click();	

		String expected_error="Hmm, that's not the right password. Please try again.";
		String actual_error=driver.findElement(By.xpath("//span[@id='login_error_msg']")).getText();
		System.out.println(actual_error);
		if(expected_error.equals(actual_error)) {
			System.out.println("Same as Password Expected Error");

		}else {
			System.out.println("Different as Password Expected Error");
		}
		
	}
	
	
	public void ITBK_14() {
		
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		driver.findElement(By.id("femail")).sendKeys("roshan.yadav@1secmail.com");
		driver.findElement(By.xpath("//button[text()='Reset Password']")).click();

		String expected_msg="Hi, Your New Password for Signing Up with ItBusinessBook is: 19439";
		
		
	}
	
	
	public void ITBK_15() {
		
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		String signUp_page_title=driver.getTitle();
		System.out.println(signUp_page_title);
		
		boolean signUp_paga_componenat=driver.findElement(By.xpath("//div[@id='tab-2']")).isDisplayed();
		if(signUp_paga_componenat==true) {
			System.out.println("all sign Up componenats are visiable");
		}else {
			System.out.println("all sign Up componenats are not visiable");
		}
	}
	
	public void ITBK_16() throws InterruptedException {
		
		driver.findElement(By.xpath("//li[@data-tab='tab-2']/child::a")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("EVS");
		driver.findElement(By.id("lastname")).sendKeys("Work");
		driver.findElement(By.id("email")).sendKeys("evsexpert@gmail.com");
		driver.findElement(By.id("password")).sendKeys("expert123");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']")));
		
		List<WebElement> we=driver.findElements(By.xpath("//div[@class='rc-image-tile-wrapper']"));
		for (WebElement web : we) {
			web.click();
		}
		
		if(driver.findElement(By.xpath("//button[@class='rc-button-default goog-inline-block']")).getText().equalsIgnoreCase("Skip")) {
			WebElement we_click=driver.findElement(By.xpath("//button[@class='rc-button-default goog-inline-block']"));
			we_click.click();
			Thread.sleep(3000);
			we_click.click();
		}
		
		driver.findElement(By.xpath("//button[@class='rc-button-default goog-inline-block']")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("c2")).click();
		driver.findElement(By.id("iregister")).click();
		
	
		
		
	}


}
