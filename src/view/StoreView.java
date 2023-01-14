package view;

import java.util.Vector;

import controller.StoreController;
import model.Item;

public class StoreView {
	StoreController store;

	public StoreView(int currentMoney, Vector<Item> currentItem) {
		store = new StoreController(currentMoney,currentItem);
		storemenu();
	}
	
	public void storemenu() {
		int ch = 0;
		while(true && store.currentMoney >= 0) {
			store.storeBanner();
			store.storeItem();
			ch = store.util.Int(1, 6, "[1..6]:");
			if(ch == 1) {
				store.buyItem(10,1,"Potion");
			}else if (ch == 2) {
				store.buyItem(100,2,"Big Potion");			
			}else if (ch == 3) {
				store.buyItem(200,3,"Ultimate Potion");	
			}else if (ch == 4) {
				store.buyItem(10,4,"Premier Ball");
			}else if (ch == 5) {
				store.buyItem(100,5,"Great Ball");
			}else if (ch == 6) {
				store.util.cls();
				return;
			}
		}
		
	}
	public int updateMoney() {
		return store.updateMoney();
	}
	
	public Vector<Item> updateItems(){
		return store.bag.getCurrentItem();
	}
}
