package actionsClass;

import org.openqa.selenium.interactions.Actions;

public class ActionsClassMethods {

	public static void main(String[] args) {
		
		Actions act=new Actions(null);
		act.click();
		act.click(null);
		act.clickAndHold();
		act.clickAndHold(null);
		act.contextClick();
		act.contextClick(null);
		act.doubleClick();
		act.doubleClick(null);
		act.dragAndDrop(null, null);
		act.dragAndDropBy(null, 0, 0);
		act.moveByOffset(0, 0);
		act.moveToElement(null);
		act.moveToElement(null, 0, 0);
		act.release();
		act.release(null);
		act.sendKeys("");
		act.sendKeys("", "");
		act.build();
		act.perform();


	}

}
