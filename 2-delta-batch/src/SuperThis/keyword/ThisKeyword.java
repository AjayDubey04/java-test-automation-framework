package SuperThis.keyword;

public class ThisKeyword {
 
	private int a;
	
	ThisKeyword(){
		System.out.println("this is non parameterize constructor");
	}
	
	ThisKeyword(ThisKeyword str){
		this();
		System.out.println("this is  parameterize constructor");
	}
	
	public static void main(String[] args) {
		
		ThisKeyword obj=new ThisKeyword();
         obj.method();
         
	}
	
	public void method() {
		int a=5;
		System.out.println(a);
		System.out.println(this.a);
	}
	
	public ThisKeyword method2(ThisKeyword obj) {
		return this;
	}
	
	public void method3() {
		ThisKeyword obj=new ThisKeyword(this);
        obj.method2(this);
	}
	

}
