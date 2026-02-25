package automation.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		popupHandle();
		
		

	}
   
	public static void popupHandle() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
	    driver.get("http://localhost:8888");
	    
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.name("Login")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='more_5']/following-sibling::table//a")).click();
	    driver.findElement(By.xpath("//input[@name='button_tagfileds']")).click();
	    driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("//a[text()='Send Email With PDF']")).click();
	    
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	    driver.findElementByXPath("//input[contains(@onclick,'resizable')]/following-sibling::input[@title='Save [Alt+S]']").click();
	    driver.switchTo().alert().dismiss();
	    
	    
//	    driver.findElementByLinkText("Marketing").click();
//	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
//	    driver.findElement(By.xpath("//b[text()='Campaign Information']/parent::td/parent::tr/preceding-sibling::tr//descendant::input[@title='Save [Alt+S]']")).click();
//		
//		Alert weAl=driver.switchTo().alert();
////	weAl.accept();
//		String alertText=weAl.getText();
//		System.out.println(alertText);
//		if(alertText.equalsIgnoreCase("Campaign Name cannot be empty")) {
//		System.out.println("Popup msg is currect ");
//		}else {
//			System.out.println("Popup msg is not currect ");
//		}
//		weAl.dismiss();
////	weAl.sendKeys("");
//		
//		
//		driver.findElementByLinkText("Support").click();
//		driver.findElement(By.xpath("//input[@id='115']")).click();
//		driver.findElement(By.xpath("//select[@id='viewname']//ancestor::td[@width='40%']/preceding-sibling::td[@style='padding-right:20px']/child::input[@value='Delete']")).click();
//		weAl.dismiss();
		
		
		
	}
}
