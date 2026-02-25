package rahul.sir.zip.file;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class VtigerListWebElement {

		public static void main(String[] args) throws InterruptedException {

			VtigerListWebElement x=new VtigerListWebElement();
			//  x is a variable of type vtiger_list_webElement which has reference of Object of vtiger_list_webElement

			int y=10;
			String z=new String("");//  z is a variable of type String which has reference of Object of String

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-my selenium\\Selenium_practice\\driver\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();	driver.get("http://localhost:8888");

			WebElement weUserName=driver.findElement(By.name("user_name"));
			WebElement wePassword=driver.findElement(By.name("user_password"));
			WebElement weLogin=driver.findElement(By.name("Login"));

			ArrayList<WebElement> ylist=new ArrayList<WebElement>();
			ylist.add(weLogin);
			ylist.add(weUserName);
			ylist.add(wePassword);
			ylist.get(1).sendKeys("admin");
			ylist.get(2).sendKeys("admin");
			ylist.get(0).click();
			
			////////
			List<WebElement> listLinksObj=driver.findElements(By.xpath("//a"));
			int linkCount=listLinksObj.size();
			for(int i=0; i<=linkCount-1;i++) {
				WebElement weLinkObject=listLinksObj.get(i);
				String innerText=weLinkObject.getText();
				if(innerText.equals("")==false) {
					System.out.println(i+"-"+innerText);
				}
			}
			System.out.println("");
		//  print innertext of all tab links
		//innertexttext of A-Z buttons
			String[] arrStr=new String[3]; /// 
			arrStr[0]="hfjskfs";
			int[] arrInteger=new int[3];  ////
			WebElement[] arrWe=new WebElement[3];  //
			arrWe[0]=weUserName;
			arrWe[1]=wePassword;
			arrWe[2]=weLogin;
			VtigerListWebElement[] arrX=new VtigerListWebElement[3];  //
			arrX[0]=new VtigerListWebElement();
			arrX[1]=new VtigerListWebElement();
			arrX[2]=new VtigerListWebElement();
			Actions actions=new Actions(driver);
			WebElement weMarketing=driver.findElement(By.xpath("//a[text()='Marketing']"));;
			actions.moveToElement(weMarketing).build().perform();
			actions.moveToElement(driver.findElement(By.linkText("Leads"))).click().build().perform();
			List<WebElement> WeCheckboxList=driver.findElements(By.name("selected_id"));
			int CheckboxCount=WeCheckboxList.size();
			for(int i=0; i<=CheckboxCount-1;i++) {
				WebElement weCheckboxObject=WeCheckboxList.get(i);
				weCheckboxObject.click();
			}
	  //  absurd 
	//for (int i = 1; i <=CheckboxCount; i++) {
	//driver.findElement(By.xpath("(//input[@name='selected_id'])["+i+"]")).click();
	//}

			boolean actualCheakBoxSelected= driver.findElement(By.xpath("//input[@name=\"selectall\"]")).isSelected();
			boolean expectedCheakBoxSelected=true;
			if(actualCheakBoxSelected==expectedCheakBoxSelected) {
				System.out.println("expectedCheakBoxSelected is "+expectedCheakBoxSelected+" and actualCheakBoxSelected is "+actualCheakBoxSelected+" , it is match so it's passed");
			}else {
				System.out.println("expectedCheakBoxSelected is "+expectedCheakBoxSelected+" and actualCheakBoxSelected is "+actualCheakBoxSelected+" , it is mismatch so it's failed");
			}
			Thread.sleep(3000);
			WebElement CheakboxAll=driver.findElement(By.xpath("//input[@name=\"selectall\"]"));
			actions.moveToElement(CheakboxAll).doubleClick().build().perform();
			List<WebElement> SelectCheakBox=driver.findElements(By.xpath("//input[@name='selected_id']"));
			int SelectCheakBoxSize= SelectCheakBox.size();
			Thread.sleep(3000);
			for (int i = 1; i <=SelectCheakBoxSize; i++) {
				boolean actualBoxSelected=driver.findElement(By.xpath("(//input[@name='selected_id'])["+i+"]")).isSelected();
				boolean expectedBoxSelected=true;
				System.out.println(expectedBoxSelected);
				if(actualBoxSelected==expectedBoxSelected) {
					System.out.println(i+":-  CheakBox is selected so it's passed");
				}else {
					System.out.println(i+":- CheakBox is unselected  so it's failed");
				}
			}
			List<WebElement> Find_td=driver.findElements(By.xpath("//td"));
			int SizeFind_td= Find_td.size();
			System.out.println(" SizeFind_td:- "+SizeFind_td);

			List<WebElement> Find_tr=driver.findElements(By.xpath("//tr"));
			int SizeFind_tr= Find_tr.size();
			System.out.println(" SizeFind_tr:- "+SizeFind_tr);

			List<WebElement> Find_table=driver.findElements(By.xpath("//table"));
			int SizeFind_table= Find_table.size();
			System.out.println(" SizeFind_table:- "+SizeFind_table);

			List<WebElement> Find_input=driver.findElements(By.xpath("//input"));
			int SizeFind_input= Find_input.size();
			System.out.println(" SizeFind_input:- "+SizeFind_input);

			driver.findElement(By.xpath("//xyz"));///  NoSuchElementException
			/// emptyList List with 0 WebElement's Object
			List<WebElement> WeLinkText=driver.findElements(By.xpath("//xyz"));
			int LinktextSize= WeLinkText.size();
			System.out.println("Linktext=a==:- "+LinktextSize);



		}

	}


