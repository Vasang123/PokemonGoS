package controller;

import model.Pokeball;
import view.GameView;
import view.StoreView;

public class MenuController {
	private Utility util;
	DataController data;
	BagController userBag;
	StoreView store;
	GameView game;
	public MenuController() {
		util = new Utility();
		userBag = new BagController();
		setData();
		data = new DataController();
		
	}
	public void menuItem() {
		System.out.println("Your Money : " + userBag.getCurrentMoney() + " Poke Coins");
		System.out.println("1. Play");
		System.out.println("2. View Bag");
		System.out.println("3. Poke Store");
		System.out.println("4. Exit");
	}
	public void banner() {
		System.out.println("\r\n"
				+ "  _____      _                               _____       _____ \r\n"
				+ " |  __ \\    | |                             / ____|     / ____|\r\n"
				+ " | |__) |__ | | _____ _ __ ___   ___  _ __ | |  __  ___| (___  \r\n"
				+ " |  ___/ _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\| | |_ |/ _ \\\\___ \\ \r\n"
				+ " | |  | (_) |   <  __/ | | | | | (_) | | | | |__| | (_) |___) |\r\n"
				+ " |_|   \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_|\\_____|\\___/_____/ \r\n"
				+ "                                                               \r\n"
				+ "                                                               \r\n"
				+ "");
	}
	private void ExitBanner() {
		System.out.println("\r\n"
				+ "  _______ _                 _     __     __           ______           _____  _             _             \r\n"
				+ " |__   __| |               | |    \\ \\   / /          |  ____|         |  __ \\| |           (_)            \r\n"
				+ "    | |  | |__   __ _ _ __ | | __  \\ \\_/ /__  _   _  | |__ ___  _ __  | |__) | | __ _ _   _ _ _ __   __ _ \r\n"
				+ "    | |  | '_ \\ / _` | '_ \\| |/ /   \\   / _ \\| | | | |  __/ _ \\| '__| |  ___/| |/ _` | | | | | '_ \\ / _` |\r\n"
				+ "    | |  | | | | (_| | | | |   <     | | (_) | |_| | | | | (_) | |    | |    | | (_| | |_| | | | | | (_| |\r\n"
				+ "    |_|  |_| |_|\\__,_|_| |_|_|\\_\\    |_|\\___/ \\__,_| |_|  \\___/|_|    |_|    |_|\\__,_|\\__, |_|_| |_|\\__, |\r\n"
				+ "                                                                                       __/ |         __/ |\r\n"
				+ "                                                                                      |___/         |___/ \r\n"
				+ "");
	}
	private void setData(){
		userBag.addPokeball("Premier Ball", 100);
		userBag.addPokeball("Great Ball", 50);
		userBag.setCurrentMoney(200);
	}

	public Utility getUtil() {
		return util;
	}
	public void setUtil(Utility util) {
		this.util = util;
	}
	public void choice1() {
		util.cls();
		game = new GameView(userBag.getCurrentMoney(), userBag.getCurrentPokemon(), userBag.getCurrentItem());
		userBag.setCurrentMoney(game.updateMoney());
		userBag.setCurrentPokemon(game.updatePokemon());
		userBag.setCurrentItem(game.updateItem());
	}
	
	public void choice2() {
		util.cls();
		userBag.displayBag();
		util.enter();
	}
	
	public void choice3() {
		util.cls();
		store = new StoreView(userBag.getCurrentMoney(), userBag.getCurrentItem());
		userBag.setCurrentMoney(store.updateMoney());
		userBag.setCurrentItem(store.updateItems());
	}
	
	
	public void choice4() {
		util.cls();
		ExitBanner();
	}
	

}
