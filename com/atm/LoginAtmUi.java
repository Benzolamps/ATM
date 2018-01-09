package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // 登录界面

	public LoginAtmUi(AtmUser user) {
		super(user);

	}

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("请输入卡号: ");
		String account = AbstractAtmUi.input.nextLine();
		System.out.println("请输入密码: ");
		String password = AbstractAtmUi.input.nextLine();
		user = new AtmUser(account, password);
		if (service.login(user)) {
			user = AbstractAtmUi.service.getUser();
			System.out.println("登录成功!");
			return new MainMenuAtmUi(user);
		} else {
			System.out.println("登录失败, 用户名或密码错误!");
			return this;
		}
	}
}
