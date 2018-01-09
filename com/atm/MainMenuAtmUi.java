package com.atm;

public class MainMenuAtmUi extends AbstractAtmUi { // 主界面

	public MainMenuAtmUi(AtmUser user) {
		super(user);
	}

	@Override
	public AbstractAtmUi show() {
		System.out.println("选择办理业务");
		System.out.println("1: 查询");
		System.out.println("2: 转账");
		System.out.println("3: 取款");
		System.out.println("4: 存款");
		System.out.println("5: 退卡");
		String option = AbstractAtmUi.input.nextLine(); // 用户选项
		if (option.equals("1")) {
			return new BalanceAtmUi(user);
		} else if (option.equals("2")) {
			return new TransferAtmUi(user);
		} else if (option.equals("3")) {
			return new DebitAtmUi(user);
		} else if (option.equals("4")) {
			return new DepositeAtmUi(user);
		} else if (option.equals("5")) {
			return new LoginAtmUi(user);
		} else {
			System.out.println("输入有误, 请重新输入");
			return this;
		}
	}
}
