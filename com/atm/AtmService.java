package com.atm;

public class AtmService { // ATM服务
	private AtmUser[] users = new AtmUser[] { // 数据库里已存在的账户
		new AtmUser("111", "111", "Li"),
		new AtmUser("222", "222", "Wang"),
		new AtmUser("333", "333", "Liu")
	};

	private AtmUser user = null; // 当前登录用户

	public AtmUser getUser() {
		return user;
	}

	public boolean login(AtmUser user) { // 验证登录卡号
		int index = findUser(user);
		if (index == -1) {
			return false;
		}

		if (!user.getPassword().equals(users[index].getPassword())) {
			return false;
		}

		this.user = users[index];
		return true;
	}

	public boolean logout() {
		user = null;
		return true;
	}

	// 查找User, 找不到返回-1
	public int findUser(AtmUser user) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].equals(user)) {
				return i;
			}
		}
		return -1;
	}

	public AtmUser findTransferAccount(AtmUser user) { // 验证转账账户
		//if (account.length == 12) {
		//	return transferUser.getUsername();
		//} else {
		//	return null;
		//}

		int index = findUser(user);

		if (index == -1) {
			return null;
		}

		return users[index];
	}

	public boolean transfer(AtmUser transferUser, double amount) { // 转账
		if (amount > user.getBalance()) { // 余额不足
			return false;
		} else {
			user.setBalance(user.getBalance() - amount);
			transferUser.setBalance(transferUser.getBalance() + amount);
			return true;
		}
	}

	public boolean deposite(double amount) { // 存款
		user.setBalance(user.getBalance() + amount);
		return true;
	}

	public boolean debit(double amount) { // 取款
		if (amount > user.getBalance()) { // 余额不足
			return false;
		} else {
			user.setBalance(user.getBalance() - amount);
			return true;
		}
	}
}
