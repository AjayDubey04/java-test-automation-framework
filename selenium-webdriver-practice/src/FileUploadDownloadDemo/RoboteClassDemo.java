package FileUploadDownloadDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import predefine.methods.VtigerLoginPage;

public class RoboteClassDemo extends VtigerLoginPage{
	
	WebDriver driver;
	
	public static void main(String[] args) throws AWTException {
		
		new RoboteClassDemo().uploadFileByRobotClass();
		
	}
	
	
	public void uploadFileByRobotClass() throws AWTException {
	

		driver=loginVtiger();
		driver.findElement(By.linkText("Marketing")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Import Leads']")).click();
		
		WebElement we=driver.findElement(By.xpath("//input[@name='userfile']"));
		Actions act=new Actions(driver);
		act.click(we).perform();
		
		StringSelection ss=new StringSelection("C:\\Users\\hp\\OneDrive\\Documents\\Customers.Cvs");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot obj=new Robot();
		obj.delay(2000);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}
	
	
	public void downloadFileByRobotClass() throws AWTException {
		
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");;
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		driver.findElement(By.linkText("Marketing")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Export Leads']")).click();


		WebElement we=driver.findElement(By.xpath("//input[@name='Export']"));
		we.click();

		StringSelection ss=new StringSelection("C:\\Users\\hp\\Downloads");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot obj=new Robot();
		obj.delay(2000);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
		
	}
	
	

}
