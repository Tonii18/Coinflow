package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import roundedComponents.RoundPanel;

public class Setting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setting frame = new Setting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Setting() {
		setTitle("Ajustes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formated = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy");
		String formatedDate = currentDate.format(formated);
		
		formatedDate = formatedDate.substring(0,1).toUpperCase() + formatedDate.substring(1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(682, 308, 60, 60);
		logo.setIcon(new ImageIcon(getClass().getResource("/settings.png")));
		contentPane.add(logo);
		
		JLabel date = new JLabel(formatedDate);
		date.setForeground(new Color(255, 255, 255));
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Inter", Font.PLAIN, 20));
		date.setBounds(547, 100, 330, 32);
		contentPane.add(date);
		
		JLabel title = new JLabel("Ajustes de mi Coinflow");
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Inter 18pt Black", Font.PLAIN, 50));
		title.setBounds(178, 182, 1067, 87);
		contentPane.add(title);
		
		JPanel information = new RoundPanel(20, 20);
		information.setBackground(new Color(45, 58, 100));
		information.setBounds(316, 400, 791, 531);
		((RoundPanel) information).setCustomBorderColor(Color.WHITE);
		((RoundPanel) information).setCustomBorderThickness(2);
		contentPane.add(information);
		
		JLabel background = new JLabel("");
		background.setBounds(-8, -19, 1440, 1024);
		background.setIcon(new ImageIcon(getClass().getResource("/back-home.png")));
		contentPane.add(background);

	}
}
