package predefine.methods;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class VtigerLoginPage {

	public WebDriver driver;

	public VtigerLoginPage() {
		
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}

	public WebDriver hitUrl(String url) {
		driver.get(url);
		return driver;
	}
	
	public WebDriver loginVtiger() {
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");;
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		return driver;
	}

	public void sizeOfUserName() {
		Dimension size=driver.findElement(By.name("user_name")).getSize();
		int width=size.getWidth();
		int higth=size.getHeight();
		System.out.println("UserName Size = "+width+" "+higth);
	}

	public void sizeOfPassword() {
		Dimension size=driver.findElement(By.name("user_password")).getSize();
		int width=size.getWidth();
		int higth=size.getHeight();
		System.out.println("Password Size = "+width+" "+higth);
	}

	public void sizeOfColorTheam() {
		Dimension size=driver.findElement(By.name("login_theme")).getSize();
		int width=size.getWidth();
		int higth=size.getHeight();
		System.out.println("ColorTheam Size = "+width+" "+higth);
	}

	public void sizeOfLanguage() {
		Dimension size=driver.findElement(By.name("login_language")).getSize();
		int width=size.getWidth();
		int higth=size.getHeight();
		System.out.println("Language Size = "+width+" "+higth);
	}

	public void sizeOfLoginButton() {
		Dimension size=driver.findElement(By.name("Login")).getSize();
		int width=size.getWidth();
		int higth=size.getHeight();
		System.out.println("LoginButton Size = "+width+" "+higth);
	}


	public void locationOfUserName() {
		Point location=driver.findElement(By.name("user_name")).getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println("UserName Location = "+x+" "+y);
	}

	public void locationOfPassword() {
		Point location=driver.findElement(By.name("user_password")).getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println("Password Location = "+x+" "+y);
	}

	public void locationOfColorTheam() {
		Point location=driver.findElement(By.name("login_theme")).getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println("ColorTheam Location = "+x+" "+y);
	}

	public void locationOfLanguage() {
		Point location=driver.findElement(By.name("login_language")).getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println("Language Location = "+x+" "+y);
	}

	public void locationOfLoginButton() {
		Point location=driver.findElement(By.name("Login")).getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println("LoginButton Location = "+x+" "+y);
	}

	public void displayedOfUserName() {
		boolean visiable=driver.findElement(By.name("user_name")).isDisplayed();
		if(visiable==true) {
			System.out.println("UserName Is Visiable");
		}else {
			System.out.println("UserName Is Disable");
		}
	}

	public void displayedOfPassword() {
		boolean visiable=driver.findElement(By.name("user_password")).isDisplayed();
		if(visiable==true) {
			System.out.println("Password Is Visiable");
		}else {
			System.out.println("Password Is Disable");
		}
	}

	public void displayedOfColorTheam() {
		boolean visiable=driver.findElement(By.name("login_theme")).isDisplayed();
		if(visiable==true) {
			System.out.println("ColorTheam Is Visiable");
		}else {
			System.out.println("ColorTheam Is Disable");
		}
	}

	public void displayedOfLanguage() {
		boolean visiable=driver.findElement(By.name("login_language")).isDisplayed();
		if(visiable==true) {
			System.out.println("Language Is Visiable");
		}else {
			System.out.println("Language Is Disable");
		}
	}

	public void displayedOfLoginButton() {
		boolean visiable=driver.findElement(By.name("Login")).isDisplayed();
		if(visiable==true) {
			System.out.println("LoginButton Is Visiable");
		}else {
			System.out.println("LoginButton Is Disable");
		}
	}

	public void enableOfLoginButton() {
		boolean enable=driver.findElement(By.name("Login")).isEnabled();
		if(enable==true) {
			System.out.println("LoginButton Is Clikable");
		}else {
			System.out.println("LoginButton Is Not Clikable");
		}
	}

	public  void valueTextOfUserName(String value) {
		String valueText=driver.findElement(By.name("user_name")).getAttribute("value");
		if(valueText.equals(value)) {
			System.out.println("Same As UserName ValueText");
		}else {
			System.out.println("Same As Not UserName ValueText");		}
	}

	public  void valueTextOfPassword(String value) {
		String valueText=driver.findElement(By.name("user_password")).getAttribute("value");
		if(valueText.equals(value)) {
			System.out.println("Same As Password ValueText");
		}else {
			System.out.println("Same As Not Password ValueText");		}
	}

	public void defaultValueOfColorTheam() {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		String defaultValue=obj.getFirstSelectedOption().getText();
		System.out.println("ColorTheam Default Value = "+defaultValue);
	}

	public void defaultValueOfLanguage() {
		WebElement we=driver.findElement(By.name("login_language"));
		Select obj=new Select(we);
		String defaultValue=obj.getFirstSelectedOption().getText();
		System.out.println("Language Default Value = "+defaultValue);
	}

	public void typeOfColorTheam() {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		boolean type=obj.isMultiple();
		if(type==false) {
			System.out.println("ColorTheam is Single Selection");
		}else {
			System.out.println("ColorTheam is Multiple Selection");
		}
	}

	public void typeOfLanguage() {
		WebElement we=driver.findElement(By.name("login_language"));
		Select obj=new Select(we);
		boolean type=obj.isMultiple();
		if(type==false) {
			System.out.println("Language is Single Selection");
		}else {
			System.out.println("Language is Multiple Selection");
		}
	}

	public void countOptionsOfLanguage() {
		WebElement we=driver.findElement(By.name("login_language"));
		Select obj=new Select(we);
		List<WebElement> countOptions=obj.getOptions();
		System.out.println("Count Options Of Language "+countOptions.size());
	}

	public void optionsTextOfLanguage() {
		WebElement we=driver.findElement(By.name("login_language"));
		Select obj=new Select(we);
		WebElement optionsText=obj.getWrappedElement();
		System.out.println(optionsText.getText());
	}

	public void countOptionsOfColorTheam() {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		List<WebElement> countOptions=obj.getOptions();
		System.out.println("Count Options Of ColorTheam "+countOptions.size());
	}

	public void optionsTextOfColorTheam() {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		WebElement optionsText=obj.getWrappedElement();
		System.out.println(optionsText.getText());
	}

	public void selectValueOfColorTheam(String options) {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		obj.selectByVisibleText(options);
		obj.deselectByValue(options);
	}

	public void selectValueOfColorTheam(int options) {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		obj.selectByIndex(options);
	}

	public void selectValueOfPassword(String options) {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		obj.selectByVisibleText(options);
		obj.deselectByValue(options);
	}

	public void selectValueOfPassword(int options) {
		WebElement we=driver.findElement(By.name("login_theme"));
		Select obj=new Select(we);
		obj.selectByIndex(options);
	}

	public void logOutVtiger() {
		driver.findElement(By.linkText("Sign Out")).click();

	}

	public WebDriver reLoginVtiger() {
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		return driver;
	}


	public void getValueFromUserBox(String expected_value, String value) {

		WebElement getValue=driver.findElement(By.name("user_name"));
		String actual_value=getValue.getAttribute(value);
		if(expected_value.equalsIgnoreCase(actual_value)) {
			System.out.println("Same As UserBox Value = "+actual_value);
		}else {
			System.out.println("Different As UserBox Value  = "+actual_value);
		}
	}

	public void getValueFromPasswordBox(String expected_value, String value) {

		WebElement getValue=driver.findElement(By.name("user_password"));
		String actual_value=getValue.getAttribute(value);
		if(expected_value.equalsIgnoreCase(actual_value)) {
			System.out.println("Same As PasswordBox Value = "+actual_value);
		}else {
			System.out.println("Different As PasswordBox Value  = "+actual_value);
		}
	}
	public void colorOfUserBox(String input) {
		WebElement getColor=driver.findElement(By.name("user_name"));
		String ColorOfuserbox=getColor.getCssValue(input);
		System.out.println("Color Of UserBox = "+ColorOfuserbox);
	}

	public void colorOfPasswordBox(String input) {
		WebElement getColor=driver.findElement(By.name("user_password"));
		String ColorOfuserbox=getColor.getCssValue(input);
		System.out.println("Color Of PasswordBox = "+ColorOfuserbox);
	}


	public void closeBrowser() {
		driver.close();
	}

}
