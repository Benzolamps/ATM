import com.atm.LoginAtmUi;
import com.atm.AtmUser;
import com.atm.AbstractAtmUi;

public class Test {
	public static void main(String[] args) {
		AbstractAtmUi ui = new LoginAtmUi(); // ����տ�ʼ���е�¼����

		/*
		��ʾ��ǰ���棬����uiָ����һ������
		*/
		while (ui != null) {
			ui = ui.show();
		}
	}
}

/*a: while (true) {
	if (1) {
		b: while (true) {
			if (1) {
				continue a;
			}
		}
	} else if (2) {

	}
}*/
