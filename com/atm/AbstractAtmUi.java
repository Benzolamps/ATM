package com.atm;

import java.util.Scanner;

/**
 *
 * ���н���ĸ���
 *
 * @author Benzolamps
 *
 */
public abstract class AbstractAtmUi {
	protected static Scanner input = new Scanner(System.in); // �������湲��һ��������
	protected static AtmService service = new AtmService(); // �������湲��һ̨ATM
	protected AtmUser user;

	public AbstractAtmUi() {
		//this.user = AbstractAtmUi.service.getUser();
		user = service.getUser();
	}

	public abstract AbstractAtmUi show(); // ҵ����ʾ������, ����ֵ����һ��ҳ��
}
