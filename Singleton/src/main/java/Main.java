
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string = "Hello World";
		
		Singleton s1 = Singleton.getSingleInstance();
		
		s1.str = "This is the string set after initializing the first singleton";
		Singleton s2 = Singleton.getSingleInstance();
		
//		Singleton s3 = new Singleton();
		
		
		System.out.println(s1.str);
		
		System.out.println(s2.str);
		
		s2.str = "now changing the string";
		
		System.out.println(s1.str);
		
		System.out.println(s2.str);
		

	}

}
