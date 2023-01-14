package view;

import java.util.Vector;

import controller.GameController;
import model.Item;
import model.Pokemon;

public class GameView {
	GameController gc;
	public GameView(Integer currentMoney, Vector<Pokemon> pokemons, Vector<Item> items){
		gc = new GameController(currentMoney, pokemons, items);
		gameplay();
	}
	private void gameplay() {
		Pokemon poke = gc.createPokemon();
		gc.displayPoke(poke);
		gc.getPokeBallQuantity();
		gc.displayOption();
		int ch = 0;
		while(true) {
			ch = gc.util.Int(1, 3, "Enter your choice[1-3]: ");
			if(ch == 1) {
				gc.catchPoke(1, gc.premierBall, poke);
				return;
			}else if(ch == 2) {
				gc.catchPoke(2, gc.greatBall, poke);
				return;
			}else if(ch == 3) {
				gc.util.cls();
				return;
			}else {
				System.out.println("Invalid Input");
			}
		}
	}
	public Vector<Pokemon> updatePokemon() {
		return gc.updatePokemon();
	}
	public Vector<Item> updateItem() {
		return gc.updateItem();
	}
	
	public Integer updateMoney(){
		return gc.updateMoney();
	}
}
