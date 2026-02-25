package actionsClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropAndDown {

	public static void main(String[] args) {
		
		dropDownHandle();
		
		
	}
	public  static void dropDownHandle() 
	{
		 System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://localhost:8888");
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 
//(1)
		 WebElement objd=driver.findElement(By.xpath("//select[@name='login_theme']"));
		 objd.click();
	     driver.findElement(By.xpath("//option[@value='woodspice']")).click(); 
       	 objd.click();
		 
//(2)		 
		 WebElement we=driver.findElement(By.xpath("//select[@name='login_theme']"));
		 Select test=new Select(we);
		 test.selectByVisibleText("alphagrey");
		 test.selectByIndex(3);
		 test.selectByValue("softed");
	     System.out.println(we.getText());
	     
//(3)	     
	   driver.findElement(By.xpath("//select[@name='login_theme']")).sendKeys("woodspice");
	   
	     
	            // count Drop Down Value //
	        WebElement wedd=driver.findElement(By.xpath("//select[@name='login_theme']"));
			Select obj=new Select(wedd);
			List<WebElement> weSelect=obj.getOptions();
			int weSize=weSelect.size();
			System.out.println(weSize);
			
	     
	     WebElement we1=driver.findElement(By.name("login_language"));
	     Select find=new Select(we1);
	     find.selectByVisibleText("DE Deutsch");
	     find.selectByIndex(3);
	     find.selectByValue("en_us");
	     System.out.println(we1.getText());
	     
	     
		 driver.findElement(By.name("Login")).click();
	
		 WebElement weMarketing=driver.findElement(By.xpath("//a[text()='Marketing']"));
		 Actions objOfActions=new Actions(driver);
		 objOfActions.moveToElement(weMarketing).build().perform(); // (1)
		 
		 
		 WebElement weLeads= driver.findElement(By.linkText("Leads"));
//		 objOfActions.click(obj.findElementByLinkText("Leads")).build().perform();  // (2)
		 objOfActions.doubleClick(weLeads).build().perform(); //(3)
		 
		 WebElement weRightclick=driver.findElement(By.xpath("//img[@title='Create Lead...']"));
		 objOfActions.contextClick(weRightclick).build().perform(); //
		 
		 WebElement weSales=driver.findElement(By.xpath("//a[text()='Sales']"));
		 objOfActions.moveToElement(weSales).build().perform();
		 
		 
}
}
