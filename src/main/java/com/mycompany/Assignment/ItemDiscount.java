package com.mycompany.Assignment;

/**
 * ItemDiscount
 */
public class ItemDiscount implements Discount {

	private float discount;

	ItemDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getDiscount() {
		return discount;
	}
}