package oops.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UseableMethods {

	public WebDriver DRIVER;

	public WebDriver launchBrowser() {
		
		System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
		DRIVER=new EdgeDriver();
		
//		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
//		DRIVER=new ChromeDriver();
		return  DRIVER;
	}

	public WebDriver login() {
		DRIVER.get("http://localhost:8888");
		DRIVER.findElement(By.name("user_name")).sendKeys("admin");
		DRIVER.findElement(By.name("user_password")).sendKeys("admin");
		DRIVER.findElement(By.name("Login")).click();
		return DRIVER;
	}

	public WebDriver logout() {
		DRIVER.findElement(By.linkText("Sing Out")).click();
		return DRIVER;
	}

	public WebDriver reLogin() {
		DRIVER.findElement(By.name("user_password")).sendKeys("admin");
		DRIVER.findElement(By.name("Login")).click();
		return DRIVER;
	}


}
