package com.atm;

import java.util.Date;
import java.util.Calendar;

public class AtmUser { // �û�
	private String username; // �û���
	private String account; // ����
	private String password; // ����
	private double balance; // ���
	private TradingRecord record;

	public AtmUser(String account, String password, String username) {
		this.account = account;
		this.password = password;
		this.username = username;
		balance = 1000;
		record = new TradingRecord();
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
	
	public String getRecord() {
		return record.toString();
	}
 
	public void setBalance(double balance, String message) {
		double amount = balance - this.balance;
		Date date = Calendar.getInstance().getTime();
		record.appendRecord(date, message, amount);
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
