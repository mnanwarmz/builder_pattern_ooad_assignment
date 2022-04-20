package restaurant2;

/**
 * ItemDiscount
 */
public class ItemDiscount implements Discount {

	private float discount;
	private String name;
	private String coupon;

	ItemDiscount(float discount, String name, String coupon) {
		this.discount = discount;
		this.name = name;
		this.coupon = coupon;
	}

	@Override
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public float getDiscount() {
		return discount;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}