package controller;

import java.util.Vector;

import model.Bag;
import model.Common;
import model.GreatBall;
import model.Item;
import model.Pokeball;
import model.Pokemon;
import model.Potion;
import model.PremierBall;
import model.Rare;

public class BagController {
	Bag bag = new Bag();
	public BagController() {
		
	}
	
	public void addPokeball(String name, Integer quantity) {
		int check = 0;
		Vector<Item> items = bag.getItems();
		if(items.isEmpty()) {
			if(name.equals("Premier Ball")) {
				Pokeball poke1 = new PremierBall(name, quantity,25);
				bag.setItems(poke1);
			}else if(name.equals("Great Ball")) {
				Pokeball poke2 = new GreatBall(name, quantity, 50);
				bag.setItems(poke2);
			}
			return;
		}
		for (Item item : items) {
			if(item.getName().equals(name)) {
				check = 1;
				item.setQuantity(item.getQuantity()+quantity);
				break;
			}
		}
		if(check == 0) {
			if(name.equals("Premier Ball")) {
				Pokeball poke1 = new PremierBall(name, 20,25);
				bag.setItems(poke1);
			}else if(name.equals("Great Ball")) {
				Pokeball poke2 = new GreatBall(name, 10, 50);
				bag.setItems(poke2);
			}
		}
	}
	public void addPotion(String name, Integer quantity, Integer healingTotal) {
		int check = 0;
		Vector<Item> items = bag.getItems();
		if(items.isEmpty()) {
			Potion poti = new Potion(name, quantity, healingTotal);
			bag.setItems(poti);
			return;
		}
		for (Item item : items) {
			if(item.getName().equals(name)) {
				check = 1;
				item.setQuantity(item.getQuantity()+quantity);
				break;
			}
		}
		if(check == 0) {
			Potion poti = new Potion(name, quantity, healingTotal);
			bag.setItems(poti);
		}
		
	}
	public void addCommonPoke(String name, Integer level, String commonSkill) {
		Common common = new Common(name, level, commonSkill);
		bag.setPokemons(common);
	}
	
	public void addRarePoke(String name, Integer level, String specialSkill, Integer shield) {
		Rare rare = new Rare(name, level, specialSkill, shield);
		bag.setPokemons(rare);
	}
	public void displayBag() {
		Vector<Item> items = bag.getItems();
		Vector<Pokemon> pokemons = bag.getPokemons();
		System.out.println("===========================");
		System.out.println("Your Item List: ");
		if(items.isEmpty()) {
			System.out.println("No Item");
		}
		for (Item item : items) {
			item.display();
		}
		
		System.out.println("===========================");
		System.out.println("Your Pokemon List: ");
		if(pokemons.isEmpty()) {
			System.out.println("No friends D:");
		}
		for (Pokemon pokemon : pokemons) {
			pokemon.display();
		}
	}
	public void setCurrentMoney(int temp) {
		bag.setMoney(temp);
	}
	public int getCurrentMoney() {
		return bag.getMoney();
	}
	public Vector<Item> getCurrentItem() {
		return bag.getItems();
	}
	public Vector<Pokemon> getCurrentPokemon() {
		return bag.getPokemons();
	}
	public void setCurrentItem(Vector<Item> newItems) {
		this.bag.setItems(newItems);
	}
	
	public void setCurrentPokemon(Vector<Pokemon> newPokemons) {
		this.bag.setPokemons(newPokemons);
	}

}
