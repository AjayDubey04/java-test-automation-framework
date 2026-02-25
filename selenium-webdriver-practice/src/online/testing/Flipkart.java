package online.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;


public class Flipkart {

	static {
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
	}
	ChromeOptions option=new ChromeOptions();

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.get("http://Flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement waitObj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")));
		waitObj.click();

		//		flipkart_1();
		//	    flipkart_2();
		//		flipkart_3();
		//       smartPhone();
		mobilesText();

	}

	public static void flipkart_1() throws InterruptedException 
	{

		WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("shoes");
		WebElement click=driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		click.click();


		List<WebElement> weRate=driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		List<WebElement> weBrand=driver.findElements(By.xpath("//div[@class='_2WkVRV']"));
		int brandRateCount=weBrand.size();

		for(int i=0; i<brandRateCount; i++) {
			String BrandText=weBrand.get(i).getText();
			String rateText=weRate.get(i).getText();
			System.out.println(BrandText +" = "+rateText);
		}

		search.clear();
		search.sendKeys("iphone");
		click.click();


		System.out.println("// == MOBILES == //");
		List<WebElement> weMobiles=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> weMobilesRate=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		int  mobileRateCount= weMobiles.size();
		for(int i=0; i< mobileRateCount; i++) {
			String mobilText=weMobiles.get(i).getText();
			String rateText=weMobilesRate.get(i).getText();
			System.out.println(mobilText+" = "+rateText);

		}

	}
	public static void flipkart_2() {


		Actions act=new Actions(driver);

		List<WebElement> flipkartTabLink=driver.findElements(By.xpath("//div[@class='_37M3Pb']//div[@class='xtXmba']"));
		int tbCount=flipkartTabLink.size();
		for(int i=0; i<tbCount; i++) {
			String tbText=flipkartTabLink.get(i).getText();
			System.out.println(" === "+tbText+" === ");

			WebElement weMoseOver=flipkartTabLink.get(i);
			act.moveToElement(weMoseOver).perform();

			List<WebElement> weCategory=driver.findElements(By.xpath("//div[@class='_2IjXr8']//a"));
			for(int j=0; j<weCategory.size(); j++) {
				String weCategoryText=weCategory.get(j).getText();
				System.out.println(weCategoryText);

			}
		}

	}

	public static void flipkart_3() throws InterruptedException {

		Actions act=new Actions(driver);
		List<WebElement> flipkartTabLink=driver.findElements(By.xpath("//div[@class='_1psGvi SLyWEo']"));
		int tbCount=flipkartTabLink.size();

		for(int i=0; i<tbCount; i++) {
			act.moveToElement(flipkartTabLink.get(i)).perform();
			System.out.println(" === "+flipkartTabLink.get(i).getText()+" === ");


			List<WebElement> subTabLink=driver.findElements(By.xpath("//a[contains(@class,'_6WOcW9')]"));
			for(int j=0; j<subTabLink.size(); j++) {
				subTabLink=driver.findElements(By.xpath("//a[contains(@class,'_6WOcW9')]"));
				System.out.println(subTabLink.get(j).getText());

				subTabLink.get(j).click();
				Thread.sleep(5000);
				driver.navigate().back();
				flipkartTabLink=driver.findElements(By.xpath("//div[@class='_1psGvi SLyWEo']"));
				act.moveToElement(flipkartTabLink.get(i)).perform();

			}
		}

	}

	public static void smartPhone() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).perform();

		List<WebElement> mobileList=driver.findElements(By.xpath("//a[contains(@href,'/mobile-phones-store?')]/following-sibling::a"));
		for(int i=0; i<mobileList.size(); i++) {
			String mobileText=mobileList.get(i).getText();
			System.out.println(" Mobile Brand = "+mobileText);
		}

	}


	public static void mobilesText() throws InterruptedException {

		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		WebElement dropDown=driver.findElement(By.xpath("//div[@class='_3uDYxP']/child::select"));
		Select sel=new Select(dropDown);
		sel.selectByValue("10000");

		Thread.sleep(5000);

		System.out.println("== Mobile Text ==");

		List<WebElement> list=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (WebElement webElement : list) {
			String mobileText=webElement.getText();
			System.out.println(mobileText);
		}

	}

}



