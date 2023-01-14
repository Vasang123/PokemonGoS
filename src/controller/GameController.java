package controller;

import java.util.Iterator;
import java.util.Vector;

import model.Common;
import model.GreatBall;
import model.Item;
import model.Pokeball;
import model.Pokemon;
import model.PremierBall;
import model.Rare;

public class GameController {
	private BagController bag = new BagController();
	private DataController data = new DataController();
	public Integer premierBall;
	public Integer greatBall;
	public Integer currentMoney;
	public Utility util = new Utility();
	
	public GameController(Integer currentMoney, Vector<Pokemon> pokemons, Vector<Item> items){
		bag.setCurrentPokemon(pokemons);
		this.currentMoney = currentMoney;
		bag.setCurrentItem(items);
	}
	public void getPokeBallQuantity() {
		for (Item item : bag.getCurrentItem()) {
			if(item.getName().equals("Premier Ball")) {
				premierBall = item.getQuantity();
			}else if(item.getName().equals("Great Ball")) {
				greatBall = item.getQuantity();
			}
		}
	}
	private void setPokeBallQuantity() {
		for (Item item : bag.getCurrentItem()) {
			if(item.getName().equals("Premier Ball")) {
				item.setQuantity(premierBall);
			}else if(item.getName().equals("Great Ball")) {
				item.setQuantity(greatBall);
			}
		}
	}
	public Pokemon createPokemon() {
		String type = util.randType();
		Integer level = util.randLevel();
		Integer nameIndex = util.randSize(data.pokemonSize()-1);
		String name = data.getPokemon(nameIndex);
		Integer skillIndex;
		String skill;
		if(type.equals("Common")) {
			skillIndex = util.randSize(data.commonSize()-1);
			skill = data.getCommon(skillIndex);
			return new Common(name, level, skill);
		}else {
			skillIndex = util.randSize(data.specialSize());
			skill = data.getSpecial(skillIndex);
			Integer shield = util.randSize(100);
			return new Rare(name, level, skill, shield);
		}
	}
	public void displayPoke(Pokemon poke) {
		String foundPoke = "You have encountered a wild " + poke.getName();
		util.printDynamicMsg(foundPoke,50);
		if(poke instanceof Common) {
			System.out.println("Common Pokemon");
		}else {
			System.out.println("Rare Pokemon");
		}
		poke.display();
	}
	
	private void catchAction(String name, Pokemon poke) {
		Integer pokeLevel = 0;
		Integer catchRate = 0;
		Integer range = util.randSize(100)+1;
		pokeLevel = poke.getLevel();
		if(name.equals("Premier Ball")) {
			Pokeball pb = new PremierBall(name, 0, 25);
			catchRate = pb.catchPokemon(pokeLevel);
			
		}else if(name.equals("Great Ball")) {
			Pokeball pb = new GreatBall(name, 0, 50);
			catchRate = pb.catchPokemon(pokeLevel);
		}
//		System.out.println("Range: " + range);
//		System.out.println("Catch Rate: " + catchRate);
		if(catchRate >= 1 & range <= catchRate ) {
			String msg = poke.getName() + " has been caught :D";
			util.printDynamicMsg(msg, 50);
			if(poke instanceof Common) {
				currentMoney += 20;
				bag.addCommonPoke(poke.getName(), poke.getLevel(), ((Common)poke).getCommonSkill());
			}else {
				currentMoney += 40;
				bag.addRarePoke(poke.getName(), poke.getLevel(), ((Rare)poke).getSpecialSkill(),((Rare)poke).getShield() );
			}
		}else {
			String msg = poke.getName() + " has break free and fled away";
			util.printDynamicMsg(msg,50);
		}
		util.enter();
	}
	
	private Integer validateBallQuantity(int target) {
		return (target- 1 >= 0) ? 1: 0;
	}
	public void displayOption() {
		System.out.println("Enter your choice");
		System.out.println("1. Throw Premier Ball ("+ premierBall + ")");
		System.out.println("2. Throw Great Ball (" + greatBall + ")");
		System.out.println("3. Exit" );
	}
	public void catchPoke(int ch, int quantity, Pokemon poke) {
		if(validateBallQuantity(quantity) == 1) {
			if(ch == 1) {
				premierBall-=1;
				catchAction("Premier Ball",poke);
				return;
			}else if(ch == 2) {
				greatBall -=1;
				catchAction("Great Ball",poke);
				return;
			}else if(ch == 3) {
				util.cls();
				return;
			}
		}else {
			System.out.println("Not Enough Ball");
			util.enter();
			return;
		}
	}

	
	public Vector<Pokemon> updatePokemon() {
		return bag.getCurrentPokemon();
	}
	public Vector<Item> updateItem() {
		setPokeBallQuantity();
		return bag.getCurrentItem();
	}
	
	public Integer updateMoney(){
		return currentMoney;
	}
}
