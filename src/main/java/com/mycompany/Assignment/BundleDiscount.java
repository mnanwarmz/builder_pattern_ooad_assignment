package com.mycompany.Assignment;

/**
 * BundleDiscount
 */
public class BundleDiscount implements Discount {
	private float discount;

	BundleDiscount(float discount) {
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