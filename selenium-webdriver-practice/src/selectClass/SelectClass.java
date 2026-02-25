package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {

		dropDown();

	}

	public static void dropDown() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");

		WebElement coloTheam=driver.findElement(By.name("login_theme"));
		Select obj=new Select(coloTheam); 
		obj.selectByVisibleText("bluelagoon");
		obj.selectByIndex(3);
		obj.selectByValue("softed");

//		obj.getOptions()  // it returns List<WebElement>
		
		//		obj.deselectAll();
		//		obj.deselectByIndex(0);
		//		obj.deselectByValue(null);
		//		obj.deselectByVisibleText(null);

		boolean type=obj.isMultiple();
		if(type==true) {
			System.out.println("ColorTheam DropDown Is Single Selection");
		}else {
			System.out.println("ColorTheam DropDown Is Multi Selection");
		}
         
		String expected="softed";
		WebElement defaultValue=obj.getFirstSelectedOption();
		String text=defaultValue.getText();
		if(expected.equalsIgnoreCase(text)) {
			System.out.println("Softed is ByDefault Value");
		}else {
			System.out.println("Softed is Not ByDefault Value");
		}
		
		WebElement language=driver.findElement(By.name("login_language"));
		Select objOflang=new Select(language);
		objOflang.selectByIndex(3);
		objOflang.selectByVisibleText("DE Deutsch");
		objOflang.selectByValue("en_us");

		boolean type2=objOflang.isMultiple();
		if(type2==true) {
			System.out.println("Language DropDown Is Single Selection");
		}else {
			System.out.println("Language DropDown Is Multi Selection");
		}
		
		String expectedOflang="US English";
		WebElement defaultValueOflang=obj.getFirstSelectedOption();
		String textOflang=defaultValueOflang.getText();
		if(expectedOflang.equalsIgnoreCase(textOflang)) {
			System.out.println("US English is ByDefault Value");
		}else {
			System.out.println("US English is ByDefault Value");
		}
		
		driver.findElement(By.name("Login")).click();
		
		driver.findElement(By.linkText("Marketing")).click();
		
//		WebElement champain=driver.findElement(By.id("qccombo"));
//		Select champ=new Select(champain);
//		champ.selectByValue("Campaigns");
		
		WebElement search=driver.findElement(By.id("bas_searchfield"));
		Select field=new Select(search);
		field.selectByValue("assigned_user_id");
		
		WebElement view=driver.findElement(By.id("viewname"));
		Select name=new Select(view);
		 name.selectByValue("29");
		
		driver.findElement(By.linkText("New")).click();
	}

}
