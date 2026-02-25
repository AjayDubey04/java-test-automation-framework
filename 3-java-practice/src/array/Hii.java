package array;

public class Hii extends Hello {



	public volatile String jh="hello";
	public transient String jhj="hello";



	public synchronized static void m5() {

	}


	@Deprecated
	public static void main(String[] args) {
		Hii h=new Hii();
		System.out.println(h);
		h.mop();
	}



	public String st;

	public Hii() {	
		this(5);
		String st=null;
		this.st=st;
	}


	private Hii (int a) {
		super("hello");
	}


	public void m1(Hii h) {
		System.out.println(super.st);
		super.mop();
	}

	public Hii m2() {
		System.out.println(this);
		return this;
	}



}
