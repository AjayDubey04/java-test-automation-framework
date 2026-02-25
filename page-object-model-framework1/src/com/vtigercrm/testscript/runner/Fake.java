package com.vtigercrm.testscript.runner;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Fake {
	
	
	public static void main(String[] args) {
		
		 Map<String,String> mp=new HashMap<String,String>();
			mp.put("Name","Ajay");
			mp.put("Name","Hello");
			String hi=mp.get("Name");
		   System.out.println(hi);
		   
		   Map<String,Integer> m=new HashMap<String,Integer>();
			m.put("num",353);
			m.put("num",84878);
			int h=m.get("num");
		   System.out.println(h);
		   
	}
	
	public static void mains(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "Driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement we=driver.findElement(By.xpath("//td[text()='Language']"));
		Select st=new Select(we);
		WebElement text=st.getWrappedElement();
		System.out.println(text);
		
		// example of InvalidArgumentException
		// driver.get("www.invalid-url-123456.com");
		
		// example of WebDriverException
		driver.get("http://www.invalid-url-123456.com");
		
		// example of NoSuchWindowException
		driver.get("http://localhost:8888");
		driver.close();
		System.out.println(driver.getTitle());
		
		// example of NoSuchFrameException 
		  driver.switchTo().frame("nonExistentFrame");
         System.out.println(driver.getTitle());
		
        
		
	}
	

}
