package restaurant2;

/**
 * TotalDiscount
 */
public class TotalDiscount implements Discount {
	private float discount;
	private String name;

	TotalDiscount(float discount) {
		this.discount = discount;
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