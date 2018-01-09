package com.atm;

public class LoginAtmUi extends AbstractAtmUi { // ��¼ҳ��
	private int cardLength = 3; // ���ų���

	@Override
	public AbstractAtmUi show() {
		service.logout();
		System.out.println("�����뿨��: ");
		String account = AbstractAtmUi.input.nextLine();
		if (account.length() != cardLength) {
			System.out.println("����ֻ����" + cardLength + "λ��! ");
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
			System.out.println("�û������������!");
			return this;
		}
	}
}
