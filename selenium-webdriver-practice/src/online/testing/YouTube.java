package online.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTube {

	public WebDriver driver;

	YouTube() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	public static void main(String[] args)  {

		YouTube obj=new YouTube();
        obj.searchMusicPlay();
//      obj.homeMusicPlay();
		
	}
	

	public void homeMusicPlay() {

		driver.get("http://youtube.com");
		driver.findElement(By.xpath("(//div[@id='dismissible'])[5]")).click();
		
	}
	

	public void searchMusicPlay() {

		driver.get("http://youtube.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("what is java");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60)); 
		List<WebElement>  musicList=driver.findElements(By.xpath("//ytd-badge-supported-renderer/preceding-sibling::div[@id=\"channel-info\"]/preceding-sibling::div"));
		wait.until(ExpectedConditions.visibilityOf(musicList.get(1))).click();


//		WebElement skip=driver.findElement(By.xpath("//div[@id='ad-text:6']"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ad-text:6']")))).click();
		
		/*
		 * if(skip.getText()=="Skip Ads") {
		 *  skip.click(); }
		 *  else {
		 * System.out.println("No Skip Button"); }
		 */



	}


}
