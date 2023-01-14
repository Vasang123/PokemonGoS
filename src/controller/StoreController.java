package controller;

import java.util.Vector;

import model.Item;

public class StoreController {
	public Integer currentMoney;
	public Utility util = new Utility();
	public BagController bag = new BagController();
	Integer totalBuy = 0;
	public StoreController(Integer currentMoney, Vector<Item> mainData) {
		this.currentMoney = currentMoney;
		this.bag.setCurrentItem(mainData);
	}
	public void storeBanner() {
		System.out.println(" \\ \\    / /      | (_)   | |      / ____|      / ____| |                \r\n"
				+ "  \\ \\  / /_ _  __| |_  __| | __ _| (___       | (___ | |_ ___  _ __ ___ \r\n"
				+ "   \\ \\/ / _` |/ _` | |/ _` |/ _` |\\___ \\       \\___ \\| __/ _ \\| '__/ _ \\\r\n"
				+ "    \\  / (_| | (_| | | (_| | (_| |____) |      ____) | || (_) | | |  __/\r\n"
				+ "     \\/ \\__,_|\\__,_|_|\\__,_|\\__,_|_____/      |_____/ \\__\\___/|_|  \\___|\r\n"
				+ "                                                                        ");
	}
	public void storeItem() {
//		bag.displayBag();
		System.out.println("Money : " + currentMoney);
		System.out.println("1. Potion (10 Coins)");
		System.out.println("2. Big Potion (100 Coins)");
		System.out.println("3. Ultimate Potion (200 Coins)");
		System.out.println("4. Premier Ball (10 Coins)");
		System.out.println("5. Great Ball (100 Coins)");
		System.out.println("6. Exit ");
	}
	public int validateMoney(int price, int quantity ) {
		return (this.currentMoney - (price*quantity) < 0) ? 1 :0;
	}
	public void buyItem(int price, int index,String name) {
		if(validateMoney(price,1) == 1) {
			System.out.println("Your money isn't enough");
		}else {
			int quantity;
			quantity = util.Int(1, 100, "Enter quantity[1..100]: ");
			if(validateMoney(price,quantity) == 1) {
				System.out.println("Your money isn't enough");
			}else {
				System.out.println("Item successfully purchased");
				currentMoney -= (price*quantity);
				if(index >= 1 && index <= 3) {
					int temp = 0;
					if(index == 1) {
						temp = 10;
					}else if(index == 2) {
						temp = 50;
					}else if(index == 3) {
						temp = 100;
					}
					bag.addPotion(name, quantity, temp);
				}else {
					bag.addPokeball(name, quantity);
				}
			}
			
		}
		util.enter();
	}

	public int updateMoney() {
		return this.currentMoney;
	}
	
	public Vector<Item> updateItems(){
		return this.bag.getCurrentItem();
	}

}
