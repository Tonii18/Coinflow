package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManager;
import models.User;
import roundedComponents.RoundButton;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton settings, addIncome;
	
	private User u;

	/**
	 * Create the frame.
	 */
	public Home(User u) {
		this.u = u;
		
		setTitle("Menú principal");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formated = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy");
		String formatedDate = currentDate.format(formated);
		
		formatedDate = formatedDate.substring(0,1).toUpperCase() + formatedDate.substring(1);
		
		double total = DBManager.getBalance(u);
		
		JLabel balance = new JLabel(String.format(Locale.FRANCE, "%.2f €", total));
		balance.setForeground(new Color(255, 255, 255));
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setFont(new Font("Inter 18pt Black", Font.PLAIN, 90));
		balance.setBounds(445, 166, 533, 114);
		contentPane.add(balance);
		
		JLabel date = new JLabel(formatedDate);
		date.setForeground(new Color(255, 255, 255));
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Inter", Font.PLAIN, 20));
		date.setBounds(547, 100, 330, 32);
		contentPane.add(date);
		
		settings = new JButton("");
		settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		settings.setContentAreaFilled(false);
		settings.setBorder(null);
		settings.setBounds(40, 40, 60, 60);
		settings.setIcon(new ImageIcon(getClass().getResource("/settings.png")));
		contentPane.add(settings);
		
		addIncome = new RoundButton("Ingreso", 15, 15);
		addIncome.setBackground(new Color(252, 163, 17));
		addIncome.setForeground(new Color(255, 255, 255));
		addIncome.setFont(new Font("Inter", Font.PLAIN, 20));
		addIncome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIncome.setBorder(null);
		addIncome.setBounds(458, 488, 250, 60);
		contentPane.add(addIncome);
		
		RoundButton addWithdraw = new RoundButton("Ingreso", 15, 15);
		addWithdraw.setText("Retiro");
		addWithdraw.setForeground(new Color(252, 163, 17));
		addWithdraw.setFont(new Font("Inter", Font.PLAIN, 20));
		addWithdraw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addWithdraw.setBorder(null);
		addWithdraw.setBackground(new Color(255, 213, 145));
		addWithdraw.setBounds(728, 488, 250, 60);
		contentPane.add(addWithdraw);
		
		JLabel menu = new JLabel("");
		menu.setBounds(16, 425, 1392, 546);
		menu.setIcon(new ImageIcon(getClass().getResource("/menu-back.png")));
		contentPane.add(menu);
		
		JLabel background = new JLabel("");
		background.setBounds(-8, -19, 1440, 1024);
		background.setIcon(new ImageIcon(getClass().getResource("/back-home.png")));
		contentPane.add(background);

	}
}
