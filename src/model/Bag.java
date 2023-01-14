package model;

import java.util.Vector;

public class Bag {
	private Integer money = 0;
	private Vector<Pokemon> pokemons = new Vector<>();
	private Vector<Item> items = new Vector<>();

	public Bag() {
		super();
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	public Vector<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(Pokemon pokemons) {
		this.pokemons.add(pokemons);
	}
	public Vector<Item> getItems() {
		return items;
	}
	public void setItems(Item items) {
		this.items.add(items);
	}
	public void setPokemons(Vector<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	public void setItems(Vector<Item> items) {
		this.items = items;
	}
	
	
}
