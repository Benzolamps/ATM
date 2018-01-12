package com.atm;

public class BalanceAtmUi extends AbstractAtmUi { // 查询余额界面

	@Override
	public AbstractAtmUi show() {
		System.out.println("查询业务");
		System.out.println("账户姓名: " + user.getUsername());
		System.out.println("余额: " + user.getBalance());
		System.out.println("1: 返回主菜单");
		AbstractAtmUi.input.nextLine();
		return new MainMenuAtmUi();
	}
}
