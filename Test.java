import com.atm.LoginAtmUi;
import com.atm.AtmUser;
import com.atm.AbstractAtmUi;

public class Test {
	public static void main(String[] args) {
		AbstractAtmUi ui = new LoginAtmUi(); // 程序刚开始运行登录界面

		/*
		显示当前界面，并将ui指向下一个界面
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
