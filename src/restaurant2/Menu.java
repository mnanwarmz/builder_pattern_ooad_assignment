package restaurant2;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Food> foods = new ArrayList<Food>();
	private ArrayList<Drink> drinks = new ArrayList<Drink>();
	private ArrayList<Bundle> bundles = new ArrayList<Bundle>();

	public Menu() throws Exception {
		Food pizza = new Food("Pizza", 10.0f);
		Food burger = new Food("Burger", 10.0f);
		Food chicken = new Food("Chicken", 10.0f);
		Food pasta = new Food("Pasta", 10.0f);

		Drink cola = new Drink("Cola", 2.0f);
		Drink water = new Drink("Water", 2.0f);
		Drink juice = new Drink("Juice", 2.0f);

		Bundle bundle1 = new Bundle("Bundle 1", 10.0f);
		Bundle bundle2 = new Bundle("Bundle 2", 10.0f);
		Bundle bundle3 = new Bundle("Bundle 3", 10.0f);

		BundleDiscount ten = new BundleDiscount(0.1f, "10% off");
		BundleDiscount twenty = new BundleDiscount(0.2f, "20% off");
		BundleDiscount thirty = new BundleDiscount(0.3f, "30% off");

		bundle1.addFood(burger);
		bundle1.addFood(pizza);
		bundle1.addDrink(cola);
		bundle1.addDiscount(ten);

		bundle2.addFood(pasta);
		bundle2.addFood(chicken);
		bundle2.addDrink(water);
		bundle2.addDiscount(twenty);

		bundle3.addFood(burger);
		bundle3.addFood(pizza);
		bundle3.addDrink(juice);
		bundle3.addDiscount(thirty);

		foods.add(pizza);
		foods.add(burger);
		foods.add(chicken);
		foods.add(pasta);

		drinks.add(cola);
		drinks.add(water);
		drinks.add(juice);

		bundles.add(bundle1);
		bundles.add(bundle2);
		bundles.add(bundle3);
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public ArrayList<Drink> getDrinks() {
		return drinks;
	}

	public ArrayList<Bundle> getBundles() {
		return bundles;
	}

	public void addFood(Food food) {
		foods.add(food);
	}

	public void addDrink(Drink drink) {
		drinks.add(drink);
	}

	public void addBundle(Bundle bundle) {
		bundles.add(bundle);
	}

	public void removeFood(Food food) {
		foods.remove(food);
	}

	public void removeDrink(Drink drink) {
		drinks.remove(drink);
	}

	public void removeBundle(Bundle bundle) {
		bundles.remove(bundle);
	}
}