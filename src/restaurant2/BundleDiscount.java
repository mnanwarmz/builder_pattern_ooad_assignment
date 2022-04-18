package restaurant2;

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
	public float getDiscount() {
		return discount;
	}

	@Override
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String getName() {
		return discountName;
	}

	@Override
	public void setName(String name) {
		this.discountName = name;
	}
}