package window.handle;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import predefine.methods.VtigerLoginPage;


public class HrmWindowHandle extends VtigerLoginPage {
	
     public WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		HrmWindowHandle obj=new HrmWindowHandle(); 
		obj.orangeHrm() ;
		
	}

	public  void orangeHrm() throws InterruptedException {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
		
		
		  Set<String> windowsId=driver.getWindowHandles(); 
			/*
			 *  <  First Iterator method >
			 * Iterator<String>listWindow=windowsId.iterator(); String
			 * parentWindow=listWindow.next();
			 *  childWindow=listWindow.next();
			 */
		   
		  // Second ArrayList //
		  List<String> listWindow=new ArrayList(windowsId);
		  driver.switchTo().window(listWindow.get(1));
		 
		driver.findElement(By.xpath("//input[@name='action_submitForm']")).click();
		
		driver.findElement(By.xpath("//input[@name='subdomain']")).sendKeys("UserName");
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Password");
		driver.findElement(By.xpath("//input[@name='Contact']")).sendKeys("Mobile Number");
		
		Select obj=new Select(driver.findElement(By.xpath("//select[@name='Country']")));
		obj.selectByValue("India");
		

	}
}
