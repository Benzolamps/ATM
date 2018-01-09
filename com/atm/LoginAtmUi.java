package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // ��¼����

	public LoginAtmUi(AtmUser user) {
		super(user);

	}

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("�����뿨��: ");
		String account = AbstractAtmUi.input.nextLine();
		System.out.println("����������: ");
		String password = AbstractAtmUi.input.nextLine();
		user = new AtmUser(account, password);
		if (service.login(user)) {
			user = AbstractAtmUi.service.getUser();
			System.out.println("��¼�ɹ�!");
			return new MainMenuAtmUi(user);
		} else {
			System.out.println("��¼ʧ��, �û������������!");
			return this;
		}
	}
}
