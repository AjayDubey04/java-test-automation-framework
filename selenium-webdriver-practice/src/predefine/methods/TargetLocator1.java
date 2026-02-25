package predefine.methods;

public abstract class TargetLocator1 {
	
	static WebDriver obj;
	
	public abstract WebDriver frame_(int type);
	
	public abstract WebDriver frame_(String type);
	
	public abstract WebDriver frame_(WebElement1 type);
	
	public abstract WebDriver defaultContent_();
	
	public abstract WebDriver parentFrame_();
	
	public abstract Alert1 alert_();
	
	

	public abstract class WebDriver {
	
		
		
	}
	
	
	public abstract class Alert1 {

		
		public abstract void accept_();

		public abstract void sendKeys_(String str);
		
		public abstract void dismiss_();
		
		public abstract String getText_();
	}

}
