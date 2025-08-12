package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton login;
	private JButton signup;  
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Inicia sesion en tu cuenta de Coinflow");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginPanel = new RoundPanel(15, 15);
		loginPanel.setBackground(new Color(255, 255, 255));
		loginPanel.setBounds(507, 249, 410, 486);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		login = new RoundButton("Iniciar sesión", 10, 10);
		login.setFocusable(false);
		login.setBorder(null);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(252, 163, 17));
		login.setFont(new Font("Inter", Font.BOLD, 17));
		login.setBounds(28, 330, 354, 60);
		loginPanel.add(login);
		
		signup = new RoundButton("Registrarme", 10, 10);
		signup.setBorderPainted(true);
		signup.setForeground(new Color(252, 163, 17));
		signup.setFont(new Font("Inter", Font.BOLD, 17));
		signup.setFocusable(false);
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.setBackground(new Color(255, 255, 255));
		((RoundButton) signup).setCustomBorderColor(new Color(252, 163, 17));
		signup.setBounds(28, 402, 354, 60);
		loginPanel.add(signup);
		
		username = new RoundTextField(10, 10, 10);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Inter", Font.PLAIN, 20));
		username.setBackground(new Color(217, 217, 217));
		username.setBounds(28, 45, 354, 60);
		loginPanel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Inter", Font.PLAIN, 20));
		password.setBackground(new Color(217, 217, 217));
		password.setBounds(28, 116, 354, 60);
		loginPanel.add(password);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(217, 217, 217));
		separator.setBackground(new Color(217, 217, 217));
		separator.setBounds(28, 251, 354, 1);
		loginPanel.add(separator);
		
		JLabel title = new JLabel("Bienvenido a Coinflow");
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Inter 18pt Black", Font.BOLD, 30));
		title.setBounds(507, 190, 410, 35);
		contentPane.add(title);
		
		JLabel logo = new JLabel("");
		logo.setBounds(662, 60, 100, 100);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		contentPane.add(logo);
		
		JLabel background = new JLabel("");
		background.setBackground(new Color(216, 216, 216));
		background.setBounds(-8, -19, 1440, 1024);
		background.setIcon(new ImageIcon(getClass().getResource("/background.png")));
		contentPane.add(background);

	}
}
