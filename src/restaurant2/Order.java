package restaurant2;

import java.util.ArrayList;

/**
 * Order
 */
public class Order {

	private float price;
	private TotalDiscount discount;
	private ArrayList<Food> foods;
	private ArrayList<Bundle> bundles;
	private ArrayList<Drink> drinks;

	/**
	 * Add food to order cart
	 *
	 * @param food
	 * @return void
	 * @throws Exception
	 *                   if food is already in order cart
	 */
	public void addFood(Food food) throws Exception {
		if (foods.contains(food)) {
			throw new Exception("Food already in order cart");
		} else {
			foods.add(food);
		}
	}

	/**
	 * Add bundle to order cart
	 *
	 * @param bundle
	 * @return void
	 * @throws Exception
	 *                   if bundle is already in order cart
	 */
	public void addBundle(Bundle bundle) throws Exception {
		if (bundles.contains(bundle)) {
			throw new Exception("Bundle already in order cart");
		} else {
			bundles.add(bundle);
		}
	}

	public boolean isEmpty() {
		return foods.isEmpty() && bundles.isEmpty() && drinks.isEmpty();
	}

	/**
	 * Add drink to order cart
	 *
	 * @param drink
	 * @return void
	 * @throws Exception
	 *                   if drink is already in order cart
	 */
	public void addDrink(Drink drink) throws Exception {
		if (drinks.contains(drink)) {
			throw new Exception("Drink already in order cart");
		} else {
			drinks.add(drink);
		}
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

		return price;

	}

	/**
	 * Get Calculated Price
	 *
	 * @return float
	 * @throws Exception
	 *                   if order is empty
	 */
	public float getCalculatedPrice() {
		// Price after discount
		float priceAfterDiscount = price - discount.getDiscount();
		return priceAfterDiscount;
	}

}