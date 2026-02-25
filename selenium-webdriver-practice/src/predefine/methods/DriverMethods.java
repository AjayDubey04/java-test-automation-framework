package predefine.methods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverMethods extends VtigerLoginPage {

	public WebDriver driver;


	public WebDriver hitUrl(String url) {
		driver.get(url);
		return driver;
	}

	public void getWebPageUrl() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}


	public void getWebPageTitle() {
		String title =driver.getTitle();
		System.out.println(title);

	}


	public WebElement searchElement(String xpath) {
		WebElement	element=driver.findElement(By.xpath(xpath));
		return element;
	}

	public List<WebElement> searchElements(String xpath) {
		List<WebElement>	list_element=driver.findElements(By.xpath(xpath));
		return list_element;
	}




}
