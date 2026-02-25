package online.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce {

	public static void main(String[] args) {
		
		salesForce();
		
	}

	public static void salesForce() {
		
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//a[@aria-label='Start my free trial with Salesforce CRM']")).click();
		
		 Set<String> windowsId=driver.getWindowHandles(); 
		 List<String> listWindow=new ArrayList<>(windowsId);
		 driver.switchTo().window(listWindow.get(1));

		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("Ajay");
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("Dubey");
		
	}
	
}
