package snapshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class SnapshotDemo {

	public WebDriver driver;

	public static void main(String[] args) throws IOException {

		SnapshotDemo obj=new SnapshotDemo();
		obj.launchBrowser();

	}


	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);
		loginPage();
	}

	public void loginPage() throws IOException {

		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		homePage();
	}

	public void homePage() throws IOException {

		String expectedText="My Home Page < Home";
		String actualText=driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
		if(expectedText.equalsIgnoreCase(actualText)) {
			System.out.println("it is currected");
		}
		else {
			System.out.println("it is incurrected");
			snapshot(driver, "Screenshot//module");
			snapshot_2("Screenshot//module","//td[@class='moduleName']");
		}

	}

	public void snapshot(WebDriver driver, String folderPath) throws IOException {

		Date obj= new Date();
		long time=obj.getTime();

		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceImage=ts.getScreenshotAs(OutputType.FILE);
		File path=new File(folderPath+time+".png");
		Files.copy(sourceImage, path);

	}

	public void snapshot_2(String folderPath, String Xpath) throws IOException {

		Date obj= new Date();
		long time=obj.getTime();

		WebElement we=driver.findElement(By.xpath(Xpath));
		File sourceImage=we.getScreenshotAs(OutputType.FILE);
		File path=new File(folderPath+time+".png");
		Files.copy(sourceImage, path);

	}

}
