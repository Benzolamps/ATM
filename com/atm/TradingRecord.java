package com.atm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TradingRecord {
	private StringBuffer sb;
	
	public TradingRecord() {
		sb = new StringBuffer();
	}

	public void appendRecord(Date date, String message, double amount) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sb.append(format.format(date));
		sb.append(" ");
		sb.append(message);
		sb.append(" ");
		sb.append((amount > 0 ? "+" : "") + amount);
		sb.append("\n");
	}

	public String toString() {
		if (sb.length() == 0) {
			return "暂无交易记录!";
		}
		return sb.toString();
	}
}
