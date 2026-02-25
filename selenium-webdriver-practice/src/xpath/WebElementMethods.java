package xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		WebElement obj=driver.findElement(By.xpath("//input[@name='user_name']"));
		obj.sendKeys("admin");
		obj.clear();
		obj.click();
		obj.getAttribute(null);
		obj.isDisplayed();
		obj.isEnabled();
		obj.isSelected();
		obj.getLocation();
		obj.getSize();
		obj.getText();
		obj.getTagName();
		

	}

}
