package window.handle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;

import predefine.methods.VtigerLoginPage;

public class GetWindowHandleMethods extends VtigerLoginPage{



	public static void getWindowSwitchByUrl(WebDriver driver,String expected_url) {

		Set<String> handle_value=driver.getWindowHandles();
		for (String listvalue : handle_value) {
			driver.switchTo().window(listvalue);
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase(expected_url)) {
				break;
			}
		}
	}


	public static void getWindowSwitchByTitle(WebDriver driver,String expected_title) {

		Set<String> handle_value=driver.getWindowHandles();
		for (String listvalue : handle_value) {
			driver.switchTo().window(listvalue);
			String title=driver.getTitle();
			if(title.equalsIgnoreCase(expected_title)) {
				break;
			}
		}
	}


	public static void mainWindowHandle(WebDriver driver) {

		String handle_value=driver.getWindowHandle();
		System.out.println(handle_value);

	}


	public static void closeWindowByHandleValue(WebDriver driver,String expected_title) {

		Set<String> handle_value=driver.getWindowHandles();
		for (String listvalue : handle_value) {
			driver.switchTo().window(listvalue);
			driver.close();
			String title=driver.getTitle();
			if(title.equalsIgnoreCase(expected_title)) {
				System.out.println("Now you are ready to excute");
			}else {
			
			}
		}
	}

}


