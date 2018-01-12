package com.atm;

public class MainMenuAtmUi extends AbstractAtmUi { // 主界面

	@Override
	public AbstractAtmUi show() {
		System.out.println("选择办理业务");
		System.out.println("1: 查询");
		System.out.println("2: 转账");
		System.out.println("3: 取款");
		System.out.println("4: 存款");
		System.out.println("5: 查询交易记录");
		System.out.println("6: 退卡");
		String option = AbstractAtmUi.input.nextLine(); // 用户选项
		if (option.equals("1")) {
			return new BalanceAtmUi();
		} else if (option.equals("2")) {
			return new TransferAtmUi();
		} else if (option.equals("3")) {
			return new DebitAtmUi();
		} else if (option.equals("4")) {
			return new DepositeAtmUi();
		} else if (option.equals("5")) {
			return new TradingRecordAtmUi();
		} else if (option.equals("6")) {
			return new LoginAtmUi();
		} else {
			System.out.println("输入有误, 请重新输入");
			return this;
		}
	}
}
