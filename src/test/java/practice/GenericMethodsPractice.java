package practice;

public class GenericMethodsPractice {
	
	public static void main(String[] args) { //Caller Function
		
//		int a = 10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,30));
		add(30,sum);
		add(40,50);
	}
	
	public static int add(int a, int b) //Called function - generic
	{
		
		int c = a+b;
		return c;
	}
	
	public static int add(int a, int b, int d) //Called function - generic
	{
		
		int c = a+b+d;
		return c;
	}

}
