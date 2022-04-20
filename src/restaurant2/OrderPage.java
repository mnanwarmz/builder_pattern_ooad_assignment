package restaurant2;

import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.lang.Exception;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * OrderPage
 */
public class OrderPage extends JFrame {
	private JLabel header = new JLabel("Order Page");
	private JLabel footer = new JLabel("Restaurant Sdn. Bhd.");

	private JPanel containerPanel = new JPanel();
	private JPanel headerPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();

	private JPanel itemsPanel = new JPanel();
	private JPanel foodsPanel = new JPanel();
	private JPanel drinksPanel = new JPanel();
	private JPanel bundlesPanel = new JPanel();

	private JPanel foodButtonsPanel = new JPanel();
	private JPanel drinksButtonsPanel = new JPanel();
	private JPanel bundlesButtonsPanel = new JPanel();

	private JPanel cartPanel = new JPanel();
	private JPanel footerPanel = new JPanel();

	private Menu menu;
	private Order order = new Order();

	public OrderPage(Menu menu) throws Exception {
		setContentPane(containerPanel);
		this.menu = menu;
		setLayout(new BorderLayout());
		add(headerPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panels Declaration
		headerPanel.add(header);
		footerPanel.add(footer);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		leftPanel.add(itemsPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// Items Panel
		itemsPanel.setLayout(new GridLayout(1, 3));
		itemsPanel.add(foodsContent());
		itemsPanel.add(drinksContent());
		itemsPanel.add(bundlesContent());
		cartPanel = cartContent();
		footer = new JLabel("Anwar Zaid Sdn. Bhd.");
		// Assign borders to all panels
		headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itemsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		foodsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		drinksPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bundlesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		foodButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		drinksButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bundlesButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		footerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

	private JPanel foodsContent() {
		JLabel foodsLabel = new JLabel("Foods");
		foodsLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		foodsPanel.setLayout(new BorderLayout());
		foodButtonsPanel.setLayout(new BoxLayout(foodButtonsPanel, BoxLayout.Y_AXIS));
		foodsPanel.add(foodsLabel, BorderLayout.NORTH);
		foodsPanel.add(foodButtonsPanel, BorderLayout.CENTER);
		for (Food food : menu.getFoods()) {
			String formattedPrice = String.format("%.2f", food.getPrice());
			String foodName = food.getName();
			JButton foodBtn = new JButton(foodName + " RM" + formattedPrice);
			foodBtn.setPreferredSize(new Dimension(200, 50));
			foodBtn.setBackground(new Color(22, 160, 133));
			foodButtonsPanel.add(foodBtn);
			foodBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addFood(food);
						cartPanel.removeAll();
						cartPanel = cartContent();
						rightPanel.add(cartPanel, BorderLayout.CENTER);
						rightPanel.revalidate();
						rightPanel.repaint();
						cartPanel.revalidate();
						cartPanel.repaint();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return foodsPanel;
	}

	private JPanel drinksContent() {
		JLabel drinksLabel = new JLabel("Drinks");
		drinksLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		drinksPanel.setLayout(new BorderLayout());
		drinksButtonsPanel.setLayout(new BoxLayout(drinksButtonsPanel, BoxLayout.Y_AXIS));
		drinksPanel.add(drinksLabel, BorderLayout.NORTH);
		drinksPanel.add(drinksButtonsPanel, BorderLayout.CENTER);
		for (Drink drink : menu.getDrinks()) {
			String formattedPrice = String.format("%.2f", drink.getPrice());
			String drinkName = drink.getName();
			JButton drinkBtn = new JButton(drinkName + " RM" + formattedPrice);
			drinkBtn.setPreferredSize(new Dimension(200, 50));
			drinkBtn.setBackground(new Color(22, 160, 133));
			drinksButtonsPanel.add(drinkBtn);
			drinkBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addDrink(drink);
						cartPanel.removeAll();
						cartPanel = cartContent();
						rightPanel.revalidate();
						rightPanel.repaint();
						cartPanel.revalidate();
						cartPanel.repaint();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return drinksPanel;
	}

	// Bundle Content
	private JPanel bundlesContent() {
		JLabel bundlesLabel = new JLabel("Bundles");
		bundlesLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		bundlesPanel.setLayout(new BorderLayout());
		bundlesButtonsPanel.setLayout(new BoxLayout(bundlesButtonsPanel, BoxLayout.Y_AXIS));
		bundlesPanel.add(bundlesLabel, BorderLayout.NORTH);
		bundlesPanel.add(bundlesButtonsPanel, BorderLayout.CENTER);
		for (Bundle bundle : menu.getBundles()) {
			String formattedPrice = String.format("%.2f", bundle.getPrice());
			String bundleName = bundle.getName();
			JButton bundleBtn = new JButton(bundleName + " RM" + formattedPrice);
			bundleBtn.setPreferredSize(new Dimension(200, 50));
			bundleBtn.setBackground(new Color(22, 160, 133));
			bundlesButtonsPanel.add(bundleBtn);
			bundleBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addBundle(bundle);
						cartPanel.removeAll();
						cartPanel = cartContent();
						rightPanel.add(cartPanel);
						rightPanel.revalidate();
						rightPanel.repaint();
						cartPanel.revalidate();
						cartPanel.repaint();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return bundlesPanel;
	}

	// Show a list of the items that are in the order
	private JPanel cartContent() {
		JLabel cartLabel = new JLabel("Cart");
		cartLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		JPanel cartListPanel = new JPanel();
		cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
		cartPanel.add(cartLabel);
		cartPanel.add(cartListPanel);
		cartListPanel.setLayout(new BoxLayout(cartListPanel, BoxLayout.Y_AXIS));
		cartListPanel.setPreferredSize(new Dimension(200, 200));
		cartListPanel.setFont(new Font("Verdana", Font.BOLD, 20));
		JLabel cartListPanelLabel = new JLabel("Items in your cart");
		cartListPanelLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		cartListPanel.add(cartListPanelLabel);
		for (Food food : order.getFoods()) {
			JLabel itemLabel = new JLabel(food.toString());
			itemLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			cartListPanel.add(itemLabel);
		}
		for (Drink drink : order.getDrinks()) {
			JLabel itemLabel = new JLabel(drink.toString());
			itemLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			cartListPanel.add(itemLabel);
		}
		for (Bundle bundle : order.getBundles()) {
			JLabel itemLabel = new JLabel(bundle.toString());
			itemLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			cartListPanel.add(itemLabel);
		}
		cartPanel.add(infoContent());
		cartPanel.add(discountContent());
		return cartPanel;
	}

	// Show theµ total price of the order
	private JPanel infoContent() {
		JLabel infoLabel = new JLabel("Info");
		infoLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		JPanel infPanel = new JPanel();
		JPanel infoContentPanel = new JPanel();
		infPanel.setLayout(new BoxLayout(infPanel, BoxLayout.Y_AXIS));
		infPanel.add(infoLabel);
		infPanel.add(infoContentPanel);
		infoContentPanel.setLayout(new BoxLayout(infoContentPanel, BoxLayout.Y_AXIS));
		infoContentPanel.setPreferredSize(new Dimension(200, 200));
		infoContentPanel.setFont(new Font("Verdana", Font.PLAIN, 14));
		JLabel infoContentPanelLabel = new JLabel("Sub-total");
		infoContentPanelLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		infoContentPanel.add(infoContentPanelLabel);
		String formattedPrice = String.format("%.2f", order.getTotalPrice());
		JLabel totalPriceLabel = new JLabel("RM" + formattedPrice);
		totalPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		infoContentPanel.add(totalPriceLabel);
		// Price after discount
		JLabel afterDiscountLabel = new JLabel("After discount");
		afterDiscountLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		infoContentPanel.add(afterDiscountLabel);
		String formattedPriceAfterDiscount = String.format("%.2f", order.getCalculatedPriceAfterDiscount());
		JLabel afterDiscountPriceLabel = new JLabel("RM" + formattedPriceAfterDiscount);
		afterDiscountPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		infoContentPanel.add(afterDiscountPriceLabel);
		return infPanel;
	}

	private JPanel discountContent() {
		JLabel discountLabel = new JLabel("Discount");
		discountLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		JPanel discountPanel = new JPanel();
		discountPanel.setLayout(new BoxLayout(discountPanel, BoxLayout.Y_AXIS));
		discountPanel.add(discountLabel);
		JComboBox<String> discountDropdown = new JComboBox<String>();
		discountDropdown.setPreferredSize(new Dimension(50, 30));
		discountDropdown.setFont(new Font("Verdana", Font.PLAIN, 12));
		for (TotalDiscount discount : menu.getTotalDiscounts()) {
			discountDropdown.addItem(discount.getName());
		}
		discountPanel.add(discountDropdown);
		discountDropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Find discount with name equal to the selected one
					TotalDiscount discount = null;
					for (TotalDiscount d : menu.getTotalDiscounts()) {
						if (d.getName().equals(discountDropdown.getSelectedItem())) {
							discount = d;
						}
					}
					order.setDiscount(discount);
					cartPanel.removeAll();
					cartPanel = cartContent();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		return discountPanel;
	}

	// set Preferred Size
	private void setPreferredSize() {
		this.setPreferredSize(new Dimension(1024, 800));
	}
}