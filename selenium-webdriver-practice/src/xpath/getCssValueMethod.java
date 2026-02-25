package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import predefine.methods.VtigerLoginPage;

public class getCssValueMethod extends VtigerLoginPage {

	public WebDriver driver;

	public static void main(String[] args) {

		getCssValueMethod obj=new getCssValueMethod();
		obj.getCssValue();

	}


	public void getCssValue() {

		driver=loginVtiger();

		// it returns font size and color of the elements in form of string
		String value=driver.findElement(By.cssSelector("td.moduleName")).getCssValue("font-weight");
		System.out.println(value);

		// inside partialLinktext we give the value as like contains form
		driver.findElement(By.partialLinkText("keting")).click();  

		// inside Linktext we have to give full inner text value of hyperlink
		driver.findElement(By.partialLinkText("Sales")).click();  

		// it returns all html source code  in form of string on console 
		String page=driver.getPageSource();
		System.out.println(page);
		
	}

}
