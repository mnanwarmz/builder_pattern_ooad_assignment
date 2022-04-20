package restaurant2;

import javax.swing.JLabel;

/**
 * Item
 */
abstract class Item {
	protected String name;
	protected float price;
	protected int quantity = 1;
	protected ItemDiscount discount;
	protected JLabel nameLabel;

	public Item(String name, float price) {
		this.name = name;
		this.price = price;
		nameLabel = new JLabel(name);
	}

	public float getPrice() {
		if (discount != null)
			return (price - discount.getDiscount()) * quantity;
		else
			return price * quantity;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String formattedPrice = String.format("%.2f", getPrice());
		return name + " RM" + formattedPrice + " x " + quantity + " ";
	}
}