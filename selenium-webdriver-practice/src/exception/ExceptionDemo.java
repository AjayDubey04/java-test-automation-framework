package exception;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import graphql.ExceptionWhileDataFetching;
import predefine.methods.VtigerLoginPage;

public class ExceptionDemo  {

	public WebDriver driver;


	public int returnType() {

		return 10;
		//		System.out.println("hii java"); [ unreachable code ]
	}


	public static void main(String[] args) throws InterruptedException {

		ExceptionDemo obj=new ExceptionDemo();
		obj.launchBrowser();
		/*
		 * obj.handle_demo_1(); obj.handle_demo_2(); obj.multiple_tryCatchBlock();
		 */

	}

	public  void launchBrowser()  {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		driver=new ChromeDriver(options);

		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");

		try {
			driver.findElement(By.className("Login")).click();
			System.out.println();

		}
		catch(Exception e){
			// solution of this exception 
			driver.findElement(By.name("Login")).click();
			/*
			 * System.out.println(e); e.printStackTrace();
			 * System.out.println(e.getMessage());
			 */

		}

	}


	public  void handle_demo_1() {	

		try {

			driver.findElement(By.linkText("keting")).click();
			System.out.println("this is try block of ExceptionHandlingDemo_1 ");
		}

		catch(Exception e) {

			driver.findElement(By.linkText("Marketing")).click();
			System.out.println("this is try block of ExceptionHandlingDemo_1 ");
			/*
			 * e.printStackTrace(); throw e; System.out.println("Hii"); [ unreachable code ]
			 */
		}

		String title=driver.getTitle();
		System.out.println("HomePage Title = "+title);


	}


	public  void handle_demo_2() {		

		try { 
			List<WebElement> we=driver.findElements(By.xpath("//table[@class='level2Bg']//descendant::ajhjh"));
			System.out.println("Size of Marketing sub link list = "+we.size());

		}
		catch(Exception n) { 
			n.printStackTrace(); 
			System.out.println("Hello link list");
		}

	}


	public void multiple_tryCatchBlock() {

		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		try {
			driver.findElement(By.xpath("//input[@name='campaignnameJAVA']")).sendKeys("Try Catch Block");
			System.out.println("first try block");

		}

		catch(NoSuchElementException n) {
			System.out.println("First catch block");
			try {
				driver.findElement(By.className("//input[@name='campaignname']")).sendKeys("Try Catch Block");
				System.out.println("first inner try block");
			}
			catch(InvalidSelectorException in) {
				System.out.println("first inner catch block");
				driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Try Catch Block");

			}catch(NoSuchElementException a) {
				System.out.println("second inner catch block");
				driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Try Catch Block");
			}

		}
		catch(TimeoutException t) {
			System.out.println("Second catch block");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		catch(StaleElementReferenceException s) {
			System.out.println("Third catch block");
			driver=new ChromeDriver();

		}finally {
			System.out.println("finally always excuted");
			driver.findElement(By.xpath("//input[@name='campaignname']/parent::td/parent::tr/preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")).click();
			driver.close();

		}

	}


}
