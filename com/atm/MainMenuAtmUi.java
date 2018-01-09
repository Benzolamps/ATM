package com.atm;

public class MainMenuAtmUi extends AbstractAtmUi { // ������

	public MainMenuAtmUi(AtmUser user) {
		super(user);
	}

	@Override
	public AbstractAtmUi show() {
		System.out.println("ѡ�����ҵ��");
		System.out.println("1: ��ѯ");
		System.out.println("2: ת��");
		System.out.println("3: ȡ��");
		System.out.println("4: ���");
		System.out.println("5: �˿�");
		String option = AbstractAtmUi.input.nextLine(); // �û�ѡ��
		if (option.equals("1")) {
			return new BalanceAtmUi(user);
		} else if (option.equals("2")) {
			return new TransferAtmUi(user);
		} else if (option.equals("3")) {
			return new DebitAtmUi(user);
		} else if (option.equals("4")) {
			return new DepositeAtmUi(user);
		} else if (option.equals("5")) {
			return new LoginAtmUi(user);
		} else {
			System.out.println("��������, ����������");
			return this;
		}
	}
}
