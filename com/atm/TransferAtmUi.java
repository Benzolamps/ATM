package com.atm;

import java.util.Scanner;

public class TransferAtmUi extends AbstractAtmUi { // 转账界面

	private AtmUser transferUser = null;

	private String amount = "";

	private boolean inputFinished = false; // 表示用户是否完成了输入

	@Override
	public AbstractAtmUi show() {
		if (inputFinished) {
			return transferConfirm();
		} else {
			return transfer();
		}
	}

	private AbstractAtmUi transfer() {
		System.out.println("转账业务");
		System.out.println("请输入对方的银行卡号: ");
		String account = AbstractAtmUi.input.nextLine();
		transferUser = new AtmUser(account, null);
		System.out.println("请输入转账金额:");
		amount = AbstractAtmUi.input.nextLine();
		System.out.println("1: 确认");
		System.out.println("2: 重新输入");
		System.out.println("3: 返回主菜单");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (transferVerify()) {
				inputFinished = true; // 当用户输入正确才提示转账信息
			}
			return this;
		} else if (option.equals("2")) {
			return this;
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("输入有误, 请重新输入!");
			return this;
		}
	}

	private boolean transferVerify() {
		if (user.equals(transferUser)) {
			System.out.println("不能给自己转账!");
			return false;
		}
		transferUser = AbstractAtmUi.service.findTransferAccount(transferUser);
		if (transferUser == null) { // 判断卡号是否正确
			System.out.println("账号不存在, 请重新输入!");
			return false;
		}

		if (!CommonUtil.isNumber(amount)) {
			System.out.println(amount + "不是数字!");
			System.out.println("输入有误, 请重新输入!");
			return false;
		}

		if (Double.valueOf(amount) <= 0) {
			System.out.println("输入有误, 请重新输入!");
			return false;
		}
		return true;
	}

	private AbstractAtmUi transferConfirm() {
		System.out.println("转账业务-显示对方信息");
		System.out.println("对方卡号: " + transferUser.getAccount());
		System.out.println("对方姓名: " + transferUser.getUsername());
		System.out.println("转账金额: " + Double.valueOf(amount));
		System.out.println("1: 确认转账");
		System.out.println("2: 重新输入");
		System.out.println("3: 返回主菜单");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (AbstractAtmUi.service.transfer(transferUser, Double.valueOf(amount))) {
				System.out.println("操作成功!");
				return new MainMenuAtmUi();
			} else {
				System.out.println("余额不足!");
				inputFinished = false;
				return this;
			}
		} else if (option.equals("2")) {
			inputFinished = false;
			return this;
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("输入有误, 请重新输入!");
			return this;
		}
	}
}
