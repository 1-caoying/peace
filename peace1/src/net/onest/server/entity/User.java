package net.onest.server.entity;

public class User {

	private int userId;
	private String userPhone;
	private String userName;
	private String userSex;
	private String userBirth;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPhone=" + userPhone + ", userName=" + userName + ", userSex=" + userSex
				+ ", userBirth=" + userBirth + "]";
	}
	
	
	
	
}
