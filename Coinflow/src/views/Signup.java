package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManager;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton signup;  
	private JTextField username;
	private JTextField email;
	private JTextField phone;
	private JPasswordField password;
	private JButton back;

	/**
	 * Create the frame.
	 */
	public Signup() {
		setTitle("Crea tu cuenta de Coinflow");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		back = new JButton("");
		back.setContentAreaFilled(false);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setBorder(null);
		back.setBounds(10, 11, 50, 50);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		contentPane.add(back);
		
		JPanel loginPanel = new RoundPanel(15, 15);
		loginPanel.setBackground(new Color(255, 255, 255));
		loginPanel.setBounds(507, 249, 410, 486);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		signup = new RoundButton("Registrarme", 10, 10);
		signup.setBorderPainted(true);
		signup.setForeground(new Color(255, 255, 255));
		signup.setFont(new Font("Inter", Font.BOLD, 17));
		signup.setFocusable(false);
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.setBackground(new Color(252, 163, 17));
		((RoundButton) signup).setCustomBorderColor(new Color(252, 163, 17));
		signup.setBounds(28, 395, 354, 60);
		loginPanel.add(signup);
		
		username = new RoundTextField(10, 10, 10);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Inter", Font.PLAIN, 20));
		username.setBackground(new Color(217, 217, 217));
		username.setBounds(28, 122, 354, 60);
		loginPanel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Inter", Font.PLAIN, 20));
		password.setBackground(new Color(217, 217, 217));
		password.setBounds(28, 304, 354, 60);
		loginPanel.add(password);
		
		email = new RoundTextField(10, 10, 10);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Inter", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBackground(new Color(217, 217, 217));
		email.setBounds(28, 31, 354, 60);
		loginPanel.add(email);
		
		phone = new RoundTextField(10, 10, 10);
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setFont(new Font("Inter", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBackground(new Color(217, 217, 217));
		phone.setBounds(28, 213, 354, 60);
		loginPanel.add(phone);
		
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
		background.setBounds(-8, -19, 1440, 1024);
		background.setIcon(new ImageIcon(getClass().getResource("/background.png")));
		contentPane.add(background);
		
		back.addActionListener(new buttons());
		signup.addActionListener(new buttons());

	}
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			
			if(button == back) {
				back();
			}else if(button == signup) {
				signup();
			}
		}
	}
	
	public void signup() {
		String mail = email.getText();
		String name = username.getText();
		String phonenumber = phone.getText();
		String pass = new String(password.getPassword());
		
		User u = new User(mail, name, phonenumber, pass);
		
		if(DBManager.register(u)) {
			JOptionPane.showMessageDialog(null, "Has creado tu cuenta correctamente");
			InitialHome init = new InitialHome(u);
			init.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
	}
	
	public void back() {
		Login l = new Login();
		l.setVisible(true);
		dispose();
	}
}
