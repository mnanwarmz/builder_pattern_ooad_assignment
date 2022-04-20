package restaurant2;

import java.util.ArrayList;

/**
 * Order
 */
public class Order {

	private float price;
	private TotalDiscount discount;
	private ArrayList<Food> foods = new ArrayList<Food>();
	private ArrayList<Bundle> bundles = new ArrayList<Bundle>();
	private ArrayList<Drink> drinks = new ArrayList<Drink>();

	/**
	 * Add food to order cart
	 *
	 * @param food
	 * @return void
	 * @throws Exception
	 *                   if food is already in order cart
	 */

	public void addFood(Food food) {
		// if already exists increment quantity
		for (Food f : foods) {
			if (f.getName().equals(food.getName())) {
				f.setQuantity(f.getQuantity() + 1);
				return;
			}
		}
		foods.add(food);
	}

	/**
	 * Add bundle to order cart
	 *
	 * @param bundle
	 */
	public void addBundle(Bundle bundle) {
		// if already exists increment quantity
		for (Bundle b : bundles) {
			if (b.getName().equals(bundle.getName())) {
				b.setQuantity(b.getQuantity() + 1);
				return;
			}
		}
		bundles.add(bundle);
	}

	public boolean isEmpty() {
		return foods.isEmpty() && bundles.isEmpty() && drinks.isEmpty();
	}

	/**
	 * Add drink to order cart
	 *
	 * @param drink
	 */
	public void addDrink(Drink drink) {
		// if already exists increment quantity
		for (Drink d : drinks) {
			if (d.getName().equals(drink.getName())) {
				d.setQuantity(d.getQuantity() + 1);
				return;
			}
		}
		drinks.add(drink);

	}

	/**
	 * Get order price
	 *
	 * @return float
	 * @throws Exception
	 *                   if order is empty
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Get order discount
	 *
	 * @return TotalDiscount
	 * @throws Exception
	 *                   if order is empty
	 */
	public TotalDiscount getDiscount() {
		return discount;
	}

	/**
	 * Get order cart
	 *
	 * @return ArrayList<Food>
	 * @throws Exception
	 *                   if order is empty
	 */
	public ArrayList<Food> getFoods() {
		return foods;
	}

	/**
	 * Get order cart
	 *
	 * @return ArrayList<Bundle>
	 * @throws Exception
	 *                   if order is empty
	 */
	public ArrayList<Bundle> getBundles() {

		return bundles;

	}

	/**
	 * Get order cart
	 *
	 * @return ArrayList<Drink>
	 * @throws Exception
	 *                   if order is empty
	 */
	public ArrayList<Drink> getDrinks() {
		return drinks;
	}

	/**
	 * Get order price
	 *
	 * @return float
	 * @throws Exception
	 *                   if order is empty
	 */
	public float getTotalPrice() {
		float totalPrice = 0;
		for (Food food : foods) {
			totalPrice += food.getPrice();
		}
		for (Bundle bundle : bundles) {
			totalPrice += bundle.getPrice();
		}
		for (Drink drink : drinks) {
			totalPrice += drink.getPrice();
		}
		return totalPrice;
	}

	/**
	 * Get Calculated Price
	 *
	 * @return float
	 * @throws Exception
	 *                   if order is empty
	 */
	public float getCalculatedPriceAfterDiscount() {
		// Price after discount
		float priceAfterDiscount = getTotalPrice() - discount.getDiscount();
		return priceAfterDiscount;
	}

}