package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // 登录页面
	private String cardFormat = "[0-9]{3}"; // 卡号长度

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("请输入卡号: ");
		String account = AbstractAtmUi.input.nextLine();
		if (!account.matches(cardFormat)) {
			System.out.println("卡号格式不正确! ");
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
			System.out.println("密码错误!");
			return this;
		}
	}
}
