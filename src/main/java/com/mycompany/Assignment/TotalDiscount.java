package com.mycompany.Assignment;

/**
 * TotalDiscount
 */
public class TotalDiscount implements Discount {
	private float discount;

	TotalDiscount(float discount) {
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