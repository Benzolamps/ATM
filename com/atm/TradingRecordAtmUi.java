package com.atm;

public class TradingRecordAtmUi extends AbstractAtmUi { // 登录页面
	

	@Override
	public AbstractAtmUi show() {
		System.out.println("交易记录: ");
		System.out.println(user.getRecord());
		System.out.println("1: 返回主菜单");
		AbstractAtmUi.input.nextLine();
		return new MainMenuAtmUi();
	}
}
