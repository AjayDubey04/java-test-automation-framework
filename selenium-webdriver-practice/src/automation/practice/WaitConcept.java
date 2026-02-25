package automation.practice;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;import com.sun.jdi.Location;

public class WaitConcept {

	public static void main(String[] args) throws InterruptedException {

		
//						implicitlyWait();
//		                explicitlyWait();
//						explicitlyWait_1();

	}

	public static void implicitlyWait() throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
//		Thread.sleep(5000);

		WebElement weDrag=driver.findElement(By.xpath("//b[contains(text(),'Top Invoices')]"));
		WebElement weDrop=driver.findElement(By.xpath("//b[contains(text(),'Tag Cloud')]"));
		Actions act=new Actions(driver);
		
		long startingTime=Calendar.getInstance().getTimeInMillis();
		System.out.println(startingTime);
		act.dragAndDrop(weDrag, weDrop).perform();
		long endingTime=Calendar.getInstance().getTimeInMillis();
		System.out.println(endingTime);
		System.out.println(endingTime-startingTime);
		
//		act.click(weDrag).moveToElement(weDrag).release(weDrop).build().perform();

		driver.findElement(By.linkText("Sales")).click();

	}

	public static void explicitlyWait() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));

		if(wait.until(ExpectedConditions.urlMatches("http://localhost:8888"))) {
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");

			WebElement login=driver.findElement(By.name("Login"));
//			wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(login)));
			wait.until(ExpectedConditions.elementToBeClickable(login));
			login.click();

		}


		String title=driver.getTitle();
		WebDriverWait waitTitle=new WebDriverWait(driver, Duration.ofSeconds(30));
		if(waitTitle.until(ExpectedConditions.titleIs(title))) {
			System.out.println(" Home Page Title = "+title);
		}
		

		
		WebElement module=driver.findElement(By.xpath("//td[@class='moduleName']"));
		String weText=module.getText();
		WebDriverWait waitModule=new WebDriverWait(driver, Duration.ofSeconds(10));
		if(waitModule.until(ExpectedConditions.textToBePresentInElement(module,weText))) {
			System.out.println("Header = "+weText);
		}


		
		WebElement link=driver.findElement(By.linkText("Marketing"));
		WebDriverWait waitLink=new WebDriverWait(driver, Duration.ofSeconds(50));
		if(waitLink.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(link)))) {
			link.click();
		}



		WebElement
		chekBox=driver.findElement(By.xpath("//input[@name='selectall']"));
		chekBox.click();
		WebDriverWait waitChekBox=new WebDriverWait(driver, Duration.ofSeconds(10));
		if(waitChekBox.until(ExpectedConditions.elementToBeSelected(chekBox))) {
			chekBox.click(); 
		}


		driver.findElement(By.xpath("//input[@id='132']")).click(); 
		driver.findElement(By.xpath("//input[contains(@onclick,'Marketing')]/preceding-sibling::input")).click();
		WebDriverWait waitAlert=new WebDriverWait(driver, Duration.ofSeconds(90));
//	    waitAlert.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
		waitAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();

		
		
		List<WebElement> weLatter=driver.findElements(By.xpath("//td[@class='searchAlph']"));
		WebDriverWait waitAlpha=new WebDriverWait(driver,Duration.ofSeconds(20));
//		waitAlpha.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElements(weLatter)));
		waitAlpha.until(ExpectedConditions.visibilityOfAllElements(weLatter));
		for (WebElement webElement : weLatter) {
			String latterText=webElement.getText();
			System.out.print(" "+latterText);
		}
		
//		waitAlpha.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements(weLatter)));
	
		
	}
	


	public static void explicitlyWait_1() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();

		driver.get("http://flipkart.com");	
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		String title=driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		if(wait.until(ExpectedConditions.titleIs(title))) {
			System.out.println(title);
		}

		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		List<WebElement> downList=driver.findElements(By.xpath("//span[@class='_2I9KP_']"));
		WebDriverWait waitList=new WebDriverWait(driver, Duration.ofSeconds(500));
		waitList.until(ExpectedConditions.visibilityOfAllElements(downList));
		int count=downList.size();
		for(int i=0; i<count; i++) {
			Actions act=new Actions(driver);
			act.moveToElement(downList.get(i)).perform();
		}
		
		
		
        
	}
}
