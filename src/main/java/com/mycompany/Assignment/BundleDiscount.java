package com.mycompany.Assignment;

/**
 * BundleDiscount
 */
public class BundleDiscount implements Discount {
	private float discount;
	private String discountName;

	BundleDiscount(float discount, String discountName) {
		this.discount = discount;
		this.discountName = discountName;
	}

	@Override
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
}