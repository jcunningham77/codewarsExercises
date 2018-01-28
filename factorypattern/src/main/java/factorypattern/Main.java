package factorypattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating the factory
		FoodFactory foodFactory = new FoodFactory();

		//factory instantiates an object
		Food food = foodFactory.getFood("pizza");

		System.out.println("The factory returned "+food.getClass());
		System.out.println(food.getType());
		
		//factory instantiates an object
		Food food2 = foodFactory.getFood("cake");

		System.out.println("The factory returned "+food2.getClass());
		System.out.println(food2.getType());		

	}

}
