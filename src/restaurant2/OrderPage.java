package restaurant2;

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
	private JPanel foodButtonsPanel = new JPanel();
	private JPanel drinksPanel = new JPanel();
	private JPanel bundlesPanel = new JPanel();

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
		rightPanel.add(cartPanel, BorderLayout.NORTH);

		// Items Panel
		itemsPanel.setLayout(new GridLayout(1, 3));
		// Foods
		foodContent();
		// Drinks
		JLabel drinksLabel = new JLabel("Drinks");
		drinksLabel.setFont(new Font("Verdana", Font.BOLD, 20));

		// Bundles
		JLabel bundlesLabel = new JLabel("Bundles");
		bundlesLabel.setFont(new Font("Verdana", Font.BOLD, 20));

		// Cart Panel
		itemsPanel.add(foodsPanel);
		itemsPanel.add(drinksPanel);
		itemsPanel.add(bundlesPanel);

	}

	private JPanel foodContent() {
		JLabel foodsLabel = new JLabel("Foods");
		foodsLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		foodsPanel.setLayout(new BorderLayout());
		foodButtonsPanel.setLayout(new FlowLayout());
		foodsPanel.add(foodsLabel, BorderLayout.NORTH);
		foodsPanel.add(foodButtonsPanel, BorderLayout.CENTER);
		for (Food food : menu.getFoods()) {
			String formattedPrice = String.format("%.2f", food.getPrice());
			String foodName = food.getName();
			JButton foodBtn = new JButton(foodName + "RM" + formattedPrice);
			foodBtn.setPreferredSize(new Dimension(200, 50));
			foodBtn.setBackground(new Color(22, 160, 133));
			foodButtonsPanel.add(foodBtn);
			foodBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addFood(food);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return foodsPanel;
	}
}