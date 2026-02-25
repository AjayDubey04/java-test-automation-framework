package automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserTesting {

	public WebDriver DRIVER;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		CrossBrowserTesting obj=new CrossBrowserTesting();
		obj.launchByCrossTesting();
		obj.loginByCrossTesting();
		
	}
	
	public void launchByCrossTesting() {
		
		System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
		DRIVER=new EdgeDriver();
		
		/*
		 * System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		 * DRIVER=new ChromeDriver();
		 */
	}
	
	public void loginByCrossTesting() {
		
		DRIVER.findElement(By.name("user_name")).sendKeys("admin");
		DRIVER.findElement(By.name("user_password")).sendKeys("admin");
		DRIVER.findElement(By.name("Login")).click();
		
	}

}
