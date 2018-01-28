import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	private static Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		String[] stringArray = new String[2];
		stringArray[0] = "Hello";
		stringArray[1] = "World";
		
		Integer[] intArray = new Integer[3];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		
		printArray(intArray);
		printArray(stringArray);
		
	}
	
	static <T> void printArray(T[] array) {
		for(Object entry:array) {
			logger.info(entry.toString());
			
			
		}
		
	}

}
