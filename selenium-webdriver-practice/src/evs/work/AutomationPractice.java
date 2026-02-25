package evs.work;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationPractice {

	public WebDriver driver;

	AutomationPractice(){

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	public static void main(String[] args)  {

		AutomationPractice obj=new AutomationPractice();
		/*
		 *  obj.verifyHomePage(); 
		 *  obj.new_Windows(); 
		 *  obj.alert();  
		 *  obj.datePicker(); 
		 *  obj.TextLabels();
		 *  obj.signUp();
		 *  obj.selectMenu();
		 *  obj.doubleClick();  		 
		 */
		 obj.signUp();
//		obj.dragAndDrop();

	}


	public void verifyHomePage() {

		String 	home_page_title=driver.getTitle();
		System.out.println("Home Page Title == "+home_page_title);

		String home_page_text=driver.findElement(By.xpath("//h1[@class='title']")).getText();
		System.out.println("Home Page Text == "+home_page_text);

	}


	public void new_Windows() {

		String we_text=driver.findElement(By.xpath("//div[@class='widget Wikipedia']/child::h2")).getText();
		System.out.println("===== "+we_text+" =====");

		WebElement we_search=driver.findElement(By.xpath("//form[@name='wikipedia']/descendant::input[@id='Wikipedia1_wikipedia-search-input']"));
		WebElement we_click=driver.findElement(By.xpath("//form[@name='wikipedia']/descendant::input[@class='wikipedia-search-button']"));

		we_search.sendKeys("");
		we_click.click();
		String text=driver.findElement(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']")).getText();
		if(text.equals("Please enter text to search.")) {
			System.out.println("Same as Expected Error");
		}else {
			System.out.println("Different as Expected Error");
		}


		we_search.sendKeys("Selenium");
		we_click.click();
		//       ===  Explicitly - Wait ===		
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement we_wait=driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Selenium_(software)']"));
		obj.until(ExpectedConditions.visibilityOf(we_wait)).click();


		//           ===   Window - Handle ===
		Set<String> windows_id=driver.getWindowHandles();
		/*
		 * Iterator<String> win=windows_id.iterator(); 
		 * String parent_window=win.next();
		 * String chield_window=win.next(); 
		 * driver.switchTo().window(chield_window);
		 */

		List<String> list_obj=new ArrayList(windows_id);
		driver.switchTo().window(list_obj.get(1));

		String title=driver.getTitle();
		System.out.println("New Webpage Title = "+title);

	}



	public void alert()  {

		String alert_text=driver.findElement(By.xpath("//div[@id='HTML9']/child::h2")).getText();
		System.out.println("===== "+alert_text+" =====");

		WebElement we_click=driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		we_click.click();
		driver.switchTo().alert().accept();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement we_alert_msg=driver.findElement(By.xpath("//p[@id='demo']"));
		String postive_msg_text=wait.until(ExpectedConditions.visibilityOf(we_alert_msg)).getText();
		System.out.println("Msg Text = "+postive_msg_text);

		we_click.click();
		String pop_text=driver.switchTo().alert().getText();
		System.out.println("Pop Text = "+pop_text);

		driver.switchTo().alert().dismiss();
		String negative_msg_text=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='demo']")))).getText();
		System.out.println("Msg Text = "+negative_msg_text);

	}


	public void datePicker()  {

		String date_picker_text=driver.findElement(By.xpath("//div[@id='HTML5']/child::h2")).getText();
		System.out.println("===== "+date_picker_text+" =====");      

		WebElement we_date_search_box=driver.findElement(By.xpath("//h2[text()='Date Picker']/parent::div/descendant::input"));
		we_date_search_box.click();


		WebElement we=driver.findElement(By.xpath("//a[text()='10']"));
		we.click();

	}


	public void selectMenu() {

		String we_select_text=driver.findElement(By.xpath("//div[@id='HTML6']/child::h2")).getText();
		System.out.println("== "+we_select_text+" ==");

		WebElement speed=driver.findElement(By.xpath("//label[@for='speed']"));
		System.out.println("First DropDown = "+speed.getText());
		WebElement  dd1=driver.findElement(By.xpath("//select[@id='speed']"));
		Select obj=new Select(dd1);
		obj.selectByVisibleText("Faster");


		WebElement file=driver.findElement(By.xpath("//label[@for='files']"));
		System.out.println("Second DropDown = "+file.getText());
		WebElement  dd2=driver.findElement(By.xpath("//select[@id='files']"));
		Select obj2=new Select(dd2);
		obj2.selectByValue("2");

		WebElement number=driver.findElement(By.xpath("//label[@for='number']"));
		System.out.println("Third DropDown = "+number.getText());
		WebElement  dd3=driver.findElement(By.xpath("//select[@id='number']"));
		Select obj3=new Select(dd3);
		obj3.selectByVisibleText("4");

		//		WebElement products=driver.findElement(By.xpath("//label[@for='products']"));
		//		System.out.println("Third DropDown = "+products.getText());
		WebElement  dd4=driver.findElement(By.xpath("//select[@id='products']"));
		Select obj4=new Select(dd4);
		obj4.selectByValue("Yahoo");

		//		WebElement animals=driver.findElement(By.xpath("//label[@for='animals']"));
		//		System.out.println("Third DropDown = "+animals.getText());
		WebElement  dd5=driver.findElement(By.xpath("//select[@id='animals']"));
		Select obj5=new Select(dd5);
		obj5.selectByValue("avatar");

	}


	public void TextLabels() {

		WebElement text_labels=driver.findElement(By.xpath("//div[@id='Text1']/child::h2"));
		System.out.println("== "+text_labels.getText()+" ==");

		Actions act=new Actions(driver);
		//		act.scrollToElement(text_labels).build().perform();
		act.scrollByAmount(107, 991).build().perform();

		List<WebElement> we_list=driver.findElements(By.xpath("//div[@class='widget Text']/child::div[@class='widget-content']/descendant::span"));
		int count=we_list.size();
		for(int i=0; i<count; i++) {
			String text=we_list.get(i).getText();
			System.out.println(text);
		}
	}


	public void xpathAxes() {

		WebElement we_xpath=driver.findElement(By.xpath("//div[@id='HTML14']/child::h2"));
		System.out.println("== "+we_xpath.getText()+" =");

		String we1=driver.findElement(By.xpath("//employee[@id='1']/child::empid")).getText();
		System.out.println(we1);

		String we2=driver.findElement(By.xpath("//employee[@id='1']/child::name")).getText();
		System.out.println(we2);

		String we3=driver.findElement(By.xpath("//employee[@id='1']/child::designation")).getText();
		System.out.println(we3);

		String we4=driver.findElement(By.xpath("//employee[@id='2']/child::name")).getText();
		System.out.println(we4);

		String we5=driver.findElement(By.xpath("//employee[@id='2']/child::email")).getText();
		System.out.println(we5);

		String we6=driver.findElement(By.xpath("//employee[@id='3']/child::email")).getText();
		System.out.println(we6);

	}


	public void signUp() {

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='post-body entry-content']/child::iframe")));

		String we_sign_up=driver.findElement(By.xpath("//div[@id='q19']/descendant::h1")).getText();
		System.out.println("== "+we_sign_up+" ==");


		driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input")).sendKeys("First Name");
		driver.findElement(By.xpath("//div[@id='q3']/child::input")).sendKeys("Mobile Number");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("8428786889");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("India");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Varanashi");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("evsexpert@gmail.com");


		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//label[text()='Sunday']")).click();

		Select obj=new Select(driver.findElement(By.className("drop_down")));
		obj.selectByValue("Radio-0");

		driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
		Set<String> hanle_value=driver.getWindowHandles();
		for (String string : hanle_value) {
			driver.switchTo().window(string);
			if(driver.getTitle().equalsIgnoreCase("Report Abuse")){
				driver.close();
			}
		}

		//  driver.findElement(By.id("FSsubmit")).click();

	}


	public void doubleClick() {

		String double_click_text=driver.findElement(By.xpath("//div[@id='HTML10']/child::h2")).getText();
		System.out.println("== "+double_click_text+" ==");

		Actions act=new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath("//div[@id='HTML10']/descendant::button"))).perform();

		String type_value=driver.findElement(By.xpath("//div[@id='HTML10']/descendant::input[@id='field2']")).getAttribute("type");
		System.out.println(type_value);

		String msg_text=driver.findElement(By.xpath("//input[@id='field2']/following-sibling::p")).getText();
		System.out.println(msg_text);

	}


	public void dragAndDrop() {
		String drag_and_drop_text=driver.findElement(By.xpath("//div[@id='HTML2']/child::h2")).getText();
		System.out.println("== "+drag_and_drop_text+" ==");

		Actions act=new Actions(driver);

		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(drag, drop).perform();


		// act.clickAndHold(drag).moveToElement(drag).release(drop).build().perform();
		System.out.println(drop.getText());
        
		
		
		
	}

	
	

	public void sidder() {

		
		
		
		
		
		
	}

}



