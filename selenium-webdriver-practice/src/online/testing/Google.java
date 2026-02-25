package online.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {


	public ChromeDriver driver;

	Google(){
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);
	}



	public static void main(String[] args) throws InterruptedException {

		Google obj=new Google();
		obj.gmail(); 
		/* obj.faceBook();
		 * obj.googleSearch(); 
		 * obj.googleMusic(); 
		 * obj.gmail(); 
		 * obj.youTube();
		 */

	}
	public  void googleSearch() {

		driver.get("http://google.com");
		WebElement search= driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys(" what is java ");
		search.click();
		WebElement click=driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		click.click();
		WebElement no=driver.findElement(By.xpath("(//div[@class='yuRUbf'])[1]"));
		no.click();
		//		click.clear();

	}


	public  void googleMusic() {

		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("south movie video play"); 
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
		//	driver.findElement(By.xpath("//h3[@class=\"LC20lb MBeuO MMgsKf\"]")).click();
		driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

	}


	public  void gmail() throws InterruptedException {

		driver.get("http://gmail.com");

		WebElement we=driver.findElement(By.xpath("//div[@jsname='oYxtQd']"));
		we.click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		
		  List<WebElement> language=driver.findElements(By.xpath("//li[@aria-selected='false']")); 
		  for(int i=0; i<language.size(); i++) {
		  language=driver.findElements(By.xpath("//li[@aria-selected='false']"));
		  wait.until(ExpectedConditions.visibilityOf(language.get(i))).click();
		  driver.findElement(By.xpath("//div[@jsname='oYxtQd']")).click();
		  
		  }
		 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.xpath("//li[@data-value='en-US']")).click();

		
		
	}
	

	public void youTube() throws InterruptedException {

		// musicPlay without search //
		driver.get("http://youtube.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//	driver.findElementByXPath("(//div[@id='dismissible'])[5]").click();
		driver.findElement(By.xpath("//div[@id='meta']")).click();



		// musicPlay by search //		
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("what is java");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60)); 
		List<WebElement>  musicList=driver.findElements(By.xpath("//ytd-badge-supported-renderer/preceding-sibling::div[@id=\"channel-info\"]/preceding-sibling::div"));
		wait.until(ExpectedConditions.visibilityOf(musicList.get(1))).click();


		Thread.sleep(10000);
		WebElement skip=driver.findElement(By.xpath("//div[@id='ad-text:6']"));
		wait.until(ExpectedConditions.visibilityOf(skip)).click();
		/*
		 * if(skip.getText()=="Skip Ads") {
		 *  skip.click(); }
		 *  else {
		 * System.out.println("No Skip Button"); }
		 */
	}




	public  void faceBook() throws InterruptedException {

		driver.get("http://facebook.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='_8esh']")).click();

	}
}	  

