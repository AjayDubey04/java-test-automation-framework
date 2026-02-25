package snapshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SnapshotMethods {

	public WebDriver driver;


	public SnapshotMethods(){

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);

	}


	public static void main(String[] args) throws IOException {

		SnapshotMethods obj=new SnapshotMethods();
		obj.vtigerSnapshot();
		obj.jumiaSnapshot();

	}

	public void vtigerSnapshot() throws IOException {

		driver.get("http://localhost:8888");
		snapshotOffullPage(driver,"Screenshot//VtigerHomePage.png");
		snapshotOfElement(driver,"Screenshot//loginButton.png","//input[@name='Login']");

	}

	public  void jumiaSnapshot() throws IOException {

		driver.get("https://www.jumia.com.ng/");
		snapshotOffullPage(driver,"Screenshot//jumiaFullPage.png");
		snapshotOfElement(driver,"Screenshot//jumiaSearch.png","//form[@id='search']");


	}


	public void snapshotOffullPage(WebDriver driver, String f_Path ) throws IOException {

		TakesScreenshot tss= (TakesScreenshot) driver;
		File from=tss.getScreenshotAs(OutputType.FILE);
		File to=new File(f_Path);
		Files.copy(from, to);

	}

	public void snapshotOfElement(WebDriver driver, String f_Address, String xpath) throws IOException {

		WebElement we=driver.findElement(By.xpath(xpath));
		File element=we.getScreenshotAs(OutputType.FILE);
		File location=new File(f_Address);
		Files.copy(element, location);

	}


	public void screenshotConcept() throws IOException {

		/* (1)
		 * search context is super or top most interface which is extended by WebDriver
		 * and WebElement it has only two method findElement() and FindElements() ;
		 */

		/*(2)
		 * RemoteWebDriver is predefine class in SeleniuM which have implemented more
		 * then three interfaces such as WebDriver, TakesScreenshot, JavascriptExecutor;
		 */


		/* TakesScreenshot is a interface which is contains getScreenshotAs method and
			it is used to capture full screen short of the WebPage */
		TakesScreenshot pic= (TakesScreenshot) driver;


		/*
		 * it is method of takeScreenshot and it takes OutputType interface type
		 * argument and it is return x type value  by using this method we can 
		 * capture screen shot and store in temprory file
		 */
		File from= pic.getScreenshotAs(OutputType.FILE);

		/*
		 * it is file class object which take Srting type argument as argument we have
		 * to pass location where we want to save our screenshot image
		 */
		File to =new File("ScreenShort//home.png");

		/* it is files class and copy is static method of files class 
		 * we have to pass tow type argument first file from and second file to
		 * by using this method we can copy our file from where to capture 
		 * the image and from where we want to save */
		Files.copy(from, to);




	}		

}
