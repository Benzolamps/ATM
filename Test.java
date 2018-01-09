import com.atm.LoginAtmUi;
import com.atm.AtmUser;
import com.atm.AbstractAtmUi;

public class Test {
	public static void main(String[] args) {
		AtmUser user = new AtmUser(null, null, null);
		AbstractAtmUi ui = new LoginAtmUi(user); // 程序刚开始运行登录界面

		/*
		显示当前界面，并将ui指向下一个界面
		*/
		while (true) {
			if (ui == null) {
				break;
			}
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
