package com.rainier.gc.system.gc.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String emailAddress;
	private String password;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmaiAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPasword(String password) {
		this.password = password;
	}
	
	

}
