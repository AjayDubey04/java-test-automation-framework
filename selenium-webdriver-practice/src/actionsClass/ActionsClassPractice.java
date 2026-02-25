package actionsClass;



import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsClassPractice {

	//	these are some method of Actions class
	//	click(), clickAndHold(), doubleClick(), sendKeys(), moveToElement(),
	//	contextClick(), drogAndDrop(), release(),
	//	these method is overloaded method // 
	//	every and each method of actions class are parameterize and non parameterize //
	// dropAndDrap start from crosShair // 

	public static void main(String[] args) {

		actions();
		// dragAndDrop();
		
	}

	public static void actions() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		Actions act=new Actions(driver);
		//		username.sendKeys("admin");
		//		act.sendKeys("admin").build().perform();
		act.sendKeys(username, "admin").perform();

		WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
		//		password.sendKeys("admin");
		//		act.sendKeys("admin").perform();
		act.sendKeys(password, "admin").build().perform();

		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		//		login.click();
		//		act.click().perform();
		act.click(login).build().perform();

		WebElement Marketing=driver.findElement(By.xpath("//a[text()='Marketing']"));
		//	    act.moveToElement(Marketing).perform();
		act.moveToElement(Marketing).click().perform();

		//	    Point add= Marketing.getLocation();
		//	    int y=add.getY();
		//	    int x=add.getX();
		//	    System.out.println(x+","+y);
		//	    act.moveByOffset(189, 55).build().perform();
		//	    act.moveToElement(Marketing, 189, 55).build().perform();

		WebElement leads=driver.findElement(By.xpath("(//a[text()='Leads'])[3]"));
		act.click(leads).build().perform();
		//	    act.doubleClick(leads).build().perform();


		WebElement plush=driver.findElement(By.xpath("//img[@title='Create Lead...']"));
		act.contextClick(plush).build().perform();
		//		act.contextClick();


	}

	public static void dragAndDrop() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		Actions act=new Actions(driver);
		WebElement weDrag=driver.findElement(By.xpath("//b[contains(text(),'Tag Cloud')]"));
		WebElement weDrop=driver.findElement(By.xpath("//b[contains(text(),'My Recent FAQs')]"));
		act.clickAndHold(weDrag).moveToElement(weDrop).release().build().perform();
		//		act.dragAndDrop(weDrag, weDrop).build().perform();

		WebElement WeDrag1=driver.findElement(By.xpath("//b[contains(text(),'Top Accounts')]"));
		WebElement WeDrop1=driver.findElement(By.xpath("//b[contains(text(),'My New Leads')]"));
		act.dragAndDrop(WeDrag1, WeDrop1).perform();

		//		Point add=WeDrop1.getLocation();
		//		int x=add.getX();
		//		int y=add.getY();
		//		System.out.println("Size"+x+","+y);
		//		act.dragAndDropBy(WeDrag1, x, y).perform();

	}

}
