package TestListners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ITestListner.class)
public class MyListner {

 
	@Test
	public void m1() {
		System.out.println("Hello Listner");
	}


}
