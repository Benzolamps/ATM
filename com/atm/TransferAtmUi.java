package com.atm;

import java.util.Scanner;

public class TransferAtmUi extends AbstractAtmUi { // ת�˽���

	private String cardFormat = "[0-9]{3}"; // ���ų���

	private AtmUser transferUser = null;

	private String amount = "";

	private boolean inputFinished = false; // ��ʾ�û��Ƿ����������

	@Override
	public AbstractAtmUi show() {
		if (inputFinished) {
			return transferConfirm();
		} else {
			return transfer();
		}
	}

	private AbstractAtmUi transfer() {
		System.out.println("ת��ҵ��");
		System.out.println("������Է������п���: ");
		String account = AbstractAtmUi.input.nextLine();
		transferUser = new AtmUser(account, null);
		if (!accountVerify()) {
			return this;
		}
		System.out.println("������ת�˽��:");
		amount = AbstractAtmUi.input.nextLine();
		System.out.println("1: ȷ��");
		System.out.println("2: ��������");
		System.out.println("3: �������˵�");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (transferVerify()) {
				inputFinished = true; // ���û�������ȷ����ʾת����Ϣ
			}
			return this;
		} else if (option.equals("2")) {
			return this;
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("��������, ����������!");
			return this;
		}
	}

	private boolean accountVerify() {
		if (!transferUser.getAccount().matches(cardFormat)) {
			System.out.println("���Ÿ�ʽ����!");
			return false;
		}
		if (user.equals(transferUser)) {
			System.out.println("���ܸ��Լ�ת��!");
			return false;
		}
		transferUser = AbstractAtmUi.service.findTransferAccount(transferUser);
		if (transferUser == null) { // �жϿ����Ƿ���ȷ
			System.out.println("�˺Ų�����, ����������!");
			return false;
		}
		return true;
	}
	
	private boolean transferVerify() {
		if (!CommonUtil.isNumber(amount)) {
			System.out.println(amount + "��������!");
			System.out.println("��������, ����������!");
			return false;
		}

		if (Double.valueOf(amount) <= 0) {
			System.out.println("��������, ����������!");
			return false;
		}
		return true;
	}

	private AbstractAtmUi transferConfirm() {
		System.out.println("ת��ҵ��-��ʾ�Է���Ϣ");
		System.out.println("�Է�����: " + transferUser.getAccount());
		System.out.println("�Է�����: " + transferUser.getUsername());
		System.out.println("ת�˽��: " + Double.valueOf(amount));
		System.out.println("1: ȷ��ת��");
		System.out.println("2: ��������");
		System.out.println("3: �������˵�");
		String option = AbstractAtmUi.input.nextLine();
		if (option.equals("1")) {
			if (AbstractAtmUi.service.transfer(transferUser, Double.valueOf(amount))) {
				System.out.println("�����ɹ�!");
				return new MainMenuAtmUi();
			} else {
				System.out.println("����!");
				inputFinished = false;
				return this;
			}
		} else if (option.equals("2")) {
			inputFinished = false;
			return this;
		} else if (option.equals("3")) {
			return new MainMenuAtmUi();
		} else {
			System.out.println("��������, ����������!");
			return this;
		}
	}
}
