package exception;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {


	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement userName=driver.findElement(By.name("user_name"));
		userName.sendKeys("admin");

		 // [ StaleElementReferenceException ]  //
		driver.navigate().refresh(); 
		//	driver.navigate().back();
		//	driver.navigate().forward();

		userName=driver.findElement(By.name("user_name"));
		userName.sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		List<WebElement> weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
		int tabLinkCount=weTabLink.size();

		for(int i=0; i<tabLinkCount; i++) {
			weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
			//	( StaleElementReferenceException )
			String tabLinkText=weTabLink.get(i).getText(); 
			System.out.println(" == "+tabLinkText+" == ");
			weTabLink.get(i).click();

			List<WebElement> weSubTabLink=driver.findElements(By.xpath("//table[@class='level2Bg']//descendant::a"));
			int subTabCount=weSubTabLink.size();
			for(int j=0; j<subTabCount; j++) {
				weSubTabLink=driver.findElements(By.xpath("//table[@class='level2Bg']//descendant::a"));
				String subTabText=weSubTabLink.get(j).getText();
				System.out.println(subTabText);
				weSubTabLink.get(j).click();


				if(subTabText.equalsIgnoreCase("Webmail")==false && subTabText.equalsIgnoreCase("Settings")==false && subTabText.equalsIgnoreCase("Module Manager")==false ) {

					String actualHeader=driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
					String expectedHeader=tabLinkText+" > "+subTabText;
					if(actualHeader.equalsIgnoreCase(expectedHeader)) {
						System.out.println("Passed :- Actual == "+actualHeader+" Same As Expected == "+expectedHeader);	 
					}else {
						System.out.println("Failed :- Actual == "+actualHeader+" Same As Expected == "+expectedHeader);	 
					}
				}
			}
		}
	}

}
