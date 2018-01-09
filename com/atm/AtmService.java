package com.atm;

public class AtmService { // ATM����
	private AtmUser[] users = new AtmUser[] { // ���ݿ����Ѵ��ڵ��˻�
		new AtmUser("111", "111", "Li"),
		new AtmUser("222", "222", "Wang"),
		new AtmUser("333", "333", "Liu")
	};

	private AtmUser user = null; // ��ǰ��¼�û�

	public AtmUser getUser() {
		return user;
	}

	public boolean login(AtmUser user) { // ��֤��¼����
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

	// ����User, �Ҳ�������-1
	public int findUser(AtmUser user) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].equals(user)) {
				return i;
			}
		}
		return -1;
	}

	public AtmUser findTransferAccount(AtmUser user) { // ��֤ת���˻�
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

	public boolean transfer(AtmUser transferUser, double amount) { // ת��
		if (amount > user.getBalance()) { // ����
			return false;
		} else {
			user.setBalance(user.getBalance() - amount);
			transferUser.setBalance(transferUser.getBalance() + amount);
			return true;
		}
	}

	public boolean deposite(double amount) { // ���
		user.setBalance(user.getBalance() + amount);
		return true;
	}

	public boolean debit(double amount) { // ȡ��
		if (amount > user.getBalance()) { // ����
			return false;
		} else {
			user.setBalance(user.getBalance() - amount);
			return true;
		}
	}
}
