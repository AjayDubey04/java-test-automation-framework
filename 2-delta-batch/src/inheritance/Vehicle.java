package inheritance;

public class Vehicle {

	
	public Vehicle() {
		System.out.println("Parent consturctor");
	}
	

	{
		System.out.println("parent non static block");
	}
	
	

	static {
		System.out.println("parent static block");
	}
	
	

	public void run() {
		System.out.println("parent method ");
	}

	public static void main(String[] args) {

	}
}


//     child          // parent
class MotorCar extends Vehicle {

	MotorCar(){
		System.out.println("MotorCar constructor");
	}

	{
		System.out.println("MotorCar Non static block");
	}

	static {
		System.out.println("MotorCar  static block");
	}

	public void stop() {
		System.out.println("child method ");
	}


	public static void main(String[] args) {
		MotorCar obj=new MotorCar();
		obj.stop();
		
		Vehicle obj1=new MotorCar();
		obj1.run();
		
		Vehicle obj2=new Vehicle();
		obj2.run();

	}


}
