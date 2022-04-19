package restaurant2;

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
	private JPanel infoPanel = new JPanel();
	private JPanel footerPanel = new JPanel();

	private Menu menu;
	private Order order = new Order();
	private int i = 0;

	public OrderPage(Menu menu) throws Exception {
		setContentPane(containerPanel);
		this.menu = menu;
		setLayout(new BorderLayout());
		add(headerPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);

		// Panels Declaration
		headerPanel.add(header);
		footerPanel.add(footer);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		leftPanel.add(itemsPanel);
		rightPanel.add(infoPanel, BorderLayout.SOUTH);
		rightPanel.add(cartPanel, BorderLayout.CENTER);

		// Items Panel
		itemsPanel.setLayout(new GridLayout(1, 3));
		itemsPanel.add(foodsContent());
		itemsPanel.add(drinksContent());
		itemsPanel.add(bundlesContent());
		cartPanel = cartContent();
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
						System.out.println(food);
						order.addFood(food);
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
						System.out.println(drink);
						order.addDrink(drink);
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
						System.out.println(bundle);
						order.addBundle(bundle);
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
		JPanel cartList = new JPanel();
		cartPanel.setLayout(new BorderLayout());
		cartPanel.add(cartLabel, BorderLayout.NORTH);
		cartPanel.add(cartList, BorderLayout.CENTER);
		cartList.setLayout(new BoxLayout(cartList, BoxLayout.Y_AXIS));
		cartList.setPreferredSize(new Dimension(200, 200));
		cartList.setBackground(new Color(22, 160, 133));
		cartList.setForeground(Color.WHITE);
		cartList.setFont(new Font("Verdana", Font.BOLD, 20));
		for (Food food : order.getFoods()) {
			JLabel itemLabel = new JLabel(food.getName());
			cartList.add(itemLabel);
		}
		for (Drink drink : order.getDrinks()) {
			JLabel itemLabel = new JLabel(drink.getName());
			cartList.add(itemLabel);
		}
		for (Bundle bundle : order.getBundles()) {
			JLabel itemLabel = new JLabel(bundle.getName());
			cartList.add(itemLabel);
		}
		return cartPanel;
	}
}