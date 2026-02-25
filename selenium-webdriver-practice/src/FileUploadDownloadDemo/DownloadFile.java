package FileUploadDownloadDemo;

import java.awt.AWTException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class DownloadFile {

	private WebDriver driver;


	public static void main(String[] args) throws InterruptedException, AWTException  {

		DownloadFile obj=new DownloadFile();
		obj.launchBrowserForDownload();
		obj.downloadFile();

	}

	public void launchBrowserForDownload() {


		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options1 = new ChromeOptions();
		
		HashMap<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.default_directory","C:\\Users\\hp\\eclipse-workspace\\org.selenium.webdriver\\downloadFile"); 

		options1.setExperimentalOption("prefs", prefs);
		driver=new ChromeDriver(options1);

	}

	/*
	 * HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	 * chromePrefs.put("profile.default_content_settings.popups", 1);
	 * chromePrefs.put("download.default_directory",
	 * "C:\\Users\\hp\\eclipse-workspace\\selenium.webDriver\\downloadFile");
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * options.setExperimentalOption("prefs", chromePrefs);
	 * options.addArguments("--remote-allow-origins=*"); driver=new
	 * ChromeDriver(options);
	 */


	public void downloadFile()  {

		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");;
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		driver.findElement(By.linkText("Marketing")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Export Leads']")).click();

		WebElement we=driver.findElement(By.xpath("//input[@name='Export']"));
		we.click();

	}

}