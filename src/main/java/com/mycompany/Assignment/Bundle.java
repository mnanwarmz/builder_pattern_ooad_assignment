package com.mycompany.Assignment;

import java.util.ArrayList;

/**
 * Bundle
 */
public class Bundle {
	private String name;
	private float price;
	private int quantity;
	private BundleDiscount discount;
	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;

	/**
	 * Constructor
	 *
	 * @param name
	 * @param price
	 * @param quantity
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
	public void addFood(Food food) throws Exception {
		if (foods.contains(food)) {
			throw new Exception("Food already in bundle");
		} else {
			foods.add(food);
		}
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
	public void addDrink(Drink drink) throws Exception {
		if (drinks.contains(drink)) {
			throw new Exception("Drink already in bundle");
		} else if (!(drink instanceof Drink)) {
			throw new Exception("Drink is not a drink");
		} else {
			drinks.add(drink);
		}
	}

	/**
	 * Get name of bundle
	 *
	 * @return name
	 * @throws Exception
	 *                   if bundle is empty
	 */
	public String getName() throws Exception {
		if (foods.size() == 0 && drinks.size() == 0) {
			throw new Exception("Bundle is empty");
		} else {
			return name;
		}
	}

	/**
	 * Get price of bundle
	 *
	 * @return price
	 * @throws Exception
	 *                   if bundle is empty
	 *                   if bundle has discount but no price
	 */
	public float getPrice() throws Exception {
		if (foods.size() == 0 && drinks.size() == 0)
			throw new Exception("Bundle is empty");
		if (discount.getDiscount() == 0)
			throw new Exception("Bundle has discount but no price");
		return (price * (1 - discount.getDiscount() / 100));

	}

	/**
	 * Get quantity of bundle
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
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

	public void addDiscount(BundleDiscount discount) {
		this.discount = discount;
	}
}