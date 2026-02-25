package online.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);;
		driver.get("http://amazon.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']")).click();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("pendrive");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='nav-tools']/child::a[@id='nav-cart']")).click();
		
		}
	}


