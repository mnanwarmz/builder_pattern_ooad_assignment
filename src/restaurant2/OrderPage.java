package restaurant2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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

	private JPanel headerPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel itemsPanel = new JPanel();
	private JPanel foodsPanel = new JPanel();
	private JPanel drinksPanel = new JPanel();
	private JPanel bundlesPanel = new JPanel();
	private JPanel cartPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel footerPanel = new JPanel();
	private int i = 0;

	public OrderPage(Menu menu) throws Exception {
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
		rightPanel.add(cartPanel, BorderLayout.NORTH);
		rightPanel.add(infoPanel, BorderLayout.SOUTH);

		// Items Panel
		itemsPanel.setLayout(new GridLayout(1, 3));
		// Foods
		JLabel foodsLabel = new JLabel("Foods");
		foodsLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		foodsPanel.setLayout(new BorderLayout());
		foodsPanel.add(foodsLabel, BorderLayout.NORTH);
		for (Food food : menu.getFoods()) {
			String formattedPrice = String.format("%.2f", food.getPrice());
			String foodName = food.getName();
			JButton foodBtn = new JButton(foodName + "RM" + formattedPrice);
			foodBtn.setPreferredSize(new Dimension(200, 50));
			foodBtn.setBackground(new Color(22, 160, 133));
			foodsPanel.add(foodBtn);
			foodBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Cart.add(food);
					cartPanel.setLayout(new GridLayout(i, 2));
					cartPanel.add(new JLabel(foodName));
					cartPanel.add(new JLabel("RM" + formattedPrice));
					cartPanel.revalidate();
					cartPanel.repaint();
				}
			});
			i++;
		}

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
}