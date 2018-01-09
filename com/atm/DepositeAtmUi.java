package com.atm;

import java.util.Scanner;

public class DepositeAtmUi extends AbstractAtmUi { // ������

	public String amount;

	public DepositeAtmUi(AtmUser user) {
		super(user);
	}

	@Override
	public AbstractAtmUi show() {
		System.out.println("���ҵ��");
		System.out.println("����������: ");
		amount = AbstractAtmUi.input.nextLine();
		System.out.println("1: ȷ��");
		System.out.println("2: ��������");
		System.out.println("3: �������˵�");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (!depositeVerify()) {
				return this;
			}
			if (AbstractAtmUi.service.deposite(Double.valueOf(amount))) {
				System.out.println("�����ɹ�!");
				return new MainMenuAtmUi(user);
			} else {
				System.out.println("����!");
				return this;
			}
		} else if (option.equals("2")) {
			return new DepositeAtmUi(user);
		} else if (option.equals("3")) {
			return new MainMenuAtmUi(user);
		} else {
			System.out.println("��������, ����������!");
			return this;
		}
	}

	private boolean depositeVerify() {
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
