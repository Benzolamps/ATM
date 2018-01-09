package com.atm;

import java.util.Scanner;

/**
 * 
 * 所有界面的父类
 * 
 * @author Benzolamps
 *
 */
public abstract class AbstractAtmUi {
	protected static Scanner input = new Scanner(System.in); // 各个界面共享一个输入流
	protected static AtmService service = new AtmService(); // 各个界面共享一台ATM
	protected AtmUser user;

	public AbstractAtmUi(AtmUser user) {
		//this.user = AbstractAtmUi.service.getUser();
		this.user = user;
	}

	public abstract AbstractAtmUi show(); // 业务显示主方法, 返回值是下一个页面
}
