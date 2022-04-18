package restaurant2;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Restaurant2 extends JFrame {
	// Builder Design Pattern
	private JLabel lb1;
	private JPanel p1, p2;
	private JButton foodsBtn, drinksBtn, bundleBtn;

	// Window Settings
	public Restaurant2() {
		lb1 = new JLabel("Welcome to the Restaurant");
		// lb1.setForeground(Color.WHITE);
		lb1.setFont(new Font("Verdana", Font.BOLD, 20));

		foodsBtn = new JButton("Foods");
		foodsBtn.setPreferredSize(new Dimension(130, 100));
		drinksBtn = new JButton("Drinks");
		drinksBtn.setPreferredSize(new Dimension(160, 100));
		bundleBtn = new JButton("Bundles");
		bundleBtn.setPreferredSize(new Dimension(120, 100));

		foodsBtn.setBackground(new Color(22, 160, 133));
		drinksBtn.setBackground(new Color(22, 160, 133));
		bundleBtn.setBackground(new Color(22, 160, 133));
		// foodsBtn.setForeground(Color.WHITE);
		// drinksBtn.setForeground(Color.WHITE);
		// bundleBtn.setForeground(Color.WHITE);

		p1 = new JPanel();
		p1.setBackground(new Color(22, 160, 133));

		p1.add(lb1);

		p2 = new JPanel();
		p2.add(foodsBtn);
		p2.add(drinksBtn);
		p2.add(bundleBtn);
		p2.setLocation(10, 10);
		p2.setBackground(new Color(26, 188, 156));

		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		p2.setLayout(new GridLayout(1, 3));

	}

	public static void main(String[] args) throws Exception {
		Restaurant2 obj = new Restaurant2();
		obj.setVisible(true);
		obj.setSize(500, 500);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menu initialization
		Menu menu = new Menu();

		Food testFood = new Food("Test Food", 10.0f);

		ItemDiscount testDiscount = new ItemDiscount(0.1f, "10% off");
		menu.addDiscountToFood(testFood, testDiscount);
	}
}