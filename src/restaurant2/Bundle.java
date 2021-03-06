package restaurant2;

import java.util.ArrayList;

/**
 * Bundle
 */
public class Bundle {
	private String name;
	private float price;
	private int quantity = 1;
	private BundleDiscount discount;
	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;

	/**
	 * Constructor
	 *
	 * @param name
	 * @param price
	 */
	public Bundle(String name, float price) {
		this.name = name;
		this.price = price;
		this.discount = new BundleDiscount(0, "");
		this.foods = new ArrayList<Food>();
		this.drinks = new ArrayList<Drink>();
	}

	/**
	 * Add food to bundle
	 *
	 * @param food
	 * @return void
	 * @throws Exception
	 *                   if food is already in bundle
	 *                   if bundle is already full
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
	 * Add drink to bundle
	 *
	 * @param drink
	 * @return void
	 * @throws Exception
	 *                   if drink is already in bundle
	 *                   if bundle is already full
	 *                   if drink is not a drink
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
	 * Get name of bundle
	 *
	 * @return name
	 * @throws Exception
	 *                   if bundle is empty
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get price of bundle
	 *
	 * @return price
	 * @throws Exception
	 *                   if bundle is empty
	 *                   if bundle has discount but no price
	 */
	public float getPrice() {
		return ((price * (1 - discount.getDiscount())) * quantity);
	}

	/**
	 * Get quantity of bundle
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get discount of bundle
	 *
	 * @return discount
	 * @throws Exception
	 *                   if bundle is empty
	 *                   if bundle has no discount
	 *                   if bundle has discount but no price
	 */
	public BundleDiscount getDiscount() throws Exception {
		if (foods.size() == 0 && drinks.size() == 0)
			throw new Exception("Bundle is empty");
		if (discount.getDiscount() == 0)
			throw new Exception("Bundle has no discount");
		if (discount.getDiscount() == 0)
			throw new Exception("Bundle has discount but no price");
		return discount;
	}

	/**
	 * Set discount of bundle
	 * 
	 * @param discount
	 *                 Discount in decimals e.g. 0.1 for 10%
	 *
	 * @return void
	 */
	public void addDiscount(BundleDiscount discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String formattedPrice = String.format("%.2f", getPrice());
		return name + " RM" + formattedPrice + " x " + quantity + " ";
	}
}