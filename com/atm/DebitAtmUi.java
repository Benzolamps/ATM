package com.atm;

public class DebitAtmUi extends AbstractAtmUi { // ȡ�����

	public String amount;

	@Override
	public AbstractAtmUi show() {
		System.out.println("ȡ��ҵ��");
		System.out.println("������ȡ����: ");
		amount = AbstractAtmUi.input.nextLine();
		System.out.println("1: ȷ��");
		System.out.println("2: ��������");
		System.out.println("3: �������˵�");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (!debitVerify()) return this;
			if (AbstractAtmUi.service.debit(Double.valueOf(amount))) {
				System.out.println("�����ɹ�!");
				return new MainMenuAtmUi();
			} else {
				System.out.println("����!");
				return this;
			}
		} else if (option.equals("2")) {
			return new DepositeAtmUi();
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("��������, ����������!");
			return this;
		}
	}

	private boolean debitVerify() {
		if (!CommonUtil.isNumber(amount)) {
			System.out.println(amount + "��������!");
			System.out.println("��������, ����������!");
			return false;
		}

		if (Double.valueOf(amount) % 100 != 0 || Double.valueOf(amount) <= 0) {
			System.out.println("������100��������!");
			System.out.println("��������, ����������!");
			return false;
		}

		return true;
	}
}
