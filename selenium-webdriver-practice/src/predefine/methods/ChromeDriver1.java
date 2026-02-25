package predefine.methods;

public  class ChromeDriver1 {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * WebElement1 obj=new WebElement1();
	 * 
	 * ChromeDriver1 obj1=new ChromeDriver1();
	 * 
	 * WebElement1 obj3= new ChromeDriver1();
	 * 
	 * // ChromeDriver1 obj2=new WebElement1();
	 * 
	 * }
	 */
	
	public  WebElement1 findElement_( By1 locator ) {
		 WebElement1 obj=null;
		return obj;
		
	}
	
	public  List1<WebElement1> findElements_(By1 locator) {
		List1<WebElement1> obj=null;
		return obj;
	}
	
	
	public String getTitle_() {
		String str=null;
		return str;
	}
	
	public String getCurrentUrl_() {
		String str=null;
		return str;
	}
	
	public TargetLocator1 switchTo_() {
		TargetLocator1 obj=null;
		return obj;
	}
	
	public Navigation1 navigate_() {
		Navigation1 obj=null;
		return obj;
	}
	
	public void close_() {
		System.out.println();
	}
	public void quit_() {
		System.out.println();
	}
	
	public void get_(String url) {
		System.out.println(url);
	}

	
	
	public abstract class List1<WebElement> {
		
		
		public static void get_(int index) {
			System.out.println(index);
		}
		
		public static  int size_() {
			int count=0;
			System.out.println(count);
			return count;
		}
		
		public static void add_(String add) {
			System.out.println(add);
		}
		
		
	}
	
}		
	
	



