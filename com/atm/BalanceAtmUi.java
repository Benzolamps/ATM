package com.atm;

public class BalanceAtmUi extends AbstractAtmUi { // ��ѯ������

	public BalanceAtmUi(AtmUser user) {
		super(user);
	}

	@Override
	public AbstractAtmUi show() {
		System.out.println("��ѯҵ��");
		System.out.println("�˻�����: " + user.getUsername());
		System.out.println("���: " + user.getBalance());
		return new MainMenuAtmUi(user);
	}
}
