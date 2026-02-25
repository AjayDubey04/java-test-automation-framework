package home.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginScenario {

	static {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
	}
	static ChromeDriver obj=new ChromeDriver();

	public static void main(String[] args) 
	{

		obj.get("http://localhost:8888");
		userName();
		System.out.println();
		password();
		System.out.println();
		colorTheam();
		System.out.println();
		language();
		System.out.println();
		login();
		System.out.println();
		homePage();
		
		
	}

	public static void userName() 
	{

		WebElement we=obj.findElement(By.xpath("//input[@name='user_name']"));
		boolean userbox=we.isDisplayed();
		if(userbox==true) {
			System.out.println("Userbox is visiable");
		}else {
			System.out.println("Userbox is invisiable");
		}

		String text=we.getText();
		System.out.println("Inner text of user box = "+text);
		we.sendKeys("admin");
		String value=we.getAttribute("value");
		System.out.println("Value = "+value);

		Dimension size=we.getSize();
		int a=size.getHeight();
		int b=size.getWidth();
		System.out.println("Size of Userbox = "+a+","+b);

		Point addresh=we.getLocation();
		int c=addresh.getX();
		int d=addresh.getY();
		System.out.println("Location of Userbox = "+c+","+d);

		String color=we.getCssValue("color");
		System.out.println("Colour of Userbox = "+color);
	}

	public static void password() 
	{
		WebElement we=obj.findElement(By.xpath("//input[@name='user_password']"));
		boolean pass=we.isDisplayed();
		if(pass==true) {
			System.out.println("password box is visiable");
		}else {
			System.out.println("password box is invisiable");
		}

		String text=we.getText();
		System.out.println("Inner text of password box = "+text);
		we.sendKeys("admin");
		String value=we.getAttribute("value");
		System.out.println("Value = "+value);

		Dimension size=we.getSize();
		int a=size.getHeight();
		int b=size.getWidth();
		System.out.println("Size of password box = "+a+","+b);

		Point addresh=we.getLocation();
		int c=addresh.getX();
		int d=addresh.getY();
		System.out.println("Location of password box = "+c+","+d);

		String color=we.getCssValue("color");
		System.out.println("Colour of password box = "+color);

	}
	public static void colorTheam() {

		WebElement we=obj.findElement(By.xpath("//select[@name='login_theme']"));
		Select test=new Select(we);
		boolean pass=we.isDisplayed();
		if(pass==true) {
			System.out.println("ColorTheam box is visiable");
		}else {
			System.out.println("ColorTheam box is invisiable");
		}

		boolean dropdown=test.isMultiple();
		if(dropdown==false) {
			System.out.println("ColorTheam is single selection dropdown "); 
		}else {
			System.out.println("ColorTheam is multi selection dropdown "); 
		}

		String expected="softed";
		WebElement bydefault=test.getFirstSelectedOption();
		String text=bydefault.getText();
		if(expected.equalsIgnoreCase(text)) {
			System.out.println("passed softed is first text");
		}else {
			System.out.println("failed softed is not first text");
		}

		Dimension size=we.getSize();
		int a=size.getHeight();
		int b=size.getWidth();
		System.out.println("Size of ColorTheam = "+a+","+b);

		Point addresh=we.getLocation();
		int c=addresh.getX();
		int d=addresh.getY();
		System.out.println("Location of ColorTheam = "+c+","+d);

		String color=we.getCssValue("color");
		System.out.println("Colour of ColorTheam = "+color);

//		test.selectByVisibleText("bluelagoon");
//        test.selectByValue("bluelagoon");
		
//		for(int i=0; i<=3; i++) {
//			
//		     test.selectByIndex(i);	
//		}
	}

	public static void language() {

		WebElement we=obj.findElement(By.xpath("//select[@name='login_language']"));
		Select test=new Select(we);
		boolean pass=we.isDisplayed();
		if(pass==true) {
			System.out.println("Language box is visiable");
		}else {
			System.out.println("Language box is invisiable");
		}




		boolean dropdown=test.isMultiple();
		if(dropdown==false) {
			System.out.println("Language is single selection dropdown "); 
		}else {
			System.out.println("Language is multi selection dropdown "); 
		}

		String expected="ES Spanish";
		WebElement bydefault=test.getFirstSelectedOption();
		String text=bydefault.getText();
		if(expected.equalsIgnoreCase(text)) {
			System.out.println("passed ES Spanish is first text");
		}else {
			System.out.println("failed ES Spanish is not first text");
		}

		Dimension size=we.getSize();
		int a=size.getHeight();
		int b=size.getWidth();
		System.out.println("Size of Language = "+a+","+b);

		Point addresh=we.getLocation();
		int c=addresh.getX();
		int d=addresh.getY();
		System.out.println("Location of ColorTheam = "+c+","+d);

		String color=we.getCssValue("color");
		System.out.println("Colour of Language = "+color);

		test.selectByVisibleText("ES Spanish");
		//     test.selectByValue("es_es");
		//     test.selectByIndex(5);
	}

	public static void login() {

		WebElement we=obj.findElement(By.xpath("//input[@name='Login']"));
		boolean userbox=we.isEnabled();
		if(userbox==true) {
			System.out.println("Login Button is Enalbed");
		}else {
			System.out.println("Login Button is disEnalbed");
		}

		String text=we.getText();
		System.out.println("Inner text of Login Button = "+text);
		we.sendKeys("admin");
		String value=we.getAttribute("value");
		System.out.println("Value = "+value);

		Dimension size=we.getSize();
		int a=size.getHeight();
		int b=size.getWidth();
		System.out.println("Size of Login Button = "+a+","+b);

		Point addresh=we.getLocation();
		int c=addresh.getX();
		int d=addresh.getY();
		System.out.println("Location of Login Button = "+c+","+d);

		String color=we.getCssValue("color");
		System.out.println("Colour of Login Button = "+color);

		we.click();	
	}

	public static void homePage() {

		String title=obj.getTitle();
		System.out.println("Title of Home Page = "+title);

		String url=obj.getCurrentUrl();
		System.out.println("Current URL of Home Page = "+url);
		
		String header=obj.findElement(By.xpath("//td[@class='moduleName']")).getText();
		System.out.println("module Name = "+header);
		
		boolean click=obj.findElement(By.xpath("(//img[@style='cursor:pointer;'])[1]")).isEnabled();
		if(click==true) {
			System.out.println(" Plush Button is Clickable");
		}else {
			System.out.println(" Plush Button is  Inclickable");
		}
		
	}
}


