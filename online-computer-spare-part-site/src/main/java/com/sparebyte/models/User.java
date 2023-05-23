package com.sparebyte.models;

public class User {
	
	private String UserId;
	private String UserName;
	private String Email;
	private String Password;
	private String MobileNo;
	private String userRole;
	
	public void setUserId(String userId) {
		
		UserId = userId;
	}
	
	public String getUserId() {
		
		return UserId;
	}
	
	public void setUserName(String userName) {
		
		UserName = userName;
	}
	
	public String getUserName() {
		
		return UserName;
	}
	
	public void setEmail(String email) {
		
		Email = email;
	}
	
	public String getEmail() {
		
		return Email;
	}
	
	public void setPassword(String password) {
		
		Password = password;
	}
	
	public String getPassword() {
		
		return Password;
	}
	
	public void setMobileNo(String string) {
		
		MobileNo = string;
	}
	
	public String getMobileNo() {
		
		return MobileNo;
	}
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


}


