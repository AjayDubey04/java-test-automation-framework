package rahul.sir.zip.file;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VTigerTabScenario {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get( "http://localhost:8888");


		driver.findElement(By.name("user_name")).sendKeys("admin");  ///  8  Byte
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		List<WebElement> listBoxHeading=driver.findElements(By.xpath("//div[@id='MainMatrix']//td[@class='homePageMatrixHdr']//b"));
		int headingCount=listBoxHeading.size();
		for(int i=0; i<headingCount;i++) {
			WebElement weHeading=listBoxHeading.get(i);
			String headingText=weHeading.getText();
			System.out.println(headingText);
		}

		List<WebElement> listTabLinks=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
		int tabLinkCount=listTabLinks.size();
		for(int i=0; i<tabLinkCount;i=i+1) {
			listTabLinks=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
			WebElement weTabLinks=listTabLinks.get(i);

			String tabLinkText=weTabLinks.getText();
			System.out.println("=="+tabLinkText+"==");
			weTabLinks.click();
			List<WebElement> listSubTabLinks=driver.findElements(By.xpath("//table[@class='level2Bg']//a"));
			int subTabLinkCount=listSubTabLinks.size();
			for(int j=0; j<=subTabLinkCount-1;j++) {
				listSubTabLinks=driver.findElements(By.xpath("//table[@class='level2Bg']//a"));
				WebElement weSubTabLink=listSubTabLinks.get(j);
				String subTabLinkText=weSubTabLink.getText();
				System.out.println(subTabLinkText);
				weSubTabLink.click();

				if(subTabLinkText.equalsIgnoreCase("Webmail")==false && subTabLinkText.equalsIgnoreCase("Settings")==false && subTabLinkText.equalsIgnoreCase("Module Manager")==false) {

					String actualPageHeader=driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
					String expectedPageHeader=tabLinkText+" > "+subTabLinkText;
					if(actualPageHeader.equalsIgnoreCase(expectedPageHeader)) {
						System.out.println("Passed. Where Actual-"+actualPageHeader+" && expected-"+expectedPageHeader);
					}else {
						System.out.println("Failed. Where Actual-"+actualPageHeader+" && expected-"+expectedPageHeader);

					}

				}
			}


		}
	}

}




