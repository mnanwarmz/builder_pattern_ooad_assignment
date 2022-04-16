package com.mycompany.Assignment;

public class Main {

	// Builder Design Pattern
	public static void main(String[] args) throws Exception {
		// List of Drinks
		Drink coke = new Drink("Coke", 1.5f, 10);
		Drink sprite = new Drink("Sprite", 1.5f, 10);
		Drink fanta = new Drink("Fanta", 1.5f, 10);
		Drink sevenUp = new Drink("7Up", 1.5f, 10);

		// List of Foods
		Food burger = new Food("Burger", 5.0f, 10);
		Food pizza = new Food("Pizza", 5.0f, 10);
		Food pasta = new Food("Pasta", 5.0f, 10);
		Food soup = new Food("Soup", 5.0f, 10);

		// List of Bundles
		Bundle bundle1 = new Bundle("Bundle 1", 0.0f, 10);
		Bundle bundle2 = new Bundle("Bundle 2", 0.0f, 10);
		Bundle bundle3 = new Bundle("Bundle 3", 0.0f, 10);

		// Bundle Discounts
		BundleDiscount ten = new BundleDiscount(0.1f, "10% off");
		BundleDiscount twenty = new BundleDiscount(0.2f, "20% off");
		BundleDiscount thirty = new BundleDiscount(0.3f, "30% off");

		// Bundle 1 Content
		bundle1.addFood(burger);
		bundle1.addFood(pizza);
		bundle1.addDrink(coke);
		bundle1.addDiscount(ten);

		// Bundle 2 Content
		bundle2.addFood(pasta);
		bundle2.addFood(soup);
		bundle2.addDrink(sprite);
		bundle2.addDiscount(twenty);

		// Bundle 3 Content
		bundle3.addFood(burger);
		bundle3.addFood(pizza);
		bundle3.addDrink(fanta);
		bundle3.addDrink(sevenUp);
		bundle3.addDiscount(thirty);
	}
}