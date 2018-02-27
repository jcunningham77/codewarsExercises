import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
	
	
	public static void main(String[] args) {
		
		String prefix = "Mr.";
		
		System.out.println(processString("Hello World", str -> {
			return prefix.concat(str);
		}));
		
		
		System.out.println(processString("Hello World!", prefix::concat));
		System.out.println(processString("Hello World!", String::toLowerCase));
		System.out.println(processString2("Hello World!", 4, String::substring));
		
		String[] names = {"Dr Sanjay", "Mz Tripti", "Mr Smith", "Mrs Cunningham"};
		
		
		System.out.println("Names array, before sorting by last name: ");
		for (String name : names) {
			System.out.println(name);
		}
		
		//java 7 sorting style
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.toString().split(" ")[1].compareTo(o2.toString().split(" ")[1]);
			}
			
		});
		
		System.out.println("Names array, after sorting by last name: ");
		
		for (String name : names) {
			System.out.println(name);
		}
		
		//java 8 sorting style - lambda expression
		
		String[] names2 = {"Dr Phillips", "Mz Czepiel", "Mr Morrison", "Mr Cunningham"};
		System.out.println("Names2 array, before sorting by last name: ");
		for (String name : names2) {
			System.out.println(name);
		}
		

		Arrays.sort(names2, (name,name2)->{
			return name.split(" ")[1].compareTo(name2.split(" ")[1]);
		});	
		
		System.out.println("Names2 array, after sorting by last name: ");
		for (String name : names2) {
			System.out.println(name);
		}		
		
		
		//java 8 sorting style - lambda expression
		
		String[] names3 = {"Dr Phillips", "Mz Czepiel", "Mr Morrison", "Cl Cunningham"};
		System.out.println("Names3 array, before sorting by last name: ");
		for (String name : names3) {
			System.out.println(name);
		}
		

		Arrays.sort(names3, Comparator.comparing(str->str.split(" ")[1]));	
		
		System.out.println("Names3 array, after sorting by last name: ");
		for (String name : names3) {
			System.out.println(name);
		}		
		
		//method reference style
		Arrays.sort(names3, Comparator.comparing(Main::sortByFirstTitle));	
		
		System.out.println("Names3 array, after sorting by first title: ");
		for (String name : names3) {
			System.out.println(name);
		}		
		
		//use default Comparator method to reverse it
		Arrays.sort(names3, Comparator.comparing(Main::sortByFirstTitle).reversed());	
		
		System.out.println("Names3 array, after reverse sorting by first title: ");
		for (String name : names3) {
			System.out.println(name);
		}			

		
	}
	
	private static String sortByFirstTitle(String name) {
		return name.split(" ")[0];
	}
	
	private static String processString(String str, Function<String, String> processor) {
		return processor.apply(str);
	}
	
	private static String processString2(String str, int i, BiFunction<String, Integer, String> processor) {
		return processor.apply(str, i);
	}
	
}

//interface Processor{
//	String process(String str);
//}