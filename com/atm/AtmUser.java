package com.atm;

public class AtmUser { // 用户
	private String username; // 用户名
	private String account; // 卡号
	private String password; // 密码
	private double balance; // 余额

	public AtmUser(String account, String password, String username) {
		this.account = account;
		this.password = password;
		this.username = username;
		balance = 1000;
	}

	public AtmUser(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String getUsername() {
		return username;
	}

	public boolean equals(AtmUser anotherUser) { // 判断两个用户是否是同一个用户
		return anotherUser.getAccount().equals(account);
	}

	public String toString() {
		return account + "";
	}

}
