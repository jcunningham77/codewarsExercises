package factorypattern;

public class FoodFactory {
	
	public Food getFood(String order) {
		Food food = null;
		if(order.equalsIgnoreCase("pizza")) {
			food = new Pizza();
		} else if (order.equalsIgnoreCase("cake")){
			food = new Cake();
		}
		
		return food;
		
	}

}
