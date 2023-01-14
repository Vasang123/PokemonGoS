package controller;

import java.util.Vector;

public class DataController {
	Vector<String> pokemonList;
	Vector<String> commonSkills;
	Vector<String> specialSkills;
	public DataController() {
		pokemonList = new Vector<>();
		commonSkills = new Vector<>();
		specialSkills = new Vector<>();
		pokemonData();
		commonSkill();
		specialSkill();
	}
	public void pokemonData() {
		pokemonList.add("Togepi");
		pokemonList.add("Pikachu");
		pokemonList.add("Eevee");
		pokemonList.add("Snorlax");
		pokemonList.add("Charizard");
		pokemonList.add("Gardevoir");
		pokemonList.add("Lucario");
	}

	public void commonSkill() {
		commonSkills.add("Energy ball");
		commonSkills.add("Shadow ball");
		commonSkills.add("Poison heal");
		commonSkills.add("Iron fist");
		commonSkills.add("Super luck");
		commonSkills.add("Limber");
	}

	public void specialSkill() {
		specialSkills.add("Ice Scale");
		specialSkills.add("Unaware");
		specialSkills.add("Sturdy");
		specialSkills.add("Multiscale");
		specialSkills.add("Protean");
	}

	public Integer pokemonSize() {
		return pokemonList.size();
	}

	public Integer commonSize() {
		return commonSkills.size();
	}

	public Integer specialSize() {
		return specialSkills.size();
	}

	public String getPokemon(int target) {
		String temp = "";
		for (int i = 0; i < pokemonSize(); i++) {
			if (target == i) {
				temp = pokemonList.get(i);
				break;
			}
		}
		return temp;
	}

	public String getCommon(int target) {
		String temp = "";
		for (int i = 0; i < commonSize(); i++) {
			if (target == i) {
				temp = commonSkills.get(i);
				break;
			}
		}
		return temp;
	}

	public String getSpecial(int target) {
		String temp = "";
		for (int i = 0; i < specialSize(); i++) {
			if (target == i) {
				temp = specialSkills.get(i);
				break;
			}
		}
		return temp;
	}
}
