package rahul.sir.zip.file;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartScenario {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get( "http://flipkart.com");

		///  click on close button of Login Popup
		WebElement UName=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));  ///  8  Byte
		UName.click();  //  8 byte

		///  getting list of all the tabs with down arrow link
		List<WebElement> tabsWithDownArrowList= driver.findElements(By.xpath("//div[@class='_1psGvi SLyWEo']//div[@class='xtXmba']"));
		//  taking count of  tabs
		int tabsCount=tabsWithDownArrowList.size();

		Actions actObj=  new Actions(driver);
		////  loop for tabs
		for(int i=0; i<=tabsCount-1;i++) {
			/// Taking WebElement Object of all the tabs one by one
			WebElement weTab= tabsWithDownArrowList.get(i);
			///  mouse over on tab
			actObj.moveToElement(weTab).build().perform();
			////  taking WebElement list of all the categories
			List<WebElement> categoryBoxItemsList=driver.findElements(By.xpath("//a[starts-with(@class,'_6WOcW9')]"));
			int categoryCount=categoryBoxItemsList.size();
			////  Loop for categories 
			for(int j=0; j<=categoryCount-1;j++) {
				////  Taking fresh reference of all the categories otherwise it will throw StaleElementRefenceException 
				categoryBoxItemsList=driver.findElements(By.xpath("//a[starts-with(@class,'_6WOcW9')]"));
				///  Taking WebElement of Category one by one
				WebElement weCategory=categoryBoxItemsList.get(j);
				/// printing innertext of category
				System.out.println(weCategory.getText());

				/// clicking on category and reaching on category page
				weCategory.click();
				Thread.sleep(3000);
				/// back on Main page again
				driver.navigate().back();
				Thread.sleep(3000);
				//// Taking Fresh Refernce of all the tabs again 
				//// because Page is changed so  all the list and webelements
				///  are use less otherwise they will throw StaleElementRefenceException
				tabsWithDownArrowList= driver.findElements(By.xpath("//div[@class='_1psGvi SLyWEo']//div[@class='xtXmba']"));
				/// Taking Fresh WebElement of Tab from Fresh Reference of Tab List
				weTab= tabsWithDownArrowList.get(i);
				actObj.moveToElement(weTab).build().perform();
			}
			System.out.println("====================================");

		}


	}

}


