package automation.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IFrameHandle {

	public static void main(String[] args) throws InterruptedException {


		iFrame003();


	}

	public static void iFrame001() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_iframe.asp");

//		driver.switchTo().frame(0); -- index number
//		driver.switchTo().frame(); --- id and name attribute value
		WebElement objIframe=driver.findElement(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));
		driver.switchTo().frame(objIframe);
//		driver.findElementByXPath("//a[text()='Study our free HTML Tutorial »']//ancestor::div[@id='belowtopnav']//preceding-sibling::div[@id='pagetop']//descendant::a[@id='w3loginbtn']").click();
		driver.findElement(By.xpath("//a[text()='Study our free HTML Tutorial »']//ancestor::body//descendant::div[@id='pagetop']//a[@id='navbtn_menu']")).click();

	}

	public static void iFrame002() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");

		//		driver.switchTo().frame(1);

		WebElement weIframe=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
		driver.switchTo().frame(weIframe);
		driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[text()='Selenium']")).click();

	}

	public static void iFrame003() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

//		Frame--1
//	    driver.switchTo().frame(1);
//	    driver.switchTo().frame("frm1");
		WebElement weIframe_1= driver.findElement(By.xpath("//iframe[@id='google_esf']//preceding-sibling::body//descendant::div[@id='content-wrapper']//descendant::iframe[@id='frm1']"));
		driver.switchTo().frame(weIframe_1);
				
		WebElement weManu=driver.findElement(By.xpath("(//select[@id='selectnav2'])"));
		Select obj=new Select(weManu);
//		obj.selectByIndex(2);
//		obj.selectByValue("undefined");
	    obj.selectByVisibleText("Contact");

		driver.switchTo().defaultContent();

	    WebElement weModule=driver.findElement(By.xpath("//iframe[@id='google_esf']/preceding-sibling::body//descendant::ul[@id='nav1']//a[text()='Tutorials']"));
	    Actions act=new Actions(driver);
		act.moveToElement(weModule).perform();

//   Frame--2
//				driver.switchTo().frame("frm2");

		//		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("admin");
		//		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("admin");
		//		driver.findElement(By.xpath("//input[@id='englishchbx']")).click();
		//		driver.findElement(By.xpath("//input[@id='hindichbx']")).click();

		//		driver.findElement(By.xpath("//input[@id='femalerb']")).click();
		//		driver.findElement(By.xpath("//input[@id='malerb']")).click();
		//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ajaydubeyji@gmail.com");
		//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Selenium");

		//		driver.findElement(By.xpath("//select[@id='selectnav1']")).click();

		//		driver.switchTo().defaultContent();
		
		
//	Frame--3
		    WebElement  weIframe_3=driver.findElement(By.xpath("//iframe[@id='google_esf']/preceding-sibling::body//descendant::iframe[@id='frm3']"));
		    driver.switchTo().frame(weIframe_3);
		    
		

	}

	public static void iFrame004() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/iframes/");

		driver.findElement(By.xpath("//a[@id='cookie_action_close_header']")).click();

		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.switchTo().frame("oneid-iframe");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='input-InputIdentityFlowValue']")).sendKeys("ajaydubeyji@gmail.com");
		driver.findElement(By.xpath("//button[@id='BtnSubmit']")).click();

//		driver.switchTo().defaultContent();

//		driver.switchTo().frame("frame1");
//		driver.findElementById("navbarDropdown").click();


	}

}
