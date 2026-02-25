package evs.work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EvsTestCase_1 {

	public static void main(String[] args) {

		TC001();
		TC002(); 
		TC003();
		TC004();
	}

	public static void TC001() 
	{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement obj=driver.findElement(By.xpath("(//td[@class=\"small\"])[2]"));
		boolean hii=obj.isDisplayed();
		boolean hii1=obj.isEnabled();
		if(hii==true){
			System.out.println("user name is visiable,test is passed");
		}else {
			System.out.println("user name is disable,test is failed");
		}

		if(hii1==true){
			System.out.println("user name is Enabled,test is passed");
		}else {
			System.out.println("user name is disable,test is failed");
		}

		WebElement pass=driver.findElement(By.xpath("(//td[@class=\"small\"])[4]"));
		boolean box=pass.isDisplayed();
		boolean box1=pass.isEnabled();
		if(box==true){
			System.out.println("password is visiable,test is passed");
		}else {
			System.out.println("password is disable,test is failed");
		}

		if(box1==true){
			System.out.println("password is Enabled,test is passed");
		}else {
			System.out.println("password is disable,test is passed");
		}
		WebElement colourtheam=driver.findElement(By.xpath("(//td[@class=\"small\"])[6]"));
		boolean colur=colourtheam.isDisplayed();
		boolean colur1=colourtheam.isEnabled();
		if(colur==true){
			System.out.println("colourtheam is Visible,test is passed");
		}else {
			System.out.println("colourtheam is invisible,test is failed");
		}
		if(colur1==true){
			System.out.println("colourtheam is Enabled,test is passed");
		}else {
			System.out.println("colourtheam is disable,test is failed");
		}
		WebElement language=driver.findElement(By.xpath("(//td[@class=\"small\"])[8]"));
		boolean lang=language.isDisplayed();
		boolean lang1=language.isEnabled();
		if(lang==true){
			System.out.println("language is Visible,test is passed");
		}else {
			System.out.println("language is invisible,test is failed");
		}
		if(lang1==true){
			System.out.println("language is Enabled,test is passed");
		}else {
			System.out.println("language is disable,test is failed ");
		}
		WebElement button=driver.findElement(By.xpath("//input[@name=\"Login\"]"));
		boolean bot=button.isDisplayed();
		boolean bot1=button.isEnabled();
		if(bot==true){
			System.out.println("button is Visible,test is passed");
		}else {
			System.out.println("button is invisible,test is failed");
		}
		if(bot1==true){
			System.out.println("button is Enabled, test is passed");
		}else {
			System.out.println("button is disable , test is failed");
		}

	}

	public static void TC002()  
	{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		String user="admin";
		WebElement obj=driver.findElement(By.name("user_name"));
		obj.sendKeys("admin");
		String able=obj.getAttribute("value");
		if(able.equalsIgnoreCase(user)) {
			System.out.println("Username Box is visible");
		}else {
			System.out.println("Username box is not visiable");
		}

		String pass="admin";
		WebElement obj1=driver.findElement(By.name("user_password"));
		obj1.sendKeys("admin");
		String able1=obj1.getAttribute("value");
		if(able1.equalsIgnoreCase(pass)) {
			System.out.println("password box is visible");
		}else {
			System.out.println("password box is not visible");
		}

	}

	public static void TC003() 
	{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Login']")).click();

		String Home="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String title=driver.getTitle();
		System.out.println("Home Page Title = "+title);
		boolean right=title.equalsIgnoreCase(Home);
		if(right==true) {
			System.out.println("Valid title so test is passed");
		}else {
			System.out.println("Invalid title so test is failed");
		}
	}


	public static void TC004() 
	{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admins");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admins");
		driver.findElement(By.xpath("//input[@name='Login']")).click();

		String test="You must specify a valid username and password.";
		String error=driver.findElement(By.xpath("//font[@color=\"Brown\"]")).getText();
		boolean finderror=test.equalsIgnoreCase(error);
		if(finderror==true) {
			System.out.println("correct Error so test is passed");
		}
		else {
			System.out.println("incorrect Error so test is failed");
		}
	}
}
