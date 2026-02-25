package evs.work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EvsTestCase_2 {

	static {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
	}
	static ChromeDriver driver=new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		
		driver.get("http://practice.automationtesting.in");
		EvsTestCase_2 test=new  EvsTestCase_2();
		test.V001();
		test.V002();
		test.V003();		

	}

	public  void V001(){
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		WebElement we=driver.findElement(By.xpath("//input[@name='email']"));
	    boolean user=we.isDisplayed();
	    if(user==true){
	    	System.out.println("Email Box is visible");
	    }else {
	    	System.out.println("Email Box is invisible");	
	    }
	    
	    we.sendKeys("roshan.morningStar772@yopmail.com");
		WebElement we1=driver.findElement(By.xpath("(//input[@name='password'])[2]"));
		boolean pass=we1.isDisplayed();
	    if(pass==true){
	    	System.out.println("Password Box is visible");
	    }else {
	    	System.out.println("Password Box is invisible");	
	    }
	    
		we1.sendKeys("Roshan@morningstar");
		WebElement we2=driver.findElement(By.xpath("//input[@name='register']"));
		boolean rgister=we1.isDisplayed();
	    if(rgister==true){
	    	System.out.println("Register Button is Enabled");
	    }else {
	    	System.out.println("Register Button is disabled");	
	    }
	    
	    we2.click();
		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.xpath("//input[@name='register']")).click();
	    String homepage=driver.getTitle();
		System.out.println("Home page Title = "+homepage);
		
//		driver.findElementByXPath("//a[text()='Sign out']").click();
	}
	public  void V002() 
	{

		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("roshan.morningStar212@tplink");
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Roshan@morningstar");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		String valid="Error: Please provide a valid email address.";
		String verify=driver.findElement(By.xpath("//li[text()=' Please provide a valid email address.']")).getText();
//		System.out.println(verify);
		if(valid.equalsIgnoreCase(verify)) {
			System.out.println("Correct Error so test is passed");
		}else {
			System.out.println("Incorrect Error so test is failed");
		}
		
	}
	public  void V003() 
	{
		
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("  ");
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Roshan@morningstar");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		String error="Please provide a valid email address.";
		String verify=driver.findElement(By.xpath("//li[text()=' Please provide a valid email address.']")).getText();
//		System.out.println(verify);
		if(error.equalsIgnoreCase(verify)) {
			System.out.println("Correct Error so test is passed");
		}else {
		System.out.println("Incorrect Error so test is failed");
		}
	}
}
