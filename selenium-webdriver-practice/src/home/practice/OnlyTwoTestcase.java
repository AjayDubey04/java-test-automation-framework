package home.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;
import predefine.methods.VtigerLoginPage;

public class OnlyTwoTestcase  {

	WebDriver driver;



	OnlyTwoTestcase() {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
	}

	public static void main(String[] args) throws IOException {


		OnlyTwoTestcase obj1=new OnlyTwoTestcase();
		

	}


	public void linkTestCase() {

		Actions act=new Actions(driver);

		List<WebElement> linkList=driver.findElements(By.xpath("//td[contains(@class,'Selected')]"));
		for(int i=0; i<linkList.size(); i++) {
			System.out.println("====="+linkList.get(i).getText()+"=====");
			act.moveToElement(linkList.get(i)).perform();

			List<WebElement> subLinkList=driver.findElements(By.xpath("//div[contains(@onmouseout,\"fnHideDrop\")]/descendant::a"));
			for (WebElement webElement : subLinkList) {
				if(!webElement.getText().equals("")) {
					System.out.println(webElement.getText());
				}

			}
		}
	}


	public void useOfkeys() throws IOException {

		WebElement we=driver.findElement(By.name("user_name"));
		we.sendKeys("admin",Keys.CONTROL+"a");
		we.sendKeys(Keys.CONTROL+"c");
		we.sendKeys(Keys.TAB);

		driver.findElement(By.name("user_password")).sendKeys(Keys.CONTROL+"v");

		try {
			driver.findElement(By.name("Login")).sendKeys(Keys.ENTER);
		} catch(Exception e) {

			TakesScreenshot ts=(TakesScreenshot) driver;
			File f=ts.getScreenshotAs(OutputType.FILE);
			File f1=new File("Screenshot\\TestCase.png");
			Files.copy(f, f1);
		}


	}

	public void cookies() {

		driver.get("http://www.amazon.com");

		Set<Cookie> cok=driver.manage().getCookies();
		for (Cookie cookie : cok) {
			System.out.println(cookie.getValue());
		}

	}
}
