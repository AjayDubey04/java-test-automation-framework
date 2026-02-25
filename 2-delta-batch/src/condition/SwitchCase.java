package condition;

import java.util.Scanner;
public class SwitchCase {

	public static void main(String[] args) 
	{
//		Scanner();
		calculatoer();
//		Switch();
//		condition();
	}
	public static void condition() {
		
	
		int i=7;
		
		switch(i) {
		case 1:{
			System.out.println("new");
			break;
		}
		case 2:{
			System.out.println("two");
			break;
		}
		case 3:{
			System.out.println("three");
			break;
		}
		default:{
			System.out.println("unexpected value:"+i);
			break;
		}
		case 5:{
			System.out.println("five");
		}
		}
	}
	
public static void Switch()
{
			char a='G';
			switch (a) {
			case 'R':{
				System.out.println("Red");
				break;
			}
			case 'G':{
				System.out.println("Green");
				break;
			}
			case 'B':{
				System.out.println("Blue");
				break;
			}
			default:{
				System.out.println("unexpected colour: "+a);
				break;
			}
			}
		}

public static void Scanner()
{
	System.out.println("Switch Case");
	
			String name;
		Scanner sc=new Scanner (System.in);
		 name=sc.next();
		
		switch (name) {
		case "A" :
			System.out.println("hii");
				break;
			
		case "B":
			System.out.println("Hello");
			break;

		case "C":
			System.out.println("java");
			break;
	
		default :
			System.out.println("unexpected name "+name);
		}	
		System.out.println("Ajay Hello");
		
		}

public static void calculatoer()
{
	System.out.println("calculater");
	
	String opr="";
	Scanner sc=new Scanner (System.in);
	int num1=sc.nextInt();
	opr=sc.next();
	switch(opr) {
	case "+":{
		int num2=sc.nextInt();
		System.out.println(num1+num2);
		break;
	}
	case "-":{
		int num2=sc.nextInt();
		System.out.println(num1-num2);
		break;
	}
	case "*":{
		int num2=sc.nextInt();
		System.out.println(num1*num2);
		break;
	}
	case "/":{
		int num2=sc.nextInt();
		System.out.println(num1/num2);	
		break;
	}
	case "%":
		int num2=sc.nextInt();
		System.out.println(num1%num2);
	break;

	}
	}
}

