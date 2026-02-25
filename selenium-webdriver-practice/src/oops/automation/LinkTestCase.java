package oops.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import predefine.methods.VtigerLoginPage;

public class LinkTestCase extends VtigerLoginPage {

		static LinkTestCase obj=new LinkTestCase();

	public WebDriver verifyUpperLink() {
		
		WebDriver driver2=obj.loginVtiger();
		List<WebElement> gmailLink=driver2.findElements(By.xpath("//td[@style='padding-left:10px;padding-right:10px']"));
		int sizeCount=gmailLink.size();
		for(int i=0; i<sizeCount; i++) {
			String linkText=gmailLink.get(i).getText();
			System.out.println(linkText);
		}

		return driver2;
	}

	public WebDriver  verifyLowerLink(){

		WebDriver driver3=obj. verifyUpperLink();
		Actions act=new Actions(driver3);

		List<WebElement> link=driver3.findElements(By.xpath("//table[@class='hdrTabBg']/descendant::a[contains(@href,'index.php')]"));
		int count=link.size();
		for(int i=0; i<count; i++) {
			act.moveToElement(link.get(i)).perform();
			String downLinkText=link.get(i).getText();
			System.out.println(" == "+downLinkText+" == ");
		}
		
		return driver3;
	}

	public void TC003() {
		
		WebDriver driver4=obj.verifyLowerLink();
		driver4.findElement(By.xpath(""));
		
		
		
	}

	public static void main(String[] args) {
		
		LinkTestCase obj=new LinkTestCase();
		obj.loginVtiger();
		obj.verifyLowerLink();

	}
}
