package actionsClass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DragAndDrop {

	public static void main(String[] args) {
		
		dragAndDrop();

		
		
	}
	
 public static void dragAndDrop() {
	 

	 
	 System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://localhost:8888");
	 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	 
	 WebElement obj=driver.findElement(By.xpath("//select[@name='login_theme']"));
	 Select sel=new Select(obj);
	 sel.selectByIndex(3);
	 driver.findElement(By.xpath("//input[@name='Login']")).click();
	 
	 Actions act=new Actions(driver);
	 WebElement source=driver.findElement(By.xpath("//b[text()=' Top Potentials']"));
	 WebElement target=driver.findElement(By.xpath("//b[text()=' Tag Cloud']"));
	 act.moveToElement(source).clickAndHold(source).release(target).build().perform();
//	 act.dragAndDrop(source, target).perform();
//	 act.dragAndDropBy(source, 0, 0).perform();
	 
 }

}
