package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import predefine.methods.VtigerLoginPage;

public class Scroll extends VtigerLoginPage {
	
	public WebDriver driver;
	
	public static void main(String[] args) {
		
		Scroll obj=new Scroll();
		obj.scrollByElement();
		
	}
	
	public void scrollByElement() {
		
		driver=loginVtiger();
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		act.pause(Duration.ofSeconds(6)).perform();;
		System.out.println(driver.getTitle());
		
		act.scrollByAmount(273, 491).perform();
		
		
		driver.findElement(By.linkText("Marketing")).click();
		act.scrollToElement(driver.findElement(By.xpath("(//input[contains(@onclick,'Campaigns')])[last()-1]"))).perform();
		
		
	}
	

}
