package encapsulation;

public class DataHiding {

	private static String str;

	public void setterMethod(String str) {
		this.str=str;
//		str=str;
	}
	
	public  String getterMethod() {
		return str;
	}

	public static void main(String[] args) {

	}
}



class TestHiding {

	public static void main(String[] args) {

		DataHiding obj=new DataHiding();
		System.out.println(obj.getterMethod());
		obj.setterMethod("java");
		String take=obj.getterMethod();
		System.out.println(take);
	}

}

