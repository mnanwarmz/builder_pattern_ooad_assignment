package restaurant2;

import javax.swing.JLabel;

/**
 * Item
 */
abstract class Item {
	protected String name;
	protected float price;
	protected int quantity;
	protected ItemDiscount discount;
	protected JLabel nameLabel;

	public Item(String name, float price) {
		this.name = name;
		this.price = price;
		nameLabel = new JLabel(name);
	}

	public float getPrice() {
		if (discount != null)
			return price - discount.getDiscount();
		else
			return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addDiscount(ItemDiscount discount) {
		this.discount = discount;
	}
}