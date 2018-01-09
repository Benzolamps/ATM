package com.atm;

public class AtmUser { // �û�
	private String username; // �û���
	private String account; // ����
	private String password; // ����
	private double balance; // ���

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

	public boolean equals(AtmUser anotherUser) { // �ж������û��Ƿ���ͬһ���û�
		return anotherUser.getAccount().equals(account);
	}

	public String toString() {
		return account + "";
	}

}
