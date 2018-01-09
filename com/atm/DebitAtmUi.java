package com.atm;

public class DebitAtmUi extends AbstractAtmUi { // 取款界面

	public String amount;

	@Override
	public AbstractAtmUi show() {
		System.out.println("取款业务");
		System.out.println("请输入取款金额: ");
		amount = AbstractAtmUi.input.nextLine();
		System.out.println("1: 确认");
		System.out.println("2: 重新输入");
		System.out.println("3: 返回主菜单");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (!debitVerify()) return this;
			if (AbstractAtmUi.service.debit(Double.valueOf(amount))) {
				System.out.println("操作成功!");
				return new MainMenuAtmUi();
			} else {
				System.out.println("余额不足!");
				return this;
			}
		} else if (option.equals("2")) {
			return new DepositeAtmUi();
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("输入有误, 请重新输入!");
			return this;
		}
	}

	private boolean debitVerify() {
		if (!CommonUtil.isNumber(amount)) {
			System.out.println(amount + "不是数字!");
			System.out.println("输入有误, 请重新输入!");
			return false;
		}

		if (Double.valueOf(amount) % 100 != 0 || Double.valueOf(amount) <= 0) {
			System.out.println("请输入100的整数倍!");
			System.out.println("输入有误, 请重新输入!");
			return false;
		}

		return true;
	}
}
