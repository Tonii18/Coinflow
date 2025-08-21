package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManager;
import models.User;

public class InitialHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton addBalance, settings;
	private User u;

	/**
	 * Create the frame.
	 */
	public InitialHome(User u) {
		this.u = u;
		
		setTitle("Inicio");
		
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
		
		settings = new JButton("");
		settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		settings.setContentAreaFilled(false);
		settings.setBorder(null);
		settings.setBorderPainted(false);
		settings.setBounds(40, 40, 60, 60);
		settings.setIcon(new ImageIcon(getClass().getResource("/settings.png")));
		contentPane.add(settings);
		
		JLabel vector = new JLabel("");
		vector.setBounds(11, 500, 588, 474);
		vector.setIcon(new ImageIcon(getClass().getResource("/vector.png")));
		contentPane.add(vector);
		
		addBalance = new JButton("");
		addBalance.setBorder(null);
		addBalance.setBorderPainted(false);
		addBalance.setFocusable(false);
		addBalance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addBalance.setContentAreaFilled(false);
		addBalance.setBounds(609, 352, 205, 205);
		addBalance.setIcon(new ImageIcon(getClass().getResource("/initial-balance.png")));
		contentPane.add(addBalance);
		
		JLabel title = new JLabel("Pulsa aquí para establecer tu saldo inicial");
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Inter 18pt Black", Font.PLAIN, 50));
		title.setBounds(178, 182, 1067, 87);
		contentPane.add(title);
		
		JLabel date = new JLabel(formatedDate);
		date.setForeground(new Color(255, 255, 255));
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Inter", Font.PLAIN, 20));
		date.setBounds(547, 100, 330, 32);
		contentPane.add(date);
		
		JLabel background = new JLabel("");
		background.setBounds(-8, -19, 1440, 1024);
		background.setIcon(new ImageIcon(getClass().getResource("/back-home.png")));
		contentPane.add(background);
		
		addBalance.addActionListener(new buttons());
		settings.addActionListener(new buttons());

	}
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			
			if(button == addBalance) {
				addBalance();
			}else if(button == settings) {
				openSettings();
			}
		}
		
	}
	
	public void addBalance() {
		String input = JOptionPane.showInputDialog("Introduce el saldo inicial de tu cuenta");
		Double balance = Double.parseDouble(input);
		
		if(DBManager.setBalance(u, balance)) {
			JOptionPane.showMessageDialog(null, "Saldo ingresado correctamente");
			Home h = new Home(u);
			h.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
	}
	
	public void openSettings() {
		Setting s = new Setting();
		s.setVisible(true);
		dispose();
	}
}
