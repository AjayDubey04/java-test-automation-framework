package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelectorXpaths {

	public static void main(String[] args) {

		css_selector();

	}



	public static void css_selector() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);

		driver.get("http://localhost:8888");	

		// TagName[attribute=value]
		driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys("admin");

		// TagName.valueOfClass[attribute=value]
		driver.findElement(By.cssSelector("input.small[name='user_password']")).sendKeys("admin");


		driver.findElement(By.cssSelector("input[name='Login']")).submit();
		driver.findElement(ById.linkText("Marketing")).click();

		// tagName#valueOfId attribute
		driver.findElement(By.cssSelector("select#bas_searchfield")).click();

		//	tagName.valueOfclass 
		driver.findElement(By.cssSelector("input.txtBox")).sendKeys("Hello");

		//	subString (startWith=^, endWith=&, contains=* , Syntax=tagname[attribute^=substring]  )
        //	Syntax of startWith=^ 
		driver.findElement(By.cssSelector("img[title^='Create']")).click();
		
		// Syntax of endWith=&
		driver.findElement(By.cssSelector("input[name$='paignname']")).sendKeys("Ram");
		
		// Syntax of contains=*
		driver.findElement(By.cssSelector("input[class*='save']")).click();
		

	}

}
