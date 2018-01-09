package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // 登录页面
	private int cardLength = 3; // 卡号长度

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("请输入卡号: ");
		String account = AbstractAtmUi.input.nextLine();
		if (account.length() != cardLength) {
			System.out.println("卡号只能是" + cardLength + "位数! ");
			return this;
		}
		if (service.findUser(new AtmUser(account, null)) == -1) {
			System.out.println("卡号不存在!");
			return this;
		}
		System.out.println("请输入密码: ");
		String password = AbstractAtmUi.input.nextLine();
		if (service.login(new AtmUser(account, password))) {
			System.out.println("登录成功!");
			return new MainMenuAtmUi();
		} else {
			System.out.println("用户名或密码错误!");
			return this;
		}
	}
}
