package com.atm;

public class BalanceAtmUi extends AbstractAtmUi { // ��ѯ������

	@Override
	public AbstractAtmUi show() {
		System.out.println("��ѯҵ��");
		System.out.println("�˻�����: " + user.getUsername());
		System.out.println("���: " + user.getBalance());
		System.out.println("1: �������˵�");
		AbstractAtmUi.input.nextLine();
		return new MainMenuAtmUi();
	}
}
