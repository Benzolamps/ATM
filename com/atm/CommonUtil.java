
package com.atm;

public final class CommonUtil {
	public static boolean isNumber(String str) { // 判断一个字符串是否是数字
		
		//try {
		//	Double.valueOf(str);
		//} catch (NumberFormatException e) {
		//	return false;
		//}
		//return true;
		
		String figure = "(\\-)?(\\d)*(\\.)?(\\d)+([Ee](\\-)?(\\d)+)?";
		return str.matches(figure);
	}
}
