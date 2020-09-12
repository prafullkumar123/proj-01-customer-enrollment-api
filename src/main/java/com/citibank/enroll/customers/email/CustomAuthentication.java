package com.citibank.enroll.customers.email;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomAuthentication extends Authenticator {
	
	public CustomAuthentication() {
		// TODO Auto-generated constructor stub
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication passwordAuthentication = new PasswordAuthentication(username, password);
		return passwordAuthentication;
	}

	public CustomAuthentication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
