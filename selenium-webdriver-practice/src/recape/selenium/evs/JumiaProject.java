package recape.selenium.evs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class JumiaProject {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		// RelativeLocator in selenium 4 but it was not in selenium 3
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement userName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(password));
		password.sendKeys("admin");
		userName.sendKeys("admin");
	
		
		WebElement we= driver.findElement(RelativeLocator.with(By.tagName("input")).below(password));
		we.click();
		
		
		
	}

}
