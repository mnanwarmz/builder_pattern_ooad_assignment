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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant2 extends JFrame implements ActionListener {
	// Builder Design Pattern
	private JLabel header, footer;
	private JPanel p1, p2, p3;
	private JButton userBtn, adminBtn;

	// Window Settings
	public Restaurant2() {
		header = new JLabel("Welcome to the Restaurant");
		header.setFont(new Font("Verdana", Font.BOLD, 20));
		footer = new JLabel("Restaurant Sdn. Bhd.");
		footer.setFont(new Font("Verdana", Font.PLAIN, 10));

		userBtn = new JButton("Make an order");
		userBtn.setPreferredSize(new Dimension(130, 50));
		adminBtn = new JButton("Modify system");
		adminBtn.setPreferredSize(new Dimension(160, 50));

		userBtn.setBackground(new Color(22, 160, 133));
		adminBtn.setBackground(new Color(22, 160, 133));

		p1 = new JPanel();
		p1.setBackground(new Color(22, 160, 133));

		p1.add(header);

		p2 = new JPanel();
		p2.add(userBtn);
		p2.add(adminBtn);
		p2.setLocation(10, 10);
		p2.setBackground(new Color(26, 188, 156));

		p3 = new JPanel();
		p3.add(footer);
		p3.setBackground(new Color(26, 188, 156));

		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(1, 2));
	}

	public static void main(String[] args) throws Exception {
		Restaurant2 obj = new Restaurant2();
		obj.setVisible(true);
		obj.setSize(500, 500);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Menu menu = new Menu();

		OrderPage orderPage = new OrderPage(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == userBtn) {

		}
	}
}