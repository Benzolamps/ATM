package com.atm;

public class TradingRecordAtmUi extends AbstractAtmUi { // ��¼ҳ��
	

	@Override
	public AbstractAtmUi show() {
		System.out.println("���׼�¼: ");
		System.out.println(user.getRecord());
		System.out.println("1: �������˵�");
		AbstractAtmUi.input.nextLine();
		return new MainMenuAtmUi();
	}
}
