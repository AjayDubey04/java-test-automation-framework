package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HierarchyXpath {




	public static void main(String[] args) throws InterruptedException {


		relationXPath();


	}
	public static void relationXPath() {

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();


		driver.findElement(By.linkText("Marketing")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();



		driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr//table//td[12]/a")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=CustomView&parenttab=Inventory']")).click();
		driver.findElement(By.xpath("//div[@align='center']/input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//div[@id='miniCal']//following-sibling::table//a[contains(@href,'Marketing')]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//div[@id='moreTab']/preceding-sibling::div//input[@value='  Save  ']")).click();


	}
}