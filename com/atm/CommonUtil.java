
package com.atm;

public final class CommonUtil {
	public static boolean isNumber(String str) { // �ж�һ���ַ����Ƿ�������
		try {
			Double.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
