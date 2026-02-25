package snapshot;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.io.Files;

public class SnapshotPractice {


	public WebDriver driver;


	public static void main(String[] args) throws IOException, InterruptedException {

		SnapshotPractice obj=new SnapshotPractice();
		obj.loginForSnapShot();
		obj.desktopSnapShot();
		/*
		 * obj.fullPageSnapShot(); Thread.sleep(5000); obj.listElementSnapShot();
		 */
		//		obj.specificElementSnapShot();

	}


	public void loginForSnapShot() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions opaions=new ChromeOptions();
		opaions.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(opaions);
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).sendKeys(Keys.ENTER);
	}


	public void fullPageSnapShot() throws IOException {


		TakesScreenshot tss=(TakesScreenshot) driver;  // downCating
		File snapShotTo=tss.getScreenshotAs(OutputType.FILE);
		File snapShotForm=new File("FullPageSnapShotDemo\\VtegerHomePage.png");
		Files.copy(snapShotTo,snapShotForm);

		/*
		 * FileNotFoundException we are trying in this way 
		 * Files.copy(snapShotForm,snapShotTo);
		 */

		ChromeDriver ChDriver=(ChromeDriver) driver; //  downCasting  //  ChDriver.getScreenshotAs(OutputType.FILE);
		File snapShotTo_1=ChDriver.getScreenshotAs(OutputType.FILE);
		File snapShotForm_1=new File("FullPageSnapShotDemo\\VtegerHomePage_1.png");
		Files.copy(snapShotTo_1,snapShotForm_1);

		RemoteWebDriver rm=ChDriver; // upCating // rm.getScreenshotAs(OutputType.FILE);
		File snapShotTo_2=rm.getScreenshotAs(OutputType.FILE);
		File snapShotForm_2=new File("FullPageSnapShotDemo\\VtegerHomePage_2.png");
		Files.copy(snapShotTo_2,snapShotForm_2);

		TakesScreenshot ts=ChDriver; // upCating // ts.getScreenshotAs(OutputType.FILE);
		File snapShotTo_3=ts.getScreenshotAs(OutputType.FILE);
		File snapShotForm_3=new File("FullPageSnapShotDemo\\VtegerHomePage_3.png");
		Files.copy(snapShotTo_3,snapShotForm_3);


	}

	public void listElementSnapShot() throws IOException {

		//	List<WebElement> tabLinkList=driver.findElements(By.xpath("//table[@class='hdrTabBg']/descendant::a[contains(@href,'index.php?module')]/parent::td"));
		/*
		 * for (WebElement weList : tabLinkList) { 
		 * String tabLinkText=weList.getText();
		 * File snapShotTo=weList.getScreenshotAs(OutputType.FILE); 
		 * File snapShotForm=new File("SpecificElementSnapShotDemo\\"+tabLinkText+".png");
		 * Files.copy(snapShotTo,snapShotForm);
		 * 
		 * }
		 */


		/*
		 * for (int i = 0; i<tabLinkList.size(); i++) { 
		 * String tabLinkText=tabLinkList.get(i).getText(); 
		 * File snapShotTo=tabLinkList.get(i).getScreenshotAs(OutputType.FILE); 
		 * File snapShotForm=new File("SpecificElementSnapShotDemo\\"+tabLinkText+".png");
		 * Files.copy(snapShotTo,snapShotForm); 
		 * 
		 * }
		 */

		/*List<WebElement> tabLinkList=driver.findElements(By.xpath("//table[@class='hdrNameBg']/descendant::marquee[@id='rss']/parent::td/following-sibling::td/descendant::td"));

		int i=0;
		while(i<tabLinkList.size()) {
			String	tabLinkText=tabLinkList.get(i).getText(); File
			snapShotTo=tabLinkList.get(i).getScreenshotAs(OutputType.FILE); File
			snapShotForm=new File("SpecificElementSnapShotDemo\\"+tabLinkText+"="+i+".png");
			Files.copy(snapShotTo,snapShotForm); 
			i++;
		}*/

		List<WebElement> tabLinkList=driver.findElements(By.xpath("//div[@id='MainMatrix']/child::div"));
		int i=0;
		System.out.println(tabLinkList.size());
		do {
			File snapShotTo=tabLinkList.get(i).getScreenshotAs(OutputType.FILE); 
			File snapShotForm=new File("SpecificElementSnapShotDemo\\HelloPage_"+i+".png");
			Files.copy(snapShotTo,snapShotForm); 
			i++;
		}while(i<tabLinkList.size()) ;


	}

	public void  specificElementSnapShot() throws IOException {

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Clock.gif']")).click();

		WebElement we=driver.findElement(By.xpath("//div[@id='wclock']"));
		File snapShotTo=we.getScreenshotAs(OutputType.FILE); 
		File snapShotForm=new File("SpecificElementSnapShotDemo\\ClockPage.png");
		Files.copy(snapShotTo,snapShotForm); 


	}



	public void hierchacy() {

		// we can access al method by chromedriver
		ChromeDriver obj=new ChromeDriver();

		ChromiumDriver obj4=obj;

		RemoteWebDriver obj1=obj4;

		WebDriver driver=obj1;

		SearchContext gh=driver;

		RemoteWebElement obj2=new RemoteWebElement();
		WebElement obj3=obj2;

	}

	public void  desktopSnapShot() throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File snapShotTo=ts.getScreenshotAs(OutputType.FILE); 
		File snapShotForm=new File("C:\\Users\\hp\\OneDrive\\Desktop\\ScreenShot\\Hello.png");
		Files.copy(snapShotTo,snapShotForm); 


	}


}
