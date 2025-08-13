package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.User;

public class DBManager {
	
	public static boolean login(User u) {
		boolean loggued = false;
		
		try {
			String username = u.getName();
			String pass = u.getPassword();
			
			String sql = "SELECT * FROM users WHERE full_name = ? AND pass = ?";
			
			Connection conn = Connectiondb.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pass);
			
			loggued = ps.executeQuery().next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return loggued;
	}
	
	public static boolean register(User u) {
		boolean registered = false;
		
		String mail = u.getMail();
		String name = u.getName();
		String phone = u.getPhone();
		String password = u.getPassword();
		
		User user = new User(name, password);
		
		String sql = "INSERT INTO users (full_name, mail, phone, pass, balance, balance_limit) VALUES (?, ?, ?, ?, 0.00, 0.00)";
		
		try {
			if(login(user)) {
				registered = false;
			}else{
				Connection conn = Connectiondb.obtener();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, name);
				ps.setString(2, mail);
				ps.setString(3, phone);
				ps.setString(4, password);	
				
				ps.executeUpdate();
				
				registered = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return registered;
	}

}
