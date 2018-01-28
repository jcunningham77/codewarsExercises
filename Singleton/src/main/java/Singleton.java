
public class Singleton {
	
	public static String str;
	
	private static Singleton instance;
	
	private Singleton() {
	}
	
	static Singleton getSingleInstance() {
		
		if (instance==null) {
			instance = new Singleton();
		}
		
		return instance;
		
	}

}
