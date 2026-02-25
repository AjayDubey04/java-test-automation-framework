package xpath;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ListElement {

	public static void main(String[] args) throws InterruptedException {

		ListElement obj=new ListElement();
		obj.listWebElement001();
		obj.listWebElement002();
		obj.listWebElement003(); 
		obj.listWebElement004();

	}
	public  void listWebElement001(){

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		WebElement weUserName=driver.findElement(By.name("user_name"));
		WebElement wePassword=driver.findElement(By.name("user_password"));
		WebElement weLogin=driver.findElement(By.name("Login"));	

		ArrayList<WebElement> obj=new ArrayList<WebElement>();
		obj.add(weUserName);
		obj.add(wePassword);
		obj.add(weLogin);

		obj.get(0).sendKeys("admin");
		obj.get(1).sendKeys("admin");
		obj.get(2).click();


		//		driver.findElementByXPath("//img[@src='themes/images/settings_top.gif']").click();
		//		Thread.sleep(4000);
		//		List<WebElement> weModuleLink=driver.findElementsByXPath("//input[@type='checkbox']");
		//		int moduleCount=weModuleLink.size();
		//		System.out.println(moduleCount);
		//		for(int i=0; i<moduleCount; i++) {
		//			weModuleLink.get(i).click();
		//			
		//		}


		List<WebElement> weLink=driver.findElements(By.xpath("//a"));
		int count=weLink.size();
		for(int j=0; j<count; j++) {
			String linktext=weLink.get(j).getText();
			if(linktext.equals("")==false)
				System.out.println(linktext);
		}

		Actions act=new Actions(driver);
		WebElement weMarketing=driver.findElement(By.linkText("Marketing"));
		act.moveToElement(weMarketing).click(weMarketing).build().perform();

		WebElement upperCheckBox=driver.findElement(By.xpath("//input[@name='selectall']"));
		upperCheckBox.click();

		List<WebElement> listLowerCheckbox=driver.findElements(By.xpath("//input[@name='selected_id']"));
		int listcount=listLowerCheckbox.size();

		for(int i=1; i<=listcount; i++) {
			boolean checkboxes=driver.findElement(By.xpath("(//input[@name='selected_id'])["+i+"]")).isSelected();
			if(checkboxes==true) {
				System.out.println(i+" LowerCheckBox Passed");
			}else {
				System.out.println(i+" LowerCheckBox Failed");
			}
		}

		upperCheckBox.click();

		for(int i=0; i<listcount; i++) {
			WebElement getLower=listLowerCheckbox.get(i);
			getLower.click();
			//			driver.findElementByXPath("(//input[@name='selected_id'])["+i+"]").click();
		}
		boolean  checkBox= upperCheckBox.isSelected();
		if( checkBox==true) {
			System.out.println("Top CheckBox Passed");
		}else {
			System.out.println("Top CheckBox Failed");
		}
	}

	public  void listWebElement002() {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		List<WebElement> weLink=driver.findElements(By.xpath("//a"));
		int count=weLink.size();
		for(int j=0; j<count; j++) {
			String linktext=weLink.get(j).getText();
			if(linktext.equals("")==false)
				System.out.println(linktext);
		}


		driver.findElement(By.linkText("Sales")).click();

		List<WebElement> weLatter=driver.findElements(By.xpath("//td[@class='searchAlph']"));
		int a=weLatter.size();
		for(int i=0; i<a; i++) {
			String text=weLatter.get(i).getText();
			System.out.print(text+",");
		}


		List<WebElement>  listSize=driver.findElements(By.xpath("//input[@name='selected_id']"));
		int length=listSize.size();
		for(int i=1; i<=length; i++) {
			driver.findElement(By.xpath("(//input[@name='selected_id'])["+i+"]")).click();
		}

		WebElement we=driver.findElement(By.xpath("//input[@name='selectall']"));
		boolean  actualStatus=we.isSelected();
		if(actualStatus==true) {
			System.out.println("Selectall Passed");
		}else {
			System.out.println("Selectall Failed");
		}

		we.click();
		we.click();
		for(int i=1; i<=length; i++) {
			boolean  allCheckBoxStatus=driver.findElement(By.xpath("(//input[@name='selected_id'])["+i+"]")).isSelected();
			if(allCheckBoxStatus==true) {
				System.out.println(i+" CheckBox Passed ");
			}else {
				System.out.println(i+" CheckBox Failed ");
			}
		}



		List<WebElement> find_a=driver.findElements(By.tagName("a"));
		System.out.println("TagName a      = "+find_a.size());

		List<WebElement> findInput=driver.findElements(By.tagName("input"));
		System.out.println("TagName input  = "+findInput.size());

		List<WebElement> findSelect=driver.findElements(By.tagName("select"));
		System.out.println("TagName select = "+findSelect.size());

		List<WebElement> count_4=driver.findElements(By.tagName("td"));
		System.out.println("TagName td    = "+count_4.size());

		List<WebElement> count_5=driver.findElements(By.tagName("table"));
		System.out.println("TagName table = "+count_5.size());

		List<WebElement> count_6=driver.findElements(By.tagName("b"));
		System.out.println("TagName b     = "+count_6.size());

		List<WebElement> count_7=driver.findElements(By.tagName("div"));
		System.out.println("TagName div   = "+count_7.size());

		List<WebElement> count_8=driver.findElements(By.tagName("img"));
		System.out.println("TagName img   = "+count_8.size());

		List<WebElement> count_9=driver.findElements(By.tagName("tr"));
		System.out.println("TagName tr    = "+count_9.size());

		List<WebElement> count_10=driver.findElements(By.tagName("tbody"));
		System.out.println("TagName tbody = "+count_10.size());

		List<WebElement> count_11=driver.findElements(By.tagName("script"));
		System.out.println("TagName script = "+count_11.size());

		List<WebElement> count_12=driver.findElements(By.tagName("form"));
		System.out.println("TagName form   = "+count_12.size());


	}
	public   void listWebElement003() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(4000);

		driver.findElement(By.linkText("Marketing")).click();
		driver.navigate().back();
		List<WebElement> weBox=driver.findElements(By.xpath("//tr[@class='headerrow']"));
		for(int i=1; i<weBox.size(); i++) {
			WebElement weText=driver.findElement(By.xpath("(//tr[@class='headerrow'])["+i+"]"));
			String weBoxText=weText.getText();
			Point loct= weText.getLocation();

			int x=loct.getX();
			int y=loct.getY();

			System.out.println(weBoxText);
			System.out.println(x+" "+y);

		}


		System.out.println();

		List<WebElement> weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
		for(int i=0; i<weTabLink.size(); i++) {
			weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php')]"));
			String weTabText=weTabLink.get(i).getText();
			System.out.println(weTabText);
			weTabLink.get(i).click();

			WebElement weModule=driver.findElement(By.xpath("//td[@class='moduleName']"));
			System.out.println(" Module Name "+weModule.getText());

			Dimension weSiz=weModule.getSize();

			System.out.println(" TabLink Size "+weSiz.height+" "+weSiz.width);

			Point weloction=weModule.getLocation();
			System.out.println(" TabLink Location "+weloction.getX()+" "+weloction.getY());

		}

	}

	public  void listWebElement004() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		// == V-tiger Login == //
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");

		//  == DropAnddown Count == //
		WebElement wedd=driver.findElement(By.xpath("//select[@name='login_theme']"));
		Select obj=new Select(wedd);		
		List<WebElement> we=obj.getOptions();
		int weSize=we.size();
		System.out.println(weSize);

		driver.findElement(By.name("Login")).click();

		// == TabLink == //
		System.out.println(" // == TabLink == // ");
		List<WebElement> weTabLink=driver.findElements(By.xpath("//table[@class='hdrTabBg']//descendant::a[contains(@href,'index.php')]"));
		int linkCount=weTabLink.size();
		for(int i=0; i<linkCount; i++) {
			WebElement linkGetText=weTabLink.get(i);
			String tabInnerText=linkGetText.getText();
			System.out.println(tabInnerText);
		}

		// == WebPage Heading == //
		System.out.println(" // == WebPage Heading == // ");
		List<WebElement> webBox=driver.findElements(By.xpath("//div[@id='MainMatrix']//descendant::tr[@class='headerrow']//b"));
		int webBoxCount=webBox.size();
		for(int i=0; i<webBoxCount; i++) {
			WebElement weBoxText=webBox.get(i);
			String WebBoxInnerText= weBoxText.getText();
			System.out.println(WebBoxInnerText);
		}

		// == Module Heading == //
		System.out.println(" // == Module Heading == // ");
		List<WebElement> weInnerText=driver.findElements(By.xpath("//table[@class='hdrNameBg']//td[@class='small']"));
		int moduleCount=weInnerText.size();
		for(int i=0; i<moduleCount; i++) {
			String linkText=weInnerText.get(i).getText();
			System.out.println(linkText);
		}


		// == Not Found Heading == //
		System.out.println(" // == Not Found Heading == // ");
		Thread.sleep(4000);
		List<WebElement> weNotFound=driver.findElements(By.xpath("//div[@class='componentName']"));
		int notFoundCount=weNotFound.size();
		for(int i=0; i<notFoundCount; i++) {
			String notFoundText=weNotFound.get(i).getText();
			System.out.println(i+1+":- "+notFoundText);
		}

		// == Module CheckBox == //
		driver.findElement(By.xpath("//img[@src='themes/images/settings_top.gif']")).click();
		Thread.sleep(4000);
		List<WebElement> weModuleLink=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int CheckBoxCount=weModuleLink.size();
		for(int i=0; i<CheckBoxCount; i++) {
			weModuleLink.get(i).click();
		}

	}

}


