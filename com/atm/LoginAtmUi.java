package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // ��¼ҳ��
	private String cardFormat = "[0-9]{3}"; // ���ų���

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("�����뿨��: ");
		String account = AbstractAtmUi.input.nextLine();
		if (!account.matches(cardFormat)) {
			System.out.println("���Ÿ�ʽ����ȷ! ");
			return this;
		}
		if (service.findUser(new AtmUser(account, null)) == -1) {
			System.out.println("���Ų�����!");
			return this;
		}
		System.out.println("����������: ");
		String password = AbstractAtmUi.input.nextLine();
		if (service.login(new AtmUser(account, password))) {
			System.out.println("��¼�ɹ�!");
			return new MainMenuAtmUi();
		} else {
			System.out.println("�������!");
			return this;
		}
	}
}
