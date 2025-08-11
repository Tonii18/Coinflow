package models;

import java.util.Objects;

public class User {
	
	private int id;
	private String mail;
	private String name;
	private String phone;
	private String password;
	private double balance;
	private double balanceLimit;
	
	public User() {
		
	}

	public User(String mail, String name, String phone, String password) {
		super();
		this.mail = mail;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}

	public User(String mail, String name, String phone, String password, double balance, double balanceLimit) {
		super();
		this.mail = mail;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.balance = balance;
		this.balanceLimit = balanceLimit;
	}

	public User(int id, String mail, String name, String phone, String password, double balance, double balanceLimit) {
		super();
		this.id = id;
		this.mail = mail;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.balance = balance;
		this.balanceLimit = balanceLimit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalanceLimit() {
		return balanceLimit;
	}

	public void setBalanceLimit(double balanceLimit) {
		this.balanceLimit = balanceLimit;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", name=" + name + ", phone=" + phone + ", password=" + password
				+ ", balance=" + balance + ", balanceLimit=" + balanceLimit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	

}
