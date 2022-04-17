package com.mycompany.Assignment;

public class Main {

	// Builder Design Pattern
	public static void main(String[] args) throws Exception {
		// List of Drinks
		Drink coke = new Drink("Coke", 1.5f);
		Drink sprite = new Drink("Sprite", 1.5f);
		Drink fanta = new Drink("Fanta", 1.5f);
		Drink sevenUp = new Drink("7Up", 1.5f);

		// List of Foods
		Food burger = new Food("Burger", 5.0f);
		Food pizza = new Food("Pizza", 5.0f);
		Food pasta = new Food("Pasta", 5.0f);
		Food soup = new Food("Soup", 5.0f);

		// List of Bundles
		Bundle bundle1 = new Bundle("Bundle 1", 20.0f);
		Bundle bundle2 = new Bundle("Bundle 2", 18.0f);
		Bundle bundle3 = new Bundle("Bundle 3", 25.0f);

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