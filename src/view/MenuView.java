package view;

import controller.GameController;
import controller.MenuController;
import controller.StoreController;
import controller.Utility;

public class MenuView {
	MenuController mc;
	public MenuView() {
		mc = new MenuController();
		menu();
	}
	private void menu() {
		int ch = 0;
		while(true) {
			mc.banner();
			mc.menuItem();
			ch = mc.getUtil().Int(1, 4, ">> ");
			if(ch == 1) {
				mc.choice1();
			}else if(ch == 2) {
				mc.choice2();
			}else if(ch == 3) {
				mc.choice3();
			}else if(ch == 4) {
				mc.choice4();
				System.exit(0);
			}else {
				System.out.println("Invalid Input");
			}
		}
		
	}
}
