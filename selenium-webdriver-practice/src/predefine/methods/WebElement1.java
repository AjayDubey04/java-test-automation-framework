package predefine.methods;

import predefine.methods.ChromeDriver1.List1;

public abstract class WebElement1  {

	
	public  WebElement1 findElement_( By1 locator ) {
		 WebElement1 obj=null;
		return obj;
		
	}
	
	public  List1<WebElement1> findElements_(By1 locator) {
		List1<WebElement1> obj=null;
		return obj;
	}
		
		public abstract String getText_() ;
		public abstract String getAttribute_(String value) ;
		public abstract String getTagName_() ;
		
		public abstract void click_() ;
		public abstract void clear_() ;
		
		public abstract boolean isDisplayed_();
		public abstract boolean isSelected_();
		public abstract boolean isEnabled_();
		
		public abstract Point1 getLocation_();
		
		public abstract Dimension1 getSize_() ;

	    public abstract void sendKeys(String charsequnce);

		
		public abstract class Dimension1 {
			
			public abstract int  getX_() ;
			public abstract int  getY_() ;
			
		}
		
		public void searchElement() {
			System.out.println("searching only one element on webpage");
		}

		public void searchElements() {
			System.out.println("searching more element on webpage");
		}
		
		public abstract void close() ;
		
		public abstract class Point1 {
			
			public abstract int getHeight_();
			public abstract int getWiedth_();
		}
}