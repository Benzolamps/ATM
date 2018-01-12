package com.atm;

public class MainMenuAtmUi extends AbstractAtmUi { // ������

	@Override
	public AbstractAtmUi show() {
		System.out.println("ѡ�����ҵ��");
		System.out.println("1: ��ѯ");
		System.out.println("2: ת��");
		System.out.println("3: ȡ��");
		System.out.println("4: ���");
		System.out.println("5: ��ѯ���׼�¼");
		System.out.println("6: �˿�");
		String option = AbstractAtmUi.input.nextLine(); // �û�ѡ��
		if (option.equals("1")) {
			return new BalanceAtmUi();
		} else if (option.equals("2")) {
			return new TransferAtmUi();
		} else if (option.equals("3")) {
			return new DebitAtmUi();
		} else if (option.equals("4")) {
			return new DepositeAtmUi();
		} else if (option.equals("5")) {
			return new TradingRecordAtmUi();
		} else if (option.equals("6")) {
			return new LoginAtmUi();
		} else {
			System.out.println("��������, ����������");
			return this;
		}
	}
}
