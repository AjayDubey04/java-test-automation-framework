package xpath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {


	public static void main(String[] args) {

		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888"); // 
		driver.findElement(null);
		driver.getCurrentUrl();
		driver.getTitle();
		driver.close();
		driver.quit();
		Navigation navi=driver.navigate();
		navi.back();
		navi.forward();
		navi.refresh();
		navi.to("");
		TargetLocator tl=driver.switchTo();
		tl.frame(0);
		tl.frame("");
		tl.frame("");
		tl.parentFrame();
		tl.defaultContent();
		Alert popup= tl.alert();
		popup.accept();
		popup.dismiss();
		popup.getText();
		popup.sendKeys(null);
		driver.findElements(By.xpath(null));



	}

}
