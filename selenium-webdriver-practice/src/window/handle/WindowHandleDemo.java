package window.handle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WindowHandleDemo  {

	public WebDriver driver;

	public WindowHandleDemo() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

	}

	public static void main(String[] args) {

		WindowHandleDemo obj=new WindowHandleDemo();
		obj.listWindowHandle();

	}

	public void loginForWindowHandle() {

		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

	}


	public void mainWindowHandleOnly() {

		loginForWindowHandle();

		String main_window_handle_value=driver.getWindowHandle();
		System.out.println(main_window_handle_value);


		driver.get("http://localhost:8888");;
		String main_window_handle_value1=driver.getWindowHandle();
		System.out.println(main_window_handle_value1);

		driver.findElement(By.partialLinkText("Feedback")).click();
		driver.findElement(By.partialLinkText("Help")).click();
		driver.findElement(By.partialLinkText("About Us")).click();

		String main_window_handle_value2=driver.getWindowHandle();
		System.out.println(main_window_handle_value2);

		driver.switchTo().newWindow(WindowType.TAB);
		String main_window_handle_value3=driver.getWindowHandle();
		System.out.println(main_window_handle_value3);

	}


	public void listWindowHandle() {

		loginForWindowHandle();

		driver.findElement(By.partialLinkText("Feedback")).click();
		driver.findElement(By.partialLinkText("Help")).click();
		driver.findElement(By.partialLinkText("About Us")).click();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		//		driver.findElement(By.name("close")).click();

		Set<String>  window_value=driver.getWindowHandles();
		//		System.out.println(window_value.size());

		/*
		 * for (String list_handle_value : window_value) {
		 * driver.switchTo().window(list_handle_value); 
		 * String url=driver.getCurrentUrl(); 
		 * System.out.println(url);
		 * if(url.equals("about:blank")) { 
		 * driver.get("http://facebook.com"); 
		 * }else {
		 * driver.close(); } }
		 */

		List<String> listVaue=new ArrayList(window_value);
		System.out.println(listVaue.size());

		for(int i=0; i<listVaue.size(); i++) { 
			String count=listVaue.get(i);
			System.out.println(count);
			}
		
		driver.switchTo().window(listVaue.get(3));
		driver.findElement(By.name("close")).click();

		} 	  

}


